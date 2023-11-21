package ui.klondike;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import klondike.SolitarioKlondike;
import modeloelementos.EstadoJuego;
import modeloelementos.Palo;
import ui.*;

public class KlondikeUI extends GridPane implements Listener{

    private Stage stage;
    private SolitarioKlondike solitario;

    public KlondikeUI(Stage stage, SolitarioKlondike solitario) {
        this.stage = stage;
        this.solitario = solitario;
    }

    public void mostrar() {


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


        VistaTableau tableau = new VistaTableau(solitario);
        tablero.setColumnSpan(tableau,7);
        tablero.add(tableau,1,1);

        tablero.add(new VistaMovimientos(solitario), 8,0 );

        Scene scene = new Scene(tablero, Configuracion.ANCHO_VENTANA, Configuracion.ALTO_VENTANA);

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void escuchar() {
        if ( solitario.verificarEstado()== EstadoJuego.GANADO){
            
        }
    }
}