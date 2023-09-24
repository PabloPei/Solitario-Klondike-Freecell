package klondike;

import generalelementos.Dificultad;
import generalelementos.Palo;
import generalelementos.PilaDeCartas;
import generalsolitario.*;

import java.util.ArrayList;


/**
 * La clase TableroKlondike representa el tablero de juego específico para el Solitario Klondike.
 * Esta clase hereda de la clase Tablero general y agrega funcionalidad específica para manejar
 * las reglas del juego Klondike, incluyendo el descarte, los cimientos y la distribución de cartas
 * en las pilas iniciales.
 */
public class TableroKlondike extends Tablero {

    private Descarte descarte;
    private ArrayList<Cimiento> cimientos;
    private Mazo mazo;

    /**
     * Crea una instancia del tablero de juego Klondike con un mazo y dificultad especificados.
     * @param dificultad Dificultad del solitario, dependiendo de eso como se comporta la pila de descartes.
     * @param dificultad La dificultad del juego que afecta a las reglas y la disposición de las cartas.
     */
    public TableroKlondike(Dificultad dificultad) {

        super(7, 1);
        this.descarte = new Descarte(dificultad);
        this.mazo = mazo;
        iniciarCimientos();

    }

    /**
     * Inicializa los cimientos en el tablero.
     */
    private void iniciarCimientos() {

        this.cimientos = new ArrayList<>();
        for (Palo p : Palo.values()) {
            cimientos.add(new Cimiento());
        }
    }

    /**
     * Reparte las cartas iniciales en las pilas de juego.
     */
    private void repartirPilas() {

        int cartasPorPila = 1;

        for (PilaDeCartas pila : pilas) {
            while (pila.size() < cartasPorPila) {
                pila.push(this.mazo.pop());
            }

            pila.peek().voltear();
            cartasPorPila++;
        }
    }
}
