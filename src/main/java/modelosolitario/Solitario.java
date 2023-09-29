package modelosolitario;

import modeloelementos.Carta;
import modeloelementos.Dificultad;
import modeloelementos.EstadoJuego;

/**
 * La interfaz Solitario define un conjunto de métodos que deben ser implementados
 * por las clases que representan diferentes variantes del juego de Solitario.
 */

public interface Solitario {

    /**
     * Funcion principal para jugar al solitario
     */
    void jugar();

    /**
     * Verifica si el juego ha sido ganado según las reglas específicas del Solitario.
     * @return true si el juego ha sido ganado, false en caso contrario.
     */
    EstadoJuego verificarEstado();

    /**
     * Suma un movimiento al contador
     */
    void sumarMovimiento();

    /**
     * Devuelve la cantidad de movimientos
     * @return cantidad de movimientos.
     */
    int obtenerMovimientos();

    /**
     * Setea la dificultad del solitario
     * @param dificultad la dificultad del solitario (facil,medio,dificil)
     */
    void setDificultad(Dificultad dificultad);


    /**
     * devuelve la dificultad
     * @return dificultad la dificultad del solitario (facil,medio,dificil)
     */
    Dificultad getDificultad();
}
