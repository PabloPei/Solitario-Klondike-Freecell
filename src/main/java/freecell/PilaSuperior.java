package freecell;

import modeloelementos.Carta;
import modeloelementos.PilaDeCartas;
import modelosolitario.Cimiento;

import java.io.*;

public class PilaSuperior extends PilaDeCartas {

    @Override
    public boolean agregarCarta(Carta carta){
        if(puedeAgregarCarta(carta)){
            push(carta);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean puedeAgregarCarta(Carta carta){
        return (this.isEmpty());
    }

    public static PilaSuperior deSerializar(InputStream is) throws IOException, ClassNotFoundException {
        return (PilaSuperior) PilaDeCartas.deSerializar(is);
    }
}
