package ui.freecell;

import freecell.PilaSuperior;
import freecell.SolitarioFreeCell;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import modelosolitario.Cimiento;
import ui.*;


import java.util.ArrayList;

public class FreecellUI extends GridPane {

    private Stage stage;
    private SolitarioFreeCell solitario;

    public FreecellUI(Stage stage, SolitarioFreeCell solitario) {
        this.stage = stage;
        this.solitario = solitario;
    }

    public void mostrar() {
        GridPane tablero = new GridPane();
        tablero.setHgap(Configuracion.ANCHO_VENTANA/80);
        tablero.setVgap(Configuracion.ALTO_VENTANA/80);
        tablero.setStyle(Configuracion.BACKGROUD_COLOR);

        ArrayList<VistaPilaSuperior> vistaPilasSuperiores = new ArrayList<>();
        ArrayList<PilaSuperior> pilasSuperiores = solitario.getPilasSuperiores();
        for(int i = 0; i < 4; i++){
            vistaPilasSuperiores.add(new VistaPilaSuperior(pilasSuperiores.get(i)));
            tablero.add(vistaPilasSuperiores.get(i), i, 1);
        }

        ArrayList<VistaCimiento> vistaCimientos = new ArrayList<>();
        ArrayList<Cimiento> cimientos = solitario.getCimientos();
        for(int i = 0; i < 4; i++){
            vistaCimientos.add(new VistaCimiento(cimientos.get(i)));
            tablero.add(vistaCimientos.get(i), 5 + i, 1);
        }

        for (int i = 0; i < solitario.getPilas().size(); i++) {
            VistaPilaDeCartas vistaPila = new VistaPilaDeCartas(solitario.getPilas().get(i), true);
            tablero.add(vistaPila,  i, 10);
        }

        tablero.add(new VistaMovimientos(solitario), 12,1 );

        Scene scene = new Scene(tablero, Configuracion.ANCHO_VENTANA*1.2, Configuracion.ALTO_VENTANA);

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
