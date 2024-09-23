package ClasesAbstractas;

import Interfaces.Visualizacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class ContenidoMultimedia implements Visualizacion {
    private String titulo;
    private String descripcion;
    private List<String> categorias = new ArrayList<>();
    private LocalDate fechaLanzamiento;
    private String restriccionEdad;
    private int estrellas;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getRestriccionEdad() {
        return restriccionEdad;
    }

    public void setRestriccionEdad(String restriccionEdad) {
        this.restriccionEdad = restriccionEdad;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    @Override
    public String toString() {
        return "ContenidoMultimedia{" +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", categorias=" + categorias + '\'' +
                ", fechaLanzamiento=" + fechaLanzamiento + '\'' +
                ", restriccionEdad='" + restriccionEdad + '\'' +
                ", estrellas=" + estrellas +
                '}';
    }
}
