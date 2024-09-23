package Clases;

import ClasesAbstractas.ContenidoMultimedia;

import java.util.List;

public class Serie extends ContenidoMultimedia {
    private List<Temporada> temporadas;

    public Serie(Catalogo catalogo, List<Temporada> temporadas) {
        this.temporadas = temporadas;
        catalogo.addContenidoMultimedia(this);
    }

    @Override
    public void ver(Cuenta cuenta) {

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
