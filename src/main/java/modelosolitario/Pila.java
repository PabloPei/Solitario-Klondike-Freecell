package modelosolitario;

import modeloelementos.Carta;
import modeloelementos.PilaDeCartas;
import modeloelementos.ValorCarta;

/**
 * Representa una pila o 'tableu' en el juego de solitario. No confundir con la estructura de datos stack.
 * Las pilas son utilizadas para mover y organizar las cartas según las reglas del juego. Hereda de la clase
 * generica pila de cartas y extiende sus funcionalidades segun las reglas del juego solitario.
 */
public class Pila extends PilaDeCartas {

    public Pila() { super(); }

    /**
     * Constructor de la clase pila. Inicializa una pila con
     * las cartas pasadas por parametro.
     */
    public Pila(PilaDeCartas pila){
        while (!pila.isEmpty()){
            agregarCarta(pila.sacarCarta(true));
        }
    }

    /**
     * Verifica si es valido agregar una carta a la pila segun las reglas del solitario.
     * @param carta La carta que se va a intentar agregar a la pila.
     * @return true si la carta se puede agregar, false en otro caso.
     */
    public boolean puedeAgregarCarta(Carta carta) {
        // Verifica las condiciones genericas de una pila
        if ( !super.puedeAgregarCarta(carta)) return false;
        // Verifica si la pila está vacía y si la carta es un Rey (valor 13) para iniciar la pila.
        if (isEmpty()){
            return (carta.getValor() == ValorCarta.REY);
        }else {
            Carta tope = this.peek();
            // Verifica si la carta es válida para agregar en la pila según las reglas del solitario.
            return (Carta.esColorAlternado(tope, carta) && Carta.esValorSiguiente(carta, tope));
        }
    }

    /**
     * Accion de retirar una carta de la pila. Chequea si hay una carta anterior boca abajo y la pone bocca arriba
     * @param bocaAbajo indica si la carta estara boca abajo o no
     * @return Carta la carta que saco de la pila de cartas
     */
    public Carta sacarCarta(boolean bocaAbajo) {
        Carta carta = super.sacarCarta(bocaAbajo);
        if ( ! this.isEmpty() ){
            Carta tope = this.peek();
            tope.setBocaAbajo(false);
        }
        return carta;
    }
}