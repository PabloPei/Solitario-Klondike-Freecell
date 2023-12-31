package modelosolitario;

import modeloelementos.Carta;
import modeloelementos.Palo;
import modeloelementos.ValorCarta;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;

public class CimientoTest {
    @Test
    public void testPuedeAgregarCartaCimientoVacio() {
        Cimiento c = new Cimiento();
        assertTrue(c.puedeAgregarCarta(new Carta(ValorCarta.AS, Palo.TREBOL, false)));
    }

    @Test
    public void testPuedeAgregarCartaCimientoNoVacio(){
        Cimiento c = new Cimiento(4, Palo.TREBOL);
        assertTrue(c.puedeAgregarCarta(new Carta(ValorCarta.CINCO, Palo.TREBOL, false)));
    }

    @Test
    public void testNoSePuedenAgregarCartasPorCimientoCompleto(){
        Cimiento c = new Cimiento(13, Palo.TREBOL);
        assertFalse(c.puedeAgregarCarta(new Carta(ValorCarta.AS, Palo.TREBOL, false)));
    }

    @Test
    public void testNoSePuedenAgregarCartasPorPaloIncorrecto(){
        Cimiento c = new Cimiento(1, Palo.TREBOL);
        assertFalse(c.puedeAgregarCarta(new Carta(ValorCarta.DOS, Palo.CORAZON, false)));
    }

    @Test
    public void testNoSePuedenAgregarCartasPorValorIncorrecto(){
        Cimiento c = new Cimiento(1, Palo.TREBOL);
        assertFalse(c.puedeAgregarCarta(new Carta(ValorCarta.TRES, Palo.TREBOL, false)));
    }

    @Test
    public void testCimientoCompleto(){
        Cimiento c = new Cimiento(13, Palo.TREBOL);
        assertTrue(c.cimientoCompleto());
    }

    @Test
    public void testPersistencia() throws IOException, ClassNotFoundException {
        Cimiento c = new Cimiento();
        c.push(new Carta(ValorCarta.AS, Palo.TREBOL, false));
        c.push(new Carta(ValorCarta.DOS , Palo.TREBOL, false));

        FileOutputStream os = new FileOutputStream("test.txt");
        c.serializar(os);
        FileInputStream is = new FileInputStream("test.txt");
        Cimiento deserializado = Cimiento.deSerializar(is);

        assertNotNull(deserializado);
        assertEquals(c, deserializado);
    }
}