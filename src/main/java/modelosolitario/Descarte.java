package modelosolitario;

import modeloelementos.Carta;
import modeloelementos.PilaDeCartas;
import modeloelementos.Dificultad;

public class Descarte extends PilaDeCartas{

    private int cantidadCartas;

    public Descarte(){ super(); }

    public void setCantidadCartas(Dificultad dificultad){
        switch (dificultad) {
            case DIFICIL -> this.cantidadCartas = 3;
            case MEDIO -> this.cantidadCartas = 2;
            case FACIL -> this.cantidadCartas = 1;
            default -> this.cantidadCartas = 1;
        }
    }

    public int getCantidadCartas(){
        return this.cantidadCartas;
    }
}
