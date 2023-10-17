package klondike;

import modeloelementos.Carta;
import modeloelementos.Dificultad;
import modeloelementos.Palo;
import modelosolitario.*;

import java.util.ArrayList;


public class SolitarioKlondike extends Solitario {

    public static final int CANTIDAD_PILAS = 7;
    private ArrayList<Cimiento> cimientos;
    private Descarte descarte;

    public SolitarioKlondike(Dificultad dificultad){

        super(CANTIDAD_PILAS);
        this.cimientos = new ArrayList<>();
        inciarCimientos();
        this.descarte = new Descarte();
        this.setDificultad(dificultad);
    }

    public SolitarioKlondike(Dificultad dificultad, long semilla){

        super(CANTIDAD_PILAS, semilla);
        this.cimientos = new ArrayList<>();
        inciarCimientos();
        this.descarte = new Descarte();
        this.setDificultad(dificultad);
    }

    public SolitarioKlondike(Dificultad dificultad, Mazo mazo, ArrayList<Pila> pilas, ArrayList<Cimiento> cimientos, Descarte descarte){

        super(mazo,pilas);
        this.cimientos = cimientos;
        this.descarte = descarte;
        this.setDificultad(dificultad);
    }

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

    public void inciarCimientos() {
        for (Palo p : Palo.values()) {
            cimientos.add(new Cimiento());
        }
    }

    @Override
    public boolean verificarVictoria() {
        for (Cimiento cimiento : cimientos){
            if (!(cimiento.cimientoCompleto()))
                return false;
        }
        return true;
    }

    public void setDificultad(Dificultad dificultad){
        super.setDificultad(dificultad);
        this.getDescarte().setCantidadCartas(dificultad);
    }

    public boolean robarCartasDelMazo() {
        Mazo mazo = getMazo();
        Descarte descarte = getDescarte();

        if (descarte.isEmpty() && mazo.isEmpty())
            return false;

        mazo.agregarDescarte(descarte);

        for (int i = 0; i < descarte.getCantidadCartas(); i++) {
            Carta carta = mazo.sacarCarta(false);
            if( ! descarte.agregarCarta(carta))
                break;
        }
        sumarMovimiento();
        return true;
    }

    public Descarte getDescarte(){ return this.descarte; }

    public ArrayList<Cimiento> getCimientos(){ return this.cimientos; }
}
