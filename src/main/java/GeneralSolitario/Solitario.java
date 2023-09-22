package GeneralSolitario;

import GeneralElementos.Mazo;

import java.util.ArrayList;

public abstract class Solitario {
    protected final int cantidadMazos;
    protected ArrayList<Mazo> mazos;
    protected EstadoJuego estado;
    public Solitario(int cantidadMazos){
        this.cantidadMazos = cantidadMazos;
        this.estado = EstadoJuego.JUGANDO;
        this.mazos = new ArrayList<>();
    }

    public abstract void jugar();
    public abstract boolean ganoJuego();
    public abstract boolean perdioJuego();

}
