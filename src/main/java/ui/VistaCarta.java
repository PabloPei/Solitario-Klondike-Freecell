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
            rutaImagen = Configuracion.RUTA_RECURSOS + "imagenesCartas/REVERSO_CARTA.png";
        } else {
            rutaImagen =  Configuracion.RUTA_RECURSOS + "imagenesCartas/" + carta.getPalo() + "_" + carta.getValor() + ".png";
        }
        Image imagenCarta = new Image(rutaImagen);

        setFitWidth(Configuracion.ANCHO_VENTANA/13);
        setFitHeight(Configuracion.ALTO_VENTANA/6);

        setImage(imagenCarta);


    }

    public Carta getCarta(){ return this.carta; }

}


