package klondike;

import modeloelementos.Carta;
import modeloelementos.Dificultad;
import modelosolitario.*;

public class SolitarioKlondike extends Solitario {

    /**
     * Constructor para iniciar un juego de Solitario Klondike.
     * @param dificultad La dificultad del juego.
     * @param tablero    El tablero con el cual se quiere inicializar el solitario.
     */
    public SolitarioKlondike(Dificultad dificultad, TableroKlondike tablero){
        super(dificultad,tablero);
    }

    /**
     * Verifica si el jugador ha ganado el juego.
     * @return true si el juego ha sido ganado, false de lo contrario.
     */
    public boolean verificarVictoria() {
        return getTablero().tableroCompletado();
    }

    /**
     * Verifica si el jugador ha perdido el juego.
     * @return true si el juego ha sido perdido, false de lo contrario.
     */
    public boolean verificarDerrota() {
        return !(getTablero().hayMovimientosDisponibles());
    }

    ////////////////////// Movimientos ///////////////////////////////

    /**
     * Roba cartas del mazo y las pone en la pila de descarte. Ademas, si habia cartas en la pila de descarte las mueve
     * de vuelta al mazo.
     * @param mazo     Mazo del cual va a robar las cartas y volver a ingresar
     * @param descarte pila de descarte en la cual va a agregar la carta
     * @return         Devuelve true si el movimiento se realizó con éxito, false si no se pudo realizar.
     */
    public static boolean robarCartasDelMazo(Mazo mazo, Descarte descarte) {
        // Si el mazo y el descarte estan vacios no puedo robar cartas
        if (descarte.isEmpty() && mazo.isEmpty())
            return false;

        // Paso las cartas del descarte al mazo
        mazo.agregarDescarte(descarte);

        // Saco las cartas del mazo y las coloca en la pila de descarte.
        for (int i = 0; i < descarte.getCantidadCartas(); i++) {
            Carta carta = mazo.sacarCarta(false);
            if(descarte.agregarCarta(carta))
                break; // no tengo mas cartas en el mazo

        }

        return true;
    }


}
