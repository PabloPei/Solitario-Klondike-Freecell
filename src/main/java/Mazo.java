import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Mazo {
    private List<Carta> cartas = new ArrayList<>();
    private final int cantidadCartas;
    public Mazo(){
        this.cantidadCartas = 52;
        for(int i = 0; i < cantidadCartas; i++){
            switch(i%4){
                case 0 -> cartas.add(new Carta((i+1)%13, Palo.DIAMANTE));
                case 1 -> cartas.add(new Carta((i+1)%13, Palo.CORAZON));
                case 2 -> cartas.add(new Carta((i+1)%13, Palo.TREBOL));
                default -> cartas.add(new Carta((i+1)%13, Palo.PICA));
            }
        }
    }

    public boolean equals(Mazo mazo){
        boolean sonIguales = true;
        int indice = 0;
        while (sonIguales && indice < cantidadCartas){
            if(cartas.get(indice).equals(mazo.cartas.get(indice))) indice++;
            else sonIguales = false;
        }
        return sonIguales;
    }
    public int getTamanio(){
        return cantidadCartas;
    }

    public List<Carta> mezclar(){
        List<Carta> auxiliar = new ArrayList<>();
        int numero;
        while (!cartas.isEmpty()){
            numero = (int)(Math.random()*(cartas.size()));
            auxiliar.add(cartas.get(numero));
            cartas.remove(numero);
        }
        cartas = auxiliar;
        return cartas;
    }

    public String repartirMazoCompleto(){
        String mazoCompleto = "";
        for (int i = 0; i < cartas.size(); i++){
            mazoCompleto = mazoCompleto + cartas.get(i).mostrarCarta() + "\n";
        }
        return mazoCompleto;
    }
    public void repartirMazo(){
        List<Stack> pilas = new ArrayList<>();
        for (int i = 0; i < 7; i++){
            Stack <Carta> pila = new Stack<>();
            for (int j = 0; j< i + 1; j++) {
                Carta carta = this.sacarCarta();
                if (j == i) {
                    carta.mostrarCarta();
                }
                pila.push(carta);
            }
            pilas.add(pila);
        }
    }

}

