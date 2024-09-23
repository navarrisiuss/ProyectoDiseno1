package Clases;

import ClasesAbstractas.MedioPago;

public class PagoTerceros extends MedioPago {
    private String refCliente;
    private String refProveedor;

    public PagoTerceros(String refCliente, String refProveedor) {
        this.refCliente = refCliente;
        this.refProveedor = refProveedor;
    }

    @Override
    public void cobrar() {
        System.out.println("Cobrando a terceros");
    }

    @Override
    public String toString() {
        return "PagoTerceros{" +
                "refCliente='" + refCliente + '\'' +
                ", refProveedor='" + refProveedor + '\'' +
                '}';
    }
}
