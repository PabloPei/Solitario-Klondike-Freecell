package generalsolitario;

import generalelementos.Carta;

public interface Descarte {

    /**
     * Agrega una o más cartas a la pila de descarte.
     * @param mazo el mazo del cual se van a sacar las cartas
     */
    void sacarCartas(Mazo mazo);

    /**
     * Retira la carta superior de la pila de descarte.
     * @return La carta retirada o exepcion si la pila está vacía.
     */
    Carta retirarCarta();


}