package modelosolitario;

import modeloelementos.Palo;
import modeloelementos.PilaDeCartas;
import modeloelementos.ValorCarta;
import modeloelementos.Carta;
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

    public void agregarDescarte(Descarte descarte){
        if (descarte.isEmpty()) return;

        Mazo mazoTemp = new Mazo();
        while (!this.isEmpty()) {
            mazoTemp.agregarCarta(this.sacarCarta(true));
        }

        while (! descarte.isEmpty()) {
            mazoTemp.agregarCarta(descarte.sacarCarta(true));
        }

        while (!mazoTemp.isEmpty()) {
            this.agregarCarta(mazoTemp.sacarCarta(true));
        }
    }
}