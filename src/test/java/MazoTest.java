import GeneralElementos.Mazo;
import junit.framework.TestCase;
import org.junit.Test;

public class MazoTest extends TestCase {
    @Test
    public void testCantidadCartas(){
        int cantidadEsperada = 52;
        int cantidadActual = new Mazo().tamanio();
        assertEquals(cantidadActual, cantidadEsperada);
    }

    @Test
    public void testMezclar(){
        Mazo mazoSinMezclar = new Mazo();
        Mazo mazoMezclado = new Mazo();
        mazoMezclado.mezclar();
        assertNotSame(mazoSinMezclar, mazoMezclado);
    }

}