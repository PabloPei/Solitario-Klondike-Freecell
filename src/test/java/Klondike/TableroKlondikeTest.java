package Klondike;

import GeneralElementos.Mazo;
import GeneralSolitario.EstadoJuego;
import GeneralSolitario.Tablero;
import org.junit.Test;

import static org.junit.Assert.*;

public class TableroKlondikeTest {
    @Test
    public void testChequearVictoria() {
        TableroKlondike tablero = new TableroKlondike(EstadoJuego.GANADO);
        EstadoJuego esperado = EstadoJuego.GANADO;
        EstadoJuego resultado = tablero.chequearEstadoJuego();
        assertEquals(esperado, resultado);
    }

    @Test
    public void testSacarCartaPilonSinUsar() {
        TableroKlondike tablero = new TableroKlondike(new Mazo());
        boolean esperado = true;
        boolean resultado = tablero.elegirCartaSinJugar();
        assertEquals(esperado, resultado);
    }

    @Test
    public void testSacarCartaPilonSinUsarFalla(){
        TableroKlondike tablero = new TableroKlondike(new Mazo());
        while (!tablero.getPilonSinUsar().isEmpty()){
            tablero.getDescarte().push(tablero.getPilonSinUsar().pop());
        }
        boolean esperado = false;
        boolean resultado = tablero.elegirCartaSinJugar();
        assertEquals(esperado, resultado);
    }

}