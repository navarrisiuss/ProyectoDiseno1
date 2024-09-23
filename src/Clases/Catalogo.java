package Clases;

import ClasesAbstractas.ContenidoMultimedia;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<ContenidoMultimedia> contenidoMultimedia = new ArrayList<>();

    public Catalogo() {

    }

    public List<ContenidoMultimedia> getContenidoMultimedia() {
        return contenidoMultimedia;
    }

    public void addContenidoMultimedia(ContenidoMultimedia contenidoMultimedia) {
        this.contenidoMultimedia.add(contenidoMultimedia);
    }

    public void deleteContenidoMultimedia(ContenidoMultimedia contenidoMultimedia) {
        for (ContenidoMultimedia multimedia : this.contenidoMultimedia) {
            if (multimedia.equals(contenidoMultimedia)) {
                this.contenidoMultimedia.remove(multimedia);
            }
        }
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "contenidoMultimedia=" + contenidoMultimedia +
                '}';
    }
}
