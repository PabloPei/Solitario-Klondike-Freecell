package Klondike;

import GeneralElementos.Carta;
import GeneralElementos.ValorCarta;
import GeneralSolitario.PilaDeCartas;

/**
 * La clase Klondike.Cimiento representa una pila especializada de cartas utilizada en el solitario.
 * Esta clase hereda de la clase GeneralSolitario.PilaDeCartas y agrega funcionalidad específica para manejar
 * las reglas del cimiento en el juego.
 */

public class Cimiento extends PilaDeCartas {

    //////////////////// Atributos ////////////////////



    //////////////////// Métodos ////////////////////

    /**
     * Agregar una carta al cimiento según las reglas del solitario.
     * @param carta La carta que se va a agregar al cimiento.
     * @return true si la carta se puede agregar al cimiento, false en caso contrario.
     */
    public boolean agregarCarta(Carta carta) {
        if (isEmpty()) {
            if (carta.getValor() == ValorCarta.AS) {
                push(carta);
                return true;
            }
            return false;
        } else {
            Carta tope = peek();
            if (tope.valorValidoParaEntrarAPila(carta) && (tope.getPalo() == carta.getPalo())) {
                push(carta);
                return true;
            }
            return false;
        }
    }

    public boolean cimientoCompleto(){
        return this.size() == 13;
    }
}
