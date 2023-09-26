package modelosolitario;

import modeloelementos.*;
import java.util.ArrayList;


/**
 * Esta clase abstracta representa un tablero en el juego de Solitario (todos tienen mazo y pilas).
 * Los tableros son utilizados para organizar y gestionar las cartas en el juego.
 * Las clases concretas que implementan esta clase abstracta proporcionan la
 * lógica específica para diferentes variantes del juego de Solitario.
 */

public abstract class Tablero {

    ///////// Atributos ///////////
    private ArrayList<Pila> pilas;
    private Mazo mazo;

   ///////// Metodos ///////////
    /**
     * Crea una instancia del tablero con un mazo, las pilas y los cimientos.
     */
    public Tablero(int cantidadPilas) {

        this.mazo = new Mazo();
        this.mazo.mezclar();

        this.pilas = new ArrayList<Pila>();
        iniciarPilas(cantidadPilas);
    }

    /**
     * Inicializa las pilas, dependiendo la cantidad que corresponda al solitario
     */
    public void iniciarPilas(int cantidadPilas){

        for (int i = 0; i < cantidadPilas; i++) {
            this.getPilas().add(new Pila());
        }

    }


    /**
     * Reparte las cartas iniciales en las pilas de juego (cada solitario lo implementa de distinta forma).
     */
    public abstract void repartirPilas();


    //////////// getters /////////////

    public Mazo getMazo(){
        return this.mazo;
    }

    public ArrayList<Pila> getPilas(){
        return this.pilas;
    }


}
