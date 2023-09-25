package Klondike;

import GeneralElementos.Carta;
import GeneralElementos.Mazo;
import GeneralElementos.Palo;
import GeneralElementos.ValorCarta;
import GeneralSolitario.EstadoJuego;
import GeneralSolitario.PilaDeCartas;
import GeneralSolitario.Tablero;

import java.util.ArrayList;
import java.util.Scanner;

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
        for (Palo p : Palo.values()){
            cimientos.add(new Cimiento(p));
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

    public TableroKlondike(EstadoJuego estado){
        super(7);
        if (estado == EstadoJuego.GANADO){
            for(Palo p : Palo.values()){
                cimientos.add(new Cimiento(p, ValorCarta.REY));
            }
        } else {

        }
    }

    public PilaDeCartas getDescarte(){
        return descarte;
    }
    public boolean usarCartaDescarte(PilaDeCartas pilaDestino){
        if (descarte.isEmpty()) return false;
        else {
            return moverCarta(descarte, pilaDestino);
        }
    }

    public PilaDeCartas getPilonSinUsar(){
        return cartasSinJugar;
    }
    public boolean elegirCartaSinJugar(){
        if (cartasSinJugar.isEmpty()){
            int cartasEnDescarte = descarte.size();
            for (int i = 0; i < cartasEnDescarte; i++){
                cartasSinJugar.push(descarte.pop());
            }
            return false;
        } else{
            descarte.push(cartasSinJugar.pop());
            descarte.peek().voltear();
            return true;
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

    public boolean chequearVictoria(){
        boolean cimientosCompletos = true;
        int cimientoActual = 0;
        while(cimientosCompletos && cimientoActual < 4){
            cimientosCompletos = cimientos.get(cimientoActual).cimientoCompleto();
            cimientoActual++;
        }
        return cimientosCompletos;
    }

    public boolean chequearDerrota(){
        return (yaNoSePuedenAgregarCartasACimientos() && yaNoSePuedenAgregarCartasAPilas());
    }

    public boolean yaNoSePuedenAgregarCartasACimientos(){
        boolean puedeAgregarCarta = true;
        int cimientoActual = 0;
        while (puedeAgregarCarta && cimientoActual < 4){
            int pilaActual = 0;
            while (puedeAgregarCarta && pilaActual < 7){
                if (cimientos.get(cimientoActual).agregarCarta(pilas.get(pilaActual).peek())){
                    pilas.get(pilaActual).push(cimientos.get(cimientoActual).pop());
                    pilaActual++;
                } else puedeAgregarCarta = false;
            }
            if (puedeAgregarCarta){
                if(cimientos.get(cimientoActual).agregarCarta(descarte.peek())){
                    descarte.push(cimientos.get(cimientoActual).pop());
                    cimientoActual++;
                }
            }
        }
        return puedeAgregarCarta;
    }

    public boolean yaNoSePuedenAgregarCartasAPilas(){
        boolean puedeAgregarCarta = true;
        int pilaActual = 0;
        while (puedeAgregarCarta && pilaActual < 7){
            int pilaBusqueda = 0;
            while (puedeAgregarCarta && pilaBusqueda < 7){
                if (pilaBusqueda == pilaActual) pilaBusqueda++;
                else {
                    for(Carta c : pilas.get(pilaBusqueda)){
                        if (pilas.get(pilaActual).agregarCarta(c)){
                            pilas.get(pilaBusqueda).push(pilas.get(pilaActual).pop());
                            pilaBusqueda++;
                        } else {
                            puedeAgregarCarta = false;
                            break;
                        }
                    }
                }
            }
            if (puedeAgregarCarta){
                if (pilas.get(pilaActual).agregarCarta(descarte.peek())){
                    pilas.get(pilaActual).pop();
                } else puedeAgregarCarta = false;
            }
        }
        return puedeAgregarCarta;
    }

    /*
        Devuelve true si se pudo realizar la jugada, en otro caso devuelve false
     */
    public boolean realizarJugada(int opcionDeseada){
        boolean jugadaValida = false;
        switch(opcionDeseada){
            case 0 -> jugadaValida = true;
            case 1 -> jugadaValida = true;
            case 2 -> jugadaValida = true;
            case 3 -> jugadaValida = elegirCartaSinJugar();
        }
        return jugadaValida;
    }
}