package ui.klondike;


import javafx.scene.layout.StackPane;
import klondike.SolitarioKlondike;
import modeloelementos.Carta;
import ui.ConfiguracionUI;
import ui.Listener;
import ui.VistaCarta;

public class VistaDescarte extends StackPane implements Listener {

    private SolitarioKlondike solitario;

    public VistaDescarte(SolitarioKlondike s){
        this.solitario = s;
        setPrefSize(ConfiguracionUI.ANCHO_VENTANA/13, ConfiguracionUI.ALTO_VENTANA/6);
        solitario.agregarListener(this);
    }

    @Override
    public void escuchar() {
        Carta c = solitario.getDescarte().sacarCarta(false);
        if (c != null){
            VistaCarta carta = new VistaCarta(c);
            getChildren().add(carta);
        }

    }
}