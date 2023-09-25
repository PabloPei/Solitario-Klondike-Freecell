package modelosolitario;

import modeloelementos.PilaDeCartas;
import modeloelementos.Palo;
import modeloelementos.ValorCarta;
import modeloelementos.Carta;

/**
 * La clase Mazo representa un mazo de cartas de tipo Francesa, Inglesa, Alemana, etc que hereda de PilaDeCartas.
 * Este mazo se inicializa con 52 cartas, cada una con un valor numérico en el rango de 1 a 13
 * y uno de los cuatro palos posibles: DIAMANTE, CORAZON, TREBOL o PICA.
 * Todas las cartas se inicializan como ocultas (boca abajo). El mazo se almacena en una estructura
 * de datos tipo pila.
 */

public class Mazo extends PilaDeCartas {

    //////////////////// metodos ////////////////////

    /**
     * Constructor de la clase mazo. Inicializa una baraja de cartas con 52 cartas.
     * Cada carta se crea con un valor numerico en el rango de 1 a 13 y uno de los cuatro palos posibles:
     * DIAMANTE, CORAZON, TREBOL o PICA. Todas las cartas se inicializan como ocultas.
     * Luego de iniciar el mazo, se mezcla.
     */
    public Mazo(){
        for( Palo palo : Palo.values() ){
            for ( ValorCarta valor: ValorCarta.values() ){
                Carta carta = new Carta(valor, palo, true);
                push(carta);
            }
        }

        this.mezclar();
    }

    /**
     * Compara este mazo con otro mazo para determinar si son iguales.
     * @param mazo El mazo con el que se va a comparar.
     * @return true si ambos mazos son iguales en términos de tamaño y contenido, false en caso contrario.
     */
    public boolean equals(Mazo mazo){

        if (mazo==null || this.size() != mazo.size()) {
            return false;
        }

        boolean iguales = true;
        int contador = 0;
        while (iguales && (contador < this.size())){
            if (!this.get(contador).equals(mazo.get(contador))) iguales = false;
            else contador++;
        }
        return iguales;
    }

}