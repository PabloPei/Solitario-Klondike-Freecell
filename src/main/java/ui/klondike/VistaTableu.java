package ui.klondike;

import javafx.scene.layout.GridPane;
import klondike.SolitarioKlondike;
import modeloelementos.Carta;
import modeloelementos.PilaDeCartas;
import ui.ConfiguracionUI;
import ui.ConfiguracionUI;
import ui.VistaPilaDeCartas;

import java.awt.*;


public class VistaTableu extends GridPane {

    private VistaPilaDeCartas pilaOrigen;
    private SolitarioKlondike solitario;

    public VistaTableu(SolitarioKlondike solitario) {

        this.solitario = solitario;

        for (int i = 0; i < solitario.getPilas().size(); i++) {
            VistaPilaDeCartas vistaPila = new VistaPilaDeCartas(solitario.getPilas().get(i), true);

            vistaPila.setOnMouseClicked(event -> manejoPilaClick(vistaPila));
            add(vistaPila,  i, 1);
            solitario.agregarListener(vistaPila);

        }
        setHgap(ConfiguracionUI.ANCHO_VENTANA/80);

    }

    private void manejoPilaClick(VistaPilaDeCartas vistaPila) {


        if (pilaOrigen == null) {
            pilaOrigen = vistaPila;
        } else {
            // Segundo clic, intenta mover la carta de pilaOrigen a pila
            PilaDeCartas pilaOrigenModelo = pilaOrigen.getPilaDeCartas();
            PilaDeCartas pilaDestinoModelo = vistaPila.getPilaDeCartas();

            if (! solitario.moverCarta(pilaOrigenModelo, pilaDestinoModelo )) {
                System.out.println("error");
            }

            pilaOrigen = null;



        }
    }


}
