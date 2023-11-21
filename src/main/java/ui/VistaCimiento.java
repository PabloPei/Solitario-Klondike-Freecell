package ui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import modeloelementos.PilaDeCartas;
import modelosolitario.Solitario;

public class VistaCimiento extends VistaPilaDeCartas{

    public VistaCimiento(Solitario solitario, PilaDeCartas pilaDeCartas, boolean corrimientoY) {
        super(solitario, pilaDeCartas, corrimientoY);
    }

    @Override
    protected void agregarVistaPila(boolean corrimientoY) {

        PilaDeCartas pilaInvertida = super.getPilaDeCartas().invertir();
        int corrimiento = 0;

        if (super.getPilaDeCartas().isEmpty()) {
            final StackPane descarte = new StackPane();
            descarte.setPrefSize(Configuracion.ANCHO_VENTANA / 13,  Configuracion.ALTO_VENTANA / 6);
            getChildren().add(descarte);
        } else {
            while (!pilaInvertida.isEmpty()) {
                super.agregarVistaCarta(new VistaCarta(pilaInvertida.pop()), 0);
                if (corrimientoY) {
                    corrimiento++;
                }

            }

        }
    }



}
