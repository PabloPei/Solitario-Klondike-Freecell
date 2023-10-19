package modelosolitario;

import modeloelementos.PilaDeCartas;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Descarte extends PilaDeCartas{

    private final int cantidadCartas = 1;

    public Descarte(){ super(); }

    public int getCantidadCartas(){
        return this.cantidadCartas;
    }

    public static Descarte deSerializar(String nomArchivo) throws IOException, ClassNotFoundException {
        ObjectInputStream o = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nomArchivo)));
        Descarte d = (Descarte) o.readObject();
        o.close();
        return d;
    }
}
