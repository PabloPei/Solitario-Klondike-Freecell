package ui;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import modelosolitario.Solitario;

public class VistaMovimientos extends HBox implements Listener {

    private Solitario solitario;
    private Label label;  // Declarar label como un atributo de clase

    public VistaMovimientos(Solitario s) {
        this.solitario = s;
        label = new Label("Movimientos: 0 ");  // Inicializar label
        label.setStyle(ConfiguracionUI.ESTILO_TITULO);
        getChildren().add(label);

        solitario.agregarListener(this);
    }

    @Override
    public void escuchar() {
        int movimientos = solitario.getMovimientos();
        label.setText("Movimientos: " + movimientos);
    }
}
