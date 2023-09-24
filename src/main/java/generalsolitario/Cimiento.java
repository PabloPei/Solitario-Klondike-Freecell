package generalsolitario;

import generalelementos.PilaDeCartas;
import generalelementos.Carta;
import generalelementos.ValorCarta;


/**
 * La clase Cimiento representa una pila especializada de cartas utilizada en el juego de solitario.
 * Esta clase hereda de la clase PilaDeCartas y agrega funcionalidad específica para manejar
 * las reglas del cimiento en el juego.
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
            return false;
        }

        if (isEmpty()) {
            if (carta.getValor() == ValorCarta.AS) {
                carta.setBocaAbajo(false);
                push(carta);
            }
            return false;
        } else {
            Carta tope = peek();
            if (Carta.esSiguienteValor(tope, carta) && Carta.esMismoPalo(tope, carta)) {
                carta.setBocaAbajo(false);
                push(carta);
            }
            return true;
        }
    }

    /**
     * Verifica si el cimiento está completo, es decir, si tiene 13 cartas en orden ascendente.
     *
     * @return true si el cimiento está completo, false en caso contrario.
     */
    public boolean cimientoCompleto() {
        return this.size() == 13;
    }
}
