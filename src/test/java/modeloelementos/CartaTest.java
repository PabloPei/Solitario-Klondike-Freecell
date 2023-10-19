package modeloelementos;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class CartaTest {

    @Test
    public void test_creacion_de_carta_con_parametros_validos() {
        ValorCarta valor = ValorCarta.AS;
        Palo palo = Palo.CORAZON;
        boolean bocaAbajo = false;

        Carta carta = new Carta(valor, palo, bocaAbajo);

        assertEquals(valor, carta.getValor());
        assertEquals(palo, carta.getPalo());
        assertEquals(bocaAbajo, carta.getBocaAbajo());
    }

    @Test
    public void test_obtener_valor_de_carta() {
        ValorCarta valor = ValorCarta.DIEZ;
        Palo palo = Palo.TREBOL;
        boolean bocaAbajo = false;

        Carta carta = new Carta(valor, palo, bocaAbajo);

        assertEquals(valor, carta.getValor());
    }

    @Test
    public void test_obtener_palo_de_carta() {
        ValorCarta valor = ValorCarta.REINA;
        Palo palo = Palo.PICA;
        boolean bocaAbajo = false;

        Carta carta = new Carta(valor, palo, bocaAbajo);

        assertEquals(palo, carta.getPalo());
    }

    @Test
    public void test_creacion_de_carta_con_valor_o_palo_nulo() {
        ValorCarta valor = null;
        Palo palo = Palo.CORAZON;
        boolean bocaAbajo = false;

        Carta carta = new Carta(valor, palo, bocaAbajo);

        assertNull(carta.getValor());
    }

    @Test
    public void test_comparar_carta_con_nulo() {
        ValorCarta valor = ValorCarta.SOTA;
        Palo palo = Palo.TREBOL;
        boolean bocaAbajo = false;

        Carta carta = new Carta(valor, palo, bocaAbajo);

        assertNotEquals(null, carta);
    }

    @Test
    public void test_voltear_carta() {
        ValorCarta valor = ValorCarta.AS;
        Palo palo = Palo.CORAZON;
        boolean bocaAbajo = false;

        Carta carta = new Carta(valor, palo, bocaAbajo);
        carta.voltear();

        assertTrue(carta.getBocaAbajo());
    }

    @Test
    public void test_obtener_orientacion_de_carta() {
        ValorCarta valor = ValorCarta.AS;
        Palo palo = Palo.CORAZON;
        boolean bocaAbajo = false;

        Carta carta = new Carta(valor, palo, bocaAbajo);

        assertEquals(bocaAbajo, carta.getBocaAbajo());
    }

    @Test
    public void test_obtener_color_de_carta() {
        ValorCarta valor = ValorCarta.AS;
        Palo palo = Palo.CORAZON;
        boolean bocaAbajo = false;

        Carta carta = new Carta(valor, palo, bocaAbajo);

        assertEquals(Color.ROJO, carta.getColor());
    }

    @Test
    public void test_mismos_colores() {
        Carta carta1 = new Carta(ValorCarta.AS, Palo.CORAZON, false);
        Carta carta2 = new Carta(ValorCarta.AS, Palo.DIAMANTE, false);
        assertFalse(Carta.esColorAlternado(carta1, carta2));
    }

    @Test
    public void test_diferentes_colores() {
        Carta carta1 = new Carta(ValorCarta.AS, Palo.CORAZON, false);
        Carta carta2 = new Carta(ValorCarta.AS, Palo.TREBOL, false);
        assertTrue(Carta.esColorAlternado(carta1, carta2));
    }

    @Test
    public void test_comparar_cartas_para_igualdad() {
        ValorCarta valor1 = ValorCarta.AS;
        Palo palo1 = Palo.CORAZON;
        boolean bocaAbajo1 = false;

        ValorCarta valor2 = ValorCarta.AS;
        Palo palo2 = Palo.CORAZON;
        boolean bocaAbajo2 = true;

        Carta carta1 = new Carta(valor1, palo1, bocaAbajo1);
        Carta carta2 = new Carta(valor2, palo2, bocaAbajo2);

        assertEquals(carta1, carta2);
    }

    @Test
    public void test_comparar_cartas_con_valores_o_palos_diferentes() {
        ValorCarta valor1 = ValorCarta.AS;
        Palo palo1 = Palo.CORAZON;
        boolean bocaAbajo1 = false;

        ValorCarta valor2 = ValorCarta.DOS;
        Palo palo2 = Palo.TREBOL;
        boolean bocaAbajo2 = true;

        Carta carta1 = new Carta(valor1, palo1, bocaAbajo1);
        Carta carta2 = new Carta(valor2, palo2, bocaAbajo2);

        assertNotEquals(carta1, carta2);
    }

    @Test
    public void test_obtener_representacion_en_cadena_de_carta() {
        ValorCarta valor = ValorCarta.AS;
        Palo palo = Palo.CORAZON;
        boolean bocaAbajo = false;

        Carta carta = new Carta(valor, palo, bocaAbajo);

        String esperado = "AS - CORAZON";
        String actual = carta.toString();

        assertEquals(esperado, actual);
    }

    @Test
    public void test_orden_secuencial() {
        Carta carta1 = new Carta(ValorCarta.AS, Palo.CORAZON, false);
        Carta carta2 = new Carta(ValorCarta.DOS, Palo.CORAZON, false);
        assertTrue(Carta.esValorSiguiente(carta1, carta2));
    }

    @Test
    public void testPersistencia() throws IOException, ClassNotFoundException {
        Carta c = new Carta(ValorCarta.AS, Palo.TREBOL, false);
        c.serializar("PruebaCartas.txt");
        Carta deserializada = Carta.deSerializar("PruebaCartas.txt");
        assertNotNull(deserializada);
        assertEquals(c, deserializada);
    }
}
