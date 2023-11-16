package ui;

import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import modelosolitario.Cimiento;

public class VistaCimiento extends VistaPilaDeCartas {

    private static final int PADDING = 2;

    public VistaCimiento(Cimiento cimiento){
        super(cimiento, false);
        if (cimiento.isEmpty()){
            setStyle(Configuracion.ESTILO_BORDE);
            setPadding(new Insets(PADDING));
            setPrefSize(Configuracion.ANCHO_VENTANA/13,Configuracion.ALTO_VENTANA/6);
            final ImageView imagen = new ImageView(VistaCarta.getReverso());
            imagen.setVisible(false);
            getChildren().add(imagen);
        }
    }
}
