package modelosolitario;


import modeloelementos.Dificultad;
import modeloelementos.EstadoJuego;

/**
 * La interfaz Solitario define un conjunto de métodos que deben ser implementados
 * por las clases que representan diferentes variantes del juego de Solitario.
 */

public interface Solitario {

    /** #seguir agregando metodos
     */

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
     * Verifica si el juego ha sido ganado según las reglas específicas del Solitario.
     * @return true si el juego ha sido ganado, false en caso contrario.
     */
    boolean verificarVictoria();

    /**
     * Verifica si el juego ha terminado en derrota según las reglas específicas del Solitario.
     * @return true si el juego ha terminado en derrota, false en caso contrario.
     */
    boolean verificarDerrota();

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

}
