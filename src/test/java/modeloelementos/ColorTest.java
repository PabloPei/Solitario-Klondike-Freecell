package modeloelementos;

import org.junit.Test;
import static org.junit.Assert.*;

public class ColorTest {

    @Test
    public void test_toString_retornaNombreDelColor() {
        assertEquals("ROJO", Color.ROJO.toString());
        assertEquals("NEGRO", Color.NEGRO.toString());
    }

    @Test
    public void test_valoresColorValidos() {
        assertNotNull(Color.ROJO);
        assertNotNull(Color.NEGRO);
    }

    @Test
    public void test_toString_noEsNulo() {
        assertNotNull(Color.ROJO.toString());
        assertNotNull(Color.NEGRO.toString());
    }

    @Test
    public void test_valoresEnumNoSonIguales() {
        assertNotEquals(Color.ROJO, Color.NEGRO);
    }

    @Test
    public void test_enumTieneDosValores() {
        assertEquals(2, Color.values().length);
    }

    @Test
    public void test_valores_retorna_array_con_ROJO_y_NEGRO() {
        Color[] expected = {Color.ROJO, Color.NEGRO};
        assertArrayEquals(expected, Color.values());
    }

    @Test
    public void test_valoresEnumNoSonNulos() {
        for (Color color : Color.values()) {
            assertNotNull(color);
        }
    }
}
