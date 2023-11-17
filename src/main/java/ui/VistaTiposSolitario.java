package ui;

import freecell.SolitarioFreeCell;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import klondike.SolitarioKlondike;
import modelosolitario.TiposSolitario;
import ui.freecell.FreecellUI;
import ui.klondike.KlondikeUI;

import java.awt.event.MouseEvent;


public class VistaTiposSolitario extends GridPane {


    private static final String RUTAIMAGENTIPOSSOLITARIOS = "file:src/main/recursos/imagenesSolitarios/";


    public VistaTiposSolitario(Stage stage) {

        setStyle(Configuracion.BACKGROUD_COLOR);
        setPadding(new Insets(Configuracion.ANCHO_VENTANA * 1/10,Configuracion.ANCHO_VENTANA * 1/10,Configuracion.ALTO_VENTANA * 1/10, Configuracion.ANCHO_VENTANA * 1/10));

        int cantidadTipos = TiposSolitario.values().length;

        // Configurar ColumnConstraints para ajustar automáticamente el ancho
        for (int i = 0; i < cantidadTipos; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(100.0 / cantidadTipos);
            getColumnConstraints().add(column);
        }

        // Agrego un boton por cada tipo de solitario
        for (TiposSolitario tipo : TiposSolitario.values()) {
            String rutaImagen = RUTAIMAGENTIPOSSOLITARIOS + tipo.toString() + ".png";
            Image imagenSolitario = new Image(rutaImagen);
            ImageView imageView = new ImageView(imagenSolitario);
            Button seleccionarButton = new Button("",imageView);
            seleccionarButton.setStyle(Configuracion.BOTON_SELECCION_ESTADO_NORMAL);

            seleccionarButton.setOnMouseEntered(mouseEvent  -> {
                seleccionarButton.setStyle(Configuracion.BOTON_SELECCION_MOUSE_ARRIBA);
            });

            seleccionarButton.setOnMouseExited(mouseEvent  -> {
                seleccionarButton.setStyle(Configuracion.BOTON_SELECCION_ESTADO_NORMAL);
            });


            seleccionarButton.setOnAction(e -> {
                 switch (tipo) {
                      case FREECELL -> {
                                SolitarioFreeCell solitario = new SolitarioFreeCell();
                                FreecellUI ui = new FreecellUI(stage, solitario);
                                ui.mostrar();
                            }
                            case KLONDIKE -> {
                                SolitarioKlondike solitario = new SolitarioKlondike();
                                KlondikeUI ui = new KlondikeUI(stage, solitario);
                                ui.mostrar();
                            }
                        }
            });

            add(seleccionarButton,tipo.ordinal(),0);

        }
    }
}