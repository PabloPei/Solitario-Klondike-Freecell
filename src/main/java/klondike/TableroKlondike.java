package klondike;

import modelosolitario.*;


public class TableroKlondike extends Tablero {


    ///////// Atributos ///////////
    private Descarte descarte;

    ///////// Metodos ///////////

    /**
     * Inicializa las pilas segun las reglas del solitario klondike
     */
    public TableroKlondike(){
        super();
        Descarte descarte=new Descarte();
    }

    /**
     * Inicializa las pilas segun las reglas del solitario klondike
     */
    @Override
    public void iniciarPilas() {
        for (int i = 0; i < 7; i++) {
            this.getPilas().add(new Pila());
        }
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

}
