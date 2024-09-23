package Clases;

import ClasesAbstractas.MedioPago;
import Interfaces.EncriptadorHash;

import java.time.LocalDate;
import java.util.Date;

public class TarjetaCredito extends MedioPago implements EncriptadorHash {
    private String nombreTitular;
    private String numTarjeta;
    private LocalDate fechaExpiracion;
    private String codigoVerificacion;

    public TarjetaCredito(String nombreTitular, String numTarjeta, LocalDate fechaExpiracion, String codigoVerificacion) {
        this.nombreTitular = nombreTitular;
        this.numTarjeta = numTarjeta;
        this.fechaExpiracion = fechaExpiracion;
        this.codigoVerificacion = codigoVerificacion;
    }

    @Override
    public String encriptarNumTarjeta() {
        return null;
    }

    @Override
    public String encriptarCodigo() {
        return null;
    }

    @Override
    public void cobrar() {
        System.out.println("Cobrando con tarjeta de crédito");
    }
}
