import java.sql.SQLOutput;

/**
 * La clase Carta representa una carta de una baraja de cartas estándar (Francesa,
 * Española, Alemana, etc). Cada carta tiene un valor desde el As (valor=1), hasta
 * el rey (valor=13) y un palo que toma los valores de Corazones, Diamantes,
 * Tréboles o Picas.
 */

public class Carta {

    //////////////////// atributos ////////////////////

    /** El valor de la carta, entre 1 y 13 inclusive. Un valor de 1
     *  representa un As, 11 representa una Sota (Jack), 12 representa una Reina (Queen), y
     *  13 representa un Rey (King). Todos los otros números en el rango representan
     *  las cartas con el número correspondiente.
     */
    private final int valor;

    /** Indica el palo (Corazon, Diamante, Trebol, Pica) de la carta */
    private final Palo palo;

    /** Indica si la carta esta escondida para el usuario. */
    private boolean bocaAbajo;

    /** ¿Para que se usaria el color? */
    private final Color color;


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

        // ¿Hace falta?
        switch (palo){
            case DIAMANTE -> this.color = Color.ROJO;
            case CORAZON -> this.color = Color.ROJO;
            default -> this.color = Color.NEGRO;
        }

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
     * Devuelve el valor, el palo y el color de la carta como un string.
     * @return Valor de la carta + el palo + color.
     */

    // ¿Hace falta?
    public String toString(){
        String color = this.color.toString();
        String palo = this.palo.toString();
        String valorString = this.valorToString();

        return (valorString + " de " + palo + " (" + color + ")");

    }

    /**
     * Compara el valor, palo y color de dos cartas.
     * @return true si color, palo y valor son iguales, false en otro caso.
     */

    public boolean equals (Carta carta){
        return this.valor == carta.valor && this.palo == carta.palo  && this.color == carta.color;
    }

    /**
     * Voltea la orientación de la carta. Si la carta estaba boca abajo antes de llamar a este método,
     * no lo estará después y si estaba boca arriba, entonces estará oculta después de la llamada.
     */

    public void voltear(){
        bocaAbajo = !bocaAbajo;
    }

    public String mostrarCarta(){
        bocaAbajo = false;
        return this.toString();
    }


    //// Getters & Setters ////

    public boolean obtenerBocaAbajo(){
        return bocaAbajo;
    }

    public void configurarBocaAbajo(boolean bocaAbajo){
        this.bocaAbajo = bocaAbajo;
    }

    public int obtenerValor(){
        return valor;
    }

    public Palo obtenerPalo(){
        return palo;
    }

}


