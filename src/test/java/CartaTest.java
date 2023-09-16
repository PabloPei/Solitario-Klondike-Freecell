import junit.framework.TestCase;
import org.junit.Test;

public class CartaTest extends TestCase {

    @Test
    public void testCartasIguales(){
        Carta carta1 = new Carta(10, Palo.PICA);
        Carta carta2 = new Carta(10, Palo.PICA);
        assertTrue(carta1.equals(carta2));
    }
    @Test
    public void testCartasDistintas(){
        Carta carta1 = new Carta(2,Palo.TREBOL);
        Carta carta2 = new Carta(2,Palo.CORAZON);
        assertNotSame(carta2, carta1);
    }

    @Test
    public void testMostrarCarta() {
        Carta carta1 = new Carta(12,Palo.PICA);
        String resultadoEsperado = "Q de PICA (NEGRO)";
        assertEquals(resultadoEsperado, carta1.mostrarCarta());
    }
}