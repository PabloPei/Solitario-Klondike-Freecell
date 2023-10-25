package klondike;

import modeloelementos.Carta;
import modelosolitario.*;

import java.io.*;
import java.util.ArrayList;


public class SolitarioKlondike extends SolitarioConCimientos implements Serializable{

    public static final int CANTIDAD_PILAS = 7;
    private  static final String NOMBRE_ARCHIVO = "PilaKlondike_";
    private Descarte descarte;

    public SolitarioKlondike(){
        super(CANTIDAD_PILAS);
        this.descarte = new Descarte();
    }

    public SolitarioKlondike(long semilla){
        super(CANTIDAD_PILAS, semilla);
        this.descarte = new Descarte();
    }

    public SolitarioKlondike(Mazo mazo, ArrayList<Pila> pilas, ArrayList<Cimiento> cimientos, Descarte descarte){
        super(mazo,pilas,cimientos);
        this.descarte = descarte;
    }

    @Override
    public void repartirPilas() {
        int cartasPorPila = 1;

        for (Pila pila : this.getPilas()) {
            while (pila.size() < cartasPorPila) {
                Carta cartaAux = this.getMazo().sacarCarta(true);
                pila.push(cartaAux);
            }
            pila.peek().voltear();
            cartasPorPila++;
        }
    }

    public boolean robarCartasDelMazo() {
        Mazo mazo = getMazo();
        Descarte descarte = getDescarte();

        if (descarte.isEmpty() && mazo.isEmpty())
            return false;

        mazo.agregarDescarte(descarte);

        for (int i = 0; i < descarte.getCantidadCartas(); i++) {
            Carta carta = mazo.sacarCarta(false);
            if( ! descarte.agregarCarta(carta))
                break;
        }
        sumarMovimiento();
        return true;
    }

    public Descarte getDescarte(){ return this.descarte; }

    private void guardarDescarte() throws IOException {
        this.descarte.serializar( "DescarteKlondike.txt");
    }
    public void guardarEstadoJuego() throws IOException {
        super.guardarEstadoJuego();
        guardarPilas(NOMBRE_ARCHIVO, CANTIDAD_PILAS);
        guardarCimientos();
        guardarDescarte();
    }

    private void cargarDescarte() throws IOException, ClassNotFoundException {
        this.descarte.clear();
        this.descarte = Descarte.deSerializar("DescarteKlondike.txt");
    }

    public void serializar(String nomArchivo) throws IOException {
        ObjectOutputStream o =
                new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nomArchivo)));
        o.writeObject(this);
        o.close();
    }

    public static SolitarioKlondike deSerializar(String nomArchivo) throws IOException, ClassNotFoundException {
        ObjectInputStream o = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nomArchivo)));
        SolitarioKlondike p = (SolitarioKlondike) o.readObject();
        o.close();
        return p;
    }

    public void cargarJuegoExistente() throws IOException, ClassNotFoundException {
        super.cargarJuegoExistente();
        cargarCimientos();
        cargarDescarte();
        cargarPilas(NOMBRE_ARCHIVO, CANTIDAD_PILAS);
    }


}
