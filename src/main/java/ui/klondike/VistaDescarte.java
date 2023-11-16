package ui.klondike;

import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import klondike.SolitarioKlondike;
import modeloelementos.Carta;
import modelosolitario.Descarte;
import ui.Listener;
import ui.VistaCarta;

public class VistaDescarte extends HBox implements Listener {
    private static final int PADDING = 5;
    private SolitarioKlondike solitario;

    public VistaDescarte(SolitarioKlondike s){
        this.solitario = s;
        setPadding(new Insets(PADDING));
        ImageView imagen = new ImageView(VistaCarta.getReverso());
        imagen.setVisible(false);
        getChildren().add(imagen);
        solitario.agregarListener(this);
    }

    @Override
    public void escuchar() {
        getChildren().get(0).setVisible(true);
        Carta c = solitario.getDescarte().peek();
        ImageView imagen = (ImageView) this.getChildren().get(0);
        imagen.setImage(VistaCarta.getImagenCarta(c));
    }
}
