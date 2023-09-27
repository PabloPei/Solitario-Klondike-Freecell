package modelosolitario;

import modeloelementos.Carta;
import modeloelementos.PilaDeCartas;
import modeloelementos.Dificultad;

/**
 * La clase Descarte representa la de descarte utilizada en el juego de Solitario
 * para almacenar temporalmente cartas que no se pueden jugar de inmediato.
 * Esta clase hereda de la clase PilaDeCartas y agrega funcionalidad específica para manejar
 * las reglas de cantidad de cartas en el descarte según la dificultad del juego.
 */
public class Descarte extends PilaDeCartas{

    private int cantidadCartas;

    /**
     * Setea la dificultad del solitario klondike, la misma varia la cantidad de cartas de la pila de descarte.
     * @param dificultad La dificultad del juego que determina la cantidad de cartas en el descarte.
     */
    public void setDificultad(Dificultad dificultad){

        switch (dificultad) {
            case DIFICIL -> this.cantidadCartas = 3;
            case MEDIO -> this.cantidadCartas = 2;
            case FACIL -> this.cantidadCartas = 1;
            default -> this.cantidadCartas = 1;
        }

    }

    /**
     * @return devuelve la cantidad de cartas de la pila de descarte
     */
    public int getCantidadCartas(){
        return this.cantidadCartas;
    }

    /**
     * Saca la cantidad de cartas del mazo dado y las coloca en la pila de descarte.
     * Luego, vuelve a colocar las cartas de la pila de descarte en el mazo original.
     * @param mazo El mazo del que se sacarán las cartas para colocar en el descarte.
     * @return true si la operación se realiza con éxito, false si la cantidad especificada supera el tamaño del mazo.
     */
    public boolean sacarYDevolverCartas(Mazo mazo, int cantidad) {

        if (cantidad <= 0 || mazo.isEmpty()) {
            return false;
        }

        // Coloco las cartas de la pila de descarte boca abajo y al fondo del mazo
        while (!this.isEmpty()) {
            Carta carta = sacarCarta(true);
            mazo.add(carta);
        }

        // Sacar las cartas del mazo y las coloca en la pila de descarte.
        for (int i = 0; i < this.cantidadCartas; i++) {
            Carta carta = mazo.sacarCarta(false);
            if (carta==null) break; //si no hay mas cartas en el mazo dejo de agregar al descarte
            this.agregarCarta(carta);
        }

        return true;
    }

}
