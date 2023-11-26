package ui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modeloelementos.Carta;


public class VistaCarta extends ImageView {

    private final Carta carta;

    public VistaCarta(Carta carta) {
        this.carta = carta;
        String rutaImagen;
        if (carta.getBocaAbajo()) {
            rutaImagen = ConfiguracionUI.RUTA_IMAGENES_CARTAS + "REVERSO_CARTA.png";
        } else {
            rutaImagen =  ConfiguracionUI.RUTA_IMAGENES_CARTAS + "" + carta.getPalo() + "_" + carta.getValor() + ".png";
        }
        Image imagenCarta = new Image(rutaImagen);

        setFitWidth(ConfiguracionUI.ANCHO_VENTANA/13);
        setFitHeight(ConfiguracionUI.ALTO_VENTANA/6);

        setImage(imagenCarta);
    }

    public Carta getCarta() { return this.carta; }
}