package Klondike;

import GeneralElementos.Carta;
import GeneralElementos.Palo;
import GeneralElementos.ValorCarta;
import GeneralSolitario.PilaDeCartas;

/**
 * La clase Klondike.Cimiento representa una pila especializada de cartas utilizada en el solitario.
 * Esta clase hereda de la clase GeneralSolitario.PilaDeCartas y agrega funcionalidad específica para manejar
 * las reglas del cimiento en el juego.
 */

public class Cimiento extends PilaDeCartas {

    //////////////////// Atributos ////////////////////
    private Palo paloValido;

    //////////////////// Métodos ////////////////////

    /**
     * Agregar una carta al cimiento según las reglas del solitario.
     * @param carta La carta que se va a agregar al cimiento.
     * @return true si la carta se puede agregar al cimiento, false en caso contrario.
     */

    public Cimiento(Palo palo){
        super();
        this.paloValido = palo;
    }

    public Cimiento(Palo palo, int valor){
        super();
        this.paloValido = palo;
        for(int i = 1; i <= valor; i++){
            push(new Carta(i, palo, true));
        }
    }
    public boolean agregarCarta(Carta carta) {
        if (carta.getPalo() != this.paloValido  || cimientoCompleto()) return false;
        else {
            if (isEmpty()) {
                if (carta.getValor() == ValorCarta.AS) {
                    push(carta);
                    return true;
                }
                return false;
            } else {
                Carta tope = peek();
                if (tope.valorValidoParaEntrarAPila(carta) && (tope.getPalo() == carta.getPalo())) {
                    push(carta);
                    return true;
                }
                return false;
            }
        }
    }

    public boolean cimientoCompleto(){
        return this.size() == 13;
    }
}
