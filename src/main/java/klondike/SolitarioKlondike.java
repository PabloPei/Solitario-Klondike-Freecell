package klondike;

import modeloelementos.Dificultad;
import modeloelementos.EstadoJuego;
import modelosolitario.Solitario;

public class SolitarioKlondike implements Solitario {

    // private Jugador jugador
    // protected Reglas reglas;
    private Dificultad dificultad;
    private EstadoJuego estadoJuego;
    private TableroKlondike tablero;

    /**
     * doc
     */
    public SolitarioKlondike(Dificultad dificultad){
         this.tablero = new TableroKlondike();
         this.setDificultad(dificultad);
         this.estadoJuego = EstadoJuego.INICIADO;
    }


    /**
     * doc
     */
    @Override
    public void jugar(){

        this.estadoJuego=EstadoJuego.JUGANDO;

        while (this.estadoJuego == EstadoJuego.JUGANDO){

            //Movimento.MetodoMovimiento()
            this.estadoJuego = verificarEstado();
        }
    }

    /**
     * doc
     */
    @Override
    public EstadoJuego verificarEstado() {

        if (verificarVictoria()) return EstadoJuego.GANADO;
        else if (verificarDerrota()) return EstadoJuego.PERDIDO;
        else return EstadoJuego.JUGANDO;
    }


    @Override
    public boolean verificarVictoria() {
        return false;
    }

    @Override
    public boolean verificarDerrota() {
        return false;
    }

    @Override
    public int obtenerPuntuación() {
        return 0;
    }


    /**
     * Setea la dificultad del solitario
     * @param dificultad dificultad del solitario
     */
    public void setDificultad(Dificultad dificultad) {

        this.dificultad=dificultad;
        this.tablero.getDescarte().setDificultad(dificultad);

    }

}