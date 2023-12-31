package modeloelementos;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValorCartaTest {

    @Test
    public void testObtenerValor() {
        assertEquals(1, ValorCarta.AS.getValor());
        assertEquals(4, ValorCarta.CUATRO.getValor());
        assertEquals(8, ValorCarta.OCHO.getValor());
        assertEquals(9, ValorCarta.NUEVE.getValor());
        assertEquals(13, ValorCarta.REY.getValor());
    }

    @Test
    public void testACadena() {
        assertEquals("AS", ValorCarta.AS.toString());
        assertEquals("CUATRO", ValorCarta.CUATRO.toString());
        assertEquals("OCHO", ValorCarta.OCHO.toString());
        assertEquals("NUEVE", ValorCarta.NUEVE.toString());
        assertEquals("REY", ValorCarta.REY.toString());
    }

    @Test
    public void testSiguienteValorDevuelveSiguienteValorCorrectoExceptoParaRey() {
        assertEquals(ValorCarta.DOS, ValorCarta.AS.siguienteValor());
        assertEquals(ValorCarta.SEIS, ValorCarta.CINCO.siguienteValor());
        assertEquals(ValorCarta.SIETE, ValorCarta.SEIS.siguienteValor());
        assertEquals(ValorCarta.SOTA, ValorCarta.DIEZ.siguienteValor());
        assertEquals(ValorCarta.REINA, ValorCarta.SOTA.siguienteValor());
    }

    @Test
    public void testSiguienteValorDevuelveNuloParaRey() {
        assertNull(ValorCarta.REY.siguienteValor());
    }

    @Test
    public void testAsTieneValorDe1() {
        assertEquals(1, ValorCarta.AS.getValor());
    }
}
