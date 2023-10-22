package modelosolitario;

import modeloelementos.Palo;

import java.io.IOException;
import java.util.ArrayList;

public abstract class SolitarioConCimientos extends Solitario{

    protected final ArrayList<Cimiento> cimientos;


    public SolitarioConCimientos(int cantidadPilas){
        super(cantidadPilas);
        this.cimientos = new ArrayList<>();
        inciarCimientos();
    }

    public SolitarioConCimientos(int cantidadPilas, long semilla){
        super(cantidadPilas,semilla);
        this.cimientos = new ArrayList<>();
        inciarCimientos();
    }

    public SolitarioConCimientos(Mazo mazo, ArrayList<Pila> pilas, ArrayList<Cimiento> cimientos){
        super(mazo,pilas);
        this.cimientos = cimientos;
    }

    private void inciarCimientos() {
        for (Palo p : Palo.values()) {
            cimientos.add(new Cimiento());
        }
    }

    public ArrayList<Cimiento> getCimientos(){ return this.cimientos; }

    protected void guardarCimientos() throws IOException {
        String tituloPredeterminado = "CimientoFreeCell_";
        for(int i = 0; i < cimientos.size(); i++){
            cimientos.get(i).serializar(tituloPredeterminado + i + ".txt");
        }
    }

    public boolean verificarVictoria() {
        for (Cimiento cimiento : cimientos){
            if (!(cimiento.cimientoCompleto()))
                return false;
        }
        return true;
    }
}
