package modelosolitario;

import modeloelementos.PilaDeCartas;
import modeloelementos.Carta;
import modeloelementos.ValorCarta;

/**
 * Representa el cimiento en el juego de solitario.
 * El cimiento es donde se colocan las cartas en orden ascendente por palo, comenzando por el As.
 */
public class Cimiento extends PilaDeCartas {

    //////////////////// Métodos ////////////////////

    /**
     * Intenta agregar una carta al cimiento si es una jugada válida según las reglas del juego.
     * @param carta La carta que se va a intentar agregar al cimiento.
     * @return true si la carta se ha agregado correctamente, false si no se pudo agregar debido a reglas del juego o si el cimiento está completo.
     */
    public boolean agregarCarta(Carta carta) {

        if(puedeAgregarCarta(carta)) {
            carta.setBocaAbajo(false); // La carta en un cimiento siempre esta boca arriba
            push(carta);
            return true;
        }
        return false;
    }

    /**
     * Verifica si es valido agregar una carta al cimiento
     * @param carta La carta que se va a intentar agregar al cimiento.
     * @return true si la carta se ha agregado correctamente, false si no se pudo agregar debido a reglas del juego o si el cimiento está completo.
     */
    public boolean puedeAgregarCarta(Carta carta) {

        // Verifica las condiciones genericas de una pila
        if ( !super.puedeAgregarCarta(carta)) return false;

        // Verifica si el cimiento esta completo
        if (cimientoCompleto())  return false;

        if (isEmpty()) {
            return (carta.getValor() == ValorCarta.AS); // Solo se puede comenzar con un As.
        } else {
            Carta tope = peek();
            return (Carta.esValorSiguiente(tope, carta) && Carta.esMismoPalo(tope, carta));
        }
    }


    /**
     * Verifica si el cimiento está completo, es decir, si tiene 13 cartas en orden ascendente.
     * @return true si el cimiento está completo, false en caso contrario.
     */
    public boolean cimientoCompleto() {
        return this.size() == 13;
    }
}
