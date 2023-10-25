package freecell;

import klondike.SolitarioKlondike;
import modeloelementos.Carta;
import modeloelementos.Palo;
import modeloelementos.PilaDeCartas;
import modeloelementos.ValorCarta;
import modelosolitario.Cimiento;
import modelosolitario.Descarte;
import modelosolitario.Mazo;
import modelosolitario.Pila;
import org.junit.Test;

import java.io.IOException;
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

    @Test
    public void testMoverConjuntoCartasFallaPorColor(){
        SolitarioFreeCell solitario = new SolitarioFreeCell();

        Pila pilaOrigen = new Pila();
        pilaOrigen.push(new Carta(ValorCarta.REY, Palo.TREBOL, false));
        Carta cartaAMover1 = new Carta(ValorCarta.REINA, Palo.CORAZON, false);
        pilaOrigen.push(cartaAMover1);
        Carta cartaAMover2 = new Carta(ValorCarta.SOTA, Palo.PICA, false);
        pilaOrigen.push(cartaAMover2);

        Pila pilaDestino = new Pila();
        pilaDestino.push(new Carta(ValorCarta.REY, Palo.CORAZON, false));

        assertFalse(solitario.moverCartas(pilaOrigen, pilaDestino, pilaOrigen.get(1)));
        assertEquals(pilaOrigen.pop(), cartaAMover2);
        assertEquals(pilaOrigen.pop(), cartaAMover1);
    }

    @Test
    public void testMoverConjuntoCartasFallaPorValor() {
        SolitarioFreeCell solitario = new SolitarioFreeCell();

        Pila pilaOrigen = new Pila();
        pilaOrigen.push(new Carta(ValorCarta.REY, Palo.TREBOL, false));

        Carta cartaAMover1 = new Carta(ValorCarta.REINA, Palo.CORAZON, false);
        pilaOrigen.push(cartaAMover1);
        Carta cartaAMover2 = new Carta(ValorCarta.SOTA, Palo.PICA, false);
        pilaOrigen.push(cartaAMover2);

        Pila pilaDestino = new Pila();
        pilaDestino.push(new Carta(ValorCarta.OCHO, Palo.CORAZON, false));

        assertFalse(solitario.moverCartas(pilaOrigen, pilaDestino, pilaOrigen.get(1)));
        assertEquals(pilaOrigen.pop(), cartaAMover2);
        assertEquals(pilaOrigen.pop(), cartaAMover1);
    }

    @Test
    public void testSolitarioNoGanado() {
        SolitarioFreeCell solitario = new SolitarioFreeCell();
        assertFalse(solitario.verificarVictoria());
    }

    @Test
    public void testMoverCartadeCimientoVacio() {
        SolitarioFreeCell solitario = new SolitarioFreeCell();
        Cimiento cimientoVacio = solitario.getCimientos().get(0);
        Pila pilaDestino = solitario.getPilas().get(0);
        assertFalse(solitario.moverCarta(cimientoVacio, pilaDestino));
    }

    @Test
    public void testGuardarSolitario() throws IOException, ClassNotFoundException {

        SolitarioFreeCell solitario = new SolitarioFreeCell();

        solitario.serializar("test.txt");
        SolitarioFreeCell solitarioAux = SolitarioFreeCell.deSerializar("test.txt");

        //verifico que los mazos y la cantidad de movimientos sean iguales
        boolean mazoIgual = solitario.getMazo().equals(solitarioAux.getMazo());
        boolean movIgual = (solitario.getMovimientos() == solitarioAux.getMovimientos());

        //verifico que las pilas sean iguales
        int i = 0;
        boolean pilasIgual = true;
        for (Pila pila : solitarioAux.getPilas()) {
            if (! pila.equals(solitario.getPilas().get(i))){
                pilasIgual = false;
            }
            i++;
        }

        //verifico que las pilas superiores sean iguales
        int j = 0;
        boolean apoyoIgual = true;
        for (PilaSuperior pilaSuperior : solitarioAux.getPilasSuperiores()) {
            if (! pilaSuperior.equals(solitario.getPilasSuperiores().get(j))){
                apoyoIgual = false;
            }
            j++;
        }

        assertTrue(apoyoIgual);
        assertTrue(pilasIgual);
        assertTrue(mazoIgual);
        assertTrue(movIgual);

    }

}
