package ui.klondike;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import klondike.SolitarioKlondike;
import modeloelementos.Palo;
import ui.*;

public class KlondikeUI extends SolitarioUI{


    public KlondikeUI(Stage stage, SolitarioKlondike solitario) {
        super(stage, solitario);
    }

    @Override
    public void mostrar() {

        SolitarioKlondike solitario = (SolitarioKlondike) getSolitario();

        GridPane tablero = new GridPane();
        tablero.setStyle(Configuracion.BACKGROUD_COLOR);
        tablero.setHgap(Configuracion.ANCHO_VENTANA/80);
        tablero.setVgap(Configuracion.ALTO_VENTANA/80);

        tablero.add(new VistaMazo(solitario),0,0);
        tablero.add(new VistaDescarte(solitario, solitario.getDescarte(),false),1,0);


        for(Palo palo : Palo.values()){
            VistaPilaDeCartas vistaCimiento = new VistaPilaDeCartas(solitario, solitario.getCimientos().get(palo.ordinal()),false);
            tablero.add(vistaCimiento, 2 + palo.ordinal(), 0);
        }


        for (int i = 0; i < solitario.getPilas().size(); i++) {
            VistaPilaDeCartas vistaPila = new VistaPilaDeCartas(solitario, solitario.getPilas().get(i), true);
            tablero.add(vistaPila,  1+i, 1);
        }

        tablero.add(new VistaMovimientos(solitario), 8,0 );

        Scene scene = new Scene(tablero, Configuracion.ANCHO_VENTANA, Configuracion.ALTO_VENTANA);

        Stage stage = getStage();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}