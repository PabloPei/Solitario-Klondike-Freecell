package modelosolitario;

import org.junit.Test;
import static org.junit.Assert.*;
import modeloelementos.*;
import modelosolitario.*;

import java.util.EmptyStackException;


public class MazoTest {

    // Create a new Mazo instance and verify that it has 52 cards and they are all face down.
    @Test
    public void test_nuevaInstanciadeMazo() {
        Mazo mazo = new Mazo();
        assertEquals(52, mazo.size());
        for (Carta carta : mazo) {
            assertTrue(carta.getBocaAbajo());
        }
    }

    // Create a new Mazo instance with particular values
    @Test
    public void test_nuevaInstanciadeMazo_particular() {
        PilaDeCartas pila = new PilaDeCartas();
        Carta carta1 = new Carta(ValorCarta.AS, Palo.CORAZON, true);
        Carta carta2 = new Carta(ValorCarta.DOS, Palo.CORAZON, true);
        pila.agregarCarta(carta1);
        pila.agregarCarta(carta2);
        Mazo mazo = new Mazo(pila);
    }

    @Test
    public void test_agregarCarta() {
            PilaDeCartas pila = new PilaDeCartas();
            Carta carta1 = new Carta(ValorCarta.AS, Palo.CORAZON, true);
            Carta carta2 = new Carta(ValorCarta.DOS, Palo.CORAZON, true);
            pila.agregarCarta(carta1);
            pila.agregarCarta(carta2);
            Mazo mazo = new Mazo(pila);

            Carta carta3 = new Carta(ValorCarta.TRES, Palo.CORAZON, true);
            boolean result = mazo.agregarCarta(carta3);

            assertTrue(result);
    }

    @Test
    public void test_agregarCarta_repetida() {
        PilaDeCartas pila = new PilaDeCartas();
        Carta carta1 = new Carta(ValorCarta.AS, Palo.CORAZON, true);
        Carta carta2 = new Carta(ValorCarta.DOS, Palo.CORAZON, true);
        pila.agregarCarta(carta1);
        pila.agregarCarta(carta2);
        Mazo mazo = new Mazo(pila);

        Carta carta3 = new Carta(ValorCarta.DOS, Palo.CORAZON, true);
        mazo.agregarCarta(carta3);

        boolean result = mazo.agregarCarta(carta3);

        assertFalse(result);
    }


    // Call the mezclar() method and verify that the order of the cards has changed.
    @Test
    public void test_mezclar() {
        Mazo mazo = new Mazo();
        Mazo originalMazo = new Mazo();
        mazo.mezclar();
        assertNotEquals(originalMazo, mazo);
    }

    // Call the mezclar(long semilla) method with a specific seed and verify that the order of the cards is the same every time.
    @Test
    public void test_mezclar_semilla() {
        long seed = 12345;
        Mazo mazo1 = new Mazo();
        Mazo mazo2 = new Mazo();
        mazo1.mezclar(seed);
        mazo2.mezclar(seed);
        assertEquals(mazo1, mazo2);
    }

    // Create a new Mazo instance and pop all 52 cards. Verify that the Mazo is empty.
    @Test
    public void test_sacarTodasLasCartas() {
        Mazo mazo = new Mazo();
        for (int i = 0; i < 52; i++) {
            mazo.sacarCarta(true);
        }
        assertTrue(mazo.isEmpty());
    }

    // Create a new Mazo instance and pop 51 cards. Verify that the Mazo has one card left.
    @Test
    public void test_pop51Cards() {
        Mazo mazo = new Mazo();
        for (int i = 0; i < 51; i++) {
            mazo.sacarCarta(true);
        }
        assertEquals(1, mazo.size());
    }
}