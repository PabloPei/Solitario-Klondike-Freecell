import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import modelosolitario.Solitario;
import modelosolitario.TiposSolitario;
import ui.Configuracion;
import ui.VistaTiposSolitario;


public class Main extends Application  {


    // se deberia chequear de que no haya algun solitario guardado
    @Override
    public void start(Stage primaryStage) {

        GridPane layout = new VistaTiposSolitario(primaryStage);

        Scene scene = new Scene(layout, Configuracion.ANCHO_VENTANA, Configuracion.ALTO_VENTANA);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Seleccionar Solitario");
        primaryStage.show();
    }

        public static void main(String[] args) {launch(args);
        }
}


