package ui;

import modelosolitario.Pila;
import javafx.scene.layout.FlowPane;
import java.util.ArrayList;
import javafx.geometry.Insets;


public class VistaPilas extends FlowPane {

    private int cantidadPilas;

    public VistaPilas(ArrayList<Pila> pilas){
        this.cantidadPilas = pilas.size();
        setPadding(new Insets(10));
        setHgap(10);
        getChildren().clear();

        for (int i = 0; i < cantidadPilas; i++) {
            VistaPila vistaPila = new VistaPila(pilas.get(i));
            getChildren().add(vistaPila);
        }
    }
}
