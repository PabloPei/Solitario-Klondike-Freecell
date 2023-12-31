package modelosolitario;

import modeloelementos.Palo;
import modeloelementos.PilaDeCartas;
import modeloelementos.Carta;
import modeloelementos.ValorCarta;

import java.io.*;


public class Cimiento extends PilaDeCartas {

    public Cimiento(){
        super();
    }

    public Cimiento(int cantidadCartas, Palo palo) {
        for(ValorCarta v : ValorCarta.values()) {
            if (v.ordinal() < cantidadCartas) {
                this.agregarCarta(new Carta(v, palo, false));
            }
        }
    }

    public Cimiento(PilaDeCartas cimiento) {
        while (!cimiento.isEmpty()) {
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

    public static Cimiento deSerializar(InputStream is) throws IOException, ClassNotFoundException {
        return (Cimiento) PilaDeCartas.deSerializar(is);
    }
}
