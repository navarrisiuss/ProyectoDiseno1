package Clases;

import ClasesAbstractas.ContenidoMultimedia;

import java.util.List;

public class Pelicula extends ContenidoMultimedia {
    private String director;
    private List<String> elenco;
    private boolean isPago;

    public Pelicula(String director, List<String> elenco, boolean isPago) {
        this.director = director;
        this.elenco = elenco;
        this.isPago = isPago;
    }

    public boolean isPago() {
        return isPago;
    }


    @Override
    public void ver(Cuenta cuenta) {

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
