package modelosolitario;

import modeloelementos.Carta;
import modeloelementos.PilaDeCartas;
import modeloelementos.ValorCarta;

public class Pila extends PilaDeCartas {

    public Pila() { super(); }

    public Pila(PilaDeCartas pila){
        while (!pila.isEmpty()){
            agregarCarta(pila.sacarCarta(true));
        }
    }

    public boolean puedeAgregarCarta(Carta carta) {
        // Verifica las condiciones genericas de una pila
        if ( !super.puedeAgregarCarta(carta)) return false;
        // Verifica si la pila está vacía y si la carta es un Rey (valor 13) para iniciar la pila.
        if (isEmpty()){
            return (carta.getValor() == ValorCarta.REY);
        }else {
            Carta tope = this.peek();
            // Verifica si la carta es válida para agregar en la pila según las reglas del solitario.
            return (Carta.esColorAlternado(tope, carta) && Carta.esValorSiguiente(carta, tope));
        }
    }

    public Carta sacarCarta(boolean bocaAbajo) {
        Carta carta = super.sacarCarta(bocaAbajo);
        if ( ! this.isEmpty() ){
            Carta tope = this.peek();
            tope.setBocaAbajo(false);
        }
        return carta;
    }
}