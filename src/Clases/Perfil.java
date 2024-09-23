package Clases;

import ClasesAbstractas.ContenidoMultimedia;
import ClasesAbstractas.RegistroReproduccion;
import Enums.RestriccionEdad;
import Interfaces.Busqueda;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Perfil implements Busqueda {
    private String nombre;
    private String icono;
    private String lenguaje;
    private boolean isPerfilInfantil;
    private List<ContenidoMultimedia> listaFavoritos = new ArrayList<>();
    private List<ListaPersonalizada> listasPersonalizadas = new ArrayList<>();
    private List<RegistroReproduccion> registroContenidoVisto = new ArrayList<>();

    public Perfil(String nombre, String icono, String lenguaje, boolean isPerfilInfantil) {
        this.nombre = nombre;
        this.icono = icono;
        this.lenguaje = lenguaje;
        this.isPerfilInfantil = isPerfilInfantil;
    }

    private boolean isContenidoInfantil(ContenidoMultimedia contenidoMultimedia) {
        if (this.isPerfilInfantil) {
            String restriccionContenido = contenidoMultimedia.getRestriccionEdad();
            String restriccionAdolescentes = RestriccionEdad.ADOLESCENTES.name();
            String restriccionAdultos = RestriccionEdad.ADULTOS.name();
            return !(restriccionContenido.equals(restriccionAdolescentes) || restriccionContenido.equals(restriccionAdultos));
        } else {
            return true;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public boolean isPerfilInfantil() {
        return isPerfilInfantil;
    }

    public void setPerfilInfantil(boolean perfilInfantil) {
        isPerfilInfantil = perfilInfantil;
    }

    public List<ContenidoMultimedia> getListaFavoritos() {
        return listaFavoritos;
    }

    public void setListaFavoritos(List<ContenidoMultimedia> listaFavoritos) {
        this.listaFavoritos = listaFavoritos;
    }

    public List<ListaPersonalizada> getListasPersonalizadas() {
        return listasPersonalizadas;
    }

    public void setListasPersonalizadas(List<ListaPersonalizada> listasPersonalizadas) {
        this.listasPersonalizadas = listasPersonalizadas;
    }

    public List<RegistroReproduccion> getRegistroContenidoVisto() {
        return registroContenidoVisto;
    }

    public void setRegistroContenidoVisto(List<RegistroReproduccion> registroContenidoVisto) {
        this.registroContenidoVisto = registroContenidoVisto;
    }

    public void addListaFavoritos(ContenidoMultimedia contenidoMultimedia) {
        if (isContenidoInfantil(contenidoMultimedia)) {
            this.listaFavoritos.add(contenidoMultimedia);
        } else {
            System.out.println("No se puede agregar, ya que el perfil es infantil");
        }
    }

    public void crearListaPersonalizada(String nombre) {
        ListaPersonalizada lista = new ListaPersonalizada(nombre);
        this.listasPersonalizadas.add(lista);
    }

    public void agregarAListaPersonalizada(String nombre, ContenidoMultimedia contenidoMultimedia) {
        boolean agregada = false;
        if (isContenidoInfantil(contenidoMultimedia)) {
            for (ListaPersonalizada l : this.listasPersonalizadas) {
                if (l.getNombre().equals(nombre)) {
                    l.addContenido(contenidoMultimedia);
                    agregada = true;
                }
            }
        }
        if (agregada) {
            System.out.println("Contenido Agregado");
        } else {
            System.out.println("Error al agregar");
        }
    }

    private ContenidoMultimedia buscar(Catalogo catalogo, String nombre) {
        List<ContenidoMultimedia> listaCatalogo = catalogo.getContenidoMultimedia();
        for (ContenidoMultimedia contenidoMultimedia : listaCatalogo) {
            String nombreContenidoMultimedia = contenidoMultimedia.getTitulo();
            if (nombreContenidoMultimedia.equals(nombre)) {
                return contenidoMultimedia;
            }
        }
        return null;
    }

    @Override
    public void buscarContenido(Catalogo catalogo, String nombre) {
        ContenidoMultimedia contenidoBuscado = buscar(catalogo, nombre);
        if (contenidoBuscado == null) {
            System.out.println("Contenido no encontrado");
        } else {
            if (this.isPerfilInfantil && isContenidoInfantil(contenidoBuscado)) {
                System.out.println(contenidoBuscado.toString());
            } else {
                if (this.isPerfilInfantil && !isContenidoInfantil(contenidoBuscado)) {
                    System.out.println("Contenido no apto para niños!");
                } else {
                    System.out.println(contenidoBuscado.toString());
                }
            }
        }
    }

    public void registrarVisualizacion(ContenidoMultimedia contenido, Episodio episodio, LocalTime parteVista) {
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();

        switch (contenido) {
            case Pelicula pelicula -> {
                RegistroReproduccionPelicula registroPelicula = new RegistroReproduccionPelicula(pelicula, fechaActual, horaActual);
                registroContenidoVisto.add(registroPelicula);
            }
            case Serie serie -> {
                RegistroReproduccionSerie registroSerie = new RegistroReproduccionSerie();
                registroSerie = registroSerie.obtenerRegistroSerie(serie, this);
                registroSerie.agregarEpisodioVisto(episodio, fechaActual, parteVista);
            }
            default -> {
            }
        }
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "nombre='" + nombre + '\'' +
                ", icono='" + icono + '\'' +
                ", lenguaje='" + lenguaje + '\'' +
                ", isPerfilInfantil=" + isPerfilInfantil +
                ", listaFavoritos=" + listaFavoritos +
                ", listasPersonalizadas=" + listasPersonalizadas +
                ", registroContenidoVisto=" + registroContenidoVisto +
                '}';
    }
}
