package ui.klondike;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import klondike.SolitarioKlondike;
import modelosolitario.Mazo;
import ui.Listener;
import ui.VistaCarta;

public class VistaMazo extends HBox implements Listener {
    private static String BOTON_ESTADO_NORMAL
            = "-fx-background-color: transparent; -fx-padding:5,5,5,5;";
    private static String BOTON_APRETADO
            = "-fx-background-color: transparent; -fx-padding:6,4,4,6;";

    private static ImageView reverso = new ImageView(VistaCarta.getReverso());
    private SolitarioKlondike solitario;
    public VistaMazo(SolitarioKlondike s){
        this.solitario = s;
        Button boton = new Button();
        boton.setGraphic(reverso);
        boton.setStyle(BOTON_ESTADO_NORMAL);
        getChildren().add(boton);


        boton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                    ((Button)mouseEvent.getSource()).setStyle(BOTON_APRETADO);
                }
        });

        boton.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ((Button)mouseEvent.getSource()).setStyle(BOTON_ESTADO_NORMAL);
                s.robarCartasDelMazo();
            }
        });
        solitario.agregarListener(this);

    }

    @Override
    public void escuchar() {

    }
}
