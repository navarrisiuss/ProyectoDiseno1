package Clases;

import ClasesAbstractas.ContenidoMultimedia;
import Interfaces.GenerarEnlacePublico;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder cadena = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(caracteres.length());
            cadena.append(caracteres.charAt(index));
        }
        this.enlacePublico = cadena.toString();
    }

    @Override
    public String toString() {
        return "ListaPersonalizada{" +
                "nombre='" + nombre + '\'' +
                ", listaContenidoMultimedia=" + listaContenidoMultimedia +
                ", enlacePublico='" + enlacePublico + '\'' +
                '}';
    }
}
