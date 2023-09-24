package generalsolitario;

import generalelementos.Carta;

public interface Cimiento {

    /**
     * Agrega una carta al cimiento si el movimiento es válido.
     * @param carta La carta que se intenta agregar.
     * @return true si se pudo agregar la carta, false si no es un movimiento válido.
     */
    boolean agregarCarta(Carta carta);

    /**
     * Retira una carta del cimiento.
     *
     * @return carta La carta retirada del cimiento.
     */
    Carta retirarCarta();

    /**
     * Verifica si el cimiento está completo (todas las cartas requeridas han sido agregadas).
     * @return true si el cimiento está completo, false en caso contrario.
     */
    boolean cimientoCompleto();



}