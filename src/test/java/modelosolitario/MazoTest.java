package modelosolitario;

import org.junit.Test;
import static org.junit.Assert.*;
import modeloelementos.*;

import java.io.*;


public class MazoTest {

    @Test
    public void testNuevaInstanciadeMazo() {
        Mazo mazo = new Mazo();
        assertEquals(52, mazo.size());
        for (Carta carta : mazo) {
            assertTrue(carta.getBocaAbajo());
        }
    }

    @Test
    public void testNuevaInstanciadeMazoParticular() {
        PilaDeCartas pila = new PilaDeCartas();
        Carta carta1 = new Carta(ValorCarta.AS, Palo.CORAZON, true);
        Carta carta2 = new Carta(ValorCarta.DOS, Palo.CORAZON, true);
        pila.agregarCarta(carta1);
        pila.agregarCarta(carta2);
        Mazo mazo = new Mazo(pila);
        assertNotNull(mazo);
    }

    @Test
    public void testAgregarCarta() {
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
    public void testAgregarCartaRepetida() {
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

    @Test
    public void testMezclar() {
        Mazo mazo = new Mazo();
        Mazo originalMazo = new Mazo();
        mazo.mezclar();
        assertNotEquals(originalMazo, mazo);
    }

    @Test
    public void testMezclarSemilla() {
        long seed = 12345;
        Mazo mazo1 = new Mazo();
        Mazo mazo2 = new Mazo();
        mazo1.mezclar(seed);
        mazo2.mezclar(seed);
        assertEquals(mazo1, mazo2);
    }

    @Test
    public void testSacarTodasLasCartas() {
        Mazo mazo = new Mazo();
        for (int i = 0; i < 52; i++) {
            mazo.sacarCarta(true);
        }
        assertTrue(mazo.isEmpty());
    }

    @Test
    public void testSacar51Cartas() {
        Mazo mazo = new Mazo();
        for (int i = 0; i < 51; i++) {
            mazo.sacarCarta(true);
        }
        assertEquals(1, mazo.size());
    }

    @Test
    public void testPersistencia() throws IOException, ClassNotFoundException {
        PilaDeCartas p = new PilaDeCartas();
        p.push(new Carta(ValorCarta.AS, Palo.TREBOL, false));
        p.push(new Carta(ValorCarta.REINA, Palo.CORAZON, true));
        Mazo m = new Mazo(p);

        OutputStream os = new FileOutputStream("test.txt");
        m.serializar(os);

        InputStream is = new FileInputStream("test.txt");
        Mazo deserializado = Mazo.deSerializar(is);

        assertNotNull(deserializado);
        assertEquals(m, deserializado);
    }
}