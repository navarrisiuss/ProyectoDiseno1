package Clases;

import java.time.LocalDate;

public class Pago {
    private LocalDate fecha;
    private double monto;
    private String moneda;
    private Membresia membresia;

    public Pago(String moneda, Membresia membresia) {
        Plan planMembresia = membresia.getPlan();
        this.fecha = membresia.getFechaInicio();
        this.monto = planMembresia.getCosto();
        this.moneda = moneda;
        this.membresia = membresia;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "fecha=" + fecha +
                ", monto=" + monto +
                ", moneda='" + moneda + '\'' +
                ", membresia=" + membresia +
                '}';
    }
}
