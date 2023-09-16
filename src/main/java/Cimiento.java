import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Cimiento {
    private Stack<Carta> cimiento = new Stack<>();


    public boolean agregarCarta(Carta carta) {
        if (cimiento.isEmpty()) {
            if (carta.obtenerValor() == 1) {
                cimiento.push(carta);
                return true;
            }
            return false;
        } else {
            Carta tope = cimiento.peek();
            if (tope.obtenerValor() + 1 == carta.obtenerValor() && tope.obtenerPalo() == carta.obtenerPalo()){
                cimiento.push(carta);
                return true;
            }
            return false;
        }
    }
}
