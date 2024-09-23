package Clases;

import ClasesAbstractas.MedioPago;

import java.time.LocalDate;

public class CodigoRegalo extends MedioPago {
    private String codigo;
    private String descripcion;
    private LocalDate fechaExpiracion;

    public CodigoRegalo(String codigo, String descripcion, LocalDate fechaExpiracion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fechaExpiracion = fechaExpiracion;
    }

    @Override
    public void cobrar() {
        System.out.println("Cobrando con código de regalo");
    }

    @Override
    public String toString() {
        return "CodigoRegalo{\n" +
                "    codigo='" + codigo + "',\n" +
                "    descripcion='" + descripcion + "',\n" +
                "    fechaExpiracion=" + fechaExpiracion + "\n" +
                '}';
    }
}
