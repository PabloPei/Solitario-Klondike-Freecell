/**
 * La clase Carta representa una carta de una baraja de cartas estándar (Francesa,
 * Española, Alemana, etc). Cada carta tiene un valor desde el As (valor=1), hasta
 * el rey (valor=13) y un palo que toma los valores de Corazones, Diamantes,
 * Tréboles o Picas.
 */

public class Carta {

    //////////////////// Atributos ////////////////////

    /** El valor de la carta, entre 1 y 13 inclusive. Un valor de 1
     *  representa un As, 11 representa una Sota , 12 representa una Reina, y
     *  13 representa un Rey. Todos los otros números en el rango representan
     *  las cartas con el número correspondiente.
     */
    private final int valor;

    /** Indica el palo (Corazon, Diamante, Trebol, Pica) de la carta */
    private final Palo palo;

    /** Indica si la carta esta escondida para el usuario. */
    private boolean bocaAbajo;


    //////////////////// metodos ////////////////////

    /**
     * Inicializa la carta con un palo y valor dados y si la carta está oculta para el usuario.
     *
     * @param palo El palo de la carta (Corazon, Diamante, Trebol, Pica).
     * @param valor El valor de la carta, entre 1 y 13 inclusive.
     * @param bocaAbajo Si la carta estará orientada al usuario o no.
     */
    public Carta(int valor, Palo palo, boolean bocaAbajo){

        if(valor < 1 || valor > 13){
            throw new IllegalArgumentException("Valor fuera de rango.");
        }

        this.valor = valor;
        this.palo = palo;
        this.bocaAbajo = bocaAbajo;

    }

    /**
     * Devuelve el valor de la carta como un String.
     * @return El valor entero de la carta como un string si 1 < valor < 11. En otro caso,
     * "A" si valor == 1, "J" si valor == 11, "Q" si valor == 12, "K" si valor == 13.
     */

    private String valorToString(){
        switch(valor){
            case 1: return "A";
            case 11: return "J";
            case 12: return "Q";
            case 13: return "K";
            default: return Integer.toString(valor);
        }
    }

    /**
     * Compara el valor y palo de dos cartas.
     * @return true palo y valor son iguales, false en otro caso.
     */

    public boolean equals (Carta carta){
        return this.valor == carta.valor && this.palo == carta.palo;
    }

    /**
     * Voltea la orientación de la carta. Si la carta estaba boca abajo antes de llamar a este método,
     * no lo estará después y si estaba boca arriba, entonces estará oculta después de la llamada.
     */

    public void voltear(){
        bocaAbajo = !bocaAbajo;
    }

    /**
     * Devuelve el color de la carta
     * @return devuelve un color correspondiente al color de la carta (ROJO O NEGRO) 
     */

    public Color getColor() {
        return (this.palo.ordinal() == Palo.DIAMANTE.ordinal() || this.palo.ordinal() == Palo.CORAZON.ordinal() ? Color.ROJO : Color.NEGRO);
    }

    //// Getters & Setters ////

    public void setBocaAbajo(boolean bocaAbajo){
        this.bocaAbajo = bocaAbajo;
    }

    public boolean getBocaAbajo(){
        return bocaAbajo;
    }

    public int getValor(){
        return valor;
    }

    public Palo getPalo(){
        return palo;
    }

}


