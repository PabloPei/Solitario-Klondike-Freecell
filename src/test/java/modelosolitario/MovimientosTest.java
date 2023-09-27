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
}