package modelosolitario;

/*
import modeloelementos.Carta;
import modeloelementos.Palo;
import modeloelementos.PilaDeCartas;
import modeloelementos.ValorCarta;
import org.junit.Test;
import static modelosolitario.Movimientos.moverCarta;
import static modelosolitario.Movimientos.moverCartas;
import static org.junit.Assert.*;

public class MovimientosTest {
    @Test
    public void testMoverCartaFunciona() {
        var pilaDestino = new Pila();
        pilaDestino.push(new Carta(ValorCarta.REY, Palo.TREBOL, false));
        var pilaOrigen = new Pila();
        Carta cartaAMover = new Carta(ValorCarta.REINA, Palo.CORAZON, false);
        pilaOrigen.push(cartaAMover);
        moverCarta(pilaOrigen, pilaDestino);
        Carta cartaEsperada = pilaDestino.verCarta();
        assertEquals(cartaAMover, cartaEsperada);
    }

    @Test
    public void testMoverCartaFalla(){
        var pilaDestino = new Pila();
        var pilaOrigen = new Pila();
        pilaOrigen.push(new Carta(ValorCarta.REINA, Palo.TREBOL, false));
        assertFalse(moverCarta(pilaOrigen, pilaDestino));
    }

    @Test
    public void testMoverConjuntoDeCartasFunciona() {
        Pila cartasIniciales1 = new Pila();
        cartasIniciales1.push(new Carta(ValorCarta.REY, Palo.TREBOL, false));
        cartasIniciales1.push(new Carta(ValorCarta.REINA, Palo.CORAZON, false));
        cartasIniciales1.push(new Carta(ValorCarta.SOTA, Palo.PICA, false));
        Pila pilaOrigen = new Pila(cartasIniciales1);
        Pila pilaDestino = new Pila();
        pilaDestino.push(new Carta(ValorCarta.REY, Palo.PICA, false));
        moverCartas(pilaOrigen, pilaDestino, pilaOrigen.get(1));
        assertEquals(pilaDestino.get(2),new Carta(ValorCarta.SOTA, Palo.PICA, false));
        assertEquals(pilaDestino.get(1),new Carta(ValorCarta.REINA, Palo.CORAZON, false));
    }

    @Test
    public void testMoverConjuntoCartasFallaPorColor(){
        Pila cartasIniciales1 = new Pila();
        cartasIniciales1.push(new Carta(ValorCarta.REY, Palo.TREBOL, false));
        cartasIniciales1.push(new Carta(ValorCarta.REINA, Palo.CORAZON, false));
        cartasIniciales1.push(new Carta(ValorCarta.SOTA, Palo.PICA, false));
        Pila pilaOrigen = new Pila(cartasIniciales1);
        Pila pilaDestino = new Pila();
        pilaDestino.push(new Carta(ValorCarta.REY, Palo.CORAZON, false));
        assertFalse(moverCartas(pilaOrigen, pilaDestino, pilaOrigen.get(1)));
    }

    @Test
    public void testMoverConjuntoCartasFallaPorValor(){
        Pila cartasIniciales1 = new Pila();
        cartasIniciales1.push(new Carta(ValorCarta.REY, Palo.TREBOL, false));
        cartasIniciales1.push(new Carta(ValorCarta.REINA, Palo.CORAZON, false));
        cartasIniciales1.push(new Carta(ValorCarta.SOTA, Palo.PICA, false));
        Pila pilaOrigen = new Pila(cartasIniciales1);
        Pila pilaDestino = new Pila();
        pilaDestino.push(new Carta(ValorCarta.OCHO, Palo.CORAZON, false));
        assertFalse(moverCartas(pilaOrigen, pilaDestino, pilaOrigen.get(1)));
    }
}
*/
