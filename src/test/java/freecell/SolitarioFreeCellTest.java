package freecell;

import klondike.SolitarioKlondike;
import modeloelementos.Carta;
import modeloelementos.Palo;
import modeloelementos.ValorCarta;
import modelosolitario.Cimiento;
import modelosolitario.Pila;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SolitarioFreeCellTest {
    @Test
    public void testCrearSolitario(){
        SolitarioFreeCell solitario = new SolitarioFreeCell();
        assertNotNull(solitario);
    }

    @Test
    public void testCrearSolitarioCimientosVacios(){
        SolitarioFreeCell solitario = new SolitarioFreeCell();
        ArrayList<Cimiento> cimientos = solitario.getCimientos();
        for(Cimiento c: cimientos){
            assertTrue(c.isEmpty());
        }
    }

    @Test
    public void testCrearSolitarioConSemilla(){
        SolitarioFreeCell solitario = new SolitarioFreeCell(13);
        SolitarioFreeCell solitario2 = new SolitarioFreeCell(13);

        assertEquals(solitario.getMazo(),solitario2.getMazo());
    }

    @Test
    public void testMoverCartaFunciona() {
        SolitarioFreeCell solitario = new SolitarioFreeCell();

        var pilaDestino = new Pila();
        pilaDestino.push(new Carta(ValorCarta.REY, Palo.TREBOL, false));
        var pilaOrigen = new Pila();
        Carta cartaAMover = new Carta(ValorCarta.REINA, Palo.CORAZON, false);
        pilaOrigen.push(cartaAMover);
        solitario.moverCarta(pilaOrigen, pilaDestino);
        Carta cartaEsperada = pilaDestino.verCarta();
        assertEquals(cartaAMover, cartaEsperada);
    }
}
