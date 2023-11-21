package ui;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import modeloelementos.Carta;
import modeloelementos.PilaDeCartas;
import modelosolitario.Solitario;


public class VistaPilaDeCartas extends StackPane implements Listener {

    private static final double posicionY = 20;
    private Solitario solitario;
    private PilaDeCartas pila;
    private boolean corrimiento;

    public VistaPilaDeCartas(Solitario solitario, PilaDeCartas pilaDeCartas, boolean corrimientoY) {

        this.solitario = solitario;
        this.pila = pilaDeCartas;
        this.corrimiento = corrimientoY;
        solitario.agregarListener(this);
        agregarVistaPila(corrimientoY);

    }


    protected void agregarVistaCarta( VistaCarta vistaCarta, double corrimientoY) {
        vistaCarta.setTranslateY(corrimientoY);
        vistaCarta.setOnMouseClicked(event -> manejoPilaLlenaClick(vistaCarta, this));
        getChildren().add(vistaCarta);
    }

    protected void agregarVistaPila(boolean corrimientoY) {

        PilaDeCartas pilaInvertida = this.pila.invertir();
        int corrimiento = 0;

        if (pila.isEmpty()) {
            final ImageView imagen = new ImageView(new Image(Configuracion.rutaImagenesCartas + "libre.png"));
            imagen.setOnMouseClicked(event -> manejoPilaVaciaClick(imagen, this));
            imagen.setFitHeight( Configuracion.ALTO_VENTANA / 6);
            imagen.setFitWidth(Configuracion.ANCHO_VENTANA / 13);
            getChildren().add(imagen);
        } else {
            while (!pilaInvertida.isEmpty()) {
                agregarVistaCarta(new VistaCarta(pilaInvertida.pop()), corrimiento * posicionY);
                if (corrimientoY) {
                    corrimiento++;
                }

            }

        }
    }


    protected void manejoPilaLlenaClick(VistaCarta vistaCarta, VistaPilaDeCartas vistaPila) {


        if (solitario.getPilaOrigen() == null) {

            Carta carta = vistaCarta.getCarta();
            Carta cartaAux;
            VistaCarta vistaCartaAux;
            int i = vistaPila.getChildren().size()-1;

            //selecciono desde la que apreto hacia abajo siempre que no este boca abajo
            do {
                vistaCartaAux = (VistaCarta) vistaPila.getChildren().get(i);
                cartaAux = vistaCartaAux.getCarta();

                if (cartaAux.getBocaAbajo()){
                    break;
                }

                vistaCartaAux.setStyle(Configuracion.CARTA_APRETADA);
                i--;
            } while (carta != cartaAux );

            solitario.setPilaOrigen(this.getPilaDeCartas());
            solitario.setCartaOrigen(carta);

        }
        else {
            if( ! solitario.moverCartas(solitario.getPilaOrigen(),this.getPilaDeCartas(),solitario.getCartaOrigen())) {
               System.out.println("error");
            }
            solitario.setPilaOrigen(null);
            solitario.setCartaOrigen(null);
        }
    }

    protected void manejoPilaVaciaClick(ImageView vistaCarta, VistaPilaDeCartas vistaPila) {


        if (solitario.getPilaOrigen() == null) {
            System.out.println("error");
        }
        else {
            if( ! solitario.moverCartas(solitario.getPilaOrigen(),this.getPilaDeCartas(),solitario.getCartaOrigen())) {
                System.out.println("error");
            }
            solitario.setPilaOrigen(null);
            solitario.setCartaOrigen(null);
        }
    }


    public PilaDeCartas getPilaDeCartas(){return this.pila; }
    public Solitario getSolitario(){return this.solitario; }
    @Override
    public void escuchar() {
        //actualizo la pantalla
        getChildren().clear();
        agregarVistaPila(this.corrimiento);
    }

}
