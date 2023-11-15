package ui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modeloelementos.Carta;

import java.util.HashMap;
import java.util.Map;

public class VistaCarta extends ImageView {
    private static final String rutaImagenesCartas = "file:src/main/recursos/imagenesCartas/";
    private static final int ancho = 40;
    private static final int alto = 60;

    public VistaCarta(Carta carta) {
        String rutaImagen;
        if (carta.getBocaAbajo()) {
            rutaImagen = rutaImagenesCartas + "REVERSO_CARTA.png";
        } else {
            rutaImagen = rutaImagenesCartas + carta.getPalo() + "_" + carta.getValor() + ".png";
        }
        Image imagenCarta = new Image(rutaImagen);
        setImage(imagenCarta);

        setFitWidth(ancho);
        setFitHeight(alto);
        setPreserveRatio(true);
    }

    public static Image getReverso(){
        return new Image(rutaImagenesCartas + "REVERSO_CARTA.png");
    }

    public static Image getImagenCarta(Carta carta){
        Image imagen = new Image(rutaImagenesCartas + carta.getPalo() + "_" + carta.getValor() + ".png");
        return imagen;
    }
}


