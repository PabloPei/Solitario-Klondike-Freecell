package klondike;

import modeloelementos.Carta;
import modeloelementos.Dificultad;
import modeloelementos.Palo;
import modelosolitario.*;

import java.util.ArrayList;


/**
 * Instancia de un solitario Klondike. Extiende las funcionalidades de la clase solitario pero suma cosas especificas
 * del solitario klondike
*/

public class SolitarioKlondike extends Solitario {

    public static final int CANTIDAD_PILAS = 7;

    ///////// Atributos ///////////

    private ArrayList<Cimiento> cimientos;
    private Descarte descarte;


    ///////// Metodos ///////////
    /**
     * Constructor para iniciar un juego de Solitario Klondike.
     * @param dificultad La dificultad del juego.
     */
    public SolitarioKlondike(Dificultad dificultad){

        super(CANTIDAD_PILAS);
        this.cimientos = new ArrayList<>();
        inciarCimientos();
        this.descarte = new Descarte();
        this.setDificultad(dificultad);
    }

    /**
     * Constructor para iniciar un juego de Solitario Klondike a partir de una semilla.
     * @param dificultad La dificultad del juego.
     */
    public SolitarioKlondike(Dificultad dificultad, long semilla){

        super(CANTIDAD_PILAS, semilla);
        this.cimientos = new ArrayList<>();
        inciarCimientos();
        this.descarte = new Descarte();
        this.setDificultad(dificultad);
    }

    /**
     * Constructor para iniciar un juego de Solitario Klondike a partir de un estado particular.
     * @param dificultad La dificultad del juego.
     */
    public SolitarioKlondike(Dificultad dificultad, Mazo mazo, ArrayList<Pila> pilas, ArrayList<Cimiento> cimientos, Descarte descarte){

        super(mazo,pilas);
        this.cimientos = cimientos;
        this.descarte = descarte;
        this.setDificultad(dificultad);
    }


    /**
     * Reparte las cartas iniciales en las pilas segun las reglas del solitario klondike.
     */
    @Override
    public void repartirPilas() {
        int cartasPorPila = 1;

        for (Pila pila : this.getPilas()) {
            while (pila.size() < cartasPorPila) {
                Carta cartaAux = this.getMazo().sacarCarta(true);
                pila.push(cartaAux);
            }
            pila.peek().voltear();
            cartasPorPila++;
        }
    }

    /**
     * Inicializa los 4 cimientos del solitario klondike
     */
    public void inciarCimientos() {
        for (Palo p : Palo.values()) {
            cimientos.add(new Cimiento());
        }
    }


    /**
     * Verifica si el jugador ha ganado el juego.
     * @return true si el juego ha sido ganado, false de lo contrario.
     */
    @Override
    public boolean verificarVictoria() {
        for (Cimiento cimiento : cimientos){
            if (!(cimiento.cimientoCompleto()))
                return false;
        }
        return true;
    }

    /**
     * Setea la dificultad del solitario. En este caso, la dificultad establece la cantidad de cartas en la pila
     * de descarte
     * @param dificultad del solitario
     */
    public void setDificultad(Dificultad dificultad){
        super.setDificultad(dificultad);
        this.getDescarte().setCantidadCartas(dificultad);
    }

    ////////////////////// Movimientos ///////////////////////////////

    /**
     * Roba cartas del mazo y las pone en la pila de descarte. Ademas, si habia cartas en la pila de descarte las mueve
     * de vuelta al mazo.
     * @return         Devuelve true si el movimiento se realizó con éxito, false si no se pudo realizar.
     */
    public boolean robarCartasDelMazo() {

        Mazo mazo = getMazo();
        Descarte descarte = getDescarte();

        // Si el mazo y el descarte estan vacios no puedo robar cartas
        if (descarte.isEmpty() && mazo.isEmpty())
            return false;

        // Paso las cartas del descarte al mazo
        mazo.agregarDescarte(descarte);


        // Saco las cartas del mazo y las coloca en la pila de descarte.

        for (int i = 0; i < descarte.getCantidadCartas(); i++) {
            Carta carta = mazo.sacarCarta(false);

            if( ! descarte.agregarCarta(carta))
                break; // no tengo mas cartas en el mazo

        }

        return true;
    }

    //////////// getters /////////////

    public Descarte getDescarte(){ return this.descarte; }

    public ArrayList<Cimiento> getCimientos(){ return this.cimientos; }


}
