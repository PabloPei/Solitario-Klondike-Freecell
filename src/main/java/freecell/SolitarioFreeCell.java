package freecell;

import modeloelementos.Carta;
import modelosolitario.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class SolitarioFreeCell extends SolitarioConCimientos {

    public static final int CANTIDAD_PILAS = 8;
    public static final int CARTAS_POR_PILA_MITAD_IZQ = 7;
    public static final int CARTAS_POR_PILA_MITAD_DER = 6;
    public static final int PILAS_POR_MITAD = 4;
    private final ArrayList<PilaSuperior> pilasDeApoyo;

    public SolitarioFreeCell() {
        super(CANTIDAD_PILAS);
        this.pilasDeApoyo = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            pilasDeApoyo.add(new PilaSuperior());
        }
    }

    public SolitarioFreeCell(long semilla) {
        super(CANTIDAD_PILAS, semilla);
        this.pilasDeApoyo = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            pilasDeApoyo.add(new PilaSuperior());
        }
    }

    public SolitarioFreeCell(Mazo mazo, ArrayList<Pila> pilas, ArrayList<Cimiento> cimientos,
                             ArrayList<PilaSuperior> pilasSuperiores) {
        super(mazo,pilas,cimientos);
        this.pilasDeApoyo = pilasSuperiores;
    }

    @Override
    public void repartirPilas() {
        int cartasPorPila = CARTAS_POR_PILA_MITAD_IZQ;
        int posicionPila = 0;

        for (Pila pila : this.getPilas()) {
            if(posicionPila == PILAS_POR_MITAD)
                cartasPorPila = CARTAS_POR_PILA_MITAD_DER;
            while (pila.size() < cartasPorPila) {
                Carta cartaAux = this.getMazo().sacarCarta(true);
                pila.push(cartaAux);
                pila.peek().voltear();
            }
            posicionPila++;
        }
    }

    public static SolitarioFreeCell deSerializar(InputStream is) throws IOException, ClassNotFoundException {
        return (SolitarioFreeCell) Solitario.deSerializar(is);
    }

    public ArrayList<PilaSuperior> getPilasSuperiores() {
        return this.pilasDeApoyo;
    }
}
