package modelosolitario;

import modeloelementos.Carta;
import modeloelementos.PilaDeCartas;

    public class Movimientos {
        public static boolean moverCarta(PilaDeCartas origen, PilaDeCartas destino) {
            Carta cartaSacada = origen.pop();
            if (!destino.agregarCarta(cartaSacada)){
                origen.agregarCarta(cartaSacada);
                return false;
            }
            return true;
        }

        public boolean moverConjuntoDeCartas(PilaDeCartas origen, PilaDeCartas destino, Carta primeraCarta){
            PilaDeCartas pilaAux = new PilaDeCartas();
            do {
                pilaAux.agregarCarta(origen.pop());
            } while(primeraCarta != origen.peek());
            if(!destino.agregarCarta(pilaAux.pop())){
                while (!pilaAux.isEmpty()) {
                    origen.agregarCarta(pilaAux.pop());
                }
                return false;
            }
            while (!pilaAux.isEmpty()) {
                destino.agregarCarta(pilaAux.pop());
            }
            return true;
        }
    }
