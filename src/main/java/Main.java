import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelosolitario.Solitario;
import ui.ConfiguracionUI;
import ui.VistaSeleccionSolitario;
import java.io.*;


public class Main extends Application  {
    private VistaSeleccionSolitario vistaSeleccion;
    private Solitario solitario;

    @Override
    public void start(Stage primaryStage) {
        vistaSeleccion = new VistaSeleccionSolitario(primaryStage);
        Scene scene = new Scene(vistaSeleccion, ConfiguracionUI.ANCHO_VENTANA, ConfiguracionUI.ALTO_VENTANA);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @Override
    public void stop() throws IOException {
        if (solitario != null && solitario.verificarVictoria()) return;
        if (solitario == null) {
            solitario = vistaSeleccion.getSolitario();
        }
        solitario.serializar(new FileOutputStream(ConfiguracionUI.RUTA_SERIALIZACION));
    }

    public static void main(String[] args) {
        launch(args);
    }
}


