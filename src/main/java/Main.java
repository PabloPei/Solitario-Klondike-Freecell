import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import klondike.SolitarioKlondike;
import modelosolitario.Descarte;
import modelosolitario.Mazo;
import ui.VistaCimiento;
import ui.klondike.VistaMazo;
import ui.klondike.VistaDescarte;

import java.util.ArrayList;


public class Main extends Application {
     @Override
     public void start(Stage primaryStage) {
//         Mazo m = new Mazo();
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
         primaryStage.setResizable(false);
         primaryStage.setScene(scene);
         primaryStage.show();



     }

        public static void main(String[] args) {
            launch(args);
        }
}


