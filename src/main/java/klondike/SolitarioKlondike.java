package klondike;

import modeloelementos.Carta;
import modeloelementos.Palo;
import modelosolitario.*;

import java.io.IOException;
import java.util.ArrayList;


public class SolitarioKlondike extends Solitario {

    public static final int CANTIDAD_PILAS = 7;
    private final ArrayList<Cimiento> cimientos;
    private final Descarte descarte;

    public SolitarioKlondike(){

        super(CANTIDAD_PILAS);
        this.cimientos = new ArrayList<>();
        inciarCimientos();
        this.descarte = new Descarte();
    }

    public SolitarioKlondike(long semilla){

        super(CANTIDAD_PILAS, semilla);
        this.cimientos = new ArrayList<>();
        inciarCimientos();
        this.descarte = new Descarte();
    }

    public SolitarioKlondike(Mazo mazo, ArrayList<Pila> pilas, ArrayList<Cimiento> cimientos, Descarte descarte){

        super(mazo,pilas);
        this.cimientos = cimientos;
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

    private void inciarCimientos() {
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

    private void guardarPilas() throws IOException {
        String tituloPredeterminado = "PilaKlondike_";
        for(int i = 0; i < CANTIDAD_PILAS; i++){
            pilas.get(i).serializar(tituloPredeterminado + i + ".txt");
        }
    }

    private void guardarCimientos() throws IOException {
        String tituloPredeterminado = "CimientoKlondike_";
        for(int i = 0; i < this.cimientos.size(); i++){
            cimientos.get(i).serializar(tituloPredeterminado + i + ".txt");
        }
    }

    private void guardarDescarte() throws IOException {
        this.descarte.serializar( "DescarteKlondike.txt");
    }
    public void guardarEstadoJuego() throws IOException {
        super.guardarEstadoJuego();
        guardarPilas();
        guardarCimientos();
        guardarDescarte();
    }
}
