package freecell;

import modeloelementos.Carta;
import modeloelementos.Palo;
import modelosolitario.*;

import java.io.IOException;
import java.util.ArrayList;

public class SolitarioFreeCell extends Solitario {

    public static final int CANTIDAD_PILAS = 8;
    private final ArrayList<Cimiento> cimientos;
    private final ArrayList<PilaSuperior> pilasDeApoyo;

    public SolitarioFreeCell(){

        super(CANTIDAD_PILAS);
        this.cimientos = new ArrayList<>();
        iniciarCimientos();
        this.pilasDeApoyo = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            pilasDeApoyo.add(new PilaSuperior());
        }
    }

    public SolitarioFreeCell(long semilla){

        super(CANTIDAD_PILAS, semilla);
        this.cimientos = new ArrayList<>();
        iniciarCimientos();
        this.pilasDeApoyo = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            pilasDeApoyo.add(new PilaSuperior());
        }
    }

    public SolitarioFreeCell(Mazo mazo, ArrayList<Pila> pilas, ArrayList<Cimiento> cimientos,
                             ArrayList<PilaSuperior> pilasSuperiores){

        super(mazo,pilas);
        this.cimientos = cimientos;
        this.pilasDeApoyo = pilasSuperiores;
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

    private void iniciarCimientos() {
        for (Palo p : Palo.values()) {
            cimientos.add(new Cimiento());
        }
    }

    private void guardarPilas() throws IOException {
        String tituloPredeterminado = "PilaFreeCell_";
        for(int i = 0; i < CANTIDAD_PILAS; i++){
            pilas.get(i).serializar(tituloPredeterminado + i + ".txt");
        }
    }

    private void guardarCimientos() throws IOException {
        String tituloPredeterminado = "CimientoFreeCell_";
        for(int i = 0; i < cimientos.size(); i++){
            cimientos.get(i).serializar(tituloPredeterminado + i + ".txt");
        }
    }

    private void guardarPilasSuperiores() throws IOException {
        String tituloPredeterminado = "PilaSuperiorFreeCell_";
        for(int i = 0; i < pilasDeApoyo.size(); i++){
            pilasDeApoyo.get(i).serializar(tituloPredeterminado + i + ".txt");
        }
    }
    @Override
    public void guardarEstadoJuego() throws IOException {
        super.guardarEstadoJuego();
        guardarPilas();
        guardarCimientos();
        guardarPilasSuperiores();
    }
}
