package modelosolitario;

import modeloelementos.Palo;
import modeloelementos.PilaDeCartas;
import modeloelementos.ValorCarta;
import modeloelementos.Carta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * La clase Mazo representa un mazo de cartas de tipo Francesa, Inglesa, Alemana, etc.
 * Este mazo se inicializa con 52 cartas, cada una con un valor numérico en el rango de 1 a 13
 * y uno de los cuatro palos posibles: DIAMANTE, CORAZON, TREBOL o PICA.
 * Todas las cartas se inicializan como ocultas (boca abajo). Extiende las funcionalidades de pila de Cartas.
 */

public class Mazo extends PilaDeCartas {

    public Mazo(){
        for( Palo palo : Palo.values() ) {
            for (ValorCarta valor : ValorCarta.values()) {
                Carta carta = new Carta(valor, palo, true);
                agregarCarta(carta);
            }
        }
    }

    public Mazo(PilaDeCartas mazo){
        while (!mazo.isEmpty()){
            agregarCarta(mazo.sacarCarta(true));
        }
    }

    public void mezclar() {
        Collections.shuffle(this);
    }

    public void mezclar(long semilla ) {
        var seed = new Random(semilla);
        Collections.shuffle(this, seed);
    }

    public void agregarDescarte(Descarte descarte){
        if (descarte.isEmpty()) return; //si no hay cartas en el descarte no hago nada

        Mazo mazoTemp = new Mazo();
        // Mover elementos de la pila original a la pila temporal
        while (!this.isEmpty()) {
            mazoTemp.agregarCarta(this.sacarCarta(true));
        }

        //agrego las cartas del descarte alfinal del mazo
        while (! descarte.isEmpty()) {
            mazoTemp.agregarCarta(descarte.sacarCarta(true));
        }

        // Mover elementos de la pila temporal nuevamente a la pila original
        while (!mazoTemp.isEmpty()) {
            this.agregarCarta(mazoTemp.sacarCarta(true));
        }
    }
}