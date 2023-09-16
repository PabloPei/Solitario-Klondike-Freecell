import java.sql.SQLOutput;

public class Carta {
    private final int valorCarta;
    private final Palo palo;
    private final Color color;
    private boolean bocaAbajo;
    public Carta(int valor, Palo palo){
        this.valorCarta = valor;
        this.palo = palo;
        switch (palo){
            case DIAMANTE -> this.color = Color.ROJO;
            case CORAZON -> this.color = Color.ROJO;
            default -> this.color = Color.NEGRO;
        }
        bocaAbajo = true;
    }

    public String toString(){
        String color = this.color.toString();
        String palo = this.palo.toString();
        if (valorCarta > 1 && valorCarta < 11) {
            return (valorCarta + " de " + palo + " (" + color + ")");
        } else {
            String valorReal;
            switch (valorCarta){
                case 1 -> valorReal = "A";
                case 11 -> valorReal = "J";
                case 12 -> valorReal = "Q";
                default -> valorReal = "K";
            }
            return (valorReal + " de " + palo + " (" + color + ")");
        }
    }
    public boolean equals (Carta carta){
        if ((this.valorCarta == carta.valorCarta) && (this.palo.ordinal() == carta.palo.ordinal()) && (this.color.ordinal() == carta.color.ordinal())){
            return true;
        } else return false;
    }

    public String mostrarCarta(){
        bocaAbajo = false;
        return this.toString();
    }

    public int obtenerValor(){
        return valorCarta;
    }

    public Palo obtenerPalo() {
        return palo;
    }
}


