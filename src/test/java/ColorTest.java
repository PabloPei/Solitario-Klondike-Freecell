import org.junit.Test;
import static org.junit.Assert.*;
import generalelementos.Color;


public class ColorTest {


    // Color.ROJO.toString() returns "ROJO"
    @Test
    public void test_rojo_toString() {
        assertEquals("ROJO", Color.ROJO.toString());
    }

    // Color.NEGRO.toString() returns "NEGRO"
    @Test
    public void test_negro_toString() {
        assertEquals("NEGRO", Color.NEGRO.toString());
    }


    // Color.valueOf("ROJO") returns Color.ROJO
    @Test
    public void test_valueOf_rojo() {
        assertEquals(Color.ROJO, Color.valueOf("ROJO"));
    }

    // Color.valueOf("NEGRO") returns Color.NEGRO
    @Test
    public void test_valueOf_NEGRO_returns_NEGRO() {
        assertEquals(Color.NEGRO, Color.valueOf("NEGRO"));
    }

    // Color.values() returns an array containing Color.ROJO and Color.NEGRO
    @Test
    public void test_values_returns_array_with_ROJO_and_NEGRO() {
        Color[] expected = {Color.ROJO, Color.NEGRO};
        assertArrayEquals(expected, Color.values());
    }

}