package GeneralSolitario;

import GeneralElementos.Carta;
import GeneralElementos.Palo;
import GeneralElementos.ValorCarta;

import java.util.Collections;
import java.util.Stack;

public enum EstadoJuego {
    GANADO, PERDIDO, JUGANDO;

    public boolean equals(EstadoJuego estado){
        return this.ordinal() == estado.ordinal();
    }
}
