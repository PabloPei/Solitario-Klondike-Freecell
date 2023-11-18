package ui;

import javafx.event.EventHandler;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import modeloelementos.PilaDeCartas;


public class VistaPilaDeCartas extends StackPane {
    private static final double posicionY = 20;//cambiar
    public VistaPilaDeCartas(PilaDeCartas pilaDeCartas, boolean corrimientoY) {

        PilaDeCartas pilaInvertida = pilaDeCartas.invertir();
        int corrimiento = 0;
        while (!pilaInvertida.isEmpty()) {
            agregarVistaCarta(new VistaCarta(pilaInvertida.pop()), corrimiento * posicionY);
            if (corrimientoY) {
                corrimiento++;
            }

        }

        //Agrego eventos a la ultima carta
        if (!getChildren().isEmpty()) {
            VistaCarta ultimaCarta = (VistaCarta) getChildren().get(getChildren().size() - 1);

            ultimaCarta.setOnMouseEntered(event -> ultimaCarta.setStyle(Configuracion.CARTA_MOUSE_ARRIBA));
            ultimaCarta.setOnMouseExited(mouseEvent  -> ultimaCarta.setStyle(Configuracion.BOTON_ESTADO_NORMAL));
            ultimaCarta.setOnMousePressed(event -> {

                ultimaCarta.setUserData(new double[]{event.getSceneX(), event.getSceneY()});
            });

        }
    }


    private void agregarVistaCarta( VistaCarta vistaCarta, double corrimientoY) {
        vistaCarta.setTranslateY(corrimientoY);
        getChildren().add(vistaCarta);
    }
}
