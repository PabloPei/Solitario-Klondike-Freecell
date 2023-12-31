package ui;

import freecell.SolitarioFreeCell;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import klondike.SolitarioKlondike;
import modelosolitario.*;
import ui.freecell.FreecellUI;
import ui.klondike.KlondikeUI;

import java.io.FileInputStream;
import java.io.IOException;


public class VistaSeleccionSolitario extends GridPane {

    Solitario actual;
    public VistaSeleccionSolitario(Stage stage) {

        setStyle(ConfiguracionUI.BACKGROUD_COLOR);
        setPadding(new Insets(ConfiguracionUI.ANCHO_VENTANA * 1/10, ConfiguracionUI.ANCHO_VENTANA * 1/10, ConfiguracionUI.ALTO_VENTANA * 1/10, ConfiguracionUI.ANCHO_VENTANA * 1/10));

        int cantidadTipos = TiposSolitario.values().length;

        for (int i = 0; i < cantidadTipos; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(100.0 / cantidadTipos);
            getColumnConstraints().add(column);
        }

        for (TiposSolitario tipo : TiposSolitario.values()) {
            String rutaImagen = ConfiguracionUI.RUTA_IMAGENES_SOLITARIOS + tipo.toString() + ".png";
            Image imagenSolitario = new Image(rutaImagen);
            ImageView imageView = new ImageView(imagenSolitario);
            Button seleccionarButton = new Button("",imageView);
            seleccionarButton.setStyle(ConfiguracionUI.BOTON_SELECCION_ESTADO_NORMAL);

            seleccionarButton.setOnMouseEntered(mouseEvent  -> seleccionarButton.setStyle(ConfiguracionUI.BOTON_SELECCION_MOUSE_ARRIBA));
            seleccionarButton.setOnMouseExited(mouseEvent  -> seleccionarButton.setStyle(ConfiguracionUI.BOTON_SELECCION_ESTADO_NORMAL));
            seleccionarButton.setOnAction(e -> {
                 switch (tipo) {
                      case FREECELL -> {
                          if (buscarSolitarioPorTipo() && actual.getClass() == SolitarioFreeCell.class){
                              iniciarSolitarioExistente(stage);
                          } else {
                              actual = new SolitarioFreeCell();
                              FreecellUI ui = new FreecellUI(stage, (SolitarioFreeCell) actual);
                              ui.mostrar();
                          }
                      }
                      case KLONDIKE -> {
                          if (buscarSolitarioPorTipo() && actual.getClass() == SolitarioKlondike.class){
                              iniciarSolitarioExistente(stage);
                          } else {
                              actual = new SolitarioKlondike();
                              KlondikeUI ui = new KlondikeUI(stage, (SolitarioKlondike) actual);
                              ui.mostrar();
                          }

                      }
                 }
            });
            add(seleccionarButton,tipo.ordinal(),0);
        }
    }

    private boolean buscarSolitarioPorTipo(){
        try {
            FileInputStream is = new FileInputStream(ConfiguracionUI.RUTA_SERIALIZACION);
            actual = Solitario.deSerializar(is);
        } catch (IOException | ClassNotFoundException e){
            return false;
        }
        return true;
    }
    private void iniciarSolitarioExistente(Stage stage){
        SolitarioUI ui;
        if (actual.getClass() == SolitarioKlondike.class) {
            ui = new KlondikeUI(stage, (SolitarioKlondike) actual);
        } else {
            ui = new FreecellUI(stage, (SolitarioFreeCell) actual);
        }
        ui.mostrar();
    }
    public Solitario getSolitario() { return actual; }
}