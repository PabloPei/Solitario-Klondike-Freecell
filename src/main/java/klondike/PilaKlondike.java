package klondike;

import generalelementos.Carta;
import generalelementos.PilaDeCartas;
import generalsolitario.Pila;
import generalelementos.ValorCarta;

public class PilaKlondike extends PilaDeCartas implements Pila {


    /**
     * doc
     */
    @Override
    public boolean agregarCarta(Carta carta) {

        // Verifica si la pila está vacía y si la carta es un Rey (valor 13) para iniciar la pila.
        if (isEmpty() && carta.getValor() == ValorCarta.REY) {
            this.add(carta);
            return true;
        }

        // Verifica si la carta es válida para agregar en la pila según las reglas de Klondike.
        Carta tope = this.peek();
        if (Carta.esColorAlternado(tope,carta) && Carta.esValorSiguiente(tope,carta)) {
            this.add(carta);
            return true;
        }

        return false;
    }

    /**
     * doc
     */
    @Override
    public PilaDeCartas retirarCartas(int cantidadCartas) {

        if (cantidadCartas > this.size()){
            throw new IllegalStateException("No hay cartas disponibles en la pila.");
        }

        PilaDeCartas cartas = new PilaDeCartas();

        for ( int i = 0; i<cantidadCartas ; i++){
              cartas.push(this.pop());
        }

        return cartas;
    }

}

