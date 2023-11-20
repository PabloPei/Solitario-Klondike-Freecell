package ui;

import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import modelosolitario.Cimiento;

public class VistaCimiento extends VistaPilaDeCartas {

    private static final int PADDING = 2;

    public VistaCimiento(Cimiento cimiento){

        super(cimiento, false);

        if (cimiento.isEmpty()){
            setStyle(ConfiguracionUI.ESTILO_BORDE);
            setPadding(new Insets(PADDING));
            setPrefSize(ConfiguracionUI.ANCHO_VENTANA/13, ConfiguracionUI.ALTO_VENTANA/6);
            final ImageView imagen = new ImageView(VistaCarta.getReverso());
            imagen.setVisible(false);
            getChildren().add(imagen);
        }

    }
}
