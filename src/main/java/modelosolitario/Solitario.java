package modelosolitario;

import klondike.SolitarioKlondike;
import modeloelementos.*;

import java.io.*;
import java.util.ArrayList;


public abstract class Solitario implements Serializable {

    private int movimientos;
    private EstadoJuego estadoJuego;
    protected final ArrayList<Pila> pilas;
    protected Mazo mazo;

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
        Carta cartaSacada = origen.sacarCarta(false);

        if (!destino.agregarCarta(cartaSacada)){
            origen.agregarCarta(cartaSacada);
            return false;
        }
        sumarMovimiento();
        return true;
    }

    private PilaDeCartas moverCartasAPilaAuxiliar(PilaDeCartas origen, Carta primeraCarta){
        PilaDeCartas pilaActual = new PilaDeCartas();
        do{
            if ( ! (pilaActual.agregarCarta(origen.sacarCarta(false)))) {
                while (!(pilaActual.isEmpty())) {
                    origen.agregarCarta(pilaActual.sacarCarta(false));
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
                    origen.agregarCarta(destino.sacarCarta(false));
                }
                while (!(pilaAux.isEmpty())) {
                    origen.agregarCarta(pilaAux.sacarCarta(false));
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

    public void serializar(String nomArchivo) throws IOException {
        ObjectOutputStream o =
                new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nomArchivo)));
        o.writeObject(this);
        o.close();
    }

    public static Solitario deSerializar(String nomArchivo) throws IOException, ClassNotFoundException {
        ObjectInputStream o = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nomArchivo)));
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

}
