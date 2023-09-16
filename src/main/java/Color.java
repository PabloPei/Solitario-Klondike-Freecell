public enum Color {
    ROJO,
    NEGRO;

    public String toString(){
        if (this.ordinal() == 0){
            return "ROJO";
        } else {
            return "NEGRO";
        }
    }
}
