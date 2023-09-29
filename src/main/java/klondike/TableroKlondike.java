package klondike;

import Klondike.Cimiento;
import modeloelementos.Dificultad;
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
     * Inicializa un tablero segun las reglas del solitario klondike
     */
    public TableroKlondike(Dificultad dificultad){
        super(CANTIDAD_PILAS);
        this.cimientos = new ArrayList<>();
        inciarCimientos();
        Descarte descarte = new Descarte(dificultad);
    }

    /**
     * Inicializa un tablero segun las reglas del solitario klondike a partir de una semilla
     */
    public TableroKlondike(Dificultad dificultad, long semilla){
        super(CANTIDAD_PILAS, semilla);
        this.cimientos = new ArrayList<>();
        inciarCimientos();
        Descarte descarte=new Descarte(dificultad);
    }


    /**
     * Inicializa un tablero segun las reglas del solitario klondike a partir de un estado del juego particular
     */
    public TableroKlondike(Dificultad dificultad, Mazo mazo, ArrayList<Cimiento> cimientos, ArrayList<Pila> pilas){
        super(mazo, pilas);
        this.cimientos = new ArrayList<>();
        for(Cimiento cimiento : cimientos){
            this.cimientos.add(cimiento);
        }
        this.descarte = new Descarte(dificultad);
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
     * Metodo auxiliar de hay movimientos disponibles.
     * Verifica si existen movimientos posibles para agregar cartas a cimientos
     * @return true si existen movimientos para agregar cartas a cimientos, false en otro caso.
     */
    private boolean hayMovimientoACimientos() {
        // Itero sobre cada cimiento
        for (Cimiento cimiento : getCimientos()) {

            // Itera a través de las pilas (tableau)
            for (Pila pila : getPilas()) {
                // Verifica si se puede agregar la carta de pila al cimiento
                Carta topePila = pila.verCarta();
                if (topePila != null && cimiento.puedeAgregarCarta(topePila)) {
                    return true;
                }
            }

            // Verifica si se puede agregar la carta superior del descarte al cimiento
            if (!descarte.isEmpty()){
                Carta topeDescarte = descarte.verCarta();
                if (cimiento.puedeAgregarCarta(topeDescarte)) {
                    return true;
                }
            }
        }
        return false; //si ninguna carta de la pila puede ser agregado a ninguno de los cimientos no hay movimientos disponibles
    }

    /**
     * Metodo auxiliar de hay movimientos disponibles.
     * Verifica si existen movimientos posibles para agregar cartas a las pilas
     * @return true si existen movimientos para agregar cartas a pilas, false en otro caso.
     */
    private boolean hayMovimientoAPilas() {
        // Itero sobre cada pila
        for (Pila pilaActual : pilas) {
            // Itero sobre cada pila de busqueda
            for (Pila pilaBusqueda : pilas) {
                if (pilaBusqueda != pilaActual) {
                    //Veo si puedo agregar la carta a la pila
                    Carta cartaEnPilaBusqueda = pilaBusqueda.verCarta();
                    if (pilaActual.puedeAgregarCarta(cartaEnPilaBusqueda)) {
                        return true;
                    }
                }
            }
            // También verifica si se puede agregar la carta del descarte al tableau actual
            if (!descarte.isEmpty()) {
                if (pilaActual.puedeAgregarCarta(descarte.verCarta())) return true;
            }
        }
        // No se encontraron movimientos válidos
        return false;
    }

    /**
     * Verifica si los cimientos estan llenos
     * @return true si estan llenos, false en otro caso
     */
    public boolean cimientosLlenos(){
        for (Cimiento cimiento : cimientos){
            if (!(cimiento.cimientoCompleto()))
                return false;
        }
        return true;
    }

    /**
     * Verifica si hay algun movimiento disponible en el trablero
     * @return true si hay movimientos disponibles, false en otro caso
     */
    @Override
    public boolean hayMovimientosDisponibles() {
        return (hayMovimientoACimientos() || hayMovimientoAPilas());
    }


    //////////// getters /////////////

    public Descarte getDescarte(){ return this.descarte; }

    public ArrayList<Cimiento> getCimientos(){ return this.cimientos; }
}
