package klondike;

import generalelementos.Dificultad;
import generalelementos.Palo;
import generalsolitario.*;
import generalsolitario.Mazo;
import java.util.ArrayList;


/**
 * doc
 */
public class TableroKlondike implements Tablero {

    protected ArrayList<PilaKlondike> pilas;
    private Mazo mazo;
    private DescarteKlondike descarte;
    private ArrayList<Cimiento> cimientos;

    /**
     * Crea una instancia del tablero de juego Klondike con un mazo, las pilas, los cimientos y la pila de descarte.

     */
    public TableroKlondike() {

        this.descarte = new DescarteKlondike();
        iniciarMazo();
        iniciarPilas();
        repartirPilas();
        iniciarCimientos();

    }

    /**
     * Inicializa el unico mazo del solitario klondike
     */
    @Override
    public void iniciarMazo() {
        this.mazo = new Mazo();
    }

    /**
     * Inicializa las pilas en el tablero.
     */
    @Override
    public void iniciarPilas() {
        this.pilas = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            pilas.add(new PilaKlondike());
        }
    }

    /**
     * Inicializa los cimientos en el tablero.
     */
    public void iniciarCimientos() {
        this.cimientos = new ArrayList<>();
        for (Palo p : Palo.values()) {
            cimientos.add(new CimientoKlondike());
        }
    }

    /**
     * Reparte las cartas iniciales en las pilas de juego.
     */
    @Override
    public void repartirPilas() {

        int cartasPorPila = 1;

        for (PilaKlondike pila : pilas) {
            while (pila.size() < cartasPorPila) {
                pila.push(this.mazo.pop());
            }

            pila.peek().voltear();
            cartasPorPila++;
        }

    }

    //////////// getters /////////////

    public DescarteKlondike getDescarte() {
        return descarte;
    }
}
