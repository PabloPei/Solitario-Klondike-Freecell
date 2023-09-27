package modelosolitario;

import modeloelementos.Palo;
import modeloelementos.ValorCarta;
import modeloelementos.Carta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * La clase Mazo representa un mazo de cartas de tipo Francesa, Inglesa, Alemana, etc que hereda de un ArrayList.
 * Este mazo se inicializa con 52 cartas, cada una con un valor numérico en el rango de 1 a 13
 * y uno de los cuatro palos posibles: DIAMANTE, CORAZON, TREBOL o PICA.
 * Todas las cartas se inicializan como ocultas (boca abajo). El mazo se almacena en una estructura
 * de datos tipo ArrayList. Se decidio de esta manera ya que brinda mas flexibilidad a la hora de insertar
 * y sacar cartas del mazo en distintas posiciones.
 */

public class Mazo extends ArrayList<Carta> {

    //////////////////// metodos ////////////////////
    /**
     * Constructor de la clase mazo. Inicializa una baraja estandar (inglesa, alemana, etc) de 52 cartas.
     * Cada carta se crea con un valor numerico en el rango de 1 a 13 y uno de los cuatro palos posibles:
     * DIAMANTE, CORAZON, TREBOL o PICA. Todas las cartas se inicializan como ocultas.
     * Luego de iniciar el mazo, se mezcla.
     */
    public Mazo(){
        for( Palo palo : Palo.values() ){
            for ( ValorCarta valor: ValorCarta.values() ){
                Carta carta = new Carta(valor, palo, true);
                add(carta);
            }
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
     * @param semilla la semmila aleatoria a partir de la cual se crea el mazo. Se toma como parametro para
     *                poder iniciarlizar solitarios desde el mismo punto
     */
    public void mezclar(long semilla ) {

        var seed = new Random(semilla);
        Collections.shuffle(this, seed);

    }


    /**
     * Saca la primera carta del mazo
     * @param carta Carta que se quiere agregar al mazo
     * @return true si se puede agregar, false sino
     */
    public boolean agregarCarta(Carta carta){

        if ( this.contains(carta))
            return false;
        else
            this.add(carta);
        return true;
    }


    /**
     * Saca la primera carta del mazo
     * @param bocaAbajo para indicar si se roba boca abajo o arriba
     * @return Carta devuelve la primera carta del mazo
     */
    public Carta sacarCarta(boolean bocaAbajo){
        if (isEmpty()) {
            return null;
        }

        Carta carta = this.remove(0);
        carta.setBocaAbajo(bocaAbajo);
        return carta;
    }


    /**
     * Compara este mazo con otro mazo para determinar si son iguales.
     * @param mazo El mazo con el que se va a comparar.
     * @return true si ambos mazos son iguales en términos de tamaño y contenido, false en caso contrario.
     */
    public boolean equals(Mazo mazo) {
        // Verifica si el mazo dado es nulo o tiene un tamaño diferente.
        if (mazo == null || this.size() != mazo.size()) {
            return false;
        }

        // Compara cada carta en ambos mazos.
        for (int i = 0; i < this.size(); i++) {
            if (!this.get(i).equals(mazo.get(i))) {
                return false;
            }
        }

        return true;
    }

}