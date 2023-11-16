package ui.klondike;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import klondike.SolitarioKlondike;
import modelosolitario.Descarte;
import modelosolitario.Mazo;
import ui.VistaCimiento;

import java.util.ArrayList;

public class KlondikeUI extends GridPane {


    public void KlondikeUI() {

    }

    public void mostrar(Stage stage) {
        GridPane tablero = new GridPane();
        tablero.setStyle("-fx-background-color: green");
        SolitarioKlondike s = new SolitarioKlondike();
        tablero.add(new VistaMazo(s),0,0);
        tablero.add(new VistaDescarte(s),1,0);
        ArrayList<VistaCimiento> cimientos = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            cimientos.add(new VistaCimiento());
            tablero.add(cimientos.get(i), 5 + i, 0);
        }
        Scene scene = new Scene(tablero, 500, 400);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

}