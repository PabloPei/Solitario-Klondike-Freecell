package ui.klondike;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import klondike.SolitarioKlondike;
import ui.*;
import java.util.ArrayList;

public class KlondikeUI extends GridPane {

    private Stage stage;
    private SolitarioKlondike solitario;

    public KlondikeUI(Stage stage, SolitarioKlondike solitario) {
        this.stage = stage;
        this.solitario = solitario;
    }

    public void mostrar() {


        GridPane tablero = new GridPane();
        tablero.setHgap(Configuracion.ANCHO_VENTANA/80);
        tablero.setVgap(Configuracion.ALTO_VENTANA/80);
        tablero.setStyle(Configuracion.BACKGROUD_COLOR);

        tablero.add(new VistaMazo(solitario),0,0);
        tablero.add(new VistaDescarte(solitario),1,0);

        ArrayList<VistaCimiento> cimientos = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            VistaCimiento cimiento = new VistaCimiento();
            cimientos.add(new VistaCimiento());
            tablero.add(cimientos.get(i), 3 + i, 0);

        }

        for (int i = 0; i < solitario.getPilas().size(); i++) {
            VistaPila vistaPila = new VistaPila(solitario.getPilas().get(i));
            tablero.add(vistaPila,  i, 1);
        }

        tablero.add(new VistaMovimientos(solitario), 8,0 );

        Scene scene = new Scene(tablero, Configuracion.ANCHO_VENTANA, Configuracion.ALTO_VENTANA);

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }



}