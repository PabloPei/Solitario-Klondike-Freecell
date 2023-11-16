package ui;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import klondike.SolitarioKlondike;
import ui.Listener;

public class VistaMovimientos extends HBox implements Listener {

    private SolitarioKlondike solitario;
    private Label label;  // Declarar label como un atributo de clase

    public VistaMovimientos(SolitarioKlondike s) {
        this.solitario = s;
        label = new Label("Movimientos: 0 ");  // Inicializar label
        label.setStyle("-fx-font-family: 'Courier New';" +
                "-fx-font-size: 30px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #FFFFFF;"+
                "-fx-alignment: center;");
        getChildren().add(label);

        solitario.agregarListener(this);
    }

    @Override
    public void escuchar() {
        int movimientos = solitario.getMovimientos();
        label.setText("Movimientos: " + movimientos);
    }
}
