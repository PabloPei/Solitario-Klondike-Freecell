package modeloelementos;

import java.io.*;
import java.util.Stack;

public class PilaDeCartas extends Stack<Carta> implements Serializable {

    public boolean agregarCarta(Carta carta) {
        if(puedeAgregarCarta(carta)) {
            push(carta);
            return true;
        }
        return false;
    }

    public Carta sacarCarta(boolean bocaAbajo) {
        if(isEmpty()) {
            return null;
        }
        Carta carta = pop();
        carta.setBocaAbajo(bocaAbajo);
        return carta;
    }

    public Carta verCarta() {
        if(isEmpty()) {
            return null;
        }
        return peek();
    }

    public boolean puedeAgregarCarta(Carta carta) {
        return (carta != null && !this.contains(carta));
    }

    public boolean equals(PilaDeCartas pila){
        if(this.size() != pila.size()) return false;
        boolean sonIguales = true;
        int indice = 0;
        while (sonIguales && indice < this.size()){
            if (this.get(indice) != pila.get(indice)) sonIguales = false;
            else indice++;
        }
        return sonIguales;
    }

    public void serializar(String nomArchivo) throws IOException {
        ObjectOutputStream o =
                new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nomArchivo)));
        o.writeObject(this);
        o.close();
    }

    public static PilaDeCartas deSerializar(String nomArchivo) throws IOException, ClassNotFoundException {
        ObjectInputStream o = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nomArchivo)));
        PilaDeCartas p = (PilaDeCartas) o.readObject();
        o.close();
        return p;
    }
}
