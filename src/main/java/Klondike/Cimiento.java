package Klondike;

import GeneralElementos.Carta;
import GeneralElementos.Palo;
import GeneralElementos.ValorCarta;
import GeneralSolitario.PilaDeCartas;

import java.util.Stack;

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
     * ??
     */

    public Cimiento(Palo palo){
        super();
        this.paloValido = palo;
    }

    public Cimiento(Palo palo, ValorCarta valor){
        super();
        this.paloValido = palo;
        ValorCarta i;
        for (i = ValorCarta.AS;  i.getValor() < valor.getValor() ; i = i.siguiente()) {
            push(new Carta(i, palo, true));
        }


    }

    private boolean validarCartaParaCimiento(Carta carta) {
        Carta tope = this.peek();
        return  ((tope.getValor().ordinal() + 1 == carta.getValor().ordinal())
                && (carta.getColor() == tope.getColor()));
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
                if (validarCartaParaCimiento(carta)) {
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