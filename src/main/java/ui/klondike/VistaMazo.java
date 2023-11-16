package ui.klondike;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import klondike.SolitarioKlondike;
import modeloelementos.Carta;
import modelosolitario.Mazo;
import ui.Configuracion;
import ui.Listener;
import ui.VistaCarta;

public class VistaMazo extends HBox {


    private SolitarioKlondike solitario;


    public VistaMazo(SolitarioKlondike s){

        this.solitario = s;

        Button boton = new Button();
        Image imagenMazo = new Image("file:src/main/recursos/imagenesCartas/mazo.png");
        boton.setGraphic(new ImageView(imagenMazo));
        boton.setPrefSize(Configuracion.ANCHO_VENTANA/13,Configuracion.ALTO_VENTANA/6);
        boton.setStyle(Configuracion.BOTON_ESTADO_NORMAL);

        getChildren().add(boton);

        boton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                    ((Button)mouseEvent.getSource()).setStyle(Configuracion.BOTON_APRETADO);
                }
        });

        boton.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ((Button)mouseEvent.getSource()).setStyle(Configuracion.BOTON_ESTADO_NORMAL);
                s.robarCartasDelMazo();
            }
        });

    }

}
