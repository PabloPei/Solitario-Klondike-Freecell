package modelosolitario;

import modeloelementos.Carta;
import modeloelementos.PilaDeCartas;
import modeloelementos.ValorCarta;

import java.io.*;

public class Pila extends PilaDeCartas {

    public Pila() { super(); }

    public Pila(PilaDeCartas pila){
        while (!pila.isEmpty()){
            agregarCarta(pila.sacarCarta(true));
        }
    }

    public boolean puedeAgregarCarta(Carta carta) {
        if ( !super.puedeAgregarCarta(carta)) return false;
        if (isEmpty()){
            return (carta.getValor() == ValorCarta.REY);
        }else {
            Carta tope = this.peek();
            return (Carta.esColorAlternado(tope, carta) && Carta.esValorSiguiente(carta, tope));
        }
    }

    public Carta sacarCarta(boolean bocaAbajo) {
        Carta carta = super.sacarCarta(bocaAbajo);
        if ( ! this.isEmpty() ){
            Carta tope = this.peek();
            tope.setBocaAbajo(false);
        }
        return carta;
    }

    public static Pila deSerializar(InputStream is) throws IOException, ClassNotFoundException {
        return (Pila) PilaDeCartas.deSerializar(is);
    }

    public Pila invertir() {
        Pila pilaInvertida = new Pila();
        Pila copia = (Pila) this.clone();
        while (!copia.isEmpty()) {
            pilaInvertida.push(copia.pop());
        }
        return  pilaInvertida;
    }
}