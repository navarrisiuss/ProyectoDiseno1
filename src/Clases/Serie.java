package Clases;

import ClasesAbstractas.ContenidoMultimedia;
import java.util.List;

public class Serie extends ContenidoMultimedia {
    private List<Temporada> temporadas;

    public Serie(Catalogo catalogo, List<Temporada> temporadas) {
        this.temporadas = temporadas;
        catalogo.addContenidoMultimedia(this);
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
        return "Serie{\n" +
            "    titulo='" + this.getTitulo() + "',\n" +
            "    descripcion='" + this.getDescripcion() + "',\n" +
            "    categorias=" + this.getCategorias() + ",\n" +
            "    fechaLanzamiento=" + this.getFechaLanzamiento() + ",\n" +
            "    restriccionEdad='" + this.getRestriccionEdad() + "',\n" +
            "    estrellas=" + this.getEstrellas() + ",\n" +
            "    temporadas=" + temporadas + "\n" +
            '}';
    }
}