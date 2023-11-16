import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import modelosolitario.Solitario;
import modelosolitario.TiposSolitario;
import ui.VistaTiposSolitario;


public class Main extends Application  {


    // se deberia chequear de que no haya algun solitario guardado
    @Override
    public void start(Stage primaryStage) {

        // Obtén las dimensiones de la pantalla
        Screen screen = Screen.getPrimary();
        double ancho = (screen.getBounds().getWidth()) * 1 / 2;
        double alto = (screen.getBounds().getHeight()) * 1 / 2;

        GridPane layout = new GridPane();
        layout.setStyle("-fx-background-color: green");
        layout.setPadding(new Insets(alto * 1/5,10,alto * 1/5, 10));

        int cantidadTipos = TiposSolitario.values().length;

        // Configurar ColumnConstraints para ajustar automáticamente el ancho
        for (int i = 0; i < cantidadTipos; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(100.0 / cantidadTipos);
            layout.getColumnConstraints().add(column);
        }

        for (TiposSolitario tipo : TiposSolitario.values()) {
            VistaTiposSolitario tipoSolitario = new VistaTiposSolitario(tipo, primaryStage);
            layout.add(tipoSolitario, tipo.ordinal(), 0);
        }

        Scene scene = new Scene(layout, ancho, alto);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Seleccionar Solitario");
        primaryStage.show();
    }

        public static void main(String[] args) {launch(args);
        }
}


