import junit.framework.TestCase;
import org.junit.Test;

public class MazoTest extends TestCase {
    @Test
    public void testCantidadCartas(){
        int cantidadEsperada = 52;
        int cantidadActual = new Mazo().obtenerTamanio();
        assertEquals(cantidadActual, cantidadEsperada);
    }

    @Test
    public void testMezclar(){
        Mazo mazoSinMezclar = new Mazo();
        Mazo mazoMezclado = new Mazo();
        mazoMezclado.mezclar();
        assertFalse(mazoMezclado.equals(mazoSinMezclar));
    }

    @Test
    public void testMazoCompleto() {
        Mazo mazo = new Mazo();
        String resultadoEsperado = mazo.repartirMazoCompleto();
        String resultadoActual = "";
        Carta cartaActual;
        for (int i = 0; i < 52; i++){
            switch (i%4){
                case 0 -> cartaActual = new Carta((i+1)%13, Palo.DIAMANTE, false);
                case 1 -> cartaActual = new Carta((i+1)%13, Palo.CORAZON, false);
                case 2 -> cartaActual = new Carta((i+1)%13, Palo.TREBOL, false);
                default -> cartaActual = new Carta((i+1)%13, Palo.PICA, false );
            }
            resultadoActual = resultadoActual + cartaActual.mostrarCarta() + "\n";
        }
        assertEquals(resultadoEsperado, resultadoActual);
    }
}