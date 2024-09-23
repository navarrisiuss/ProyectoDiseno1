import Clases.*;
import ClasesAbstractas.ContenidoMultimedia;
import Enums.Lenguajes;
import Enums.RestriccionEdad;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Catalogo CATALOGO = new Catalogo();
        Cuenta cuentaIniciada = null;
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        rellenarCuentas(cuentas);
        System.out.println("CUENTAS:");
        for (Cuenta c : cuentas) {
            System.out.println(c);
        }
        System.out.println("------------------------------------------------------------------");
        Pelicula peli1 = crearPelicula("Los Pessis", new ArrayList<>() {{
                    add("Deus");
                    add("Cap");
                    add("Pessi");
                }}, false, new ArrayList<>() {{
                    add("Comedia");
                }},
                "Buena Peli :D", 5, RestriccionEdad.ADULTOS.name(), LocalDate.of(2003, 10, 5), "Nav");
        Pelicula peli2 = crearPelicula("ShaggyDeus", new ArrayList<>() {{
                    add("Shag");
                    add("Jitu");
                    add("Jose");
                }}, false, new ArrayList<>() {{
                    add("Comedia");
                    add("Terror");
                }}, "Jiturra!, un idiota", 2, RestriccionEdad.ADOLESCENTES.name(),
                LocalDate.of(2023, 12, 15), "Capitan");
        CATALOGO.addContenidoMultimedia(peli1);
        CATALOGO.addContenidoMultimedia(peli2);
        Episodio ep1 = crearEpisodio("El curli", "Cap", new ArrayList<>() {{
            add("Lop");
            add("Nicolas");
        }}, LocalDate.of(2024, 2, 10), LocalTime.of(0, 56));
        Temporada t1 = crearTemporada(1, LocalDate.of(2024, 2, 10), new ArrayList<>() {{
            add(ep1);
        }});
        Serie serie1 = crearSerie("Los curls", "Los nicols and the curls", new ArrayList<>() {{
            add("Comedia");
            add("Suspenso");
        }}, LocalDate.of(2024, 2, 10), RestriccionEdad.TODO_PUBLICO.name(), 4, new ArrayList<>() {{
            add(t1);
        }});
        CATALOGO.addContenidoMultimedia(serie1);
        System.out.println(CATALOGO);
        System.out.println("------------------------------------------------------------------------------");
        Cuenta cuentaTest = cuentas.get(1);
        Perfil perfilTest = cuentaTest.getPerfiles().get(0);
        System.out.println(perfilTest.toString());
        ContenidoMultimedia peliculaTest = CATALOGO.getContenidoMultimedia().get(0);
        System.out.println(peliculaTest.toString());
        perfilTest.addListaFavoritos(peliculaTest);
    }

    public static void rellenarCuentas(ArrayList<Cuenta> cuentas) {
        Cuenta cuenta1 = new Cuenta("Lopesito", "lopesito123", "lopesito@lop.lop");
        Cuenta cuenta2 = new Cuenta("Curl", "curlito123", "curlito@curl.curl");
        Cuenta cuenta3 = new Cuenta("nico3798", "nicolas", "nico@3798.nico");
        Cuenta cuenta4 = new Cuenta("Nav", "nav213", "nav@nav.nav");


        cuenta1.actualizarAMembresiaStardard();

        cuentas.add(cuenta1);
        cuentas.add(cuenta2);
        cuentas.add(cuenta3);
        cuentas.add(cuenta4);
        cuenta1.crearPerfil("Perfil1Lopesito", ":)", Lenguajes.SPANISH.name(), false);
        cuenta1.crearPerfil("Perfil2Lopesito", ":)", Lenguajes.SPANISH.name(), false);
        cuenta1.crearPerfil("Perfil3Lopesito", ":)", Lenguajes.SPANISH.name(), true);
        cuenta1.crearPerfil("Perfil4Lopesito", ":)", Lenguajes.SPANISH.name(), false);
        cuenta1.crearPerfil("Perfil5Lopesito", ":)", Lenguajes.SPANISH.name(), false);
        cuenta1.crearPerfil("Perfil6Lopesito", ":)", Lenguajes.SPANISH.name(), true);

        cuenta2.crearPerfil("Curly", ">:V", Lenguajes.ENGLISH.name(), true);
    }

    public static Pelicula crearPelicula(String titulo, ArrayList<String> elenco, boolean isPago, ArrayList<String> categorias, String descripcion, int estrellas, String restriccionEdad, LocalDate fechaLanzamiento, String director) {
        Pelicula peli = new Pelicula(director, elenco, isPago);
        peli.setTitulo(titulo);
        peli.setCategorias(categorias);
        peli.setDescripcion(descripcion);
        peli.setEstrellas(estrellas);
        peli.setRestriccionEdad(restriccionEdad);
        peli.setFechaLanzamiento(fechaLanzamiento);
        return peli;
    }

    public static Episodio crearEpisodio(String nombre, String director, ArrayList<String> elenco,
                                         LocalDate fechaLanzamiento, LocalTime duracion) {
        return new Episodio(nombre, director, elenco, fechaLanzamiento, duracion);
    }

    public static Temporada crearTemporada(int numero, LocalDate fechaLanzamiento, ArrayList<Episodio> episodios) {
        return new Temporada(numero, fechaLanzamiento, episodios);
    }

    public static Serie crearSerie(String titulo, String descripcion, ArrayList<String> categorias, LocalDate fecha,
                                   String restriccion, int estrellas, ArrayList<Temporada> temporadas) {
        Serie serie = new Serie(temporadas);
        serie.setTitulo(titulo);
        serie.setDescripcion(descripcion);
        serie.setCategorias(categorias);
        serie.setFechaLanzamiento(fecha);
        serie.setEstrellas(estrellas);
        serie.setRestriccionEdad(restriccion);
        return serie;
    }
}