package ui;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import modeloelementos.PilaDeCartas;



public class VistaPilaDeCartas extends StackPane implements Listener{

    private static final int PADDING = 2;

    private static final double posicionY = 20;
    private PilaDeCartas pila;

    public VistaPilaDeCartas(PilaDeCartas pilaDeCartas, boolean corrimientoY) {

        this.pila = pilaDeCartas;
        agregarVistaPila(corrimientoY);

/*
        //Agrego eventos a la ultima carta
        if (!getChildren().isEmpty()) {
            VistaCarta ultimaCarta = (VistaCarta) getChildren().get(getChildren().size() - 1);

            ultimaCarta.setOnMouseEntered(event -> ultimaCarta.setStyle(ConfiguracionUI.CARTA_MOUSE_ARRIBA));
            ultimaCarta.setOnMouseExited(mouseEvent  -> ultimaCarta.setStyle(ConfiguracionUI.BOTON_ESTADO_NORMAL));
            ultimaCarta.setOnMousePressed(event -> {

                ultimaCarta.setUserData(new double[]{event.getSceneX(), event.getSceneY()});
            });

        }

 */
    }


    public PilaDeCartas getPilaDeCartas(){return this.pila; }

    @Override
    public void escuchar() {
        if(pila.size() != getChildren().size()){

            getChildren().clear();
            agregarVistaPila(true);

        }
    }

    private void agregarVistaCarta( VistaCarta vistaCarta, double corrimientoY) {
        vistaCarta.setTranslateY(corrimientoY);
        getChildren().add(vistaCarta);
    }

    private void agregarVistaPila(boolean corrimientoY) {

        PilaDeCartas pilaInvertida = this.pila.invertir();
        int corrimiento = 0;

        if (pila.isEmpty()) {
            final ImageView imagen = new ImageView(new Image(ConfiguracionUI.rutaImagenesCartas + "libre.png"));
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
}
