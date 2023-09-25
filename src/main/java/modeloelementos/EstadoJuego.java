package modeloelementos;

public enum EstadoJuego {
    GANADO, INICIADO, PERDIDO, JUGANDO;

    public boolean equals(EstadoJuego estado){
        return this.ordinal() == estado.ordinal();
    }
}
