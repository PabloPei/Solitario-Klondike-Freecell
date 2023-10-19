package modelosolitario;

import modeloelementos.PilaDeCartas;

public class Descarte extends PilaDeCartas{

    private int cantidadCartas = 1;

    public Descarte(){ super(); }

    public int getCantidadCartas(){
        return this.cantidadCartas;
    }
}
