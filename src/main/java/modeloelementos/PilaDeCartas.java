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
     * Intenta agregar una carta a la pila de cartas.
     * @param carta La carta que se va a intentar agregar a la pila.
     * @return true si la carta se ha agregado correctamente, false si no se pudo agregar debido a reglas del juego.
     */
    public boolean agregarCarta(Carta carta) {

        if(puedeAgregarCarta(carta)) {
            push(carta);
            return true;
        }
        return false;
    }

    /**
     * Verifica si es valido agregar una carta a una pila de cartas generica.
     * @param carta La carta que se va a intentar agregar al cimiento.
     * @return true si la carta se ha agregado correctamente, false si no se pudo agregar debido a reglas del juego o si el cimiento está completo.
     */
    public boolean puedeAgregarCarta(Carta carta) {
        return (carta != null && !this.contains(carta));
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