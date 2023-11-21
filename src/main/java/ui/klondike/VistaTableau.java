package ui.klondike;

import javafx.scene.layout.GridPane;
import klondike.SolitarioKlondike;
import ui.Configuracion;
import ui.VistaPilaDeCartas;


public class VistaTableau extends GridPane {


    public VistaTableau(SolitarioKlondike solitario) {

        for (int i = 0; i < solitario.getPilas().size(); i++) {
            VistaPilaDeCartas vistaPila = new VistaPilaDeCartas(solitario, solitario.getPilas().get(i), true);
            add(vistaPila,  i, 1);
        }
        setHgap(Configuracion.ANCHO_VENTANA/80);

    }
}
