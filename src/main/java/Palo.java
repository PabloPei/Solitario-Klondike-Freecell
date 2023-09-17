/**
 * La enumeración Palo representa los diferentes palos de una baraja de cartas estándar,
 * que incluyen DIAMANTE, CORAZON, TREBOL y PICA.
 */
public enum Palo {
    DIAMANTE,
    CORAZON,
    TREBOL,
    PICA;

    /**
     * Devuelve una representación legible en forma de cadena (String) del palo.
     * @return Un String que representa el palo, que puede ser "DIAMANTE", "CORAZON",
     * "TREBOL" o "PICA" según el valor de la enumeración.
     */
    public String toString(){
        String palo;
        switch (this.ordinal()){
            case 0 -> palo = "DIAMANTE";
            case 1 -> palo = "CORAZON";
            case 2 -> palo = "TREBOL";
            default -> palo = "PICA";
        }
        return palo;
    }
}
