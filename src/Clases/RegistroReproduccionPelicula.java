package Clases;

import ClasesAbstractas.RegistroReproduccion;

import java.time.LocalDate;
import java.time.LocalTime;

public class RegistroReproduccionPelicula extends RegistroReproduccion {
    private Pelicula peliculaVista;
    private LocalDate fechaUltimaVista;
    private LocalTime horaUltimaVista;
}
