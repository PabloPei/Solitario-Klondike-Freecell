package modelosolitario;

import modeloelementos.*;
import ui.Listener;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public abstract class Solitario implements Serializable {

    private int movimientos;
    private EstadoJuego estadoJuego;
    protected final ArrayList<Pila> pilas;
    protected Mazo mazo;

    private List<Listener> listeners = new ArrayList<>();

    public Solitario(int cantidadPilas){
        this.movimientos=0;
        this.estadoJuego = EstadoJuego.JUGANDO;

        this.mazo = new Mazo();
        this.mazo.mezclar();

        this.pilas = new ArrayList<>();
        iniciarPilas(cantidadPilas);
        repartirPilas();
    }

    public Solitario( int cantidadPilas, long semilla){
        this.movimientos=0;
        this.estadoJuego = EstadoJuego.JUGANDO;

        this.mazo = new Mazo();
        this.mazo.mezclar(semilla);

        this.pilas = new ArrayList<>();
        iniciarPilas(cantidadPilas);
        repartirPilas();
    }

    public Solitario(Mazo mazo, ArrayList<Pila> pilas){
        this.movimientos=0;
        this.estadoJuego = EstadoJuego.JUGANDO;

        this.mazo = mazo;
        this.pilas = pilas;
    }

    public void iniciarPilas(int cantidadPilas){
        for (int i = 0; i < cantidadPilas; i++) {
            this.getPilas().add(new Pila());
        }
    }

    public abstract void repartirPilas();

    public EstadoJuego verificarEstado(){
        if (verificarVictoria()) return EstadoJuego.GANADO;
        else return EstadoJuego.JUGANDO;
    }

    public abstract boolean verificarVictoria();

    public void sumarMovimiento(){
        this.movimientos++;
    }

    public boolean moverCarta(PilaDeCartas origen, PilaDeCartas destino) {

        for (Carta carta : destino){
            System.out.println("carta:" + carta.getValor());
            System.out.println("estado:" + carta.getBocaAbajo());
        }

        Carta cartaSacada = origen.sacarCarta(false);

        if (!destino.agregarCarta(cartaSacada)){
            origen.peek().setBocaAbajo(true);
            origen.push(cartaSacada);


            return false;
        }

        sumarMovimiento();
        notificar();
        return true;
    }

    private PilaDeCartas moverCartasAPilaAuxiliar(PilaDeCartas origen, Carta primeraCarta){
        PilaDeCartas pilaActual = new PilaDeCartas();
        do{
            if ( ! (pilaActual.agregarCarta(origen.sacarCarta(false)))) {
                while (!(pilaActual.isEmpty())) {
                    origen.push(pilaActual.pop());
                }
                return null;
            }
        }while (primeraCarta != pilaActual.verCarta());
        return pilaActual;
    }

    private boolean moverCartasALaNuevaPila(PilaDeCartas origen, PilaDeCartas destino, PilaDeCartas pilaAux){
        Carta ultimaCarta = origen.verCarta();
        while (!pilaAux.isEmpty()) {
            if (!(destino.agregarCarta(pilaAux.pop()))) {
                while (destino.peek() != ultimaCarta) {
                    origen.push(destino.pop());
                }
                while (!(pilaAux.isEmpty())) {
                    origen.push(pilaAux.pop());
                }
                return false;
            }
        }
        sumarMovimiento();
        return true;
    }

    public boolean moverCartas(PilaDeCartas origen, PilaDeCartas destino, Carta primeraCarta) {
        if(!destino.puedeAgregarCarta(primeraCarta)) return false;
        PilaDeCartas pilaAux = moverCartasAPilaAuxiliar(origen, primeraCarta);
        if (pilaAux == null) return false;
        else {
            return moverCartasALaNuevaPila(origen, destino, pilaAux);
        }
    }

    public void serializar(OutputStream os) throws IOException {
        ObjectOutputStream o =
                new ObjectOutputStream(new BufferedOutputStream(os));
        o.writeObject(this);
        o.close();
    }

    public static Solitario deSerializar(InputStream is) throws IOException, ClassNotFoundException {
        ObjectInputStream o = new ObjectInputStream(new BufferedInputStream(is));
        Solitario p = (Solitario) o.readObject();
        o.close();
        return p;
    }

    public int getMovimientos() {
        return this.movimientos;
    }

    public EstadoJuego getEstadoJuego(){
        return this.estadoJuego;
    }

    public void setEstadoJuego(EstadoJuego estado){this.estadoJuego=estado;}

    public Mazo getMazo(){
        return this.mazo;
    }

    public ArrayList<Pila> getPilas(){
        return this.pilas;
    }

    public void agregarListener(Listener l) {listeners.add(l);}
    protected void notificar(){
        for (Listener l : listeners) {
            l.escuchar();
        }
    }

}
