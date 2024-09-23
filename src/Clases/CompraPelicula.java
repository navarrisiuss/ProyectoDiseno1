package Clases;

import java.util.Date;

public class CompraPelicula {
    private Date fechaCompra;
    private double precio;
    private String moneda;


    public CompraPelicula(Date fechaCompra, double precio, String moneda) {
        this.fechaCompra = fechaCompra;
        this.precio = precio;
        this.moneda = moneda;
    }
}
