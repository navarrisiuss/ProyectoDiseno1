package Clases;

import java.time.LocalDate;
import java.util.List;

public class Temporada {
    private int numero;
    private LocalDate fechaLanzamiento;
    private List<Episodio> episodios;

    public Temporada(int numero, LocalDate fechaLanzamiento, List<Episodio> episodios) {
        this.numero = numero;
        this.fechaLanzamiento = fechaLanzamiento;
        this.episodios = episodios;
    }

    @Override
    public String toString() {
        return "Temporada{" +
                "numero=" + numero +
                ", fechaLanzamiento=" + fechaLanzamiento +
                ", episodios=" + episodios +
                '}';
    }
}
