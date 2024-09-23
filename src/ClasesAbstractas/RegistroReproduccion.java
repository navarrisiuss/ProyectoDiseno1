package ClasesAbstractas;

import Clases.Episodio;
import Clases.Pelicula;
import Clases.RegistroReproduccionPelicula;
import Clases.RegistroReproduccionSerie;
import Clases.Serie;
import java.time.LocalDate;
import java.time.LocalTime;
import Clases.Perfil;

public abstract class RegistroReproduccion {

    public void registrarVisualizacion(ContenidoMultimedia contenido, Episodio episodio, LocalTime parteVista, Perfil perfil) {
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();

        switch (contenido) {
            case Pelicula pelicula -> {
                RegistroReproduccionPelicula registroPelicula = new RegistroReproduccionPelicula(pelicula, fechaActual, horaActual);
                perfil.getRegistroContenidoVisto().add(registroPelicula);
            }
            case Serie serie -> {
                RegistroReproduccionSerie registroSerie = new RegistroReproduccionSerie();
                registroSerie = registroSerie.obtenerRegistroSerie(serie, perfil);
                registroSerie.agregarEpisodioVisto(episodio, fechaActual, parteVista);
            }
            default -> {
            }
        }
    }
}
