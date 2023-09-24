package generalsolitario;

import generalelementos.Carta;
import generalelementos.PilaDeCartas;
import generalelementos.Dificultad;


/**
 * La clase Descarte representa la pila de cartas utilizada en el juego de Solitario Klondike
 * para almacenar temporalmente cartas que no se pueden jugar de inmediato.
 * Esta clase hereda de la clase PilaDeCartas y agrega funcionalidad específica para manejar
 * las reglas de cantidad de cartas en el descarte según la dificultad del juego.
 */
public class Descarte extends PilaDeCartas {

    private final int cantidadCartas;

    /**
     * Crea una instancia de la pila de descarte según la dificultad del juego.
     * @param dificultad La dificultad del juego que determina la cantidad de cartas en el descarte.
     */
    public Descarte(Dificultad dificultad) {
        switch (dificultad) {
            case DIFICIL:
                cantidadCartas = 3;
                break;
            case MEDIO:
                cantidadCartas = 2;
                break;
            case FACIL:
                cantidadCartas = 1;
                break;
            default:
                cantidadCartas = 1;
        }
    }

    /**
     * Saca cartas del mazo y las coloca en el descarte.
     * @param mazo El mazo del que se sacarán las cartas para colocar en el descarte.
     */
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
    public Carta obtenerCartaUsable(){

        if(isEmpty()){
            throw new IllegalStateException("No hay cartas disponibles en la pila de descartes.");
        }

        return this.pop();

    }

}
