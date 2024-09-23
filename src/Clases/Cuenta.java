package Clases;

import ClasesAbstractas.MedioPago;
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
    private List<Pago> registroPagos = new ArrayList<>();
    private MedioPago medioPago;
    private final List<CompraPelicula> pagosPeliculas = new ArrayList<>();
    private final int MAX_PERFILES = 5;


    public Cuenta(String nombreUsuario, String password, String email) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.email = email;
        actualizarAMembresiaGratis();
        this.password = encriptarPassword(password);
    }

    public void setMedioPago(MedioPago medioPago) {
        this.medioPago = medioPago;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public List<CompraPelicula> getPagosPeliculas() {
        return pagosPeliculas;
    }

    public void crearPerfil(String nombre, String icono, String lenguaje, boolean isPerfilInfantil) {
        addPerfil(new Perfil(nombre, icono, lenguaje, isPerfilInfantil));
    }

    public void comprarPelicula(Pelicula pelicula, String moneda) {
        if (pelicula.isPago()) {
            if (this.medioPago == null) {
                System.out.println("Agregue un medio de pago");
            } else {
                CompraPelicula compraPelicula = new CompraPelicula(pelicula, LocalDate.now(), pelicula.getCosto(), moneda, this.medioPago);
                this.pagosPeliculas.add(compraPelicula);
                this.peliculasCompradas.add(pelicula);
                System.out.println("Se compró " + pelicula.getTitulo() + " por " + compraPelicula.getPrecio() + " " + moneda);
                this.medioPago.cobrar();
            }
        } else {
            System.out.println("La pelicula " + pelicula.getTitulo() + " es gratis");
        }
    }

    public List<Perfil> getPerfiles() {
        return perfiles;
    }

    public void removePerfil(String nombrePerfil) {
        for (Perfil p : perfiles) {
            if (p.getNombre().equals(nombrePerfil)) {
                perfiles.remove(p);
                System.out.println("PERFIL " + nombrePerfil + " ELIMINADO DE LA CUENTA " + this.nombreUsuario);
                return;
            }
        }
        System.out.println("Error al borrar perfil");
    }

    private void addPerfil(Perfil perfil) {
        if (this.perfiles.size() < this.MAX_PERFILES) {
            this.perfiles.add(perfil);
            System.out.println("Perfil " + perfil.getNombre() + " creado a la cuenta " + this.nombreUsuario);
        } else {
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
        this.membresia = new Membresia(plan, LocalDate.now(), null, null);
    }

    @Override
    public void actualizarAMembresiaStardard() {
        if (this.medioPago == null) {
            System.out.println("Agregue un medio de pago");
        } else {
            String nombre = NombrePlanes.STANDARD.name();
            Plan plan = new Plan(nombre);
            LocalDate fechaInicio = LocalDate.now();
            LocalDate fechaSiguienteCobro = fechaInicio.plusMonths(1);
            LocalDate fechaTermino = fechaInicio.plusMonths(1);
            Membresia m = new Membresia(plan, fechaInicio, fechaSiguienteCobro, fechaTermino);
            m.setMedioPago(this.medioPago);
            this.membresia = m;
            this.medioPago.cobrar();
        }
    }

    @Override
    public void actualizarAMembresiaPremium() {
        if (this.medioPago == null) {
            System.out.println("Agregue un medio de pago");
        } else {
            String nombre = NombrePlanes.PREMIUM.name();
            Plan plan = new Plan(nombre);
            LocalDate fechaInicio = LocalDate.now();
            LocalDate fechaSiguienteCobro = fechaInicio.plusMonths(1);
            LocalDate fechaTermino = fechaInicio.plusMonths(1);
            Membresia m = new Membresia(plan, fechaInicio, fechaSiguienteCobro, fechaTermino);
            m.setMedioPago(this.medioPago);
            this.membresia = m;
            this.medioPago.cobrar();
        }
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
                ", registroPagos=" + registroPagos +
                ", medioPago=" + medioPago +
                ", pagosPeliculas=" + pagosPeliculas +
                '}';
    }
}
