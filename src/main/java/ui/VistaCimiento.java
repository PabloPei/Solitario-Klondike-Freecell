package ui;

import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class VistaCimiento extends StackPane {

    private static final int PADDING = 2;

    public VistaCimiento(){

        setStyle(Configuracion.ESTILO_BORDE);
        setPadding(new Insets(PADDING));
        setPrefSize(Configuracion.ANCHO_VENTANA/13,Configuracion.ALTO_VENTANA/6);
        final ImageView imagen = new ImageView(VistaCarta.getReverso());
        imagen.setVisible(false);
        getChildren().add(imagen);

    }
}
