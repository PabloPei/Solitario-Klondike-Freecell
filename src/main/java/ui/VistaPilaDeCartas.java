package ui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import modeloelementos.Carta;
import modeloelementos.PilaDeCartas;
import modelosolitario.Solitario;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.io.Serializable;


public class VistaPilaDeCartas extends StackPane implements Listener, Serializable {

    private static final double posicionY = 20;
    private final Solitario solitario;
    private final PilaDeCartas pila;
    private final boolean corrimiento;

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
            final ImageView imagen = new ImageView(new Image(ConfiguracionUI.RUTA_IMAGENES_CARTAS + "libre.png"));
            imagen.setOnMouseClicked(event -> manejoPilaVaciaClick());
            imagen.setFitHeight( ConfiguracionUI.ALTO_VENTANA / 6);
            imagen.setFitWidth(ConfiguracionUI.ANCHO_VENTANA / 13);
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

    protected void manejoMovimientosInvalidos(){
        if( ! solitario.moverCartas(solitario.getPilaOrigen(),this.getPilaDeCartas(),solitario.getCartaOrigen())) {
            Media sonido = new Media(new File(ConfiguracionUI.RUTA_SONIDOS + "movefail.mp3").toURI().toString());
            MediaPlayer sonidoMovimientoInvalido = new MediaPlayer(sonido);
            sonidoMovimientoInvalido.play();
        }
        solitario.setPilaOrigen(null);
        solitario.setCartaOrigen(null);
    }

    protected void manejoPilaLlenaClick(VistaCarta vistaCarta, VistaPilaDeCartas vistaPila) {
        if (solitario.getPilaOrigen() == null) {
            Carta carta = vistaCarta.getCarta();
            Carta cartaAux;
            VistaCarta vistaCartaAux;
            int i = vistaPila.getChildren().size()-1;

            do {
                vistaCartaAux = (VistaCarta) vistaPila.getChildren().get(i);
                cartaAux = vistaCartaAux.getCarta();
                vistaCartaAux.setStyle(ConfiguracionUI.CARTA_APRETADA);

                if(i>0){
                    vistaCartaAux = (VistaCarta) vistaPila.getChildren().get(i-1);
                    if (cartaAux.getBocaAbajo() ||
                            !(Carta.esValorSiguiente(cartaAux,vistaCartaAux.getCarta()) &&
                                    Carta.esColorAlternado(vistaCartaAux.getCarta(), cartaAux))){
                        break;
                    }
                }
                i--;
            } while (carta != cartaAux && i>=0);

            solitario.setPilaOrigen(this.getPilaDeCartas());
            solitario.setCartaOrigen(carta);
        }
        else {
            manejoMovimientosInvalidos();
        }
    }

    protected void manejoPilaVaciaClick() {
        Media sonido = new Media(new File(ConfiguracionUI.RUTA_SONIDOS + "movefail.mp3").toURI().toString());
        MediaPlayer sonidoMovimientoInvalido = new MediaPlayer(sonido);

        if (solitario.getPilaOrigen() == null) {
            sonidoMovimientoInvalido.play();
        }
        else {
            manejoMovimientosInvalidos();
        }
    }

    public PilaDeCartas getPilaDeCartas() { return this.pila; }

    public Solitario getSolitario() { return this.solitario; }

    @Override
    public void escuchar() {
        getChildren().clear();
        agregarVistaPila(this.corrimiento);
    }
}
