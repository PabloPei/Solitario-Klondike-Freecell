import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {
     @Override
        public void start(Stage primaryStage) {
            StackPane tablero = new StackPane();
            Scene scene = new Scene(tablero, 500, 400);
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
}


