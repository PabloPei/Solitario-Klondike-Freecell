import freecell.SolitarioFreeCell;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import klondike.SolitarioKlondike;
import modelosolitario.Solitario;
import ui.ConfiguracionUI;
import ui.SolitarioUI;
import ui.VistaSeleccionSolitario;
import ui.freecell.FreecellUI;
import ui.klondike.KlondikeUI;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


public class Main extends Application  {
    private Solitario solitario;

    // se deberia chequear de que no haya algun solitario guardado

    private void seleccionSolitario(Stage primaryStage){
        GridPane layout = new VistaSeleccionSolitario(primaryStage);

        Scene scene = new Scene(layout, ConfiguracionUI.ANCHO_VENTANA, ConfiguracionUI.ALTO_VENTANA);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Seleccionar Solitario");
    }

    private void buscarSerializacion(InputStream is, Solitario s, Stage stage){
        try {
            s = Solitario.deSerializar(is);
        } catch (IOException | ClassNotFoundException e) {
            seleccionSolitario(stage);
        }
    }
    @Override
    public void start(Stage primaryStage) {

        InputStream is = null;
        Solitario s = null;
        buscarSerializacion(is, s, primaryStage);
        if (s == null){
            seleccionSolitario(primaryStage);
        } else {
            SolitarioUI ui;
            if (s.getClass() == SolitarioKlondike.class){
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
        OutputStream os = null;
        solitario.serializar(os);
    }

        public static void main(String[] args) {
            launch(args);
        }
}


