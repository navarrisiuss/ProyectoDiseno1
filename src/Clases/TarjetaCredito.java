package Clases;

import ClasesAbstractas.MedioPago;
import Interfaces.EncriptadorHash;

import java.time.LocalDate;

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
        encriptarNumTarjeta();
        encriptarCodigo();
    }

    @Override
    public void encriptarNumTarjeta() {
        if (this.numTarjeta.length() < 4) {
            throw new IllegalArgumentException("El número de la tarjeta debe tener al menos 4 dígitos");
        }
        String ultimosCuatro = this.numTarjeta.substring(this.numTarjeta.length() - 4);
        String ocultos = "*".repeat(this.numTarjeta.length() - 4);
        this.numTarjeta = ocultos + ultimosCuatro;
    }

    @Override
    public void encriptarCodigo() {
        this.codigoVerificacion = "*".repeat(this.codigoVerificacion.length());
    }

    @Override
    public void cobrar() {
        System.out.println("Cobrando con tarjeta de crédito");
    }

    @Override
    public String toString() {
        return "TarjetaCredito{\n" +
            "    nombreTitular='" + nombreTitular + "',\n" +
            "    numTarjeta='" + numTarjeta + "',\n" +
            "    fechaExpiracion=" + fechaExpiracion + ",\n" +
            "    codigoVerificacion='" + codigoVerificacion + "'\n" +
            '}';
    }
}
