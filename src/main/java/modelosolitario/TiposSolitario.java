package modelosolitario;

public enum TiposSolitario {
    KLONDIKE,
    FREECELL;


    @Override
    public String toString(){
        return this.name();
    }

}
