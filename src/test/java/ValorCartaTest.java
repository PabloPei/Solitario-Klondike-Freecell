import GeneralElementos.ValorCarta;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

public class ValorCartaTest extends TestCase {

    @Test
    public void test_getValor() {
        assertEquals(1, ValorCarta.AS.getValor());
        assertEquals(4, ValorCarta.CUATRO.getValor());
        assertEquals(8, ValorCarta.OCHO.getValor());
        assertEquals(9, ValorCarta.NUEVE.getValor());
        assertEquals(13, ValorCarta.REY.getValor());
    }

    @Test
    public void test_toString() {
        assertEquals("AS", ValorCarta.AS.toString());
        assertEquals("CUATRO", ValorCarta.CUATRO.toString());
        assertEquals("OCHO", ValorCarta.OCHO.toString());
        assertEquals("NUEVE", ValorCarta.NUEVE.toString());
        assertEquals("REY", ValorCarta.REY.toString());
    }

    @Test
    public void test_equals_returns_true_for_same_card() {
        assertTrue(ValorCarta.AS.equals(ValorCarta.AS));
        assertTrue(ValorCarta.DOS.equals(ValorCarta.DOS));
        assertTrue(ValorCarta.TRES.equals(ValorCarta.TRES));
        assertTrue(ValorCarta.REY.equals(ValorCarta.REY));
    }

    @Test
    public void test_AS_has_value_of_1() {
        assertEquals(1, ValorCarta.AS.getValor());
    }
}
