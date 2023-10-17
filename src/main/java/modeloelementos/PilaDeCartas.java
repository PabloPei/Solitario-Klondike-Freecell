package modeloelementos;
import modelosolitario.Pila;

import java.util.Collections;
import java.util.Stack;

/**
 * Esta clase representa una pila de cartas. Extiende la clase Stack y proporciona
 * funcionalidad específica para manipular un conjunto de cartas en el contexto de un solitario.
 * No confundir con la clase pila que representa una "pila" o "tableu" en un juego de solitario.
 * (Se utilizara en el futuro para definir la posicion, ancho y alto de las pilas.)
 */
public class PilaDeCartas extends Stack<Carta> {

    public boolean agregarCarta(Carta carta) {

        if(puedeAgregarCarta(carta)) {
            push(carta);
            return true;
        }
        return false;
    }

    public Carta sacarCarta(boolean bocaAbajo) {
        if(isEmpty()) {
            return null;
        }
        Carta carta = pop();
        carta.setBocaAbajo(bocaAbajo);
        return carta;
    }

    public Carta verCarta() {
        if(isEmpty()) {
            return null;
        }
        return peek();
    }

    public boolean puedeAgregarCarta(Carta carta) {
        return (carta != null && !this.contains(carta));
    }

    public boolean equals(PilaDeCartas pila){
        if(this.size() != pila.size()) return false;
        boolean sonIguales = true;
        int indice = 0;
        while (sonIguales && indice < this.size()){
            if (this.get(indice) != pila.get(indice)) sonIguales = false;
            else indice++;
        }
        return sonIguales;
    }
}
