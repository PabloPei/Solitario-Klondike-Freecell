package ui.klondike;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import klondike.SolitarioKlondike;
import ui.Configuracion;
import ui.VistaCimiento;
import ui.VistaMazo;

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
        tablero.setHgap(10);
        tablero.setStyle(Configuracion.BACKGROUD_COLOR);


        tablero.add(new VistaMazo(solitario),0,0);
        tablero.add(new VistaDescarte(solitario),1,0);


        ArrayList<VistaCimiento> cimientos = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            VistaCimiento cimiento = new VistaCimiento();
            cimientos.add(new VistaCimiento());
            tablero.add(cimientos.get(i), 5 + i, 0);

        }

        Scene scene = new Scene(tablero, Configuracion.ANCHO_VENTANA, Configuracion.ALTO_VENTANA);

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }



}