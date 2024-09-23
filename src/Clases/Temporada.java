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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = episodios;
    }

    public Episodio getUltimoEpisodio() {
        if (episodios != null && !episodios.isEmpty()) {
            return episodios.get(episodios.size() - 1);
        }
        return null;
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