package ui.klondike;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import klondike.SolitarioKlondike;
import ui.Configuracion;

public class VistaMazo extends HBox {


    private final SolitarioKlondike solitario;


    public VistaMazo(SolitarioKlondike s){

        this.solitario = s;

        Button boton = new Button();
        Image imagenMazo = new Image("file:src/main/recursos/imagenesCartas/mazo.png");
        boton.setGraphic(new ImageView(imagenMazo));
        boton.setPrefSize(Configuracion.ANCHO_VENTANA/13,Configuracion.ALTO_VENTANA/6);
        boton.setStyle(Configuracion.BOTON_ESTADO_NORMAL);

        getChildren().add(boton);

        boton.setOnMousePressed(mouseEvent -> ((Button)mouseEvent.getSource()).setStyle(Configuracion.BOTON_APRETADO));

        boton.setOnMouseReleased(mouseEvent -> {
            ((Button) mouseEvent.getSource()).setStyle(Configuracion.BOTON_ESTADO_NORMAL);
            s.robarCartasDelMazo();
        });




    }

}
