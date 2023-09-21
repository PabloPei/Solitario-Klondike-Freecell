package GeneralSolitario;

import GeneralElementos.Carta;
import GeneralElementos.ValorCarta;

import java.util.Stack;

/**
 * Esta clase representa una pila de cartas. Extiende la clase Stack y proporciona
 * funcionalidad específica para manipular un conjunto de cartas.
 */
public class PilaDeCartas extends Stack<Carta> {

    //////////////////// Atributos ////////////////////

    protected Stack<Carta> pilaDeCartas;

    //////////////////// Métodos ////////////////////

    /**
     * Constructor que inicializa una nueva pila de cartas vacía.
     */
    public PilaDeCartas(){
        pilaDeCartas = new Stack<Carta>();
    }

    /**
     * Extrae y devuelve la carta en la parte superior de la pila.
     * @return La carta en la parte superior de la pila.
     */
    public Carta popCarta(){
        return this.pilaDeCartas.pop();
    }

    /**
     * Agrega una carta a la parte superior de la pila.
     * @param carta La carta que se va a agregar a la pila.
     */
    public void pushCarta(Carta carta){
        this.pilaDeCartas.push(carta);
    }

    /**
     * Obtiene la carta en la parte superior de la pila sin eliminarla.
     * @return La carta en la parte superior de la pila.
     */
    public Carta peekCarta(){
        return this.pilaDeCartas.peek();
    }

    /**
     * Voltea todas las cartas en la pila para que queden boca arriba.
     */
    public void voltearTodas (){
        for (Carta carta : this.pilaDeCartas){
            carta.setBocaAbajo(false);
        }
    }

    /**
     * Obtiene el tamaño actual de la pila de cartas.
     * @return El tamaño de la pila.
     */
    public int tamanio(){
        return this.pilaDeCartas.size();
    }

    /**
     * Verifica si la pila de cartas está vacía.
     * @return true si la pila está vacía, false de lo contrario.
     */
    public boolean estaVacio(){
        return this.pilaDeCartas.empty();
    }

    public boolean agregarCarta(Carta carta){
        if (estaVacio()){
            if (carta.getValor() == ValorCarta.REY){
                pushCarta(carta);
                return true;
            } else return false;
        } else {
            Carta tope = peekCarta();
            if (carta.valorValidoParaEntrarAPila(tope) && (carta.getColor() != tope.getColor())){
                pushCarta(carta);
                return true;
            } else return false;
        }
    }
}
