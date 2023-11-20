package ui.klondike;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import klondike.SolitarioKlondike;
import modeloelementos.Palo;
import modelosolitario.Cimiento;
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
        tablero.setStyle(ConfiguracionUI.BACKGROUD_COLOR);
        tablero.setHgap(ConfiguracionUI.ANCHO_VENTANA/80);
        tablero.setVgap(ConfiguracionUI.ALTO_VENTANA/80);

        tablero.add(new VistaMazo(solitario),0,0);
        tablero.add(new VistaDescarte(solitario),1,0);

        for(Palo palo : Palo.values()){
            VistaPilaDeCartas vistaCimiento = new VistaPilaDeCartas(solitario.getCimientos().get(palo.ordinal()),false);
            tablero.add(vistaCimiento, 2 + palo.ordinal(), 0);
        }

        VistaTableu tableu = new VistaTableu(solitario);
        tablero.setColumnSpan(tableu,7);
        tablero.add(tableu,1,1);

        tablero.add(new VistaMovimientos(solitario), 8,0 );

        Scene scene = new Scene(tablero, ConfiguracionUI.ANCHO_VENTANA, ConfiguracionUI.ALTO_VENTANA);

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}