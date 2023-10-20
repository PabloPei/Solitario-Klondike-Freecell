package freecell;

import modeloelementos.Carta;
import modeloelementos.Palo;
import modelosolitario.*;

import java.util.ArrayList;

public class SolitarioFreeCell extends Solitario {

    public static final int CANTIDAD_PILAS = 8;
    private final ArrayList<Cimiento> cimientos;
    private  ArrayList<Carta> celdas;

    public SolitarioFreeCell(){

        super(CANTIDAD_PILAS);
        this.cimientos = new ArrayList<>();
        inciarCimientos();
        this.celdas = new ArrayList<>();
    }

    public SolitarioFreeCell(long semilla){

        super(CANTIDAD_PILAS, semilla);
        this.cimientos = new ArrayList<>();
        inciarCimientos();
        this.celdas = new ArrayList<>();
    }

    public SolitarioFreeCell(Mazo mazo, ArrayList<Pila> pilas, ArrayList<Cimiento> cimientos, ArrayList<Carta> celdas){

        super(mazo,pilas);
        this.cimientos = cimientos;
        this.celdas = celdas;
    }

    @Override
    public void repartirPilas() {
        int cartasPorPilaMitadIzq = 7;
        int cartasPorPilaMitadDer = 6;
        int pilasPorMitad = 4;

        int cartasPorPila = cartasPorPilaMitadIzq;
        int posicionPila = 0;

        for (Pila pila : this.getPilas()) {
            if(posicionPila == pilasPorMitad)
                cartasPorPila = cartasPorPilaMitadDer;
            while (pila.size() < cartasPorPila) {
                Carta cartaAux = this.getMazo().sacarCarta(true);
                pila.push(cartaAux);
                pila.peek().voltear();
            }
            posicionPila++;
        }
    }

    @Override
    public boolean verificarVictoria() {
        return false;
    }

    private void inciarCimientos() {
        for (Palo p : Palo.values()) {
            cimientos.add(new Cimiento());
        }
    }
}
