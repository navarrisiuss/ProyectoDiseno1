package Clases;

import ClasesAbstractas.ContenidoMultimedia;
import java.util.List;

public class Pelicula extends ContenidoMultimedia {
    private String director;
    private List<String> elenco;
    private boolean isPago;
    private double costo;

    public Pelicula(Catalogo catalogo, String director, List<String> elenco, double costo) {
        this.director = director;
        this.elenco = elenco;
        this.costo = costo;
        verificarIsPago();
        catalogo.addContenidoMultimedia(this);
    }

    private void verificarIsPago() {
        if (this.costo == 0) {
            this.isPago = false;
        }
        else {
            this.isPago = true;
        }
    }

    public double getCosto() {
        return costo;
    }

    public boolean isPago() {
        return isPago;
    }

    @Override
    public String toString() {
        return "Pelicula{\n" +
            "    titulo='" + this.getTitulo() + "',\n" +
            "    descripcion='" + this.getDescripcion() + "',\n" +
            "    categorias=" + this.getCategorias() + ",\n" +
            "    fechaLanzamiento=" + this.getFechaLanzamiento() + ",\n" +
            "    restriccionEdad='" + this.getRestriccionEdad() + "',\n" +
            "    estrellas=" + this.getEstrellas() + ",\n" +
            "    director='" + director + "',\n" +
            "    elenco=" + elenco + ",\n" +
            "    isPago=" + isPago + "\n" +
            '}';
    }

    
}
