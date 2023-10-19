package modeloelementos;

import java.io.*;

/**
 * La clase Carta representa una carta de una baraja de cartas estándar (Francesa,
 * Inglesa, Alemana, etc). Cada carta tiene un valor desde el As (valor=1), hasta
 * el rey (valor=13) y un palo que toma los valores de Corazones, Diamantes,
 * Tréboles o Picas.
 */

public class Carta implements Serializable {

    private final ValorCarta valor;

    private final Palo palo;

    private boolean bocaAbajo;

    public Carta(ValorCarta valor, Palo palo, boolean bocaAbajo){

        this.valor = valor;
        this.palo = palo;
        this.bocaAbajo = bocaAbajo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Carta carta = (Carta) obj;
        return valor == carta.valor && palo == carta.palo;
    }

    @Override
    public String toString() {
        this.setBocaAbajo(false);
        return valor.toString() + " - " + palo.toString();
    }

    public void voltear(){
        bocaAbajo = !bocaAbajo;
    }

    public static boolean esValorSiguiente(Carta carta1, Carta carta2) {
        return (carta1.getValor().siguienteValor() == carta2.getValor());
    }

    public static boolean esMismoPalo(Carta carta1, Carta carta2) {
        return (carta1.getPalo() == carta2.getPalo());
    }

    public static boolean esColorAlternado(Carta carta1, Carta carta2) {
        return (carta1.getPalo().getColor() != carta2.getPalo().getColor());
    }

    //// Getters & Setters ////

    public void setBocaAbajo(boolean bocaAbajo){
        this.bocaAbajo = bocaAbajo;
    }

    public boolean getBocaAbajo(){
        return bocaAbajo;
    }

    public ValorCarta getValor(){
        return valor;
    }

    public Palo getPalo(){
        return palo;
    }

    public Color getColor() { return getPalo().getColor(); }

    public void serializar(String nomArchivo) throws IOException {
        ObjectOutputStream o =
                new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nomArchivo)));
        o.writeObject(this);
        o.close();
    }

    public static Carta deSerializar(String nomArchivo) throws IOException, ClassNotFoundException {
        ObjectInputStream o = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nomArchivo)));
        Carta c = (Carta) o.readObject();
        o.close();
        return c;
    }


}


