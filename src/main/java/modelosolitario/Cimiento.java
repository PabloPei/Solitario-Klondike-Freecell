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

    public Cimiento(){
        super();
    }

    public Cimiento(int cantidadCartas, Palo palo){
        for(ValorCarta v : ValorCarta.values()){
            if (v.ordinal() < cantidadCartas){
                this.agregarCarta(new Carta(v, palo, false));
            }
        }
    }

    public Cimiento(PilaDeCartas cimiento){
        while (!cimiento.isEmpty()){
            agregarCarta(cimiento.sacarCarta(true));
        }
    }

    public boolean puedeAgregarCarta(Carta carta) {
        // Verifica las condiciones genericas de una pila
        if ( !super.puedeAgregarCarta(carta)) return false;

        // Verifica si el cimiento esta completo
        if (cimientoCompleto())  return false;

        if (isEmpty()) {
            return (carta.getValor() == ValorCarta.AS);
        } else {
            Carta tope = peek();
            return (Carta.esValorSiguiente(tope, carta) && Carta.esMismoPalo(tope, carta));
        }
    }

    public boolean cimientoCompleto() {
        return this.size() == 13;
    }
}
