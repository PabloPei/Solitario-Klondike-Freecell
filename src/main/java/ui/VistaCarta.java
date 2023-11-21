package ui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modeloelementos.Carta;



public class VistaCarta extends ImageView {

    private static final String rutaImagenesCartas = "file:src/main/recursos/imagenesCartas/";
    private Carta carta;

    public VistaCarta(Carta carta) {

        this.carta = carta;

        String rutaImagen;
        if (carta.getBocaAbajo()) {
            rutaImagen = rutaImagenesCartas + "REVERSO_CARTA.png";
        } else {
            rutaImagen = rutaImagenesCartas + carta.getPalo() + "_" + carta.getValor() + ".png";
        }
        Image imagenCarta = new Image(rutaImagen);

        setFitWidth(Configuracion.ANCHO_VENTANA/13);
        setFitHeight(Configuracion.ALTO_VENTANA/6);

        setImage(imagenCarta);


    }

    public static Image getReverso(){
        return new Image(rutaImagenesCartas + "REVERSO_CARTA.png");
    }

    public Carta getCarta(){ return this.carta; }

    public static Image getImagenCarta(Carta carta){
        Image imagen = new Image(rutaImagenesCartas + carta.getPalo() + "_" + carta.getValor() + ".png");
        return imagen;
    }
}


