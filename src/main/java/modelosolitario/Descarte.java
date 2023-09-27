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

}
