import modeloelementos.Carta;
import modeloelementos.Palo;
import modeloelementos.ValorCarta;
import modeloelementos.Color;
import junit.framework.TestCase;
import org.junit.Test;

public class CartaTest extends TestCase {

    @Test
    public void test_create_card_with_valid_value_suit_and_orientation() {
        ValorCarta valor = ValorCarta.AS;
        Palo palo = Palo.CORAZON;
        boolean bocaAbajo = false;

        Carta carta = new Carta(valor, palo, bocaAbajo);

        assertEquals(valor, carta.getValor());
        assertEquals(palo, carta.getPalo());
        assertEquals(bocaAbajo, carta.getBocaAbajo());
    }

    @Test
    public void test_get_card_value() {
        ValorCarta valor = ValorCarta.DIEZ;
        Palo palo = Palo.TREBOL;
        boolean bocaAbajo = false;

        Carta carta = new Carta(valor, palo, bocaAbajo);

        assertEquals(valor, carta.getValor());
    }

    @Test
    public void test_get_card_suit() {
        ValorCarta valor = ValorCarta.REINA;
        Palo palo = Palo.PICA;
        boolean bocaAbajo = false;

        Carta carta = new Carta(valor, palo, bocaAbajo);

        assertEquals(palo, carta.getPalo());
    }

    @Test
    public void test_create_card_with_null_value_or_suit() {
        ValorCarta valor = null;
        Palo palo = Palo.CORAZON;
        boolean bocaAbajo = false;

        Carta carta = new Carta(valor, palo, bocaAbajo);

        assertNull(carta.getValor());
    }

    @Test
    public void test_compare_card_to_null() {
        ValorCarta valor = ValorCarta.SOTA;
        Palo palo = Palo.TREBOL;
        boolean bocaAbajo = false;

        Carta carta = new Carta(valor, palo, bocaAbajo);

        assertFalse(carta.equals(null));
    }

    @Test
    public void test_flip_card_over() {
        ValorCarta valor = ValorCarta.AS;
        Palo palo = Palo.CORAZON;
        boolean bocaAbajo = false;

        Carta carta = new Carta(valor, palo, bocaAbajo);
        carta.voltear();

        assertTrue(carta.getBocaAbajo());
    }

    @Test
    public void test_get_card_orientation() {
        ValorCarta valor = ValorCarta.AS;
        Palo palo = Palo.CORAZON;
        boolean bocaAbajo = false;

        Carta carta = new Carta(valor, palo, bocaAbajo);

        assertEquals(bocaAbajo, carta.getBocaAbajo());
    }

    @Test
    public void test_get_card_color() {
        ValorCarta valor = ValorCarta.AS;
        Palo palo = Palo.CORAZON;
        boolean bocaAbajo = false;

        Carta carta = new Carta(valor, palo, bocaAbajo);

        assertEquals(Color.ROJO, carta.getColor());
    }

    @Test
    public void test_compare_cards_for_equality() {
        ValorCarta valor1 = ValorCarta.AS;
        Palo palo1 = Palo.CORAZON;
        boolean bocaAbajo1 = false;

        ValorCarta valor2 = ValorCarta.AS;
        Palo palo2 = Palo.CORAZON;
        boolean bocaAbajo2 = true;

        Carta carta1 = new Carta(valor1, palo1, bocaAbajo1);
        Carta carta2 = new Carta(valor2, palo2, bocaAbajo2);

        assertTrue(carta1.equals(carta2));
    }

    @Test
    public void test_compare_cards_with_different_values_or_suits() {
        ValorCarta valor1 = ValorCarta.AS;
        Palo palo1 = Palo.CORAZON;
        boolean bocaAbajo1 = false;

        ValorCarta valor2 = ValorCarta.DOS;
        Palo palo2 = Palo.TREBOL;
        boolean bocaAbajo2 = true;

        Carta carta1 = new Carta(valor1, palo1, bocaAbajo1);
        Carta carta2 = new Carta(valor2, palo2, bocaAbajo2);

        assertFalse(carta1.equals(carta2));
    }

    @Test
    public void test_get_string_representation_of_card() {
        ValorCarta valor = ValorCarta.AS;
        Palo palo = Palo.CORAZON;
        boolean bocaAbajo = false;

        Carta carta = new Carta(valor, palo, bocaAbajo);

        String expected = "AS - CORAZON";
        String actual = carta.toString();

        assertEquals(expected, actual);
    }

}