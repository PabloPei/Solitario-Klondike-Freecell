package Klondike;

import junit.framework.TestCase;
import klondike.SolitarioKlondike;
import modeloelementos.*;
import modelosolitario.*;
import org.junit.Test;

import java.util.ArrayList;

public class SolitarioKlondikeTest extends TestCase {

    @Test
    public void testCrearSolitario(){
        SolitarioKlondike solitario = new SolitarioKlondike(Dificultad.FACIL);
        assertEquals(Dificultad.FACIL,solitario.getDificultad());

    }

    @Test
    public void testCrearSolitarioConSemilla(){
        SolitarioKlondike solitario = new SolitarioKlondike(Dificultad.FACIL,13);
        SolitarioKlondike solitario2 = new SolitarioKlondike(Dificultad.FACIL,13);

        assertEquals(solitario.getMazo(),solitario2.getMazo());
    }

    @Test
    public void testMoverCartaFunciona() {
        SolitarioKlondike solitario = new SolitarioKlondike(Dificultad.FACIL);

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
    public void testMoverCartaFalla(){
        SolitarioKlondike solitario = new SolitarioKlondike(Dificultad.FACIL);

        var pilaDestino = new Pila();
        var pilaOrigen = new Pila();
        pilaOrigen.push(new Carta(ValorCarta.REINA, Palo.TREBOL, false));
        assertFalse(solitario.moverCarta(pilaOrigen, pilaDestino));
    }

    @Test
    public void testMoverConjuntoDeCartasFunciona() {
        SolitarioKlondike solitario = new SolitarioKlondike(Dificultad.FACIL);

        Pila pilaOrigen = new Pila();
        pilaOrigen.push(new Carta(ValorCarta.REY, Palo.TREBOL, false));
        pilaOrigen.push(new Carta(ValorCarta.REINA, Palo.CORAZON, false));
        pilaOrigen.push(new Carta(ValorCarta.SOTA, Palo.PICA, false));

        Pila pilaDestino = new Pila();
        pilaDestino.push(new Carta(ValorCarta.REY, Palo.PICA, false));
        solitario.moverCartas(pilaOrigen, pilaDestino, pilaOrigen.get(1));
        assertEquals(pilaDestino.get(2),new Carta(ValorCarta.SOTA, Palo.PICA, false));
        assertEquals(pilaDestino.get(1),new Carta(ValorCarta.REINA, Palo.CORAZON, false));
    }

    @Test
    public void testMoverConjuntoCartasFallaPorColor(){
        SolitarioKlondike solitario = new SolitarioKlondike(Dificultad.FACIL);

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
        SolitarioKlondike solitario = new SolitarioKlondike(Dificultad.FACIL);

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
        SolitarioKlondike solitario = new SolitarioKlondike(Dificultad.FACIL);
        assertFalse(solitario.verificarVictoria());
    }

    @Test
    public void testRobarCartasdelMazo() {
        SolitarioKlondike solitario = new SolitarioKlondike(Dificultad.FACIL);
        Carta carta = solitario.getMazo().verCarta();
        solitario.robarCartasDelMazo();

        assertEquals ( solitario.getDescarte().verCarta(), carta);
    }

    @Test
    public void test_RepartirPilas() {
        SolitarioKlondike solitario = new SolitarioKlondike(Dificultad.FACIL);
        ArrayList<Pila> pilas = solitario.getPilas();
        for (Pila pila : pilas) {
            assertEquals(pila.size(), pilas.indexOf(pila) + 1);
        }
    }

    @Test
    public void test_MoverYGanar() {
        //inicializo el juego en el estado ganado
        ArrayList<Cimiento> cimientos = new ArrayList<Cimiento>();
        cimientos.add( new Cimiento(12,Palo.PICA));
        cimientos.add( new Cimiento(13,Palo.TREBOL));
        cimientos.add( new Cimiento(13,Palo.CORAZON));
        cimientos.add( new Cimiento(13,Palo.DIAMANTE));

        ArrayList<Pila> pilas = new ArrayList<Pila>();
        pilas.add( new Pila());
        pilas.add( new Pila());
        pilas.add( new Pila());
        pilas.add( new Pila());
        pilas.add( new Pila());
        pilas.add( new Pila());
        Pila pila7 = new Pila();
        pila7.agregarCarta(new Carta (ValorCarta.REY, Palo.PICA, false));
        pilas.add(pila7);

        PilaDeCartas mazoVacio = new PilaDeCartas();
        Mazo mazo = new Mazo(mazoVacio);

        Descarte descarte = new Descarte();

        SolitarioKlondike solitario = new SolitarioKlondike(Dificultad.FACIL, mazo, pilas, cimientos, descarte);

        assertFalse(solitario.verificarVictoria());

        solitario.moverCarta(solitario.getPilas().get(6), solitario.getCimientos().get(0));

        assertTrue(solitario.verificarVictoria());
        }

    @Test
    public void test_verificarDificultad() {
        SolitarioKlondike solitario = new SolitarioKlondike(Dificultad.MEDIO);
        Carta carta = solitario.getMazo().verCarta();
        solitario.robarCartasDelMazo();

        assertEquals (2,solitario.getDescarte().size());
    }

    @Test
    public void test_MoverCartadeCimientoVacio() {
        SolitarioKlondike solitario = new SolitarioKlondike(Dificultad.FACIL);
        Cimiento cimientoVacio = solitario.getCimientos().get(0);
        Pila pilaDestino = solitario.getPilas().get(0);
        assertFalse(solitario.moverCarta(cimientoVacio, pilaDestino));
    }

    @Test
    public void test_Movimientos() {
        SolitarioKlondike solitario = new SolitarioKlondike(Dificultad.FACIL);
        Carta carta = solitario.getMazo().verCarta();
        solitario.robarCartasDelMazo();
        assertEquals ( solitario.getMovimientos(), 1);
    }

    @Test
    public void testEstadoDeJuegoGanado(){
        //inicializo el juego en el estado ganado
        ArrayList<Cimiento> cimientos = new ArrayList<Cimiento>();
        cimientos.add( new Cimiento(13,Palo.PICA));
        cimientos.add( new Cimiento(13,Palo.TREBOL));
        cimientos.add( new Cimiento(13,Palo.CORAZON));
        cimientos.add( new Cimiento(13,Palo.DIAMANTE));

        Descarte descarte = new Descarte();

        PilaDeCartas mazoVacio = new PilaDeCartas();
        Mazo mazo = new Mazo(mazoVacio);

        ArrayList<Pila> pilas = new ArrayList<Pila>();
        pilas.add(new Pila());
        pilas.add(new Pila());
        pilas.add(new Pila());
        pilas.add(new Pila());
        pilas.add(new Pila());
        pilas.add(new Pila());
        pilas.add(new Pila());

        SolitarioKlondike solitario = new SolitarioKlondike(Dificultad.MEDIO, mazo, pilas,cimientos, descarte );

        assertTrue(solitario.verificarVictoria());
    }
}