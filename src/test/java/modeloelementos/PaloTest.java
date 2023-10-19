package modeloelementos;

import static org.junit.Assert.*;
import org.junit.Test;

public class PaloTest {

    @Test
    public void test_toString_devuelveRepresentacionCadenaCorrecta() {
        assertEquals("DIAMANTE", Palo.DIAMANTE.toString());
        assertEquals("CORAZON", Palo.CORAZON.toString());
        assertEquals("TREBOL", Palo.TREBOL.toString());
        assertEquals("PICA", Palo.PICA.toString());
    }

    @Test
    public void test_ordinal_devuelveValorEnteroCorrecto() {
        assertEquals(0, Palo.DIAMANTE.ordinal());
        assertEquals(1, Palo.CORAZON.ordinal());
        assertEquals(2, Palo.TREBOL.ordinal());
        assertEquals(3, Palo.PICA.ordinal());
    }

    @Test
    public void test_equals_devuelveFalseParaValoresEnumDiferentes() {
        assertNotSame(Palo.DIAMANTE, Palo.CORAZON);
        assertNotSame(Palo.CORAZON, Palo.TREBOL);
        assertNotSame(Palo.TREBOL, Palo.PICA);
        assertNotSame(Palo.PICA, Palo.DIAMANTE);
    }

    @Test
    public void test_ordinal_devuelveValorEnteroUnico() {
        assertNotEquals(Palo.DIAMANTE.ordinal(), Palo.CORAZON.ordinal());
        assertNotEquals(Palo.CORAZON.ordinal(), Palo.TREBOL.ordinal());
        assertNotEquals(Palo.TREBOL.ordinal(), Palo.PICA.ordinal());
        assertNotEquals(Palo.PICA.ordinal(), Palo.DIAMANTE.ordinal());
    }

    @Test
    public void test_values_devuelveArrayConOrdenCorrecto() {
        Palo[] expectedValues = {Palo.DIAMANTE, Palo.CORAZON, Palo.TREBOL, Palo.PICA};
        assertArrayEquals(expectedValues, Palo.values());
    }

    @Test
    public void test_valuesLength_devuelve4() {
        assertEquals(4, Palo.values().length);
    }

    @Test
    public void test_valueOf_lanzaIllegalArgumentExceptionParaEntradasDeCadenaInvalidas() {
        assertThrows(IllegalArgumentException.class, () -> Palo.valueOf("INVALIDO"));
    }
}
