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



public class VistaSeleccionSolitario extends GridPane {


    private static final String RUTAIMAGENTIPOSSOLITARIOS = "file:src/main/recursos/imagenesSolitarios/";


    public VistaSeleccionSolitario(Stage stage) {

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

            seleccionarButton.setOnMouseEntered(mouseEvent  -> seleccionarButton.setStyle(Configuracion.BOTON_SELECCION_MOUSE_ARRIBA));

            seleccionarButton.setOnMouseExited(mouseEvent  -> seleccionarButton.setStyle(Configuracion.BOTON_SELECCION_ESTADO_NORMAL));


            seleccionarButton.setOnAction(e -> {
                 switch (tipo) {
                      case FREECELL -> {
                                SolitarioFreeCell solitario = new SolitarioFreeCell();
                                FreecellUI ui = new FreecellUI(stage, solitario);
                                ui.mostrar();
                            }
                            case KLONDIKE -> {
                          /*
                                ArrayList<Cimiento> cimientos = new ArrayList<>();
                                cimientos.add( new Cimiento(12, Palo.PICA));
                                cimientos.add( new Cimiento(13,Palo.TREBOL));
                                cimientos.add( new Cimiento(13,Palo.CORAZON));
                                cimientos.add( new Cimiento(13,Palo.DIAMANTE));

                                ArrayList<Pila> pilas = new ArrayList<>();
                                pilas.add( new Pila());
                                pilas.add( new Pila());
                                pilas.add( new Pila());
                                pilas.add( new Pila());
                                pilas.add( new Pila());
                                pilas.add( new Pila());
                                Pila pila7 = new Pila();
                                pila7.agregarCarta(new Carta(ValorCarta.REY, Palo.PICA, false));
                                pilas.add(pila7);

                                PilaDeCartas mazoVacio = new PilaDeCartas();
                                Mazo mazo = new Mazo(mazoVacio);

                                Descarte descarte = new Descarte();

                                SolitarioKlondike solitario = new SolitarioKlondike(mazo, pilas, cimientos, descarte);

                                KlondikeUI ui = new KlondikeUI(stage, solitario);
                           */
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