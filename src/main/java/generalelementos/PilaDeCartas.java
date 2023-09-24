package generalelementos;
import java.util.Collections;
import java.util.Stack;

/**
 * Esta clase representa una pila de cartas. Extiende la clase Stack y proporciona
 * funcionalidad específica para manipular un conjunto de cartas en el contexto de un solitario.
 */
public class PilaDeCartas extends Stack<Carta> {

    //////////////////// Atributos ////////////////////
    /* # ver con que llenarla */

    //////////////////// Métodos ////////////////////

    /**
     * Mezcla las cartas en la pila de manera aleatoria.
     * #hacer metodo que demuestre que mezcla de forma aleatoria.#revisar esto, agarra una lista, no una pila
     */
    public void mezclar(){
        Collections.shuffle(this);
    }

    /**
     * Voltea todas las cartas en la pila para que queden boca arriba.
     */
    public void mostrarTodas (){
        for (Carta carta : this){
            carta.setBocaAbajo(false);
        }
    }


}