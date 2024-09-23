package Clases;

import Enums.NombrePlanes;

public class Plan {
    private String nombre;
    private String descripcion;
    private double costo;
    private int pantallasActivas;

    public Plan(String nombre) {
        this.nombre = nombre;
        rellenarInfoPlan();
    }

    private void rellenarInfoPlan() {
        if (this.nombre.equals(NombrePlanes.GRATIS.name())) {
            this.descripcion = "Plan Gratis :c";
            this.costo = 0;
            this.pantallasActivas = 1;
        }
        else {
            if (this.nombre.equals(NombrePlanes.STANDARD.name())) {
                this.descripcion = "Plan Standard, más pantallas :D";
                this.costo = 5;
                this.pantallasActivas = 2;
            } else {
                if (this.nombre.equals(NombrePlanes.PREMIUM.name())) {
                    this.descripcion = "Plan Prepreprepremium";
                    this.costo = 8.5;
                    this.pantallasActivas = 4;
                }
                else {
                    System.out.println("Nombre no válido");
                }
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getPantallasActivas() {
        return pantallasActivas;
    }

    public void setPantallasActivas(int pantallasActivas) {
        this.pantallasActivas = pantallasActivas;
    }

    @Override
    public String toString() {
        return "Plan{\n" +
            "    nombre='" + nombre + "',\n" +
            "    descripcion='" + descripcion + "',\n" +
            "    costo=" + costo + ",\n" +
            "    pantallasActivas=" + pantallasActivas + "\n" +
            '}';
    }
}
