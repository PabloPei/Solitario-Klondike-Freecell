package ui.klondike;

import javafx.event.EventHandler;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import klondike.SolitarioKlondike;
import modeloelementos.PilaDeCartas;
import modelosolitario.Solitario;
import ui.Configuracion;
import ui.VistaPilaDeCartas;


public class VistaTableau extends GridPane {


    public VistaTableau(SolitarioKlondike solitario) {

        for (int i = 0; i < solitario.getPilas().size(); i++) {
            VistaPilaDeCartas vistaPila = new VistaPilaDeCartas(solitario.getPilas().get(i), true);
            add(vistaPila,  i, 1);
        }
        setHgap(Configuracion.ANCHO_VENTANA/80);

    }
}
