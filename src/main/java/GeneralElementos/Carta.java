package GeneralElementos;

/**
 * La clase General.Carta representa una carta de una baraja de cartas estándar (Francesa,
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
    private final ValorCarta valor;

    /** Indica el palo (Corazon, Diamante, Trebol, Pica) de la carta */
    private final Palo palo;

    /** Indica si la carta esta escondida para el usuario. */
    private boolean bocaAbajo;


    //////////////////// metodos ////////////////////

    /**
     * Inicializa la carta con un palo y valor dados y si la carta está oculta para el usuario.
     *
     * @param palo El palo de la carta (Corazon, Diamante, Trebol, Pica).
     * @param valor El valor de la carta
     * @param bocaAbajo Si la carta estará orientada al usuario o no.
     */
    public Carta(ValorCarta valor, Palo palo, boolean bocaAbajo){

        this.valor = valor;
        this.palo = palo;
        this.bocaAbajo = bocaAbajo;

    }

    /**
     * Compara el valor y palo de dos cartas.
     * @param obj El objeto a comparar.
     * @return true si el objeto es una instancia de Carta y tiene el mismo valor y palo, false en otro caso.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Carta carta = (Carta) obj;
        return valor == carta.valor && palo == carta.palo;
    }

    /**
     * Convierte una instancia de la clase Carta en una representación en forma de cadena
     * que combina su valor y su palo en un formato legible.
     * @return Una cadena que representa la carta en el formato "Valor - Palo".
     */
    @Override
    public String toString() {
        return valor.toString() + " - " + palo.toString();
    }


    /**
     * Voltea la orientación de la carta. Si la carta estaba boca abajo antes de llamar a este método,
     * no lo estará después y si estaba boca arriba, entonces estará oculta después de la llamada.
     */

    public void voltear(){
        bocaAbajo = !bocaAbajo;
    }

    /**
     * Metodo para obtener el color de la carta 
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

    public ValorCarta getValor(){
        return valor;
    }

    public Palo getPalo(){
        return palo;
    }


}


