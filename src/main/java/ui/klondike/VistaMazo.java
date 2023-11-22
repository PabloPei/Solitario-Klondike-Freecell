package ui.klondike;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import klondike.SolitarioKlondike;
import ui.ConfiguracionUI;

public class VistaMazo extends HBox {


    private final SolitarioKlondike solitario;


    public VistaMazo(SolitarioKlondike s){

        this.solitario = s;

        Button boton = new Button();
        Image imagenMazo = new Image("file:src/main/recursos/imagenesCartas/mazo.png");
        boton.setGraphic(new ImageView(imagenMazo));
        boton.setPrefSize(ConfiguracionUI.ANCHO_VENTANA/13, ConfiguracionUI.ALTO_VENTANA/6);
        boton.setStyle(ConfiguracionUI.BOTON_ESTADO_NORMAL);

        getChildren().add(boton);

        boton.setOnMousePressed(mouseEvent -> ((Button)mouseEvent.getSource()).setStyle(ConfiguracionUI.BOTON_APRETADO));

        boton.setOnMouseReleased(mouseEvent -> {
            ((Button) mouseEvent.getSource()).setStyle(ConfiguracionUI.BOTON_ESTADO_NORMAL);
            solitario.robarCartasDelMazo();
        });




    }

}
