package modeloelementos;

import org.junit.Test;
import static org.junit.Assert.*;

public class PilaDeCartasTest {

    @Test
    public void test_puede_agregar_carta_a_pila() {
        PilaDeCartas pila = new PilaDeCartas();
        Carta carta = new Carta(ValorCarta.AS, Palo.CORAZON, true);
        assertTrue(pila.agregarCarta(carta));
    }

    @Test
    public void test_agregar_carta_a_pila_vacia() {
        var pila = new PilaDeCartas();
        Carta carta = new Carta(ValorCarta.REY, Palo.TREBOL, false);
        pila.agregarCarta(carta);
        assertEquals(pila.peek(), carta);
    }

    @Test
    public void test_agregar_carta_existente_a_pila() {
        var pila = new PilaDeCartas();
        pila.push(new Carta(ValorCarta.REY, Palo.TREBOL, false));
        assertFalse(pila.agregarCarta(new Carta(ValorCarta.REY, Palo.TREBOL, false)));
    }

    @Test
    public void test_ver_carta_en_pila_vacia() {
        var pila = new PilaDeCartas();
        assertEquals(null, pila.verCarta());
    }

    @Test
    public void test_ver_carta() {
        var pila = new PilaDeCartas();
        pila.push(new Carta(ValorCarta.REY, Palo.TREBOL, false));
        Carta carta = new Carta(ValorCarta.DOS, Palo.CORAZON, false);
        pila.push(carta);
        assertEquals(carta, pila.verCarta());
    }

    @Test
    public void test_no_puede_quitar_carta_de_pila_vacia() {
        PilaDeCartas pila = new PilaDeCartas();
        assertNull(pila.sacarCarta(true));
    }

    @Test
    public void test_no_puede_agregar_carta_existente_a_pila() {
        PilaDeCartas pila = new PilaDeCartas();
        Carta carta = new Carta(ValorCarta.AS, Palo.CORAZON, true);
        pila.agregarCarta(carta);
        assertFalse(pila.agregarCarta(carta));
    }

    @Test
    public void test_equals() {
        var pila = new PilaDeCartas();
        var pila2 = new PilaDeCartas();
        Carta carta1 = new Carta(ValorCarta.REY, Palo.TREBOL, false);
        Carta carta2 = new Carta(ValorCarta.SOTA, Palo.CORAZON, false);
        pila.push(carta1);
        pila.push(carta2);
        pila2.push(carta1);
        pila2.push(carta2);
        assertTrue(pila.equals(pila2));
    }
}
