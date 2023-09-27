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
     * #este metodo y el de abajo revisarlos 1) como poner carta alfinal , 2) conviene pasar mazo o carta?
     * Cuando se saca una carta de la pila de descarte se debe agregar otra.
     * @param mazo El mazo del que se sacarán las cartas para colocar en el descarte.
     */
    public Carta usarCarta(Mazo mazo) {

        // Chequeo que no haya 3 cartas ya en la pila de descarte
        if (this.cantidadCartas - this.size() == 0){
            throw new IllegalStateException("La pila de descartes ya esta llena");
        }

        // Saco la carta de la pila de descarte
        Carta carta = this.pop();

        // Saco la carta del mazo y la agrego a la pila
        Carta cartaMazo = mazo.pop();
        carta.setBocaAbajo(false);
        this.push(cartaMazo);

        return carta;
    }

    /**
     * Saco la cantidad de cartas del mazo a la pila de descarte y vuelvo a poner las que estaban
     * en la pila de descarte en el mazo.
     * @param mazo El mazo del que se sacarán las cartas para colocar en el descarte.
     */
    public boolean sacarCartas(Mazo mazo) {

        return true;
    }



}
