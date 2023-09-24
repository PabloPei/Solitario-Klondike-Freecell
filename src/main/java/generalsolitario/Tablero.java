package generalsolitario;

import generalelementos.PilaDeCartas;
import java.util.ArrayList;

/**
 * La clase abstracta Tablero sirve como base para implementar diferentes tipos de tableros de solitario.
 * Se inicializan los parametros comunes a los tableros de los distintos solitarios: Mazos (Uno o mas), Pilas (Una o mas).
 */
public abstract class Tablero {

    protected final int cantidadPilas;
    protected final int cantidadMazos;

    protected ArrayList<Pila> pilas;
    protected ArrayList<Mazo> mazos;

    /**
     * Crea un nuevo objeto Tablero con la cantidad especificada de pilas y mazos.
     *
     * @param cantidadPilas La cantidad de pilas en el tablero.
     * @param cantidadMazos La cantidad de mazos en el tablero.
     */
    public Tablero(int cantidadPilas, int cantidadMazos) {
        this.cantidadPilas = cantidadPilas;
        this.cantidadMazos = cantidadMazos;
        iniciarMazo();
        iniciarPilas();
    }

    /**
     * Inicializa los mazos en el tablero.
     */
    public void iniciarMazo() {
        this.mazos = new ArrayList<>();
        for (int i = 0; i < cantidadMazos; i++) {
            mazos.add(new Mazo());
        }
    }

    /**
     * Inicializa las pilas en el tablero.
     */
    public void iniciarPilas() {
        this.pilas = new ArrayList<>();
        for (int i = 0; i < cantidadPilas; i++) {
            pilas.add(new Pila());
        }
    }


    ///////// Getters /////////

    public ArrayList<Mazo> getMazos() {
        return mazos;
    }

    public ArrayList<Pila> getPilas() {
        return pilas;
    }
}
