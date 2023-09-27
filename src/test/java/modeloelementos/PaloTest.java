package modeloelementos;

import static org.junit.Assert.*;
import org.junit.Test;

public class PaloTest {

    // Verificar que toString() devuelve la representación de cadena correcta de cada valor enum.
    @Test
    public void test_toString_devuelveRepresentacionCadenaCorrecta() {
        assertEquals("DIAMANTE", Palo.DIAMANTE.toString());
        assertEquals("CORAZON", Palo.CORAZON.toString());
        assertEquals("TREBOL", Palo.TREBOL.toString());
        assertEquals("PICA", Palo.PICA.toString());
    }

    // Verificar que equals() devuelve true al comparar dos valores enum iguales.
    @Test
    public void test_equals_devuelveTrueParaValoresEnumIguales() {
        assertTrue(Palo.DIAMANTE == Palo.DIAMANTE);
        assertTrue(Palo.CORAZON == Palo.CORAZON);
        assertTrue(Palo.TREBOL == Palo.TREBOL);
        assertTrue(Palo.PICA == Palo.PICA);
    }

    // Verificar que el método ordinal() devuelve el valor entero correcto para cada valor enum.
    @Test
    public void test_ordinal_devuelveValorEnteroCorrecto() {
        assertEquals(0, Palo.DIAMANTE.ordinal());
        assertEquals(1, Palo.CORAZON.ordinal());
        assertEquals(2, Palo.TREBOL.ordinal());
        assertEquals(3, Palo.PICA.ordinal());
    }

    // Verificar que equals() devuelve false al comparar dos valores enum diferentes.
    @Test
    public void test_equals_devuelveFalseParaValoresEnumDiferentes() {
        assertFalse(Palo.DIAMANTE == Palo.CORAZON);
        assertFalse(Palo.CORAZON == Palo.TREBOL);
        assertFalse(Palo.TREBOL == Palo.PICA);
        assertFalse(Palo.PICA == Palo.DIAMANTE);
    }

    // Verificar que el método ordinal() devuelve un valor entero único para cada valor enum.
    @Test
    public void test_ordinal_devuelveValorEnteroUnico() {
        assertNotEquals(Palo.DIAMANTE.ordinal(), Palo.CORAZON.ordinal());
        assertNotEquals(Palo.CORAZON.ordinal(), Palo.TREBOL.ordinal());
        assertNotEquals(Palo.TREBOL.ordinal(), Palo.PICA.ordinal());
        assertNotEquals(Palo.PICA.ordinal(), Palo.DIAMANTE.ordinal());
    }

    // Verificar que el método values() devuelve un array de todos los valores enum en el orden correcto.
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
