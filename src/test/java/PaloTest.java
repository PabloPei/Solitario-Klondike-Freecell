import modeloelementos.Palo;
import static org.junit.Assert.*;
import org.junit.Test;



public class PaloTest {


    // Verify that toString() returns the correct string representation of each enum value.
    @Test
    public void test_toString_returnsCorrectStringRepresentation() {
        assertEquals("DIAMANTE", Palo.DIAMANTE.toString());
        assertEquals("CORAZON", Palo.CORAZON.toString());
        assertEquals("TREBOL", Palo.TREBOL.toString());
        assertEquals("PICA", Palo.PICA.toString());
    }

    // Verify that equals() returns true when comparing two equal enum values.
    @Test
    public void test_equals_returnsTrueForEqualEnumValues() {
        assertTrue(Palo.DIAMANTE == Palo.DIAMANTE);
        assertTrue(Palo.CORAZON == Palo.CORAZON);
        assertTrue(Palo.TREBOL == Palo.TREBOL);
        assertTrue(Palo.PICA == Palo.PICA);
    }

    // Verify that the ordinal() method returns the correct integer value for each enum value.
    @Test
    public void test_ordinal_returnsCorrectIntegerValue() {
        assertEquals(0, Palo.DIAMANTE.ordinal());
        assertEquals(1, Palo.CORAZON.ordinal());
        assertEquals(2, Palo.TREBOL.ordinal());
        assertEquals(3, Palo.PICA.ordinal());
    }

    // Verify that equals() returns false when comparing two different enum values.
    @Test
    public void test_equals_returnsFalseForDifferentEnumValues() {
        assertFalse(Palo.DIAMANTE == Palo.CORAZON);
        assertFalse(Palo.CORAZON == Palo.TREBOL);
        assertFalse(Palo.TREBOL == Palo.PICA);
        assertFalse(Palo.PICA == Palo.DIAMANTE);
    }

    // Verify that the ordinal() method returns a unique integer value for each enum value.
    @Test
    public void test_ordinal_returnsUniqueIntegerValue() {
        assertNotEquals(Palo.DIAMANTE.ordinal(), Palo.CORAZON.ordinal());
        assertNotEquals(Palo.CORAZON.ordinal(), Palo.TREBOL.ordinal());
        assertNotEquals(Palo.TREBOL.ordinal(), Palo.PICA.ordinal());
        assertNotEquals(Palo.PICA.ordinal(), Palo.DIAMANTE.ordinal());
    }

    // Verify that the values() method returns an array of all enum values in the correct order.
    @Test
    public void test_values_returnsArrayWithCorrectOrder() {
        Palo[] expectedValues = {Palo.DIAMANTE, Palo.CORAZON, Palo.TREBOL, Palo.PICA};
        assertArrayEquals(expectedValues, Palo.values());
    }

}