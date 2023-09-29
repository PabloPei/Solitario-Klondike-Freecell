package modelosolitario;

import org.junit.Test;
import static org.junit.Assert.*;
import modeloelementos.*;
import modelosolitario.*;

import java.util.EmptyStackException;


public class MazoTest {

    // Create a new Mazo instance and verify that it has 52 cards and they are all face down.
    @Test
    public void test_newMazoInstance() {
        Mazo mazo = new Mazo();
        assertEquals(52, mazo.size());
        for (Carta carta : mazo) {
            assertTrue(carta.getBocaAbajo());
        }
    }

    // Call the mezclar() method and verify that the order of the cards has changed.
    @Test
    public void test_mezclarMethod() {
        Mazo mazo = new Mazo();
        Mazo originalMazo = new Mazo();
        mazo.mezclar();
        assertNotEquals(originalMazo, mazo);
    }

    // Call the mezclar(long semilla) method with a specific seed and verify that the order of the cards is the same every time.
    @Test
    public void test_mezclarMethodWithSeed() {
        long seed = 12345;
        Mazo mazo1 = new Mazo();
        Mazo mazo2 = new Mazo();
        mazo1.mezclar(seed);
        mazo2.mezclar(seed);
        assertEquals(mazo1, mazo2);
    }

    // Create a new Mazo instance and pop all 52 cards. Verify that the Mazo is empty.
    @Test
    public void test_popAllCards() {
        Mazo mazo = new Mazo();
        for (int i = 0; i < 52; i++) {
            mazo.remove(mazo.size()-1);
        }
        assertTrue(mazo.isEmpty());
    }

    // Create a new Mazo instance and pop 51 cards. Verify that the Mazo has one card left.
    @Test
    public void test_pop51Cards() {
        Mazo mazo = new Mazo();
        for (int i = 0; i < 51; i++) {
            mazo.remove(mazo.size()-1);
        }
        assertEquals(1, mazo.size());
    }

    // Create a new Mazo instance and pop 53 cards. Verify that an exception is thrown.
//    @Test(expected = EmptyStackException.class)
//    public void test_pop53Cards() {
//        Mazo mazo = new Mazo();
//        for (int i = 0; i <53; i++) {
//            mazo.remove(mazo.size()-1);
//        }
//    }
}