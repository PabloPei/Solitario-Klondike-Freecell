package ui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modeloelementos.Carta;

public class VistaCarta extends ImageView {
    private static final String rutaImagenesCartas = "file:src\\main\\recursos\\imagenesCartas\\";
    private final int ancho = 40;
    private final int alto = 60;

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
}


