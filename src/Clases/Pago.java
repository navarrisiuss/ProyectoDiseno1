package Clases;

import java.time.LocalDate;

import ClasesAbstractas.MedioPago;
import Enums.Monedas;

public class Pago {
    private LocalDate fecha;
    private double monto;
    private String moneda;
    private Membresia membresia;
    private MedioPago medioPago;

    public Pago(String moneda, Membresia membresia) {
        Plan planMembresia = membresia.getPlan();
        this.fecha = membresia.getFechaInicio();
        this.monto = planMembresia.getCosto();
        this.moneda = moneda;
        this.membresia = membresia;
        this.medioPago = membresia.getMedioPago();
        convertirMoneda();
    }

    private void convertirMoneda() {
        if (this.moneda.equals(Monedas.CLP.name())){
            this.monto = this.monto * 922 ;
        }
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
