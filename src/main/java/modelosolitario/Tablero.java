package modelosolitario;

import modeloelementos.*;
import java.util.ArrayList;


/**
 * Esta clase abstracta representa un tablero en el juego de Solitario.
 * Los tableros son utilizados para organizar y gestionar las cartas en el juego.
 * Las clases concretas que implementan esta clase abstracta proporcionan la
 * lógica específica para diferentes variantes del juego de Solitario.
 */

public abstract class Tablero {

    ///////// Atributos ///////////
    private ArrayList<Pila> pilas;
    private Mazo mazo;
    private ArrayList<Cimiento> cimientos;

   ///////// Metodos ///////////
    /**
     * Crea una instancia del tablero con un mazo, las pilas y los cimientos.
     */
    public Tablero() {

        this.mazo = new Mazo();
        this.cimientos = new ArrayList<Cimiento>();
        this.pilas = new ArrayList<Pila>();

    }

    /**
     * Inicializa los cimientos en el tablero.
     */
    public void iniciarCimientos() {
        this.cimientos = new ArrayList<>();
        for (Palo p : Palo.values()) {
            cimientos.add(new Cimiento());
        }
    }

    /**
     * Inicializa las pilas en el tablero.
     */
    public abstract void iniciarPilas();


    /**
     * Reparte las cartas iniciales en las pilas de juego.
     */
    public abstract void repartirPilas();


    //////////// getters /////////////

    public Mazo getMazo(){
        return this.mazo;
    }


    public ArrayList<Cimiento> getCimientos(){
        return this.cimientos;
    }

    public ArrayList<Pila> getPilas(){
        return this.pilas;
    }


}
