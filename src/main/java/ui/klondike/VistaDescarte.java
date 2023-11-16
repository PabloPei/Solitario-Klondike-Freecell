package ui.klondike;


import javafx.scene.layout.StackPane;
import klondike.SolitarioKlondike;
import modeloelementos.Carta;
import ui.Configuracion;
import ui.Listener;
import ui.VistaCarta;

public class VistaDescarte extends StackPane implements Listener {

    private SolitarioKlondike solitario;

    public VistaDescarte(SolitarioKlondike s){
        this.solitario = s;
        setPrefSize(Configuracion.ANCHO_VENTANA/13,Configuracion.ALTO_VENTANA/6);
        solitario.agregarListener(this);
    }

    @Override
    public void escuchar() {
        Carta c = solitario.getDescarte().peek();
        VistaCarta carta = new VistaCarta(c);
        getChildren().add(carta);
    }
}