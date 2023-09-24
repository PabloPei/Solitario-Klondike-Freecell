package generalelementos;

/**
 * Representa los niveles de dificultad de un solitario
 * Las dificultades disponibles son facil y dificil.
 */
public enum Dificultad {
    FACIL, MEDIO, DIFICIL;


    @Override
    public String toString(){
        return this.name();
    }


}
