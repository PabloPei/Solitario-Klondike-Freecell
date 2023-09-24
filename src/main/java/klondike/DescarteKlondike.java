package klondike;

import generalelementos.Carta;
import generalelementos.PilaDeCartas;
import generalelementos.Dificultad;
import generalsolitario.Mazo;
import generalsolitario.Descarte;

/**
 * La clase Descarte representa la pila de cartas utilizada en el juego de Solitario Klondike
 * para almacenar temporalmente cartas que no se pueden jugar de inmediato.
 * Esta clase hereda de la clase PilaDeCartas y agrega funcionalidad específica para manejar
 * las reglas de cantidad de cartas en el descarte según la dificultad del juego.
 */
public class DescarteKlondike extends PilaDeCartas implements Descarte{

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
     * Saca cartas del mazo y las coloca en el descarte.
     * @param mazo El mazo del que se sacarán las cartas para colocar en el descarte.
     */
    @Override
    public void sacarCartas(Mazo mazo) {

        this.empty();

        int i = 0;
        while(i < this.cantidadCartas && !mazo.isEmpty()){
            Carta carta = mazo.pop();
            carta.setBocaAbajo(false);
            this.push(carta);
        }
    }

    /**
     * Obtiene una carta utilizable de la pila de cartas.
     * Si la pila está vacía, devuelve una excepcion.
     * @return La carta obtenida de la pila.
     */
    @Override
    public Carta retirarCarta(){

        if(isEmpty()){
            throw new IllegalStateException("No hay cartas disponibles en la pila de descartes.");
        }
        return this.pop();

    }



}
