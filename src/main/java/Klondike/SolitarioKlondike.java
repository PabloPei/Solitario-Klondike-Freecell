package Klondike;

import GeneralElementos.Mazo;
import GeneralSolitario.EstadoJuego;
import GeneralSolitario.Solitario;
import GeneralSolitario.Tablero;

public class SolitarioKlondike extends Solitario {
    private Tablero tablero;

    public SolitarioKlondike(){
        super(1);
        mazos.add(new Mazo());
        Mazo mazoJuego = mazos.get(0);
        mazoJuego.mezclar();
        tablero = new TableroKlondike(mazoJuego);
    }


    public void jugar(){
        while (estado == EstadoJuego.JUGANDO){
            tablero.realizarJugada(3);
            estado = tablero.chequearEstadoJuego();
        }
        if (estado == EstadoJuego.GANADO){
            System.out.println("Ganaste capo!");
        } else {
            System.out.println("Perdiste burro!");
        }
    }

    /*
    public boolean ganoJuego(){
        estado = tablero.chequearEstadoJuego();
        return estado == EstadoJuego.GANADO;
    }

    public boolean perdioJuego(){
        estado = tablero.chequearEstadoJuego();
        return estado == EstadoJuego.PERDIDO;
    }
     */
}
