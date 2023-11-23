package klondike;

import modeloelementos.Carta;
import modelosolitario.*;

import java.io.*;
import java.util.ArrayList;


public class SolitarioKlondike extends SolitarioConCimientos implements Serializable{

    public static final int CANTIDAD_PILAS = 7;
    private final Descarte descarte;

    public SolitarioKlondike(){
        super(CANTIDAD_PILAS);
        this.descarte = new Descarte();
    }

    public SolitarioKlondike(long semilla){
        super(CANTIDAD_PILAS, semilla);
        this.descarte = new Descarte();
    }

    public SolitarioKlondike(Mazo mazo, ArrayList<Pila> pilas, ArrayList<Cimiento> cimientos, Descarte descarte){
        super(mazo,pilas,cimientos);
        this.descarte = descarte;
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

    public boolean robarCartasDelMazo() {
        Mazo mazo = getMazo();
        Descarte descarte = getDescarte();
        if (descarte.isEmpty() && mazo.isEmpty())
            return false;


        for (int i = 0; i < descarte.getCantidadCartas(); i++) {
            if(mazo.isEmpty()){
                mazo.agregarDescarte(descarte);
            }
            else {
                Carta carta = mazo.sacarCarta(false);
                descarte.agregarCarta(carta);

            }
        }
        sumarMovimiento();
        notificar();
        return true;
    }

    public static SolitarioKlondike deSerializar(InputStream is) throws IOException, ClassNotFoundException {
        return (SolitarioKlondike) Solitario.deSerializar(is);
    }

    public Descarte getDescarte(){ return this.descarte; }
}
