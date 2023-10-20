package freecell;

import modeloelementos.Carta;
import modeloelementos.PilaDeCartas;

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
    public static PilaSuperior deSerializar(String nomArchivo) throws IOException, ClassNotFoundException {
        ObjectInputStream o = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nomArchivo)));
        PilaSuperior p = (PilaSuperior) o.readObject();
        o.close();
        return p;
    }
}
