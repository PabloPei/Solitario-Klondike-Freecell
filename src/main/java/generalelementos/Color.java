package generalelementos;

public enum Color {
    ROJO,
    NEGRO;

    @Override
    public String toString(){
        return this.name();
    }
}