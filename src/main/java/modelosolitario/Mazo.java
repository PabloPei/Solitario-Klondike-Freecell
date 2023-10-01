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

    //////////////////// metodos ////////////////////
    /**
     * Constructor de la clase mazo. Inicializa una baraja estandar (inglesa, alemana, etc) de 52 cartas.
     * Cada carta se crea con un valor numerico en el rango de 1 a 13 y uno de los cuatro palos posibles:
     * DIAMANTE, CORAZON, TREBOL o PICA. Todas las cartas se inicializan como ocultas.
     */
    public Mazo(){
        for( Palo palo : Palo.values() ) {
            for (ValorCarta valor : ValorCarta.values()) {
                Carta carta = new Carta(valor, palo, true);
                agregarCarta(carta);
            }
        }
    }

    /**
     * Constructor de la clase mazo. Inicializa una baraja estandar (inglesa, alemana, etc) con
     * las cartas pasadas por parametro. No se mezcla.
     */
    public Mazo(PilaDeCartas mazo){
        while (!mazo.isEmpty()){
            agregarCarta(mazo.sacarCarta(true));
        }
    }

    /**
     * Mezcla el mazo de forma pseudo aleatoria
     */
    public void mezclar() {
        Collections.shuffle(this);
    }

    /**
     * Mezcla el mazo de forma pseudo aleatoria
     * @param semilla la semilla aleatoria a partir de la cual se crea el mazo. Se toma como parametro para
     *                poder iniciarlizar solitarios desde el mismo punto
     */
    public void mezclar(long semilla ) {
        var seed = new Random(semilla);
        Collections.shuffle(this, seed);
    }

    /**
     * Este metodo cumple la funcionalidad de insertar las cartas no utilizadas de la pila de
     * descarte nuevamente al fondo del mazo.
     * @param descarte pila de las cartas de descarte no utilizadas
     */
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