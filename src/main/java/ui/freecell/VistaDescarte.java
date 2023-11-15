package ui.freecell;

import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import modelosolitario.Descarte;
import ui.VistaCarta;
import ui.VistaCimiento;
import ui.VistaMazo;

public class VistaDescarte extends HBox {
    private Descarte descarte;
    private static final int PADDING = 5;

    public VistaDescarte(Descarte descarte){
        setPadding(new Insets(PADDING));
        this.descarte = descarte;
        ImageView imagen;
        if (descarte.isEmpty()){
            imagen = new ImageView(VistaCarta.getReverso());
        } else {
            imagen = new ImageView(VistaCarta.getImagenCarta(descarte.verCarta()));
        }

        imagen.setVisible(false);
        getChildren().add(imagen);
    }

}
