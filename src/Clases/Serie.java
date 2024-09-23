package Clases;

import ClasesAbstractas.ContenidoMultimedia;
import java.util.List;

public class Serie extends ContenidoMultimedia {
    private List<Temporada> temporadas;

    public Serie(List<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(List<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

    public Episodio getUltimoEpisodio() {
        if (temporadas != null && !temporadas.isEmpty()) {
            Temporada ultimaTemporada = temporadas.get(temporadas.size() - 1);
            return ultimaTemporada.getUltimoEpisodio();
        }
        return null;
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