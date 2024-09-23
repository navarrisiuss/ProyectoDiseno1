package Clases;

import ClasesAbstractas.MedioPago;
import Enums.Monedas;
import Interfaces.ConvertidorMonedas;

import java.time.LocalDate;

public class CompraPelicula implements ConvertidorMonedas {
    private Pelicula pelicula;
    private LocalDate fechaCompra;
    private double precio;
    private String moneda;
    private MedioPago medioPago;


    public CompraPelicula(Pelicula pelicula, LocalDate fechaCompra, double precio, String moneda, MedioPago medioPago) {
        this.pelicula = pelicula;
        this.fechaCompra = fechaCompra;
        this.precio = precio;
        this.moneda = moneda;
        this.medioPago = medioPago;
        convertirMoneda();
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPago medioPago) {
        this.medioPago = medioPago;
    }

    @Override
    public void convertirMoneda() {
        if (this.moneda.equals(Monedas.CLP.name())){
            this.precio *= 922;
        }
    }

    @Override
    public String toString() {
        return "CompraPelicula{" +
                "pelicula=" + pelicula +
                ", fechaCompra=" + fechaCompra +
                ", precio=" + precio +
                ", moneda='" + moneda + '\'' +
                ", medioPago=" + medioPago +
                '}';
    }
}
