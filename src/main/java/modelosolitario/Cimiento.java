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

        if (cimientoCompleto()) {
            return false; // El cimiento está completo, no se pueden agregar más cartas.
        }

        if (isEmpty()) {
            if (carta.getValor() == ValorCarta.AS) {
                carta.setBocaAbajo(false); // Voltea la carta boca arriba.
                push(carta);
                return true; // La carta se ha agregado con éxito.
            }
            return false; // Solo se puede comenzar con un As.
        } else {
            Carta tope = peek();
            if (Carta.esValorSiguiente(tope, carta) && Carta.esMismoPalo(tope, carta)) {
                carta.setBocaAbajo(false); // Voltea la carta boca arriba.
                push(carta);
                return true; // La carta se ha agregado con éxito.
            }
            return false; // La carta no cumple con las reglas de colocación en el cimiento.
        }
    }

    /**
     * Retira una carta del cimiento.
     * @return devuelve la última carta del cimiento o excepción en caso de que no haya ninguna.
     */
    public Carta retirarCarta() {
        if (isEmpty())
            throw new IllegalStateException("No hay cartas disponibles en el cimiento.");

        return this.pop(); // Retira la carta del cimiento y la devuelve.
    }

    /**
     * Verifica si el cimiento está completo, es decir, si tiene 13 cartas en orden ascendente.
     * @return true si el cimiento está completo, false en caso contrario.
     */
    public boolean cimientoCompleto() {
        return this.size() == 13;
    }
}
