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
        this.password = encriptarPassword(password);
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

    @Override
    public String encriptarPassword(String password) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) ((c - base + 10) % 26 + base);
            }
            resultado.append(c);
        }
        return resultado.toString();
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
        password = encriptarPassword(password);
        return this.email.equals(email) && password.equals(this.password);
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
