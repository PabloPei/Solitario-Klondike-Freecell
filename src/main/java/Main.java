import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ui.ConfiguracionUI;
import ui.VistaSeleccionSolitario;


public class Main extends Application  {


    // se deberia chequear de que no haya algun solitario guardado
    @Override
    public void start(Stage primaryStage) {

        GridPane layout = new VistaSeleccionSolitario(primaryStage);

        Scene scene = new Scene(layout, ConfiguracionUI.ANCHO_VENTANA, ConfiguracionUI.ALTO_VENTANA);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Seleccionar Solitario");
        primaryStage.show();
    }

        public static void main(String[] args) {launch(args);
        }
}


