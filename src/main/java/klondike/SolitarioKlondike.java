package klondike;

import generalelementos.Dificultad;
import generalelementos.EstadoJuego;
import generalsolitario.Solitario;
import generalsolitario.Tablero;

public class SolitarioKlondike implements Solitario {

    //private Jugador jugador
    // protected Reglas reglas;
    private Dificultad dificultad;
    private EstadoJuego estadoJuego;
    private Tablero tablero;

    /**
     * doc
     */
    public SolitarioKlondike(){

         this.tablero = new TableroKlondike(dificultad);
         this.estadoJuego = EstadoJuego.INICIADO;

    }

    /**
     * doc
     */
    @Override
    public void iniciarJuego(Dificultad dificultad){

            this.setDificultad(dificultad);
            tablero.iniciarPilas();
    }

    /**
     * doc
     */
    @Override
    public void jugar(){

        this.estadoJuego=EstadoJuego.JUGANDO;

        while (this.estadoJuego == EstadoJuego.JUGANDO){
            //realizarJugada(3);
            //estado = verificarVictoria();
        }
    }

    @Override
    public void realizarJugada() {

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


    /////////// setters //////////
    public void setDificultad(Dificultad dificultad) {
        this.dificultad=dificultad;
    }

}