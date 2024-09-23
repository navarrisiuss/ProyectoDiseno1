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
        encriptarNumTarjeta();
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

    }

    @Override
    public void cobrar() {
        System.out.println("Cobrando con tarjeta de débito");
    }

    @Override
    public String toString() {
        return "TarjetaDebito{" +
                "numTarjeta='" + numTarjeta + '\'' +
                ", rutTitular='" + rutTitular + '\'' +
                ", rutBanco='" + rutBanco + '\'' +
                '}';
    }
}
