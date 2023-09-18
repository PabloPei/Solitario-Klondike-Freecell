import java.util.Collections;

/**
 * La clase Mazo representa un mazo de cartas que hereda de PilaDeCartas.
 * Este mazo se inicializa con 52 cartas, cada una con un valor numérico en el rango de 1 a 13
 * y uno de los cuatro palos posibles: DIAMANTE, CORAZON, TREBOL o PICA.
 * Todas las cartas se inicializan como ocultas (boca abajo). El mazo se almacena en una estructura
 * de datos tipo pila.
 */

public class Mazo extends PilaDeCartas {

    //////////////////// atributos ////////////////////


    //////////////////// metodos ////////////////////

    /**
     * Constructor de la clase mazo. Inicializa una baraja de cartas con 52 cartas.
     * Cada carta se crea con un valor numerico en el rango de 1 a 13 y uno de los cuatro palos posibles:
     * DIAMANTE, CORAZON, TREBOL o PICA. Todas las cartas se inicializan como ocultas.
     * La baraja se almacena en una estructura de datos de pila.
     */
    public Mazo(){

        super();

        for( Palo palo : Palo.values() ){
            for ( int i = 1 ; i < 14 ; i++ ){
                Carta carta = new Carta(i, palo, true);
                pushCarta(carta);
            }
        }

    }

    /**
     * Mezcla las cartas en el mazo de manera aleatoria.
     */
    public void mezclar(){
        Collections.shuffle(pilaDeCartas);
    }

    public boolean equals(Mazo mazo){
        boolean iguales = true;
        int contador = 0;
        while (iguales && (contador < this.tamanio())){
            if (!this.pilaDeCartas.get(contador).equals(mazo.pilaDeCartas.get(contador))) iguales = false;
            else contador++;
        }
        return iguales;
    }

}

