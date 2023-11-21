package ui;

import javafx.scene.layout.StackPane;
import modeloelementos.Carta;
import modeloelementos.PilaDeCartas;
import modelosolitario.Solitario;

public class VistaDescarte extends VistaPilaDeCartas{

    public VistaDescarte(Solitario solitario, PilaDeCartas pilaDeCartas, boolean corrimientoY) {
        super(solitario, pilaDeCartas, corrimientoY);
    }

    @Override
    protected void agregarVistaPila(boolean corrimientoY) {

        PilaDeCartas pilaInvertida = super.getPilaDeCartas().invertir();

        if (super.getPilaDeCartas().isEmpty()) {
            final StackPane descarte = new StackPane();
            descarte.setPrefSize(Configuracion.ANCHO_VENTANA / 13,  Configuracion.ALTO_VENTANA / 6);
            getChildren().add(descarte);
        } else {
            while (!pilaInvertida.isEmpty()) {
                super.agregarVistaCarta(new VistaCarta(pilaInvertida.pop()), 0);
            }

        }
    }

    protected void manejoPilaLlenaClick(VistaCarta vistaCarta, VistaPilaDeCartas vistaPila) {


        if (super.getSolitario().getPilaOrigen() == null) {

            Carta carta = vistaCarta.getCarta();
            vistaCarta.setStyle(Configuracion.CARTA_APRETADA);

            super.getSolitario().setPilaOrigen(this.getPilaDeCartas());
            super.getSolitario().setCartaOrigen(carta);

        }
        else {
            //no puedo mover cartas de ninguna pila al descarte
            System.out.println("error");
        }
    }

}
