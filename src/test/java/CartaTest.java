import GeneralElementos.Carta;
import GeneralElementos.Palo;
import GeneralSolitario.PilaDeCartas;
import Klondike.Cimiento;
import junit.framework.TestCase;
import org.junit.Test;

public class CartaTest extends TestCase {

    @Test
    public void testCartasIguales(){
        Carta carta1 = new Carta(10, Palo.PICA, false);
        Carta carta2 = new Carta(10, Palo.PICA, false);
        assertTrue(carta1.equals(carta2));
    }
    @Test
    public void testCartasDistintas(){
        Carta carta1 = new Carta(1, Palo.TREBOL, false);
        Carta carta2 = new Carta(5,Palo.CORAZON, false);
        assertNotSame(carta2, carta1);
    }

    @Test
    public void testValorValidoParaEntrarAPilaNormal() {
        Carta cartaNueva = new Carta(3, Palo.DIAMANTE, true);
        PilaDeCartas pila = new PilaDeCartas();
        pila.push(new Carta(4, Palo.TREBOL, false));
        boolean esperado = true;
        boolean resultado = cartaNueva.valorValidoParaEntrarAPila(pila.peek());
        assertEquals(esperado, resultado);
    }

    @Test
    public void testValorValidoParaEntrarACimiento() {
        Carta cartaNueva = new Carta(3, Palo.DIAMANTE, true);
        Cimiento cimiento = new Cimiento(Palo.DIAMANTE);
        cimiento.push(new Carta(2, Palo.DIAMANTE, false));
        boolean esperado = true;
        boolean resultado = cimiento.peek().valorValidoParaEntrarAPila(cartaNueva);
        assertEquals(esperado, resultado);
    }

    @Test
    public void noPuedeAgregarCartaAPila(){
        Carta cartaNueva = new Carta(10, Palo.CORAZON, true);
        PilaDeCartas pila = new PilaDeCartas();
        pila.push(new Carta(9, Palo.TREBOL, true));
        boolean esperado = false;
        boolean resultado = cartaNueva.valorValidoParaEntrarAPila(pila.peek());
        assertEquals(esperado, resultado);
    }

}