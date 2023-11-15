package ui;

import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class VistaCimiento extends StackPane {
    private static final int PADDING = 5;
    private static final String ESTILO_BORDE
            = "-fx-border-color: lightgray;" + "-fx-border-width: 1.5;" + "-fx-border-radius: 5.0;";
    private static final int alto = 60;
    private static final int ancho = 40;
    public VistaCimiento(){
        setPadding(new Insets(PADDING));
        setStyle(ESTILO_BORDE);
        final ImageView imagen = new ImageView(VistaCarta.getReverso());
        imagen.setVisible(false);
        setWidth(ancho);
        setHeight(alto);
        getChildren().add(imagen);
    }
}
