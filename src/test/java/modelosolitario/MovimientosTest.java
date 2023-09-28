package modelosolitario;


import modeloelementos.Carta;
import modeloelementos.Palo;
import modeloelementos.PilaDeCartas;
import modeloelementos.ValorCarta;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovimientosTest {
    @Test
    public void testMoverCartaFunciona() {
        var pilaDestino = new Pila();
        pilaDestino.push(new Carta(ValorCarta.REY, Palo.TREBOL, false));
        var pilaOrigen = new Pila();
        pilaOrigen.push(new Carta(ValorCarta.REINA, Palo.CORAZON, false));
        assertTrue(Movimientos.moverCarta(pilaOrigen, pilaDestino));
    }

    @Test
    public void testMoverCartaFalla(){
        var pilaDestino = new Pila();
        var pilaOrigen = new Pila();
        pilaOrigen.push(new Carta(ValorCarta.REINA, Palo.TREBOL, false));
        assertFalse(Movimientos.moverCarta(pilaOrigen, pilaDestino));
    }

    @Test
    public void testMoverConjuntoDeCartasFunciona() {
        Pila cartasIniciales1 = new Pila();
        cartasIniciales1.push(new Carta(ValorCarta.REY, Palo.TREBOL, false));
        cartasIniciales1.push(new Carta(ValorCarta.REINA, Palo.CORAZON, false));
        cartasIniciales1.push(new Carta(ValorCarta.SOTA, Palo.PICA, false));
        PilaDeCartas pilaOrigen = new Pila(cartasIniciales1);
        PilaDeCartas pilaDestino = new Pila();
        pilaDestino.push(new Carta(ValorCarta.REY, Palo.PICA, false));
        assertTrue(Movimientos.moverCartas(pilaOrigen, pilaDestino, pilaOrigen.get(1)));
    }

    @Test
    public void testMoverConjuntoCartasFallaPorColor(){
        Pila cartasIniciales1 = new Pila();
        cartasIniciales1.push(new Carta(ValorCarta.REY, Palo.TREBOL, false));
        cartasIniciales1.push(new Carta(ValorCarta.REINA, Palo.CORAZON, false));
        cartasIniciales1.push(new Carta(ValorCarta.SOTA, Palo.PICA, false));
        PilaDeCartas pilaOrigen = new Pila(cartasIniciales1);
        PilaDeCartas pilaDestino = new Pila();
        pilaDestino.push(new Carta(ValorCarta.REY, Palo.CORAZON, false));
        assertFalse(Movimientos.moverCartas(pilaOrigen, pilaDestino, pilaOrigen.get(1)));
    }

    @Test
    public void testMoverConjuntoCartasFallaPorValor(){
        Pila cartasIniciales1 = new Pila();
        cartasIniciales1.push(new Carta(ValorCarta.REY, Palo.TREBOL, false));
        cartasIniciales1.push(new Carta(ValorCarta.REINA, Palo.CORAZON, false));
        cartasIniciales1.push(new Carta(ValorCarta.SOTA, Palo.PICA, false));
        PilaDeCartas pilaOrigen = new Pila(cartasIniciales1);
        PilaDeCartas pilaDestino = new Pila();
        pilaDestino.push(new Carta(ValorCarta.OCHO, Palo.CORAZON, false));
        assertFalse(Movimientos.moverCartas(pilaOrigen, pilaDestino, pilaOrigen.get(1)));
    }
}