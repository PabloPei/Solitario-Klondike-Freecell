package modelosolitario;

import modeloelementos.Carta;
import modeloelementos.Palo;
import modeloelementos.PilaDeCartas;
import modeloelementos.ValorCarta;
import org.junit.Test;

import static org.junit.Assert.*;

public class PilaTest {
    @Test
    public void testPuedeAgregarCartaPilaVaciaFunciona() {
        Pila pila = new Pila();
        Carta carta = new Carta(ValorCarta.REY, Palo.TREBOL, false);
        assertTrue(pila.puedeAgregarCarta(carta));
    }

    @Test
    public void testPuedeAgregarCartaPilaVaciaFalla(){
        Pila pila = new Pila();
        Carta carta = new Carta(ValorCarta.REINA, Palo.TREBOL, false);
        assertFalse(pila.puedeAgregarCarta(carta));
    }

    @Test
    public void testPuedeAgregarCartaPilaNoVaciaFunciona(){
        var cartasIniciales = new PilaDeCartas();
        cartasIniciales.push(new Carta(ValorCarta.REY, Palo.TREBOL, false));
        var pila = new Pila(cartasIniciales);
        Carta carta = new Carta(ValorCarta.REINA, Palo.CORAZON, false);
        assertTrue(pila.puedeAgregarCarta(carta));
    }

    @Test
    public void testPuedeAgregarCartaPilaNoVaciaFallaPorColor(){
        var cartasIniciales = new PilaDeCartas();
        cartasIniciales.push(new Carta(ValorCarta.REY, Palo.TREBOL, false));
        var pila = new Pila(cartasIniciales);
        assertFalse(pila.puedeAgregarCarta(new Carta(ValorCarta.REINA, Palo.PICA, false)));
    }

    @Test
    public void testPuedeAgregarCartaPilaNoVaciaFallaPorValor(){
        var cartasIniciales = new PilaDeCartas();
        cartasIniciales.push(new Carta(ValorCarta.REY, Palo.TREBOL, false));
        var pila = new Pila(cartasIniciales);
        assertFalse(pila.puedeAgregarCarta(new Carta(ValorCarta.NUEVE, Palo.CORAZON, false)));
    }

    @Test
    public void testRetirarUnaCarta() {
        var cartasIniciales = new PilaDeCartas();
        cartasIniciales.push(new Carta(ValorCarta.REY, Palo.TREBOL, false));
        cartasIniciales.push(new Carta(ValorCarta.REINA, Palo.CORAZON, false));
        cartasIniciales.push(new Carta(ValorCarta.SOTA, Palo.PICA, false));
        cartasIniciales.push(new Carta(ValorCarta.DIEZ, Palo.CORAZON, false));
        cartasIniciales.push(new Carta(ValorCarta.NUEVE, Palo.TREBOL, false));
        cartasIniciales.push(new Carta(ValorCarta.OCHO, Palo.DIAMANTE, false));
        cartasIniciales.push(new Carta(ValorCarta.SIETE, Palo.PICA, false));
        var pilaOriginal = new Pila(cartasIniciales);
        int cantidadDeCartasASacar = 1;
        var nuevaPila = pilaOriginal.sacarCarta(false);
        var resultadoEsperado = new Pila();
        resultadoEsperado.push(cartasIniciales.peek());
        assertEquals(resultadoEsperado, nuevaPila);
    }

    @Test
    public void testRetirarMasDeUnaCarta(){
        var cartasIniciales = new PilaDeCartas();
        cartasIniciales.push(new Carta(ValorCarta.REY, Palo.TREBOL, false));
        cartasIniciales.push(new Carta(ValorCarta.REINA, Palo.CORAZON, false));
        cartasIniciales.push(new Carta(ValorCarta.SOTA, Palo.PICA, false));
        cartasIniciales.push(new Carta(ValorCarta.DIEZ, Palo.CORAZON, false));
        cartasIniciales.push(new Carta(ValorCarta.NUEVE, Palo.TREBOL, false));
        cartasIniciales.push(new Carta(ValorCarta.OCHO, Palo.DIAMANTE, false));
        cartasIniciales.push(new Carta(ValorCarta.SIETE, Palo.PICA, false));
        var pilaOriginal = new Pila(cartasIniciales);
        int cantidadDeCartasASacar = 4;
        var nuevaPila = new Pila();
        for(int i = 0; i < cantidadDeCartasASacar; i++){
            nuevaPila.push(pilaOriginal.sacarCarta(false));
        }
        var resultadoEsperado = new Pila();
        for(int i = 0; i < cantidadDeCartasASacar; i++) {
            resultadoEsperado.push(cartasIniciales.pop());
        }
        assertEquals(resultadoEsperado, nuevaPila);
    }

    @Test
    public void testRetirarCartasTotalesEnPila(){
        var cartasIniciales = new PilaDeCartas();
        cartasIniciales.push(new Carta(ValorCarta.REY, Palo.TREBOL, false));
        cartasIniciales.push(new Carta(ValorCarta.REINA, Palo.CORAZON, false));
        cartasIniciales.push(new Carta(ValorCarta.SOTA, Palo.PICA, false));
        cartasIniciales.push(new Carta(ValorCarta.DIEZ, Palo.CORAZON, false));
        cartasIniciales.push(new Carta(ValorCarta.NUEVE, Palo.TREBOL, false));
        cartasIniciales.push(new Carta(ValorCarta.OCHO, Palo.DIAMANTE, false));
        cartasIniciales.push(new Carta(ValorCarta.SIETE, Palo.PICA, false));
        var pilaOriginal = new Pila(cartasIniciales);
        int cantidadDeCartasASacar = pilaOriginal.size();var nuevaPila = new Pila();
        for(int i = 0; i < cantidadDeCartasASacar; i++){
            nuevaPila.push(pilaOriginal.sacarCarta(false));
        }
        var resultadoEsperado = new Pila();
        for(int i = 0; i < cantidadDeCartasASacar; i++){
            resultadoEsperado.push(cartasIniciales.pop());
        }
        assertEquals(resultadoEsperado, nuevaPila);
    }


}