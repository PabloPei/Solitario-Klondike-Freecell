package ui;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import modeloelementos.EstadoJuego;
import modelosolitario.Solitario;

import java.io.File;

public abstract class SolitarioUI extends GridPane implements Listener {


    private final Stage stage;
    private final Solitario solitario;


    public SolitarioUI(Stage stage, Solitario solitario) {
        solitario.agregarListener(this);
        this.stage = stage;
        this.solitario = solitario;
    }


    @Override
    public void escuchar() {

        if ( solitario.verificarEstado() == EstadoJuego.GANADO){

            Media sonido = new Media(new File(ConfiguracionUI.RUTA_SONIDOS + "win.mp3").toURI().toString());
            MediaPlayer sonidoVictoria = new MediaPlayer(sonido);
            sonidoVictoria.play();

            ImageView imagenVictoria = new ImageView(new Image(ConfiguracionUI.RUTA_IMAGENES_SOLITARIOS+ "victoria.png"));
            imagenVictoria.setFitWidth(ConfiguracionUI.ANCHO_VENTANA);
            imagenVictoria.setFitHeight(ConfiguracionUI.ALTO_VENTANA);

            VBox contenedorVictoria = new VBox();
            contenedorVictoria.getChildren().add(imagenVictoria);

            Scene sceneVictoria = new Scene(contenedorVictoria);

            stage.setResizable(false);
            stage.show();
            this.stage.setScene(sceneVictoria);

        }
    }


    public abstract void mostrar();

    public Solitario getSolitario(){ return this.solitario; }
    public Stage getStage(){ return this.stage; }
}
