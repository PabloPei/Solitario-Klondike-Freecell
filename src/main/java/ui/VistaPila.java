package ui;

import javafx.scene.layout.StackPane;
import modelosolitario.Pila;


public class VistaPila extends StackPane {
    private static final double posicionY = 17;//cambiar
    public VistaPila(Pila pila, double posicionX) {
        this.setTranslateX(posicionX);
        Pila pilaInvertida =  pila.invertir();
        int corrimiento = 0;
        while(!pilaInvertida.isEmpty()) {
            agregarVistaCarta(new VistaCarta(pilaInvertida.pop()), corrimiento*posicionY);
            corrimiento++;
        }
    }

    private void agregarVistaCarta( VistaCarta vistaCarta, double corrimientoY) {
        vistaCarta.setTranslateY(corrimientoY);
        getChildren().add(vistaCarta);
    }
}
