package modeloelementos;

public enum Palo {
    DIAMANTE,
    CORAZON,
    TREBOL,
    PICA;


    @Override
    public String toString(){
        return this.name();
    }

    public Color getColor() { return (this.equals(Palo.DIAMANTE) || this.equals(Palo.CORAZON) ? Color.ROJO : Color.NEGRO);}
}
