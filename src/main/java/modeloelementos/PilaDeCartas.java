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

        if (this.size() != pila.size()) {
            return false;
        }
        while (!this.isEmpty() && !pila.isEmpty()) {
            Carta carta1 = this.pop();
            Carta carta2 = pila.pop();

            if (!carta1.equals(carta2)) {
                return false;
            }
        }
        return true;
    }

    public void serializar(OutputStream os) throws IOException {
        ObjectOutputStream o =
                new ObjectOutputStream(new BufferedOutputStream(os));
        o.writeObject(this);
        o.close();
    }

    public static PilaDeCartas deSerializar(InputStream is) throws IOException, ClassNotFoundException {
        ObjectInputStream o = new ObjectInputStream(new BufferedInputStream(is));
        PilaDeCartas p = (PilaDeCartas) o.readObject();
        o.close();
        return p;
    }

    public PilaDeCartas invertir() {
        PilaDeCartas pilaInvertida = new PilaDeCartas();
        PilaDeCartas copia = (PilaDeCartas) this.clone();
        while (!copia.isEmpty()) {
            pilaInvertida.push(copia.pop());
        }
        return  pilaInvertida;
    }
}
