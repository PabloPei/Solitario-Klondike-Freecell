package modeloelementos;

import junit.framework.TestCase;
import org.junit.Test;

public class ValorCartaTest extends TestCase {

    @Test
    public void test_obtener_valor() {
        assertEquals(1, ValorCarta.AS.getValor());
        assertEquals(4, ValorCarta.CUATRO.getValor());
        assertEquals(8, ValorCarta.OCHO.getValor());
        assertEquals(9, ValorCarta.NUEVE.getValor());
        assertEquals(13, ValorCarta.REY.getValor());
    }

    @Test
    public void test_a_cadena() {
        assertEquals("AS", ValorCarta.AS.toString());
        assertEquals("CUATRO", ValorCarta.CUATRO.toString());
        assertEquals("OCHO", ValorCarta.OCHO.toString());
        assertEquals("NUEVE", ValorCarta.NUEVE.toString());
        assertEquals("REY", ValorCarta.REY.toString());
    }

    @Test
    public void test_siguiente_valor_devuelve_siguiente_valor_correcto_excepto_para_rey() {
        assertEquals(ValorCarta.DOS, ValorCarta.AS.siguienteValor());
        assertEquals(ValorCarta.SEIS, ValorCarta.CINCO.siguienteValor());
        assertEquals(ValorCarta.SIETE, ValorCarta.SEIS.siguienteValor());
        assertEquals(ValorCarta.SOTA, ValorCarta.DIEZ.siguienteValor());
        assertEquals(ValorCarta.REINA, ValorCarta.SOTA.siguienteValor());
    }


    @Test
    public void test_siguiente_valor_devuelve_nulo_para_rey() {
        assertNull(ValorCarta.REY.siguienteValor());
    }

    @Test
    public void test_equals_devuelve_true_para_la_misma_carta() {
        assertTrue(ValorCarta.AS.equals(ValorCarta.AS));
        assertTrue(ValorCarta.DOS.equals(ValorCarta.DOS));
        assertTrue(ValorCarta.TRES.equals(ValorCarta.TRES));
        assertTrue(ValorCarta.REY.equals(ValorCarta.REY));
    }

    @Test
    public void test_AS_tiene_valor_de_1() {
        assertEquals(1, ValorCarta.AS.getValor());
    }
}
