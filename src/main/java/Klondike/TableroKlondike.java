package Klondike;

import GeneralElementos.Carta;
import GeneralElementos.Mazo;
import GeneralSolitario.EstadoJuego;
import GeneralSolitario.PilaDeCartas;
import GeneralSolitario.Tablero;

import java.util.ArrayList;

public class TableroKlondike extends Tablero {
    private ArrayList<Cimiento> cimientos = new ArrayList<>();
    private PilaDeCartas descarte = new PilaDeCartas();
    private PilaDeCartas cartasSinJugar = new PilaDeCartas();

    /**
     * Crea un GeneralSolitario.Tablero para un juego de Klondike.
     * Crea los 4 cimientos correspondientes
     * Crea las 7 pilas necesarias para el juego, con la cantidad de cartas en orden cresciente de
        izquierda (el indice 0 de pilas) a derecha (el indice 6) y voltea la carta superior de cada pila
     */
    public TableroKlondike(Mazo mazo){
        super(7);
        for(int i = 0; i < 7; i++){
            pilas.add(new PilaDeCartas());
        }
        for (int i = 0; i < 4; i++){
            cimientos.add(new Cimiento());
        }
        int cartasPorPila = 1;
        for(PilaDeCartas pila : pilas){
            while (pila.size() < cartasPorPila){
                pila.push(mazo.pop());
            }
            pila.peek().voltear();
            cartasPorPila++;
        }
        int tamanioMazo = mazo.size();
        for (int i = 0; i < tamanioMazo; i++){
            cartasSinJugar.push(mazo.pop());
        }
    }

    public boolean moverCarta(PilaDeCartas pilaActual, PilaDeCartas nuevaPila){
        return (nuevaPila.agregarCarta(pilaActual.pop()));
    }

    public boolean moverConjuntoCartas(PilaDeCartas pilaActual, PilaDeCartas nuevaPila, Carta primeraCartaAMover){
        if (!pilaActual.contains(primeraCartaAMover)) return false;
        else {
            int iterator = 0;
            boolean seguirBuscando = true;
            while (iterator < pilaActual.size() && seguirBuscando){
                if (pilaActual.get(iterator) == primeraCartaAMover){
                    seguirBuscando = false;
                } else iterator++;
            }
            if (nuevaPila.agregarCarta(primeraCartaAMover)){
                for(int i = iterator+1; i < pilaActual.size(); i++){
                    nuevaPila.push(pilaActual.get(iterator));
                }
                for (int j = pilaActual.size(); j >= iterator; j--){
                    pilaActual.pop();
                }
                return true;
            } else return false;
        }
    }
    public EstadoJuego chequearEstadoJuego(){
        if (chequearVictoria()) return EstadoJuego.GANADO;
        else if (chequearDerrota()) return EstadoJuego.PERDIDO;
        else return EstadoJuego.JUGANDO;
    }

    private boolean chequearVictoria(){
        boolean cimientosCompletos = true;
        int cimientoActual = 0;
        while(cimientosCompletos && cimientoActual < 4){
            cimientosCompletos = cimientos.get(cimientoActual).cimientoCompleto();
        }
        return cimientosCompletos;
    }

    private boolean chequearDerrota(){
        boolean condicionDerrota = false;
        return condicionDerrota;
    }

}
