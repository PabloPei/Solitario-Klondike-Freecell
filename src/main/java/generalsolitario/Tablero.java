package generalsolitario;

/**
 * Esta interfaz define las operaciones comunes relacionadas con el tablero de un juego de Solitario.
 */
public interface Tablero {

    /**
     * Inicia el mazo de cartas del juego.
     */
    void iniciarMazo();

    /**
     * Inicia las pilas del tablero.
     */
    void iniciarPilas();

    /**
     * Reparte las pilas iniciales en el tablero.
     */
    void repartirPilas();
}
