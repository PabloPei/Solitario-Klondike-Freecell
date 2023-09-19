import java.util.ArrayList;

public abstract class Tablero {
    protected final int cantidadPilas;
    protected ArrayList<PilaDeCartas> pilas;

    public Tablero(int cantidadPilas){
        this.cantidadPilas = cantidadPilas;
    }
}
