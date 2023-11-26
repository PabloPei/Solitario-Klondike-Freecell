package modelosolitario;

import modeloelementos.PilaDeCartas;

import java.io.*;

public class Descarte extends PilaDeCartas {

    private final int cantidadCartas = 1;

    public Descarte() { super(); }

    public int getCantidadCartas(){
        return this.cantidadCartas;
    }

    public static Descarte deSerializar(InputStream is) throws IOException, ClassNotFoundException {
        return (Descarte) PilaDeCartas.deSerializar(is);
    }
}
