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
     * Suma el valor pasado a la puntuacion
     * @param cantidad Cantidad que se debe sumar a la puntuación
     */
    void sumarPuntuacion(int cantidad);

    /**
     * Calcula la puntuación del juego según las reglas de puntuación del Solitario.
     * @return La puntuación del juego.
     */
    int obtenerPuntuación();

    /**
     * Setea la dificultad del solitario
     * @param dificultad la dificultad del solitario (facil,medio,dificil)
     */
    void setDificultad(Dificultad dificultad);

}
