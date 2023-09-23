package GeneralElementos;

/**
 * Esta enumeración representa los valores de las cartas en un juego de cartas de baraja estandar (española, francesa, etc).
 * Cada valor de carta tiene un valor numérico asociado que se puede obtener con el método getValor().
 */
public enum ValorCarta {
    AS(1), DOS(2), TRES(3), CUATRO(4), CINCO(5), SEIS(6), SIETE(7), OCHO(8),
    NUEVE(9), DIEZ(10), SOTA(11), REINA(12), REY(13);

    /**
     * El valor numérico de la carta.
     */
    private final int value;

    /**
     * Constructor para crear una instancia de ValorCarta con un valor numérico específico.
     * @param value El valor numérico de la carta.
     */
    private ValorCarta(int value) {
        this.value = value;
    }

    /**
     * Obtiene el valor numérico asociado con la carta.
     * @return El valor numérico de la carta.
     */
    public int getValor() {
        return value;
    }

    /**
     * Devuelve una representación en forma de cadena del nombre de la carta.
     * @return El nombre de la carta.
     */
    public String toString(){
        return this.name();
    }

    /**
     * Devuelve el siguiente valor de una carta. Si el valor actual es `REY`, devuelve `null`.
     * @return Siguiente valor de una carta o `null` si es `REY`.
     */
    public ValorCarta siguiente(){
        if (this == REY) {
            return null;
        }
        return ValorCarta.values()[this.ordinal() + 1];
    }


}
