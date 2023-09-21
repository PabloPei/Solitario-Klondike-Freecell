package GeneralSolitario;

import java.util.ArrayList;

public abstract class Tablero {
    protected final int cantidadPilas;
    protected ArrayList<PilaDeCartas> pilas = new ArrayList<>();

    public Tablero(int cantidadPilas){
        this.cantidadPilas = cantidadPilas;
    }

    public abstract EstadoJuego chequearEstadoJuego();
}
