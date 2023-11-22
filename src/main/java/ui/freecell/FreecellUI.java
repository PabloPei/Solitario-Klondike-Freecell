package ui.freecell;

import freecell.PilaSuperior;
import freecell.SolitarioFreeCell;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import modeloelementos.Palo;
import ui.*;


import java.util.ArrayList;

public class FreecellUI extends SolitarioUI {

    public FreecellUI(Stage stage, SolitarioFreeCell solitario) {
        super(stage, solitario);
    }

    public void mostrar() {
        GridPane tablero = new GridPane();
        tablero.setStyle(Configuracion.BACKGROUD_COLOR);
        tablero.setHgap(Configuracion.ANCHO_VENTANA/80);
        tablero.setVgap(Configuracion.ALTO_VENTANA/80);


        SolitarioFreeCell solitario = (SolitarioFreeCell) getSolitario();
        ArrayList<PilaSuperior> pilasSuperiores = solitario.getPilasSuperiores();

        for(int i = 0; i < 4; i++){
            VistaPilaDeCartas pilaSuperior = new VistaPilaDeCartas(solitario, pilasSuperiores.get(i), false);
            tablero.add(pilaSuperior, i, 0);
        }

        for(Palo palo : Palo.values()){
            VistaPilaDeCartas vistaCimiento = new VistaPilaDeCartas(solitario, solitario.getCimientos().get(palo.ordinal()),false);
            tablero.add(vistaCimiento, 5 + palo.ordinal(), 0);
        }

        for (int i = 0; i < solitario.getPilas().size(); i++) {
            VistaPilaDeCartas vistaPila = new VistaPilaDeCartas(solitario, solitario.getPilas().get(i), true);
            tablero.add(vistaPila,  i, 10);
        }

        tablero.add(new VistaMovimientos(solitario), 12,1 );

        Scene scene = new Scene(tablero, Configuracion.ANCHO_VENTANA*1.2, Configuracion.ALTO_VENTANA);

        Stage stage = getStage();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
