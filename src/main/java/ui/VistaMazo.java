package ui;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import modelosolitario.Mazo;

public class VistaMazo extends HBox {
    private static String BOTON_ESTADO_NORMAL
            = "-fx-background-color: transparent; -fx-padding:5,5,5,5;";
    private static String BOTON_APRETADO
            = "-fx-background-color: transparent; -fx-padding:6,4,4,6;";

    private static ImageView reverso = new ImageView(VistaCarta.getReverso());
    private boolean bocaAbajo = true;
    private Mazo mazo;
    public VistaMazo(Mazo mazo){
        this.mazo = mazo;
        Button boton = new Button();
        boton.setGraphic(reverso);
        boton.setStyle(BOTON_ESTADO_NORMAL);
        getChildren().add(boton);

        boton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (bocaAbajo){
                    ((Button) mouseEvent.getSource()).setGraphic(new ImageView(VistaCarta.getImagenCarta(mazo.verCarta())));
                    ((Button)mouseEvent.getSource()).setStyle(BOTON_APRETADO);
                    bocaAbajo = false;
                } else{
                    ((Button) mouseEvent.getSource()).setGraphic(reverso);
                    ((Button)mouseEvent.getSource()).setStyle(BOTON_ESTADO_NORMAL);
                    bocaAbajo = true;
                }
            }
        });
    }
}
