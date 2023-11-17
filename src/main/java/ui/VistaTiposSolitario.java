package ui;

import freecell.SolitarioFreeCell;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import klondike.SolitarioKlondike;
import modelosolitario.TiposSolitario;
import ui.freecell.FreecellUI;
import ui.klondike.KlondikeUI;


public class VistaTiposSolitario extends StackPane {


    private static final String RUTAIMAGENTIPOSSOLITARIOS = "file:src/main/recursos/imagenesSolitarios/";


    public VistaTiposSolitario(TiposSolitario tipoSolitario, Stage stage) {


        String rutaImagen = RUTAIMAGENTIPOSSOLITARIOS + tipoSolitario.toString() + ".png";
        Image imagenSolitario = new Image(rutaImagen);
        ImageView imageView = new ImageView(imagenSolitario);

        Button seleccionarButton = new Button("",imageView);


        seleccionarButton.setOnAction(e -> {

            switch (tipoSolitario) {
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


        getChildren().addAll(seleccionarButton);
    }
}