package klondike;

import generalelementos.PilaDeCartas;
import generalelementos.Carta;
import generalelementos.ValorCarta;
import generalsolitario.Cimiento;


/**
 * doc
 */
public class CimientoKlondike extends PilaDeCartas implements Cimiento {

    //////////////////// Métodos ////////////////////

    /**
     * Intenta agregar una carta al cimiento si es una jugada válida según las reglas del juego. La carta agregada siempre
     * @param carta La carta que se va a intentar agregar al cimiento.
     * @return true si la carta se ha agregado correctamente, false si no se pudo agregar debido a reglas del juego o si el cimiento está completo.
     */
    @Override
    public boolean agregarCarta(Carta carta) {

        if (cimientoCompleto()) {
            return false;
        }

        if (isEmpty()) {
            if (carta.getValor() == ValorCarta.AS) {
                carta.setBocaAbajo(false);
                push(carta);
                return true;
            }
            return false;
        } else {
            Carta tope = peek();
            if (Carta.esValorSiguiente(tope, carta) && Carta.esMismoPalo(tope, carta)) {
                carta.setBocaAbajo(false);
                push(carta);
            }
            return true;
        }
    }

    /**
     * Retira una carta del cimiento
     * @return devuelve la ultima carta del cimiento o excepcion en caso de que no haya ninguna.
     */
    @Override
    public Carta retirarCarta(){
        if(isEmpty())
            throw new IllegalStateException("No hay cartas disponibles en el cimiento.");

        return this.pop();
    }

    /**
     * Verifica si el cimiento está completo, es decir, si tiene 13 cartas en orden ascendente.
     * @return true si el cimiento está completo, false en caso contrario.
     */
    @Override
    public boolean cimientoCompleto() {
        return this.size() == 13;
    }


}
