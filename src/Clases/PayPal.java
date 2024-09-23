package Clases;

import ClasesAbstractas.MedioPago;

public class PayPal extends MedioPago {
    private String email;
    private String token;

    public PayPal(String email, String token) {
        this.email = email;
        this.token = token;
    }

    @Override
    public void cobrar() {
        System.out.println("Cobrando con PayPal");
    }

    @Override
    public String toString() {
        return "PayPal{" +
                "email='" + email + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
