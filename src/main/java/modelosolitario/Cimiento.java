package modelosolitario;

import modeloelementos.Palo;
import modeloelementos.PilaDeCartas;
import modeloelementos.Carta;
import modeloelementos.ValorCarta;

/**
 * Representa el cimiento en el juego de solitario. Hereda de la clase pila de cartas genericas y suma funcionalidades
 * propias de un cimiento.
 * El cimiento es donde se colocan las cartas en orden ascendente por palo, comenzando por el As.
 */
public class Cimiento extends PilaDeCartas {

    //////////////////// Métodos ////////////////////

    /**
     * Constructor estandard
     */
    public Cimiento(){
        super();
    }

    /**
     * Permite iniciar un cimiento en un estado particular
     * @param cantidadCartas la cantidad de cartas que va tener el cimiento
     * @param palo el palo de las cartas del cimiento
     */
    public Cimiento(int cantidadCartas, Palo palo){
        for(ValorCarta v : ValorCarta.values()){
            if (v.ordinal() < cantidadCartas){
                this.agregarCarta(new Carta(v, palo, false));
            }
        }
    }
    /**
     * Verifica si es valido agregar una carta al cimiento segun las reglas del solitario.
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
