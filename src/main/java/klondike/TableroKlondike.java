package klondike;

import modelosolitario.*;

import java.util.ArrayList;


public class TableroKlondike extends Tablero {

    public static final int CANTIDAD_PILAS = 7;

    ///////// Atributos ///////////
    private ArrayList<Cimiento> cimientos;
    private Descarte descarte;

    ///////// Metodos ///////////

    /**
     * Inicializa las pilas segun las reglas del solitario klondike
     */
    public TableroKlondike(){

        super(CANTIDAD_PILAS);

        this.cimientos = new ArrayList<Cimiento>();
        Descarte descarte=new Descarte();
    }

    /**
     * Reparte las cartas iniciales en las pilas segun las reglas del solitario klondike.
     */
    @Override
    public void repartirPilas() {

        int cartasPorPila = 1;

        for (Pila pila : this.getPilas()) {
            while (pila.size() < cartasPorPila) {
                pila.push(this.getMazo().pop());
            }
            pila.peek().voltear();
            cartasPorPila++;
        }

    }


    //////////// getters /////////////

    public Descarte getDescarte(){ return this.descarte; }

    public ArrayList<Cimiento> getCimientos(){ return this.cimientos; }

}
