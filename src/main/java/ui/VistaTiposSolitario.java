package ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import modelosolitario.Solitario;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import modelosolitario.TiposSolitario;
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
                    System.out.println("Seleccionaste la opción 2");
                }
                case KLONDIKE -> {
                    KlondikeUI ui = new KlondikeUI();
                    ui.mostrar(stage);
                }
            }

        });


        getChildren().addAll(seleccionarButton);
    }
}