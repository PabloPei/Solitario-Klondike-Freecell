package modelosolitario;

import modeloelementos.Palo;

import java.io.IOException;
import java.lang.reflect.Array;
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


    public boolean verificarVictoria() {
        for (Cimiento cimiento : cimientos){
            if (!(cimiento.cimientoCompleto()))
                return false;
        }
        return true;
    }

    public ArrayList<Cimiento> getCimientos(){ return this.cimientos; }
}
