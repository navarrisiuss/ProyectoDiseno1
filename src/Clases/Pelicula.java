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
        return "Pelicula{" +
                "titulo='" + this.getTitulo() + "\'" +
                ", descripcion='" + this.getDescripcion() + "\'" +
                ", categorias=" + this.getCategorias() +
                ", fechaLanzamiento=" + this.getFechaLanzamiento() +
                ", restriccionEdad='" + this.getRestriccionEdad() + "\'" + '\n' +
                "estrellas=" + this.getEstrellas() +
                ", director='" + director + "\'" +
                ", elenco=" + elenco +
                ", isPago=" + isPago +
                '}'+ "\n";
    }

    
}
