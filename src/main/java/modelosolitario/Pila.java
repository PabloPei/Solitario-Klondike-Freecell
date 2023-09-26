package modelosolitario;

import modeloelementos.Carta;
import modeloelementos.PilaDeCartas;
import modeloelementos.ValorCarta;

/**
 * Representa una pila en el juego de solitario.
 * Las pilas son utilizadas para mover y organizar las cartas según las reglas del juego.
 */
public class Pila extends PilaDeCartas {


    /**
     * Intenta agregar una carta a la pila si es una jugada válida según las reglas del juego.
     * @param carta La carta que se va a intentar agregar a la pila.
     * @return true si la carta se ha agregado correctamente, false si no se pudo agregar debido a reglas del juego.
     */
    public boolean agregarCarta(Carta carta) {

        // Verifica si la pila está vacía y si la carta es un Rey (valor 13) para iniciar la pila.
        if (isEmpty() && carta.getValor() == ValorCarta.REY) {
            this.add(carta);
            return true;
        }

        // Verifica si la carta es válida para agregar en la pila según las reglas del solitario.
        Carta tope = this.peek();
        if (Carta.esColorAlternado(tope, carta) && Carta.esValorSiguiente(tope, carta)) {
            this.add(carta);
            return true;
        }

        return false;
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
