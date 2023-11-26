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
    }

    private void iniciarSolitarioExistente(Solitario s, Stage stage){
        solitario = s;
        SolitarioUI ui;
        if (s.getClass() == SolitarioKlondike.class) {
            ui = new KlondikeUI(stage, (SolitarioKlondike) s);
        } else {
            ui = new FreecellUI(stage, (SolitarioFreeCell) s);
        }
        ui.mostrar();
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
        }
        if (s != null) iniciarSolitarioExistente(s, primaryStage);
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


