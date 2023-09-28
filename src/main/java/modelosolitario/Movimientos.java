package modelosolitario;

import modeloelementos.Carta;
import modeloelementos.PilaDeCartas;

/**
 * Esta clase proporciona métodos para realizar movimientos en el juego de Solitario.
 */
public class Movimientos {

    private int cantidadMovimientos;

    /**
     * Mueve una carta desde una pila de origen a una pila de destino.
     * @param origen   La pila de origen desde la que se va a sacar la carta.
     * @param destino  La pila de destino a la que se va a agregar la carta.
     * @return         Devuelve true si el movimiento se realizó con éxito, false si no se pudo realizar.
     */
    public static boolean moverCarta(PilaDeCartas origen, PilaDeCartas destino) {


        Carta cartaSacada = origen.sacarCarta(false);

        if (!destino.agregarCarta(cartaSacada)){
            origen.agregarCarta(cartaSacada); //no pudo agregar la carta la vuelvo al lugar original
            return false;
        }
        return true;

    }

    /**
     * Roba cartas del mazo y las pone en la pila de descarte. Ademas, si habia cartas en la pila de descarte las mueve
     * de vuelta al mazo.
     * @param mazo     Mazo del cual va a robar las cartas y volver a ingresar
     * @param descarte pila de descarte en la cual va a agregar la carta
     * @return         Devuelve true si el movimiento se realizó con éxito, false si no se pudo realizar.
     */
    public static boolean robarCartasDelMazo(Mazo mazo, Descarte descarte) {

        // Si el mazo y el descarte estan vacios no puedo robar cartas
        if (descarte.isEmpty() && mazo.isEmpty())
            return false;

        // Coloco las cartas de la pila de descarte boca abajo y lo agrego al final del mazo
        while (!descarte.isEmpty()) {
            Carta carta = descarte.sacarCarta(true);
            mazo.agregarCarta(carta);
        }

        // Saco las cartas del mazo y las coloca en la pila de descarte.
        for (int i = 0; i < descarte.getCantidadCartas(); i++) {
            Carta carta = mazo.sacarCarta(false);
            if (carta==null) break; //si no hay mas cartas en el mazo dejo de agregar al descarte
            descarte.agregarCarta(carta);
        }

        return true;
    }



    /**
     * Mueve un conjunto de cartas desde una pila de origen a una pila de destino.
     * @param origen        La pila de origen desde la que se moverá el conjunto de cartas.
     * @param destino       La pila de destino a la que se moverá el conjunto de cartas.
     * @param primeraCarta  La primera carta del conjunto a mover.
     * @return              Devuelve true si el movimiento se realizó con éxito, false si no se pudo realizar.
     */
    public static boolean moverCartas(PilaDeCartas origen, PilaDeCartas destino, Carta primeraCarta) {

        // En primer lugar reviso el caso particular de si se puede agregar la carta a la nueva pila
        if(!destino.puedeAgregarCarta(primeraCarta)) return false;

        // Me guardo la ultima carta por si falla volver atras
        Carta ultimaCarta = origen.verCarta();

        // Me armo una pila auxiliar con las cartas
        PilaDeCartas pilaAux = new PilaDeCartas();
        do{
            if ( ! (pilaAux.agregarCarta(origen.sacarCarta(false)))) {
                // Si falla en agregar vuelvo todas las cartas de la pila auxiliar al original
                while (!(pilaAux.isEmpty())) {
                    origen.agregarCarta(pilaAux.sacarCarta(false));
                }
                return false;
            }
        }while (primeraCarta != pilaAux.verCarta());


        // Comienzo a agregarlas a la nueva pila
        while (!pilaAux.isEmpty()) {
            if (!(destino.agregarCarta(pilaAux.pop()))) {
                //si fallo al agregar una carta vuelvo las cartas a la posición original
                // Las cartas que ya estaban en la pila destino las vuelvo al origen
                while (destino.peek() != ultimaCarta) {
                    origen.agregarCarta(destino.sacarCarta(false));
                }
                // Las cartas que todavia no habia podido agregar y estaban en la auxiliar las vuelvo a la origen
                while (!(pilaAux.isEmpty())) {
                    origen.agregarCarta(pilaAux.sacarCarta(false));
                }
                return false;
            }
        }
        return true;
    }
}
