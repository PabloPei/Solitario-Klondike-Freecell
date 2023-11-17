package ui.freecell;

import freecell.PilaSuperior;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import modeloelementos.PilaDeCartas;
import modelosolitario.Cimiento;
import ui.Configuracion;
import ui.VistaCarta;
import ui.VistaPilaDeCartas;

public class VistaPilaSuperior extends VistaPilaDeCartas {
    private static final int PADDING = 2;

    public VistaPilaSuperior(PilaSuperior pilaSuperior){
        super(pilaSuperior, false);
        if (pilaSuperior.isEmpty()){
            setStyle(Configuracion.ESTILO_BORDE);
            setPadding(new Insets(PADDING));
            setPrefSize(Configuracion.ANCHO_VENTANA/13,Configuracion.ALTO_VENTANA/6);
            final ImageView imagen = new ImageView(VistaCarta.getReverso());
            imagen.setVisible(false);
            getChildren().add(imagen);
        }
    }
}
