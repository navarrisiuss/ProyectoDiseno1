package Clases;

import ClasesAbstractas.ContenidoMultimedia;
import java.util.List;

public class Serie extends ContenidoMultimedia {
    private List<Temporada> temporadas;

    public Serie(List<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "titulo='" + this.getTitulo() + "\'" +
                ", descripcion='" + this.getDescripcion() + "\'" +
                ", categorias=" + this.getCategorias() +
                ", fechaLanzamiento=" + this.getFechaLanzamiento() +
                ", restriccionEdad='" + this.getRestriccionEdad() + "\'" + '\n' +
                "estrellas=" + this.getEstrellas() +
                "temporadas=" + temporadas +
                '}';
    }
}
