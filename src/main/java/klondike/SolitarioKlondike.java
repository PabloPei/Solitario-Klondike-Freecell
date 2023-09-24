package klondike;

import generalelementos.Dificultad;
import generalelementos.EstadoJuego;
import generalsolitario.Solitario;

public class SolitarioKlondike implements Solitario {

    //private Jugador jugador
    // protected Reglas reglas;
    private Dificultad dificultad;
    private EstadoJuego estadoJuego;
    private TableroKlondike tablero;

    /**
     * doc
     */
    public SolitarioKlondike(){

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


    /**
     * Setea la dificultad del solitario
     * @param dificultad dificultad del solitario
     */
    public void setDificultad(Dificultad dificultad) {

        this.dificultad=dificultad;
        this.tablero.getDescarte().setDificultad(dificultad);

    }

}