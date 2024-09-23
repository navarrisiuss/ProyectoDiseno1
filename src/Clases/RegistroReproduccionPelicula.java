package Clases;

import ClasesAbstractas.RegistroReproduccion;
import java.time.LocalDate;
import java.time.LocalTime;

public class RegistroReproduccionPelicula extends RegistroReproduccion {
    private Pelicula peliculaVista;
    private LocalDate fechaUltimaVista;
    private LocalTime horaUltimaVista;

    public RegistroReproduccionPelicula(Pelicula peliculaVista, LocalDate fechaUltimaVista, LocalTime horaUltimaVista) {
        this.peliculaVista = peliculaVista;
        this.fechaUltimaVista = fechaUltimaVista;
        this.horaUltimaVista = horaUltimaVista;
    }

    public Pelicula getPeliculaVista() {
        return peliculaVista;
    }

    public void setPeliculaVista(Pelicula peliculaVista) {
        this.peliculaVista = peliculaVista;
    }

    public LocalDate getFechaUltimaVista() {
        return fechaUltimaVista;
    }

    public void setFechaUltimaVista(LocalDate fechaUltimaVista) {
        this.fechaUltimaVista = fechaUltimaVista;
    }

    public LocalTime getHoraUltimaVista() {
        return horaUltimaVista;
    }

    public void setHoraUltimaVista(LocalTime horaUltimaVista) {
        this.horaUltimaVista = horaUltimaVista;
    }

    public void actualizarUltimaVista(LocalDate fecha, LocalTime hora) {
        this.fechaUltimaVista = fecha;
        this.horaUltimaVista = hora;
    }
}
