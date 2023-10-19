package modeloelementos;

public enum ValorCarta {
    AS(1), DOS(2), TRES(3), CUATRO(4), CINCO(5), SEIS(6), SIETE(7), OCHO(8),
    NUEVE(9), DIEZ(10), SOTA(11), REINA(12), REY(13);

    private final int value;

    ValorCarta(int value) {
        this.value = value;
    }

    public int getValor() {
        return value;
    }

    public ValorCarta siguienteValor(){
        if (this == REY) {
            return null;
        }
        return ValorCarta.values()[this.ordinal() + 1];
    }
}
