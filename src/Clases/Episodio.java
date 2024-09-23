package Clases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Episodio {
    private int numEpisodio;
    private String nombre;
    private String director;
    private List<String> elenco;
    private LocalDate fechaLanzamiento;
    private LocalTime duracion;

    public Episodio(String nombre, String director, List<String> elenco, LocalDate fechaLanzamiento, LocalTime duracion) {
        this.nombre = nombre;
        this.director = director;
        this.elenco = elenco;
        this.fechaLanzamiento = fechaLanzamiento;
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Episodio{" +
                "nombre='" + nombre + '\'' +
                ", director='" + director + '\'' +
                ", elenco=" + elenco +
                ", fechaLanzamiento=" + fechaLanzamiento +
                ", duracion=" + duracion +
                '}';
    }
}
