package modelosolitario;


import modeloelementos.*;
import modelosolitario.*;

/**
 * La claro abstracta Solitario define un conjunto de métodos que deben ser implementados
 * por las clases que representan diferentes variantes del juego de Solitario.
 */

public abstract class Solitario {


    private int movimientos;
    private Dificultad dificultad;
    private EstadoJuego estadoJuego;
    private Tablero tablero;


    /**
     * Constructor para iniciar un juego de Solitario Klondike con una dificultad especificada.
     * @param dificultad La dificultad del juego.
     */
    public Solitario(Dificultad dificultad, Tablero tablero){
        this.movimientos=0;
        this.dificultad=dificultad;
        this.estadoJuego = EstadoJuego.INICIADO;
        this.tablero = tablero;
    }



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


    /**
     * Suma un movimiento al contador
     */
    public void sumarMovimiento(){
        this.movimientos++;
    }

    /////////////////////// Movimientos //////////////////////////

    /**
     * Mueve una carta desde una pila de origen a una pila de destino.
     * @param origen   La pila de origen desde la que se va a sacar la carta.
     * @param destino  La pila de destino a la que se va a agregar la carta.
     * @return         Devuelve true si el movimiento se realizó con éxito, false si no se pudo realizar.
     */
    public static boolean moverCarta(PilaDeCartas origen, PilaDeCartas destino) {
        Carta cartaSacada = origen.sacarCarta(false);

        if (!destino.agregarCarta(cartaSacada)){
            origen.agregarCarta(cartaSacada); //no pudo agregar la carta la vuelvo al lugar original
            return false;
        }
        return true;
    }

    /**
     * Mueve un conjunto de cartas desde una pila de origen a una pila de destino.
     * @param origen        La pila de origen desde la que se moverá el conjunto de cartas.
     * @param destino       La pila de destino a la que se moverá el conjunto de cartas.
     * @param primeraCarta  La primera carta del conjunto a mover.
     * @return              Devuelve true si el movimiento se realizó con éxito, false si no se pudo realizar.
     */
    public static boolean moverCartas(PilaDeCartas origen, PilaDeCartas destino, Carta primeraCarta) {
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
        return true;
    }


    /////////////////// getters & setters ///////////////////////
    /**
     * Obtiene el número total de movimientos realizados en el juego.
     * @return El número total de movimientos.
     */
    public int obtenerMovimientos() {
        return this.movimientos;
    }

    /**
     * Setea la dificultad del solitario
     * @param dificultad del solitario
     */
    public void setDificultad(Dificultad dificultad){
        this.dificultad = dificultad;
    }

    /**
     * obtiene la dificultad del solitario
     * @return dificultad del solitario
     */
    public Dificultad getDificultad(){
        return this.dificultad;
    }

    /**
     * obtiene el estado del juego
     * @return EstadoJuego
     */
    public EstadoJuego getEstadoJuego(){
        return this.estadoJuego;
    }

    /**
     * setea el estado del juego
     * @param estado
     */
    public void setEstadoJuego(EstadoJuego estado){this.estadoJuego=estado;}

    /**
     * obtiene el tablero
     */
    public Tablero getTablero(){return this.tablero; }
}
