package Klondike;

import GeneralElementos.Carta;
import GeneralElementos.Palo;
import GeneralElementos.ValorCarta;
import org.junit.Test;

import static org.junit.Assert.*;

public class CimientoTest {

    @Test
    public void testAgregarCartaValida(){
        Carta nuevaCarta = new Carta(ValorCarta.DOS, Palo.DIAMANTE, true);
        Cimiento cimiento = new Cimiento(Palo.DIAMANTE);
        cimiento.push(new Carta(ValorCarta.AS, Palo.DIAMANTE, true));
        boolean esperado = true;
        boolean resultado = cimiento.agregarCarta(nuevaCarta);
        assertEquals(esperado, resultado);
    }

    @Test
    public void testAgregarCartaInvalidaPorPalo(){
        Carta nuevaCarta = new Carta(ValorCarta.TRES, Palo.TREBOL, true);
        Cimiento cimiento = new Cimiento(Palo.CORAZON,ValorCarta.DOS );
        boolean esperado = false;
        boolean resultado = cimiento.agregarCarta(nuevaCarta);
        assertEquals(esperado, resultado);
    }

    @Test
    public void testAgregarCartaInvalidaPorCimientoVacio(){
        Carta nuevaCarta = new Carta(ValorCarta.DOS, Palo.PICA, true);
        Cimiento cimiento = new Cimiento(Palo.PICA);
        boolean esperado = false;
        boolean resultado = cimiento.agregarCarta(nuevaCarta);
        assertEquals(esperado, resultado);
    }

    @Test
    public void testAgregarCartaInvalidaPorValor(){
        Carta nuevaCarta = new Carta(ValorCarta.TRES, Palo.TREBOL, true);
        Cimiento cimiento = new Cimiento(Palo.TREBOL);
        boolean esperado = false;
        boolean resultado = cimiento.agregarCarta(nuevaCarta);
        assertEquals(esperado, resultado);
    }

    @Test
    public void testAgregarCartaInvalidaPorCimientoLleno(){
        Carta nuevaCarta = new Carta(ValorCarta.AS, Palo.CORAZON, true);
        Cimiento cimiento = new Cimiento(Palo.CORAZON, ValorCarta.REY);
        boolean esperado = false;
        boolean resultado = cimiento.agregarCarta(nuevaCarta);
    }

}