package klondike;

import Klondike.Cimiento;
import modeloelementos.*;
import modelosolitario.Mazo;
import modelosolitario.Pila;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class SolitarioKlondikeTest {

    @Test
    public void testEstadoDeJuegoPerdido(){
        var cartasIniciales = new PilaDeCartas();
        cartasIniciales.push(new Carta(ValorCarta.CUATRO, Palo.TREBOL, true));
        cartasIniciales.push(new Carta(ValorCarta.SIETE, Palo.TREBOL, false));
        var cartasIniciales2 = new PilaDeCartas();
        cartasIniciales2.push(new Carta(ValorCarta.CINCO, Palo.TREBOL, true));
        cartasIniciales2.push(new Carta(ValorCarta.SEIS, Palo.TREBOL, true));
        cartasIniciales2.push(new Carta(ValorCarta.OCHO, Palo.TREBOL, true));
        cartasIniciales2.push(new Carta(ValorCarta.NUEVE, Palo.TREBOL, true));
        cartasIniciales2.push(new Carta(ValorCarta.DIEZ, Palo.TREBOL, true));
        cartasIniciales2.push(new Carta(ValorCarta.SOTA, Palo.TREBOL, true));
        cartasIniciales2.push(new Carta(ValorCarta.REINA, Palo.TREBOL, true));
        cartasIniciales2.push(new Carta(ValorCarta.REY, Palo.TREBOL, true));
        var pilas = new ArrayList<Pila>();
        pilas.add(new Pila(cartasIniciales));
        pilas.add(new Pila(cartasIniciales2));
        for(int i = 0; i < 5; i++){
            pilas.add(new Pila());
        }
        Mazo mazo = new Mazo();
        while (!mazo.isEmpty()){
            mazo.remove(mazo.size()-1);
        }
        var cimientos = new ArrayList<Cimiento>();
        cimientos.add(new Cimiento(13, Palo.CORAZON));
        cimientos.add(new Cimiento(13, Palo.PICA));
        cimientos.add(new Cimiento(13, Palo.DIAMANTE));
        cimientos.add(new Cimiento(3, Palo.TREBOL));
        var tablero = new TableroKlondike(Dificultad.FACIL, mazo, cimientos, pilas);
        var solitario = new SolitarioKlondike(Dificultad.FACIL, tablero);
        assertEquals(EstadoJuego.PERDIDO, solitario.verificarEstado());
    }

}