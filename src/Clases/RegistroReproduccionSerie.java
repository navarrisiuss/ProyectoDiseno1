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
}
