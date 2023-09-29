package klondike;


import modeloelementos.Dificultad;
import modeloelementos.EstadoJuego;
import modelosolitario.*;

public class SolitarioKlondike implements Solitario {

    private int movimientos;
    private Dificultad dificultad;
    private EstadoJuego estadoJuego;
    private TableroKlondike tablero;

    /**
     * Constructor para iniciar un juego de Solitario Klondike con una dificultad especificada.
     * @param dificultad La dificultad del juego.
     */
    public SolitarioKlondike(Dificultad dificultad){
        this.movimientos=0;
        this.dificultad=dificultad;
        this.tablero = new TableroKlondike(dificultad);
        this.estadoJuego = EstadoJuego.INICIADO;
    }

    /**
     * Constructor para iniciar un juego de Solitario Klondike con una dificultad y una semilla especificadas.
     * @param dificultad La dificultad del juego.
     * @param semilla    La semilla para la generación aleatoria del juego.
     */
    public SolitarioKlondike(Dificultad dificultad, long semilla){
        this.movimientos=0;
        this.dificultad=dificultad;
        this.tablero = new TableroKlondike(dificultad, semilla);
        this.estadoJuego = EstadoJuego.INICIADO;
    }

    /**
     * Inicia y controla la jugabilidad del juego de Solitario Klondike.
     */
    @Override
    public void jugar(){

        this.estadoJuego=EstadoJuego.JUGANDO;

        while (this.estadoJuego == EstadoJuego.JUGANDO){

            // Realiza una jugada (movimiento) en el juego
            //Object origen = tablero.getMazo();
           // Object destino = tablero.getDescarte();
           // Movimientos.moverCartas(origen, destino);

            // Incrementa el contador de movimientos si la jugada se realizó con éxito
            sumarMovimiento();
            this.estadoJuego = verificarEstado();
        }

    }

    /**
     * Verifica el estado actual del juego.
     * @return El estado del juego (GANADO, PERDIDO o JUGANDO).
     */
    @Override
    public EstadoJuego verificarEstado() {

        if (verificarVictoria()) return EstadoJuego.GANADO;
        else if (verificarDerrota()) return EstadoJuego.PERDIDO;
        else return EstadoJuego.JUGANDO;
    }

    /**
     * Verifica si el jugador ha ganado el juego.
     * @return true si el juego ha sido ganado, false de lo contrario.
     */
    @Override
    public boolean verificarVictoria() {
        return tablero.cimientosLlenos();
    }

    /**
     * Verifica si el jugador ha perdido el juego.
     * @return true si el juego ha sido perdido, false de lo contrario.
     */
    @Override
    public boolean verificarDerrota() {
        return !(tablero.hayMovimientosDisponibles());
    }

    /**
     * Incrementa el contador de movimientos.
     */
    @Override
    public void sumarMovimiento(){
        movimientos++;
    }



    /////////////////// getters & setters ///////////////////////
    /**
     * Obtiene el número total de movimientos realizados en el juego.
     * @return El número total de movimientos.
     */
    @Override
    public int obtenerMovimientos() {
        return this.movimientos;
    }

    /**
     * Setea la dificultad del solitario
     * @param dificultad del solitario
     */
    @Override
    public void setDificultad(Dificultad dificultad){
        this.dificultad = dificultad;
    }

    /**
     * obtiene la dificultad del solitario
     * @return dificultad del solitario
     */
    @Override
    public Dificultad getDificultad(){
        return this.dificultad;
    }
}
