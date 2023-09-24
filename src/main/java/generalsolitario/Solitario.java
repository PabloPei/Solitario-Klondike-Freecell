package generalsolitario;


import generalelementos.Dificultad;

/**
 * La interfaz Solitario define un conjunto de métodos que deben ser implementados
 * por las clases que representan diferentes variantes del juego de Solitario.
 */

public interface Solitario {

    /** #seguir agregando metodos
     * Inicia un nuevo juego de Solitario.
     */
    void iniciarJuego(Dificultad dificultad);

    /**
     * Funcion principal para jugar al solitario
     */
    void jugar();
    /**
     * Realiza una jugada en el juego de Solitario.
     */
    void realizarJugada();

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
     * Calcula la puntuación del juego según las reglas de puntuación del Solitario.
     * @return La puntuación del juego.
     */
    int obtenerPuntuación();

}
