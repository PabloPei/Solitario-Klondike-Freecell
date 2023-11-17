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

        //intento de agregarle efecto a la carta, no es por aca
        //VistaCarta ultimaCarta = (VistaCarta) getChildren().get(getChildren().size() - 1);
        //ultimaCarta.setOnMouseEntered(event -> setEffect(new DropShadow(20, Color.BLUE)));
    }


    private void agregarVistaCarta( VistaCarta vistaCarta, double corrimientoY) {
        vistaCarta.setTranslateY(corrimientoY);
        getChildren().add(vistaCarta);
    }
}
