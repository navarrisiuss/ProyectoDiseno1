package Clases;

import ClasesAbstractas.ContenidoMultimedia;
import Interfaces.GenerarEnlacePublico;

import java.util.ArrayList;
import java.util.List;

public class ListaPersonalizada implements GenerarEnlacePublico {
    private String nombre;
    private List<ContenidoMultimedia> listaContenidoMultimedia = new ArrayList<>();
    private String enlacePublico;

    public ListaPersonalizada(String nombre) {
        this.nombre = nombre;
        generarEnlacePublico();
    }

    public void addContenido(ContenidoMultimedia contenidoMultimedia) {
        this.listaContenidoMultimedia.add(contenidoMultimedia);
    }

    public void removeContenido(ContenidoMultimedia contenidoMultimedia) {
        for (ContenidoMultimedia m : this.listaContenidoMultimedia) {
            if (m.equals(contenidoMultimedia)) {
                this.listaContenidoMultimedia.remove(contenidoMultimedia);
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ContenidoMultimedia> getListaContenidoMultimedia() {
        return listaContenidoMultimedia;
    }

    public void setListaContenidoMultimedia(List<ContenidoMultimedia> listaContenidoMultimedia) {
        this.listaContenidoMultimedia = listaContenidoMultimedia;
    }

    public String getEnlacePublico() {
        return enlacePublico;
    }

    public void setEnlacePublico(String enlacePublico) {
        this.enlacePublico = enlacePublico;
    }

    @Override
    public void generarEnlacePublico() {

    }
}
