import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Una lista (o mazo) de cartas. Esta clase tiene todas las funcionalidades de una típica estructura de datos de lista
 * con algunas características adicionales para las cartas.
 */

public class Mazo {

    //////////////////// atributos ////////////////////

    /** Pila de cartas que conforman el mazo */
    protected ArrayList<Carta> cartas;

    /** Numero de cartas que tiene el mazo */
    private int cantidadCartas;


    //////////////////// metodos ////////////////////

    /**
     * Constructor de la clase mazo. Inicializa una baraja de cartas con 52 cartas.
     * Cada carta se crea con un valor numerico en el rango de 1 a 13 y uno de los cuatro palos posibles:
     * DIAMANTE, CORAZON, TREBOL o PICA. Todas las cartas se inicializan como ocultas.
     * La baraja se almacena en una estructura de datos de pila.
     */
    public Mazo(){

        this.cartas = new ArrayList<Carta>();
        this.cantidadCartas = 52;

        for( Palo palo : Palo.values() ){
            for ( int i = 1 ; i < 14 ; i++ ){
                cartas.add(new Carta(i, palo, false));
            }
        }

    }



    /**
     * Mezcla aleatoriamente las cartas en el mazo utilizando el algoritmo de mezcla proporcionado por
     * la clase Collections de Java.
     */
    public void mezclar(){
        Collections.shuffle(this.cartas);
    }
        /* Si se puede usar el shuffle no veo necesidad de recodear. Tampoco veo porque deberia
         devolver un Stack<Carta> si mezcla el mazo interno de la clase.

        List<Carta> auxiliar = new ArrayList<>();
        int numero;
        while (!cartas.isEmpty()){
            numero = (int)(Math.random()*(cartas.size()));
            auxiliar.add(cartas.get(numero));
            cartas.remove(numero);
        }
        cartas = auxiliar;
        return cartas;
        */


    // no entiendo muy bien para que se usaria esta clase y la de abajo

    public String repartirMazoCompleto(){
        String mazoCompleto = "";
        for (int i = 0; i < cartas.size(); i++){
            mazoCompleto = mazoCompleto + cartas.get(i).mostrarCarta() + "\n";
        }
        return mazoCompleto;
    }


    public void repartirMazo(){
        List<Stack> pilas = new ArrayList<>();
        for (int i = 0; i < 7; i++){
            Stack <Carta> pila = new Stack<>();
            for (int j = 0; j< i + 1; j++) {
                Carta carta = this.sacarCarta();
                if (j == i) {
                    carta.mostrarCarta();
                }
                pila.push(carta);
            }
            pilas.add(pila);
        }
    }

    private Carta sacarCarta() {
        return null;
    }

    public int obtenerTamanio(){
        return cantidadCartas;
    }


     /* ¿ para que se usaria comparar que dos mazos sean iguales?
    public boolean equals(Mazo mazo){

        boolean sonIguales = true;
        int indice = 0;

        while (sonIguales && indice < cantidadCartas){

            if(cartas.get(indice).equals(mazo.cartas.get(indice))) indice++;
            else sonIguales = false;

        }

        return sonIguales;

    }
*/


}

