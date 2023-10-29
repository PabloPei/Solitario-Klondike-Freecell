package freecell;

import modeloelementos.Carta;
import modeloelementos.Palo;
import modeloelementos.PilaDeCartas;
import modeloelementos.ValorCarta;
import modelosolitario.Cimiento;
import modelosolitario.Mazo;
import modelosolitario.Pila;
import org.junit.Test;

import java.io.*;
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
    public void testRepartirPilas() {
        SolitarioFreeCell solitario = new SolitarioFreeCell();
        ArrayList<Pila> pilas = solitario.getPilas();
        for (Pila pila : pilas) {
            int indicePila = pilas.indexOf(pila);
            if (indicePila < 4)
                assertEquals(pila.size(), 7);
            else
                assertEquals(pila.size(), 6);
        }
    }

    @Test
    public void testMoverYGanar() {
        ArrayList<Cimiento> cimientos = new ArrayList<>();
        cimientos.add( new Cimiento(12,Palo.PICA));
        cimientos.add( new Cimiento(13,Palo.TREBOL));
        cimientos.add( new Cimiento(13,Palo.CORAZON));
        cimientos.add( new Cimiento(13,Palo.DIAMANTE));

        ArrayList<Pila> pilas = new ArrayList<>();
        for (int i = 0; i < 7 ;i++) {
            pilas.add( new Pila());
        }
        Pila pila8 = new Pila();
        pila8.agregarCarta(new Carta (ValorCarta.REY, Palo.PICA, false));
        pilas.add(pila8);

        PilaDeCartas mazoVacio = new PilaDeCartas();
        Mazo mazo = new Mazo(mazoVacio);

        ArrayList<PilaSuperior> pilasSuperiores = new ArrayList<>();

        SolitarioFreeCell solitario = new SolitarioFreeCell(mazo, pilas, cimientos, pilasSuperiores);

        assertFalse(solitario.verificarVictoria());

        solitario.moverCarta(solitario.getPilas().get(7), solitario.getCimientos().get(0));

        assertTrue(solitario.verificarVictoria());
    }

    @Test
    public void testEstadoDeJuegoGanado() {
        ArrayList<Cimiento> cimientos = new ArrayList<>();
        cimientos.add( new Cimiento(13,Palo.PICA));
        cimientos.add( new Cimiento(13,Palo.TREBOL));
        cimientos.add( new Cimiento(13,Palo.CORAZON));
        cimientos.add( new Cimiento(13,Palo.DIAMANTE));

        PilaDeCartas mazoVacio = new PilaDeCartas();
        Mazo mazo = new Mazo(mazoVacio);

        ArrayList<PilaSuperior> pilasSuperiores = new ArrayList<>();

        ArrayList<Pila> pilas = new ArrayList<>();
        pilas.add(new Pila());
        pilas.add(new Pila());
        pilas.add(new Pila());
        pilas.add(new Pila());
        pilas.add(new Pila());
        pilas.add(new Pila());
        pilas.add(new Pila());

        SolitarioFreeCell solitario = new SolitarioFreeCell(mazo, pilas,cimientos, pilasSuperiores);

        assertTrue(solitario.verificarVictoria());
    }

    @Test
    public void testGuardarSolitario() throws IOException, ClassNotFoundException {

        SolitarioFreeCell solitario = new SolitarioFreeCell();

        FileOutputStream os = new FileOutputStream("test.txt");
        solitario.serializar(os);
        FileInputStream is = new FileInputStream("test.txt");
        SolitarioFreeCell solitarioAux = SolitarioFreeCell.deSerializar(is);

        boolean mazoIgual = solitario.getMazo().equals(solitarioAux.getMazo());
        boolean movIgual = (solitario.getMovimientos() == solitarioAux.getMovimientos());

        int i = 0;
        boolean pilasIgual = true;
        for (Pila pila : solitarioAux.getPilas()) {
            if (! pila.equals(solitario.getPilas().get(i))){
                pilasIgual = false;
            }
            i++;
        }

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
