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

        GridPane layout = new GridPane();
        layout.setStyle(Configuracion.BACKGROUD_COLOR);
        layout.setPadding(new Insets(Configuracion.ANCHO_VENTANA * 1/10,10,Configuracion.ALTO_VENTANA * 1/10, 10));

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

        Scene scene = new Scene(layout, Configuracion.ANCHO_VENTANA, Configuracion.ALTO_VENTANA);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Seleccionar Solitario");
        primaryStage.show();
    }

        public static void main(String[] args) {launch(args);
        }
}


