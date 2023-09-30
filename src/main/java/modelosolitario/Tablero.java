package modelosolitario;

import modeloelementos.PilaDeCartas;

import java.util.ArrayList;


/**
 * Esta clase abstracta representa un tablero en el juego de Solitario (todos tienen mazo y pilas).
 * Los tableros son utilizados para organizar y gestionar las cartas en el juego.
 * Las clases concretas que implementan esta clase abstracta proporcionan la
 * lógica específica para diferentes variantes del juego de Solitario.
 */

public abstract class Tablero {

    ///////// Atributos ///////////
    protected final ArrayList<Pila> pilas;
    protected final Mazo mazo;

   ///////// Metodos ///////////
    /**
     * Crea una instancia del tablero con un mazo y las pilas.
     * @param cantidadPilas Dependiendo la implementación de solitario, la cantidad de pilas
     *                      en el juego sera distinta.
     */
    public Tablero(int cantidadPilas) {

        this.mazo = new Mazo();
        this.mazo.mezclar();

        this.pilas = new ArrayList<Pila>();
        iniciarPilas(cantidadPilas);
        repartirPilas();
    }

    /**
     * Crea una instancia del tablero con un mazo y pila especifica.
     */
    public Tablero(PilaDeCartas mazo, ArrayList<Pila> pilas){

        this.mazo = new Mazo(mazo);

        this.pilas = new ArrayList<Pila>();
        for( Pila pila : pilas){
            this.pilas.add(pila);
        }
    }

    /**
     * Crea una instancia del tablero con un mazo y las pilas a partir de una semilla.
     * @param cantidadPilas Dependiendo la implementación de solitario, la cantidad de pilas
     *                      en el juego sera distinta.
     * @param semilla Semilla inicial a partir de la cual se construira el juego.
     */
    public Tablero(int cantidadPilas, long semilla) {

        this.mazo = new Mazo();
        this.mazo.mezclar(semilla);

        this.pilas = new ArrayList<Pila>();
        iniciarPilas(cantidadPilas);
        repartirPilas();
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

    /**
     * Este metodo indica si aun hay movimientos disponibles, cada solitario debe implementarlo segun sus reglas
     */
    public abstract boolean hayMovimientosDisponibles();

    /**
     * Este metodo indica si aun hay movimientos disponibles, cada solitario debe implementarlo segun sus reglas
     */
    public abstract boolean tableroCompletado();


    //////////// getters /////////////

    public Mazo getMazo(){
        return this.mazo;
    }

    public ArrayList<Pila> getPilas(){
        return this.pilas;
    }
}
