package ui.freecell;

import freecell.PilaSuperior;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import ui.ConfiguracionUI;
import ui.VistaCarta;
import ui.VistaPilaDeCartas;

public class VistaPilaSuperior extends VistaPilaDeCartas {
    private static final int PADDING = 2;

    public VistaPilaSuperior(PilaSuperior pilaSuperior){
        super(pilaSuperior, false);
        if (pilaSuperior.isEmpty()){
            setStyle(ConfiguracionUI.ESTILO_BORDE);
            setPadding(new Insets(PADDING));
            setPrefSize(ConfiguracionUI.ANCHO_VENTANA/13, ConfiguracionUI.ALTO_VENTANA/6);
            final ImageView imagen = new ImageView(VistaCarta.getReverso());
            imagen.setVisible(false);
            getChildren().add(imagen);
        }
    }
}
