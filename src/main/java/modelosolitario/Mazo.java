package modelosolitario;

import modeloelementos.Palo;
import modeloelementos.PilaDeCartas;
import modeloelementos.ValorCarta;
import modeloelementos.Carta;

import java.io.*;
import java.util.Collections;
import java.util.Random;


public class Mazo extends PilaDeCartas {

    public Mazo(){
        for( Palo palo : Palo.values() ) {
            for (ValorCarta valor : ValorCarta.values()) {
                Carta carta = new Carta(valor, palo, true);
                agregarCarta(carta);
            }
        }
    }

    public Mazo(PilaDeCartas mazo){
        while (!mazo.isEmpty()){
            agregarCarta(mazo.sacarCarta(true));
        }
    }

    public void mezclar() {
        Collections.shuffle(this);
    }

    public void mezclar(long semilla ) {
        var seed = new Random(semilla);
        Collections.shuffle(this, seed);
    }

    private static void pasarCartasDeUnMazoAOtro(Mazo mazoViejo, Mazo mazoNuevo){
        while (!mazoViejo.isEmpty()){
            mazoNuevo.agregarCarta(mazoViejo.sacarCarta(true));
        }
    }

    private void agregarCartasDesdeDescarte(Descarte descarte){
        while (!descarte.isEmpty()){
            this.agregarCarta(descarte.sacarCarta(true));
        }
    }

    public void agregarDescarte(Descarte descarte){
        if (descarte.isEmpty()) return;

        Mazo mazoTemp = new Mazo();
        mazoTemp.removeAllElements();
        pasarCartasDeUnMazoAOtro(this, mazoTemp);
        mazoTemp.agregarCartasDesdeDescarte(descarte);
        pasarCartasDeUnMazoAOtro(mazoTemp, this);
    }

    public static Mazo deSerializar(InputStream is) throws IOException, ClassNotFoundException {
        return (Mazo) PilaDeCartas.deSerializar(is);
    }



}