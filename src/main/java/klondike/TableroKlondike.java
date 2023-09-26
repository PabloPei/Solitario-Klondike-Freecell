package klondike;

import modelosolitario.*;
import modeloelementos.Palo;
import modeloelementos.Carta;
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

        inciarCimientos();
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

    /**
     * Inicializa los 4 cimientos del solitario klondike
     */
    public void inciarCimientos() {

        for (Palo p : Palo.values()) {
            cimientos.add(new Cimiento());
        }

    }

    /**
     * Verifica si existen movimientos posibles para agregar cartas a cimientos
     * @return true si existen movimientos para agregar cartas a cimientos, false en otro caso.
     */
    public boolean hayMovimientoACimientos() {

        // Itero sobre cada cimiento
        for (Cimiento cimiento : getCimientos()) {

            // Itera a través de las pilas (tableau)
            for (Pila pila : getPilas()) {

                // Verifica si se puede agregar la carta de pila al cimiento
                Carta cartaSuperiorEnPila = pila.peek();
                if (cartaSuperiorEnPila != null && cimiento.puedeAgregarCarta(cartaSuperiorEnPila)) {
                        return true;
                    }
                }

                // Verifica si se puede agregar la carta superior del descarte al cimiento
                Carta cartaSuperiorEnDescarte = descarte.peek();
                if (cartaSuperiorEnDescarte != null && cimiento.puedeAgregarCarta(cartaSuperiorEnDescarte)) {
                    return true;
                }

            }

        return false; //si ninguna carta de la pila puede ser agregado a ninguno de los cimientos no hay movimientos disponibles
    }

    /**
     * Verifica si hay algun movimiento disponible en el trablero
     * @return true si hay movimientos disponibles, false en otro caso
     */
    @Override
    public boolean hayMovimientosDisponibles() {
        return false;
    }


    //////////// getters /////////////

    public Descarte getDescarte(){ return this.descarte; }

    public ArrayList<Cimiento> getCimientos(){ return this.cimientos; }

}
