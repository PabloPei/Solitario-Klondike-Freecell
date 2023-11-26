import freecell.SolitarioFreeCell;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import klondike.SolitarioKlondike;
import modelosolitario.Solitario;
import ui.ConfiguracionUI;
import ui.SolitarioUI;
import ui.VistaSeleccionSolitario;
import ui.freecell.FreecellUI;
import ui.klondike.KlondikeUI;
import java.io.*;


public class Main extends Application  {
    private VistaSeleccionSolitario vistaSeleccion;
    private Solitario solitario;

    private void seleccionSolitario(Stage primaryStage) {
        vistaSeleccion = new VistaSeleccionSolitario(primaryStage);
        Scene scene = new Scene(vistaSeleccion, ConfiguracionUI.ANCHO_VENTANA, ConfiguracionUI.ALTO_VENTANA);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Seleccionar Solitario");
    }

    @Override
    public void start(Stage primaryStage) {

        FileInputStream is;
        Solitario s = null;
        try {
            is = new FileInputStream(ConfiguracionUI.RUTA_SERIALIZACION);
            s = Solitario.deSerializar(is);
        } catch (IOException | ClassNotFoundException e) {
            seleccionSolitario(primaryStage);
            solitario = vistaSeleccion.getSolitario();
        }
        if (s != null){
            solitario = s;
            SolitarioUI ui;
            if (s.getClass() == SolitarioKlondike.class) {
                ui = new KlondikeUI(primaryStage, (SolitarioKlondike) s);
            } else {
                ui = new FreecellUI(primaryStage, (SolitarioFreeCell) s);
            }
            ui.mostrar();
        }
        primaryStage.show();
    }

    @Override
    public void stop() throws IOException {
            if (solitario != null && solitario.verificarVictoria()) return;
        if (vistaSeleccion == null){
            solitario.serializar(new FileOutputStream(ConfiguracionUI.RUTA_SERIALIZACION));
        }
        solitario.serializar(new FileOutputStream(ConfiguracionUI.RUTA_SERIALIZACION));
    }
    public static void main(String[] args) {
        launch(args);
    }
}


