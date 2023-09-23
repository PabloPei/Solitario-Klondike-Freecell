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
     * Voltea todas las cartas en la pila para que queden boca arriba.
     */
    public void voltearTodas (){
        for (Carta carta : this.pilaDeCartas){
            carta.setBocaAbajo(false);
        }
    }

    /**
     * Agregar una carta a la pila según las reglas del solitario.
     * @param carta La carta que se va a agregar a la pila.
     * @return true si la carta se puede agregar a la pila, false en caso contrario.
     */
    public boolean agregarCarta(Carta carta){
        if (isEmpty()){
            if (carta.getValor() == ValorCarta.REY){
                push(carta);
                return true;
            } else return false;
        } else {
            Carta tope = peek();
            if (carta.valorValidoParaEntrarAPila(tope) && (carta.getColor() != tope.getColor())){
                push(carta);
                return true;
            } else return false;
        }
    }
}