package Clases;

import ClasesAbstractas.MedioPago;

import java.util.Date;

public class CodigoRegalo extends MedioPago {
    private String codigo;
    private String descripcion;
    private Date fechaExpiracion;

    public CodigoRegalo(String codigo, String descripcion, Date fechaExpiracion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fechaExpiracion = fechaExpiracion;
    }

    @Override
    public void cobrar() {
        System.out.println("Cobrando con código de regalo");
    }
}
