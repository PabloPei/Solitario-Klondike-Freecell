package modelosolitario;

import modeloelementos.Carta;
import modeloelementos.PilaDeCartas;
import modeloelementos.ValorCarta;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

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

    public static Pila deSerializar(String nomArchivo) throws IOException, ClassNotFoundException {
        ObjectInputStream o = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nomArchivo)));
        Pila p = (Pila) o.readObject();
        o.close();
        return p;
    }

}