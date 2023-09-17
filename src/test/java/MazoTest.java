import junit.framework.TestCase;
import org.junit.Test;

public class MazoTest extends TestCase {
    @Test
    public void testCantidadCartas(){
        int cantidadEsperada = 52;
        int cantidadActual = new Mazo().size();
        assertEquals(cantidadActual, cantidadEsperada);
    }

    @Test
    public void testMezclar(){
        Mazo mazoSinMezclar = new Mazo();
        Mazo mazoMezclado = new Mazo();
        mazoMezclado.mezclar();
        assertFalse(mazoMezclado.equals(mazoSinMezclar));
    }

}