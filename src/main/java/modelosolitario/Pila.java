package modelosolitario;

import modeloelementos.Carta;
import modeloelementos.PilaDeCartas;
import modeloelementos.ValorCarta;

/**
 * Representa una pila o 'tableu' en el juego de solitario. No confundir con la estructura de datos stack.
 * Las pilas son utilizadas para mover y organizar las cartas según las reglas del juego. Hereda de la clase
 * generica pila de cartas y extiende sus funcionalidades segun las reglas del juego solitario.
 */
public class Pila extends PilaDeCartas {

    /**
     * Verifica si es valido agregar una carta a la pila segun las reglas del solitario.
     * @param carta La carta que se va a intentar agregar a la pila.
     * @return true si la carta se ha agregado correctamente, false si no se pudo agregar debido a reglas del juego o si el cimiento está completo.
     */
    public boolean puedeAgregarCarta(Carta carta) {

        // Verifica las condiciones genericas de una pila
        if ( !super.puedeAgregarCarta(carta)) return false;

        // Verifica si la pila está vacía y si la carta es un Rey (valor 13) para iniciar la pila.
        if (isEmpty()){
            return (carta.getValor() == ValorCarta.REY);
        }else {
            Carta tope = this.peek();
            // Verifica si la carta es válida para agregar en la pila según las reglas del solitario.
            return (Carta.esColorAlternado(tope, carta) && Carta.esValorSiguiente(tope, carta));
        }
    }

    /**
     * Accion de retirar una carta de la pila. Chequea si hay una carta anterior boca abajo y la pone bocca arriba
     * @param bocaAbajo indica si la carta estara boca abajo o no
     * @return Carta la carta que saco de la pila de cartas
     */
    public Carta sacarCarta(boolean bocaAbajo) {

        Carta carta = super.sacarCarta(bocaAbajo);

        if ( ! this.isEmpty() ){
            Carta tope = this.peek();
            tope.setBocaAbajo(false);
        }

        return carta; 

    }

    /**
     * Retira un número especificado de cartas de la pila.
     * @param cantidadCartas La cantidad de cartas que se desea retirar.
     * @return Una pila de cartas con las cartas retiradas.
     */
    public PilaDeCartas sacarCartas(int cantidadCartas, boolean bocaAbajo) {

        PilaDeCartas cartasAux = new PilaDeCartas();

        for (int i = 0; i < cantidadCartas; i++) {
            cartasAux.agregarCarta(sacarCarta(bocaAbajo));
        }
        return cartasAux;
    }
}
