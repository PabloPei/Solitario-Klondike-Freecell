package freecell;

import modeloelementos.Carta;
import modeloelementos.Palo;
import modeloelementos.ValorCarta;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PilaSuperiorTest {
    @Test
    public void agregarCartaFalla() {
        PilaSuperior pilaSuperior = new PilaSuperior();
        pilaSuperior.push(new Carta(ValorCarta.OCHO, Palo.CORAZON, false));
        assertFalse(pilaSuperior.agregarCarta(new Carta(ValorCarta.OCHO, Palo.CORAZON, false)));
    }

    @Test
    public void agregarCartaNoFalla() {
        PilaSuperior pilaSuperior = new PilaSuperior();
        assertTrue(pilaSuperior.agregarCarta(new Carta(ValorCarta.OCHO, Palo.CORAZON, false)));
    }
}
