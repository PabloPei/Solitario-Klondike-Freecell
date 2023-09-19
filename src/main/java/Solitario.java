import java.util.ArrayList;
import java.util.random.RandomGenerator;

public abstract class Solitario {
    protected final int cantidadMazos;
    protected ArrayList<Mazo> mazos;
    protected enum EstadoJuego{JUGANDO, GANADO, PERDIDO};
    protected EstadoJuego estado;
    public Solitario(int cantidadMazos){
        this.cantidadMazos = cantidadMazos;
        this.estado = EstadoJuego.JUGANDO;
    }

    public abstract void iniciarJuego();
    public abstract void jugar();
    public abstract boolean ganoJuego();
    public abstract boolean perdioJuego();

}
