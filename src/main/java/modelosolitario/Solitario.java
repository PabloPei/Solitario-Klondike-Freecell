package modelosolitario;

import modeloelementos.*;

import java.util.ArrayList;


public abstract class Solitario {

    private int movimientos;
    private EstadoJuego estadoJuego;
    private final ArrayList<Pila> pilas;
    private final Mazo mazo;

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
