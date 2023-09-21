package GeneralElementos;

public enum ValorCarta {
    JOKER, AS, DOS, TRES, CUATRO, CINCO, SEIS, SIETE, OCHO,
    NUEVE, DIEZ, SOTA, REINA, REY;

    public String toString(){
        return this.name();
    }
    public static ValorCarta getValorCorrespondiente(int valor){
        ValorCarta correspondiente = ValorCarta.JOKER;
        for (ValorCarta v : ValorCarta.values()){
            if (v.ordinal() == valor) correspondiente = v;
        }
        return correspondiente;
    }
    public boolean equals (ValorCarta valor){
        return this.ordinal() == valor.ordinal();
    }
}
