import Clases.*;
import ClasesAbstractas.ContenidoMultimedia;
import Enums.Lenguajes;
import Enums.Monedas;
import Enums.RestriccionEdad;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Catalogo CATALOGO = new Catalogo();
        Cuenta cuentaIniciada = null;
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        rellenarCuentas(CATALOGO, cuentas);
        System.out.println("CUENTAS:");
        for (Cuenta c : cuentas) {
            System.out.println(c);
        }
        System.out.println("------------------------------------------------------------------");
        System.out.println(CATALOGO);
        System.out.println("------------------------------------------------------------------------------");
        Cuenta cuentaTest1 = cuentas.get(1);
        Cuenta cuentaTest2 = cuentas.get(0);
        Perfil perfilTest1 = cuentaTest1.getPerfiles().get(0);
        Perfil perfilTest2 = cuentaTest2.getPerfiles().get(0);
        System.out.println(perfilTest1.toString());
        ContenidoMultimedia peliculaTest = CATALOGO.getContenidoMultimedia().get(0);
        System.out.println(peliculaTest.toString());
        perfilTest1.addListaFavoritos(peliculaTest);
        System.out.println(CATALOGO.buscarContenido(perfilTest2, "Shaggy"));
        System.out.println(CATALOGO.buscarContenido(perfilTest1, "Shaggy"));
        
        
    }

    public static void rellenarCuentas(Catalogo CATALOGO, ArrayList<Cuenta> cuentas) {
        Cuenta cuenta1 = new Cuenta("Lopesito", "lopesito123", "lopesito@lop.lop");
        Cuenta cuenta2 = new Cuenta("Curl", "curlito123", "curlito@curl.curl");
        Cuenta cuenta3 = new Cuenta("nico3798", "nicolas", "nico@3798.nico");
        Cuenta cuenta4 = new Cuenta("Nav", "nav213", "nav@nav.nav");
        Pelicula peli1 = crearPelicula(CATALOGO,"Los Pessis", new ArrayList<>() {{
            add("Deus");
            add("Cap");
            add("Pessi");
        }}, 10, new ArrayList<>() {{
            add("Comedia");
        }}, "Buena Peli :D", 5, RestriccionEdad.ADULTOS.name(), LocalDate.of(2003, 10, 5), "Nav");
        Episodio ep1 = crearEpisodio("El curli", "Cap", new ArrayList<>() {{
            add("Lop");
            add("Nicolas");
        }}, LocalDate.of(2024, 2, 10), LocalTime.of(0, 56));
        Temporada t1 = crearTemporada(1, LocalDate.of(2024, 2, 10), new ArrayList<>() {{
            add(ep1);
        }});
        Serie serie1 = crearSerie(CATALOGO,"Los curls", "Los nicols and the curls", new ArrayList<>() {{
            add("Comedia");
            add("Suspenso");
        }}, LocalDate.of(2024, 2, 10), RestriccionEdad.TODO_PUBLICO.name(), 4, new ArrayList<>() {{
            add(t1);
        }});
        Pelicula peli2 = crearPelicula(CATALOGO,"ShaggyDeus", new ArrayList<>() {{
            add("Shag");
            add("Jitu");
            add("Jose");
        }}, 50, new ArrayList<>() {{
            add("Comedia");
            add("Terror");
        }}, "Jiturra!, un idiota", 2, RestriccionEdad.ADOLESCENTES.name(), LocalDate.of(2023, 12, 15), "Capitan");

        cuenta1.actualizarAMembresiaStardard(Monedas.USD.name());

        cuentas.add(cuenta1);
        cuentas.add(cuenta2);
        cuentas.add(cuenta3);
        cuentas.add(cuenta4);
        cuenta1.crearPerfil("Perfil1Lopesito", ":)", Lenguajes.SPANISH.name(), false);
        cuenta1.crearPerfil("Perfil2Lopesito", ":)", Lenguajes.SPANISH.name(), false);
        cuenta1.crearPerfil("Perfil3Lopesito", ":)", Lenguajes.SPANISH.name(), true);
        cuenta1.crearPerfil("Perfil4Lopesito", ":)", Lenguajes.SPANISH.name(), false);
        cuenta1.crearPerfil("Perfil5Lopesito", ":)", Lenguajes.SPANISH.name(), true);
        cuenta1.crearPerfil("Perfil6Lopesito", ":)", Lenguajes.SPANISH.name(), true);

        cuenta2.crearPerfil("Curly", ">:V", Lenguajes.ENGLISH.name(), true);
        TarjetaCredito tarjetaCredito = new TarjetaCredito("Lopesito", "123456789",
                LocalDate.of(2024, 2, 10), "123");
        PayPal paypal = new PayPal("capi@capi.cap", "d1b09b3f-8b45-42cf-94b9-61b65cd6b434");
        cuenta1.setMedioPago(tarjetaCredito);
        cuenta2.setMedioPago(paypal);
        cuenta2.actualizarAMembresiaPremium(Monedas.CLP.name());
        cuenta1.actualizarAMembresiaStardard(Monedas.CLP.name());
        cuenta1.comprarPelicula(peli1, Monedas.USD.name());
        cuenta1.comprarPelicula(peli2, Monedas.CLP.name());
        System.out.println(cuenta1.getPagosPeliculas());
        System.out.println(cuenta1);
        cuenta1.removePerfil("Perfil3Lopesito");

        Perfil perfilTestLopesito = cuenta1.getPerfiles().get(1);
        perfilTestLopesito.crearListaPersonalizada("LISTA PARA VER");
        perfilTestLopesito.addListaPersonalizada("LISTA PARA VER", peli1);
        perfilTestLopesito.addListaPersonalizada("LISTA PARA VER", peli2);
        perfilTestLopesito.addListaFavoritos(peli1);
        System.out.println("PERFIL LOPESITO: ");
        System.out.println(perfilTestLopesito);
        System.out.println("-------------------------------");
        CATALOGO.eliminarContenidoMultimedia(peli1, cuentas);
        System.out.println(perfilTestLopesito);

        Visualizacion visualizacion = new Visualizacion(perfilTestLopesito, peli2);
        visualizacion.ver(perfilTestLopesito, peli2);
        
    }

    public static Pelicula crearPelicula(Catalogo CATALOGO, String titulo, ArrayList<String> elenco, double costo,
        ArrayList<String> categorias, String descripcion, int estrellas, String restriccionEdad, LocalDate fechaLanzamiento, String director) {
        Pelicula peli = new Pelicula(CATALOGO, director, elenco, costo);
        peli.setTitulo(titulo);
        peli.setCategorias(categorias);
        peli.setDescripcion(descripcion);
        peli.setEstrellas(estrellas);
        peli.setRestriccionEdad(restriccionEdad);
        peli.setFechaLanzamiento(fechaLanzamiento);
        return peli;
    }

    public static Episodio crearEpisodio(String nombre, String director, ArrayList<String> elenco, LocalDate fechaLanzamiento, LocalTime duracion) {
        return new Episodio(nombre, director, elenco, fechaLanzamiento, duracion);
    }

    public static Temporada crearTemporada(int numero, LocalDate fechaLanzamiento, ArrayList<Episodio> episodios) {
        return new Temporada(numero, fechaLanzamiento, episodios);
    }

    public static Serie crearSerie(Catalogo CATALOGO, String titulo, String descripcion, ArrayList<String> categorias, LocalDate fecha, String restriccion, int estrellas, ArrayList<Temporada> temporadas) {
        Serie serie = new Serie(CATALOGO, temporadas);
        serie.setTitulo(titulo);
        serie.setDescripcion(descripcion);
        serie.setCategorias(categorias);
        serie.setFechaLanzamiento(fecha);
        serie.setEstrellas(estrellas);
        serie.setRestriccionEdad(restriccion);
        return serie;
    }
}
