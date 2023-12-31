package freecell;

import modeloelementos.Carta;
import modeloelementos.PilaDeCartas;
import java.io.*;

public class PilaSuperior extends PilaDeCartas {

    @Override
    public boolean puedeAgregarCarta(Carta carta){
        return (this.isEmpty());
    }

    public static PilaSuperior deSerializar(InputStream is) throws IOException, ClassNotFoundException {
        return (PilaSuperior) PilaDeCartas.deSerializar(is);
    }
}