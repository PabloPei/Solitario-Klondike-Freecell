public enum Palo {
    DIAMANTE,
    CORAZON,
    TREBOL,
    PICA;

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
