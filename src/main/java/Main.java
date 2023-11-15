import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import modeloelementos.Carta;
import modeloelementos.Palo;
import modeloelementos.ValorCarta;
import modelosolitario.Descarte;
import modelosolitario.Mazo;
import modelosolitario.Pila;
import ui.VistaCimiento;
import ui.VistaMazo;
import ui.VistaPilas;
import ui.freecell.VistaDescarte;

import java.util.ArrayList;


public class Main extends Application {
     @Override
     public void start(Stage primaryStage) {
         Mazo m = new Mazo();
         GridPane tablero = new GridPane();
         tablero.setStyle("-fx-background-color: green");
         tablero.add(new VistaMazo(m),0,0);
         Descarte d = new Descarte();
         tablero.add(new VistaDescarte(d),1,0);
         ArrayList<VistaCimiento> cimientos = new ArrayList<>();
         for(int i = 0; i < 4; i++){
             cimientos.add(new VistaCimiento());
             tablero.add(cimientos.get(i), 5 + i, 0);
         }
         Scene scene = new Scene(tablero, 500, 400);
         primaryStage.setResizable(false);
         primaryStage.setScene(scene);
         primaryStage.show();



     }

        public static void main(String[] args) {
            launch(args);
        }
}


