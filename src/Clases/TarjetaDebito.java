package Clases;

import ClasesAbstractas.MedioPago;
import Interfaces.EncriptadorHash;

public class TarjetaDebito extends MedioPago implements EncriptadorHash {
    private String numTarjeta;
    private String rutTitular;
    private String rutBanco;

    public TarjetaDebito(String numTarjeta, String rutTitular, String rutBanco) {
        this.numTarjeta = numTarjeta;
        this.rutTitular = rutTitular;
        this.rutBanco = rutBanco;
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
        System.out.println("Cobrando con tarjeta de débito");
    }
}
