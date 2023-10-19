package modelosolitario;

import modeloelementos.Palo;
import modeloelementos.PilaDeCartas;
import modeloelementos.Carta;
import modeloelementos.ValorCarta;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Cimiento extends PilaDeCartas {

    public Cimiento(){
        super();
    }

    public Cimiento(int cantidadCartas, Palo palo){
        for(ValorCarta v : ValorCarta.values()){
            if (v.ordinal() < cantidadCartas){
                this.agregarCarta(new Carta(v, palo, false));
            }
        }
    }

    public Cimiento(PilaDeCartas cimiento){
        while (!cimiento.isEmpty()){
            agregarCarta(cimiento.sacarCarta(true));
        }
    }

    public boolean puedeAgregarCarta(Carta carta) {
        if ( !super.puedeAgregarCarta(carta)) return false;
        if (cimientoCompleto())  return false;
        if (isEmpty()) {
            return (carta.getValor() == ValorCarta.AS);
        } else {
            Carta tope = peek();
            return (Carta.esValorSiguiente(tope, carta) && Carta.esMismoPalo(tope, carta));
        }
    }

    public boolean cimientoCompleto() {
        return this.size() == 13;
    }

    public static Cimiento deSerializar(String nomArchivo) throws IOException, ClassNotFoundException {
        ObjectInputStream o = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nomArchivo)));
        Cimiento c = (Cimiento) o.readObject();
        o.close();
        return c;
    }
}
