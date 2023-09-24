package generalsolitario;

import generalelementos.Carta;
import generalelementos.PilaDeCartas;


public interface Pila {

    /**
     * Agrega una carta a la pila si el movimiento es válido.
     * @param carta La carta que se intenta agregar.
     * @return true si se pudo agregar la carta, false si no es un movimiento válido.
     */
    boolean agregarCarta(Carta carta);

    /**
     * Retira cartas de una pila
     *
     * @return La carta retirada o null si la pila está vacía.
     */
    PilaDeCartas retirarCartas(int cantidadCartas);

}
