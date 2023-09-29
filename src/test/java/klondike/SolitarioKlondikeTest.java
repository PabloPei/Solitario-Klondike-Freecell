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
    public void testVerificarVictoria() {
        var pilas = new ArrayList<Pila>();
        for(int i = 0; i < 7; i++){
            pilas.add(new Pila());
        }
        var cimientos = new ArrayList<Cimiento>();
        for(Palo p : Palo.values()){
            cimientos.add(new Cimiento(13, p));
        }
        Mazo mazo = new Mazo();
        while(!mazo.isEmpty()){
            mazo.remove(mazo.size()-1);
        }
        var tablero = new TableroKlondike(Dificultad.FACIL, mazo, cimientos, pilas);
        var solitario = new SolitarioKlondike(Dificultad.FACIL, tablero);
        assertEquals(EstadoJuego.GANADO, solitario.verificarEstado());
    }

    @Test
    public void testEstadoDeJuegoInicial(){
        var solitario = new SolitarioKlondike(Dificultad.FACIL);
        assertEquals(EstadoJuego.JUGANDO, solitario.verificarEstado());
    }
}