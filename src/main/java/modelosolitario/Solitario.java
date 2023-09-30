package modelosolitario;


import modeloelementos.*;

import java.util.ArrayList;

/**
 * La claro abstracta Solitario define un conjunto de métodos y atributos comunes a todos los solitarios.
 * por las clases que representan diferentes variantes del juego de Solitario.
 */

public abstract class Solitario {


    ///////// Atributos ///////////
    private int movimientos;
    private Dificultad dificultad;
    private EstadoJuego estadoJuego;
    private final ArrayList<Pila> pilas;
    private final Mazo mazo;


    /**
     * Constructor para iniciar un juego de Solitario con una dificultad especificada.
     * @param cantidadPilas Las pilas del solitario.
     */
    public Solitario(int cantidadPilas){
        this.movimientos=0;
        this.estadoJuego = EstadoJuego.JUGANDO;

        this.mazo = new Mazo();
        this.mazo.mezclar();

        this.pilas = new ArrayList<Pila>();
        iniciarPilas(cantidadPilas);
        repartirPilas();

    }


    /**
     * Constructor para iniciar un juego de Solitario con una dificultad especificada a partir de una semilla.
     * @param cantidadPilas Las pilas del solitario.
     * @param semilla La semilla a partir de la cual iniciar el juego.
     */
    public Solitario( int cantidadPilas, long semilla){
        this.movimientos=0;
        this.estadoJuego = EstadoJuego.JUGANDO;

        this.mazo = new Mazo();
        this.mazo.mezclar(semilla);

        this.pilas = new ArrayList<Pila>();
        iniciarPilas(cantidadPilas);
        repartirPilas();

    }

    /**
     * Constructor para iniciar desde un estado especifico un juego de Solitario  con una dificultad, mazo y pilas especificas.
     * @param mazo El mazo en el estado que se quiere iniciar.
     * @param pilas Las pilas en el estado que se quien iniciar.
     */
    public Solitario(Mazo mazo, ArrayList<Pila> pilas){

        this.movimientos=0;
        this.estadoJuego = EstadoJuego.JUGANDO;

        this.mazo = new Mazo();
        this.pilas = pilas;

    }


    /**
     * Inicializa las pilas, dependiendo la cantidad que corresponda al solitario
     */
    public void iniciarPilas(int cantidadPilas){
        for (int i = 0; i < cantidadPilas; i++) {
            this.getPilas().add(new Pila());
        }
    }

    /**
     * Reparte las cartas iniciales en las pilas de juego (cada solitario lo implementa de distinta forma).
     */
    public abstract void repartirPilas();


    /**
     * Verifica si el juego ha sido ganado o perdido según las reglas específicas del Solitario.
     * @return el estado del juego
     */
    public EstadoJuego verificarEstado(){
        if (verificarVictoria()) return EstadoJuego.GANADO;
        else return EstadoJuego.JUGANDO;
    }

    /**
     * Metodos auxiliares que cada solitario va a definir con sus reglas de victoria
     * @return true si el juego ha sido ganado, false en caso contrario.
     */
    public abstract boolean verificarVictoria();


    /////////////////////// Movimientos //////////////////////////

    /**
     * Suma un movimiento al contador
     */
    public void sumarMovimiento(){
        this.movimientos++;
    }


    /**
     * Mueve una carta desde una pila de origen a una pila de destino.
     * En la segunda etapa del tp vamos a tomar las cordenadas del mouse para las cartas
     * @param origen   La pila de origen desde la que se va a sacar la carta.
     * @param destino  La pila de destino a la que se va a agregar la carta.
     * @return         Devuelve true si el movimiento se realizó con éxito, false si no se pudo realizar.
     */
    public boolean moverCarta(PilaDeCartas origen, PilaDeCartas destino) {
        Carta cartaSacada = origen.sacarCarta(false);

        if (!destino.agregarCarta(cartaSacada)){
            origen.agregarCarta(cartaSacada); //no pudo agregar la carta la vuelvo al lugar original
            return false;
        }
        sumarMovimiento();
        return true;
    }

    /**
     * Mueve un conjunto de cartas desde una pila de origen a una pila de destino.
     * En la segunda etapa del tp vamos a tomar las cordenadas del mouse para las cartas
     * @param origen        La pila de origen desde la que se moverá el conjunto de cartas.
     * @param destino       La pila de destino a la que se moverá el conjunto de cartas.
     * @param primeraCarta  La primera carta del conjunto a mover.
     * @return              Devuelve true si el movimiento se realizó con éxito, false si no se pudo realizar.
     */
    public boolean moverCartas(PilaDeCartas origen, PilaDeCartas destino, Carta primeraCarta) {
        // En primer lugar reviso el caso particular de si se puede agregar la carta a la nueva pila
        if(!destino.puedeAgregarCarta(primeraCarta)) return false;

        // Me guardo la ultima carta por si falla volver atras
        Carta ultimaCarta = origen.verCarta();

        // Me armo una pila auxiliar con las cartas
        PilaDeCartas pilaAux = new PilaDeCartas();
        do{
            if ( ! (pilaAux.agregarCarta(origen.sacarCarta(false)))) {
                // Si falla en agregar vuelvo todas las cartas de la pila auxiliar al original
                while (!(pilaAux.isEmpty())) {
                    origen.agregarCarta(pilaAux.sacarCarta(false));
                }
                return false;
            }
        }while (primeraCarta != pilaAux.verCarta());

        // Comienzo a agregarlas a la nueva pila
        while (!pilaAux.isEmpty()) {
            if (!(destino.agregarCarta(pilaAux.pop()))) {
                //si fallo al agregar una carta vuelvo las cartas a la posición original
                // Las cartas que ya estaban en la pila destino las vuelvo al origen
                while (destino.peek() != ultimaCarta) {
                    origen.agregarCarta(destino.sacarCarta(false));
                }
                // Las cartas que todavia no habia podido agregar y estaban en la auxiliar las vuelvo a la origen
                while (!(pilaAux.isEmpty())) {
                    origen.agregarCarta(pilaAux.sacarCarta(false));
                }
                return false;
            }
        }

        sumarMovimiento();
        return true;
    }

    /////////////////// getters & setters ///////////////////////

    public int getMovimientos() {
        return this.movimientos;
    }

    public void setDificultad(Dificultad dificultad){ this.dificultad = dificultad; }

    public Dificultad getDificultad(){
        return this.dificultad;
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
