package modelosolitario;

import modeloelementos.Carta;
import modeloelementos.PilaDeCartas;
import modeloelementos.ValorCarta;

/**
 * Representa una pila o 'tableu' en el juego de solitario. No confundir con la estructura de datos stack.
 * Las pilas son utilizadas para mover y organizar las cartas según las reglas del juego.
 */
public class Pila extends PilaDeCartas {


    /**
     * Intenta agregar una carta a la pila si es una jugada válida según las reglas del juego.
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
     * Verifica si es valido agregar una carta al cimiento
     * @param carta La carta que se va a intentar agregar al cimiento.
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
     * Retira un número especificado de cartas de la pila.
     * @param cantidadCartas La cantidad de cartas que se desea retirar.
     * @return Una pila de cartas con las cartas retiradas.
     * @throws IllegalStateException si no hay suficientes cartas disponibles en la pila.
     */
    public PilaDeCartas retirarCartas(int cantidadCartas) {

        if (cantidadCartas > this.size()) {
            throw new IllegalStateException("No hay cartas disponibles en la pila.");
        }

        PilaDeCartas cartas = new PilaDeCartas();

        for (int i = 0; i < cantidadCartas; i++) {
            cartas.push(this.pop());
        }

        return cartas;
    }
}
