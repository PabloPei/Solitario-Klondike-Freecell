package modelosolitario;

public enum TiposSolitario {
    FREECELL,
    KLONDIKE;

    @Override
    public String toString(){
        return this.name();
    }

}
