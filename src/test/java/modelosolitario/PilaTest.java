package modelosolitario;

import modeloelementos.Carta;
import modeloelementos.Palo;
import modeloelementos.PilaDeCartas;
import modeloelementos.ValorCarta;
import org.junit.Test;

import static org.junit.Assert.*;

public class PilaTest {
    @Test
    public void testPuedeAgregarCartaPilaVaciaFunciona() {
        Pila pila = new Pila();
        Carta carta = new Carta(ValorCarta.REY, Palo.TREBOL, false);
        assertTrue(pila.puedeAgregarCarta(carta));
    }

    @Test
    public void testPuedeAgregarCartaPilaVaciaFalla(){
        Pila pila = new Pila();
        Carta carta = new Carta(ValorCarta.REINA, Palo.TREBOL, false);
        assertFalse(pila.puedeAgregarCarta(carta));
    }

    @Test
    public void testPuedeAgregarCartaPilaNoVaciaFunciona(){
        var cartasIniciales = new PilaDeCartas();
        cartasIniciales.push(new Carta(ValorCarta.REY, Palo.TREBOL, false));
        var pila = new Pila(cartasIniciales);
        Carta carta = new Carta(ValorCarta.REINA, Palo.CORAZON, false);
        assertTrue(pila.puedeAgregarCarta(carta));
    }

    @Test
    public void testPuedeAgregarCartaPilaNoVaciaFallaPorColor(){
        var cartasIniciales = new PilaDeCartas();
        cartasIniciales.push(new Carta(ValorCarta.REY, Palo.TREBOL, false));
        var pila = new Pila(cartasIniciales);
        assertFalse(pila.puedeAgregarCarta(new Carta(ValorCarta.REINA, Palo.PICA, false)));
    }

    @Test
    public void testPuedeAgregarCartaPilaNoVaciaFallaPorValor(){
        var cartasIniciales = new PilaDeCartas();
        cartasIniciales.push(new Carta(ValorCarta.REY, Palo.TREBOL, false));
        var pila = new Pila(cartasIniciales);
        assertFalse(pila.puedeAgregarCarta(new Carta(ValorCarta.NUEVE, Palo.CORAZON, false)));
    }

    @Test
    public void testRetirarUnaCarta() {
        Pila pilaOriginal = new Pila();
        pilaOriginal.push(new Carta(ValorCarta.REY, Palo.TREBOL, false));
        pilaOriginal.push(new Carta(ValorCarta.REINA, Palo.CORAZON, false));
        pilaOriginal.push(new Carta(ValorCarta.SOTA, Palo.PICA, false));
        pilaOriginal.push(new Carta(ValorCarta.DIEZ, Palo.CORAZON, false));
        pilaOriginal.push(new Carta(ValorCarta.NUEVE, Palo.TREBOL, false));
        Carta carta1 = new Carta(ValorCarta.OCHO, Palo.DIAMANTE, false);
        pilaOriginal.push(carta1);
        Carta carta2 = new Carta(ValorCarta.NUEVE, Palo.CORAZON, false);
        pilaOriginal.push(carta2);

        Pila pilaDestino = new Pila();
        Carta carta3 = new Carta(ValorCarta.DIEZ, Palo.PICA, false);
        pilaDestino.push(carta3);
        boolean resultado = pilaDestino.agregarCarta(pilaOriginal.sacarCarta(false));

        assertTrue(resultado);
        assertEquals(pilaDestino.verCarta(), carta2);
        assertEquals(pilaOriginal.verCarta(),carta1);
    }
    
}