package modeloelementos;
import java.util.Collections;
import java.util.Stack;

/**
 * Esta clase representa una pila de cartas. Extiende la clase Stack y proporciona
 * funcionalidad específica para manipular un conjunto de cartas en el contexto de un solitario.
 * No confundir con la clase pila que representa una "pila" o "tableu" en un juego de solitario.
 * (Se utilizara en el futuro para definir la posicion, ancho y alto de las pilas.)
 */
public class PilaDeCartas extends Stack<Carta> {

    //////////////////// Atributos ////////////////////

    //////////////////// Métodos ////////////////////



    /**
     * Voltea todas las cartas en la pila para que queden boca arriba.
     */
    public void mostrarTodas (){
        for (Carta carta : this){
            carta.setBocaAbajo(false);
        }
    }


}