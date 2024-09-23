package Clases;

import ClasesAbstractas.RegistroReproduccion;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RegistroReproduccionSerie extends RegistroReproduccion {
    private Serie serieVista;
    private List<Episodio> episodiosVistos = new ArrayList<>();
    private List<LocalDate> fechasUltimaVista = new ArrayList<>();
    private List<LocalTime> horasUltimaVista = new ArrayList<>();
    private Episodio ultimoEpisodioVisto;

    public RegistroReproduccionSerie(Serie serieVista) {
        this.serieVista = serieVista;
    }

    public RegistroReproduccionSerie() {
    }

    public Serie getSerieVista() {
        return serieVista;
    }

    public void setSerieVista(Serie serieVista) {
        this.serieVista = serieVista;
    }

    public List<Episodio> getEpisodiosVistos() {
        return episodiosVistos;
    }

    public void setEpisodiosVistos(List<Episodio> episodiosVistos) {
        this.episodiosVistos = episodiosVistos;
    }

    public List<LocalDate> getFechasUltimaVista() {
        return fechasUltimaVista;
    }

    public void setFechasUltimaVista(List<LocalDate> fechasUltimaVista) {
        this.fechasUltimaVista = fechasUltimaVista;
    }

    public List<LocalTime> getHorasUltimaVista() {
        return horasUltimaVista;
    }

    public void setHorasUltimaVista(List<LocalTime> horasUltimaVista) {
        this.horasUltimaVista = horasUltimaVista;
    }

    public Episodio getUltimoEpisodioVisto() {
        return ultimoEpisodioVisto;
    }

    public void setUltimoEpisodioVisto(Episodio ultimoEpisodioVisto) {
        this.ultimoEpisodioVisto = ultimoEpisodioVisto;
    }

    public void agregarEpisodioVisto(Episodio episodio, LocalDate fecha, LocalTime parteVista) {
        episodiosVistos.add(episodio);
        fechasUltimaVista.add(fecha);
        horasUltimaVista.add(parteVista);
        ultimoEpisodioVisto = episodio;
    }

    public RegistroReproduccionSerie obtenerRegistroSerie(Serie serie, Perfil perfil) {
        for (RegistroReproduccion registro : perfil.getRegistroContenidoVisto()) {
            if (registro instanceof RegistroReproduccionSerie) {
                RegistroReproduccionSerie registroSerie = (RegistroReproduccionSerie) registro;
                if (registroSerie.getSerieVista().equals(serie)) {
                    return registroSerie;
                }
            }
        }
        RegistroReproduccionSerie nuevoRegistroSerie = new RegistroReproduccionSerie(serie);
        perfil.getRegistroContenidoVisto().add(nuevoRegistroSerie);
        return nuevoRegistroSerie;
    }

    public List<Episodio> getEpisodiosVistos(Serie serie, Perfil perfil) {
        RegistroReproduccionSerie registroSerie = obtenerRegistroSerie(serie, perfil);
        return registroSerie.getEpisodiosVistos();
    }

    public Episodio getUltimoEpisodioVisto(Serie serie, Perfil perfil) {
        RegistroReproduccionSerie registroSerie = obtenerRegistroSerie(serie, perfil);
        return registroSerie.getUltimoEpisodioVisto();
    }
}