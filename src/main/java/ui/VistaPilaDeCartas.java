package ui;

import javafx.scene.layout.StackPane;
import modeloelementos.PilaDeCartas;

public class VistaPilaDeCartas extends StackPane {
    private static final double posicionY = 17;//cambiar
    public VistaPilaDeCartas(PilaDeCartas pilaDeCartas, boolean corrimientoY) {
        PilaDeCartas pilaInvertida =  pilaDeCartas.invertir();
        int corrimiento = 0;
        while(!pilaInvertida.isEmpty()) {
            agregarVistaCarta(new VistaCarta(pilaInvertida.pop()), corrimiento*posicionY);
            if (corrimientoY) {corrimiento++;}
        }
    }

    private void agregarVistaCarta( VistaCarta vistaCarta, double corrimientoY) {
        vistaCarta.setTranslateY(corrimientoY);
        getChildren().add(vistaCarta);
    }
}
