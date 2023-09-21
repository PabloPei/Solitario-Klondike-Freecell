package GeneralSolitario;

public enum EstadoJuego {
    GANADO, PERDIDO, JUGANDO;

    public boolean equals(EstadoJuego estado){
        return this.ordinal() == estado.ordinal();
    }
}
