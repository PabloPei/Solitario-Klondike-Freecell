package modelosolitario;

import modeloelementos.*;
import ui.Listener;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public abstract class Solitario implements Serializable {

    private int movimientos;
    private Carta cartaOrigen;
    private PilaDeCartas pilaOrigen;
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
        notificar();
        return true;
    }

    public boolean moverCartas(PilaDeCartas origen, PilaDeCartas destino, Carta primeraCarta) {

        if(!destino.puedeAgregarCarta(primeraCarta)) {
            notificar();
            return false;
        }

        PilaDeCartas pilaAux = moverCartasAPilaAuxiliar(origen, primeraCarta);

        if (pilaAux == null){
            notificar();
            return false;
        }
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

    public void setCartaOrigen(Carta carta){this.cartaOrigen=carta;}

    public void setPilaOrigen(PilaDeCartas pila){this.pilaOrigen=pila;}


    public PilaDeCartas getPilaOrigen(){
        return this.pilaOrigen;
    }

    public Carta getCartaOrigen(){
        return this.cartaOrigen;
    }


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
