package ClasesAbstractas;

import Clases.Episodio;
import Clases.Pelicula;
import Clases.RegistroReproduccionPelicula;
import Clases.RegistroReproduccionSerie;
import Clases.Serie;
import java.time.LocalDate;
import java.time.LocalTime;

public abstract class RegistroReproduccion {

    public void registrarVisualizacionSerie(Serie serie, Episodio episodio, LocalTime parteVista) {
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();
        RegistroReproduccionSerie registroSerie = new RegistroReproduccionSerie();
        registroSerie.agregarEpisodioVisto(episodio, fechaActual, parteVista);
    }

    public void registrarVisualizacionPelicula(Pelicula pelicula, LocalTime parteVista) {
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();
        RegistroReproduccionPelicula registroPelicula = new RegistroReproduccionPelicula(pelicula, fechaActual, horaActual);
        registroPelicula.setPeliculaVista(pelicula);
        registroPelicula.actualizarUltimaVista(fechaActual, horaActual);
    }

}

