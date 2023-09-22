package Klondike;

import GeneralElementos.Carta;
import GeneralElementos.Palo;
import org.junit.Test;

import static org.junit.Assert.*;

public class CimientoTest {

    @Test
    public void testAgregarCartaValida(){
        Carta nuevaCarta = new Carta(2, Palo.DIAMANTE, true);
        Cimiento cimiento = new Cimiento(Palo.DIAMANTE);
        cimiento.push(new Carta(1, Palo.DIAMANTE, true));
        boolean esperado = true;
        boolean resultado = cimiento.agregarCarta(nuevaCarta);
        assertEquals(esperado, resultado);
    }

    @Test
    public void testAgregarCartaInvalidaPorPalo(){
        Carta nuevaCarta = new Carta(3, Palo.TREBOL, true);
        Cimiento cimiento = new Cimiento(Palo.CORAZON,2 );
        boolean esperado = false;
        boolean resultado = cimiento.agregarCarta(nuevaCarta);
        assertEquals(esperado, resultado);
    }

    @Test
    public void testAgregarCartaInvalidaPorCimientoVacio(){
        Carta nuevaCarta = new Carta(2, Palo.PICA, true);
        Cimiento cimiento = new Cimiento(Palo.PICA);
        boolean esperado = false;
        boolean resultado = cimiento.agregarCarta(nuevaCarta);
        assertEquals(esperado, resultado);
    }

    @Test
    public void testAgregarCartaInvalidaPorValor(){
        Carta nuevaCarta = new Carta(3, Palo.TREBOL, true);
        Cimiento cimiento = new Cimiento(Palo.TREBOL);
        boolean esperado = false;
        boolean resultado = cimiento.agregarCarta(nuevaCarta);
        assertEquals(esperado, resultado);
    }

    @Test
    public void testAgregarCartaInvalidaPorCimientoLleno(){
        Carta nuevaCarta = new Carta(1, Palo.CORAZON, true);
        Cimiento cimiento = new Cimiento(Palo.CORAZON, 13);
        boolean esperado = false;
        boolean resultado = cimiento.agregarCarta(nuevaCarta);
    }

}