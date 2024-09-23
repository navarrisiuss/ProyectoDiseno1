package Clases;

import Enums.NombrePlanes;
import Interfaces.ActualizadorMembresias;
import Interfaces.EncriptadorPassword;
import Interfaces.InicioSesion;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cuenta implements InicioSesion, EncriptadorPassword, ActualizadorMembresias {
    private String nombreUsuario;
    private String password;
    private String email;
    private Membresia membresia;
    private List<Perfil> perfiles = new ArrayList<>();
    private List<Pelicula> peliculasCompradas = new ArrayList<>();
    private final int MAX_PERFILES = 5;

    public Cuenta(String nombreUsuario, String password, String email) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.email = email;
        actualizarAMembresiaGratis();
    }

    public void crearPerfil(String nombre, String icono, String lenguaje, boolean isPerfilInfantil) {
        addPerfil(new Perfil(nombre, icono, lenguaje, isPerfilInfantil));
    }

    private void addPerfil(Perfil perfil) {
        if (this.perfiles.size() < this.MAX_PERFILES) {
            this.perfiles.add(perfil);
            System.out.println("Perfil " + perfil.getNombre() + " creado a la cuenta " + this.nombreUsuario);
        }
        else {
            System.out.println("No se pueden crear más perfiles en " + this.nombreUsuario);
        }
    }

    public void comprarPelicula(Pelicula pelicula) {
        if (pelicula.isPago()) {
            this.peliculasCompradas.add(pelicula);
            System.out.println("Pelicula comprada");
        }
        else {
            System.out.println("Pelicula no disponible para compra");
        }
    }

    public String mostrarPeliculasCompradas() {
        String peliculas = "";
        for (Pelicula pelicula : this.peliculasCompradas) {
            peliculas += pelicula.getTitulo() + "\n";
        }
        return peliculas;
    }

    @Override
    public String encriptarPassword() {
        return null;
    }

    @Override
    public void actualizarAMembresiaGratis() {
        String nombre = NombrePlanes.GRATIS.name();
        Plan plan = new Plan(nombre);
        Membresia m = new Membresia(plan, LocalDate.now(), null, null);
        this.membresia = m;
    }

    @Override
    public void actualizarAMembresiaStardard() {

    }

    @Override
    public void actualizarAMembresiaPremium() {

    }

    @Override
    public boolean inicioSesionValido(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", membresia=" + membresia +
                ", perfiles=" + perfiles +
                ", peliculasCompradas=" + peliculasCompradas +
                '}';
    }
}
