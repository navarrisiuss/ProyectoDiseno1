package Clases;

import ClasesAbstractas.MedioPago;
import Enums.Monedas;
import Interfaces.ConvertidorMonedas;

import java.time.LocalDate;

public class Pago implements ConvertidorMonedas {
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

    @Override
    public void convertirMoneda() {
        if (this.moneda.equals(Monedas.CLP.name())){
            this.monto = this.monto * 922 ;
        }
    }

    @Override
    public String toString() {
        return "Pago{\n" +
            "    fecha=" + fecha + ",\n" +
            "    monto=" + monto + ",\n" +
            "    moneda='" + moneda + "',\n" +
            "    membresia=" + membresia + "\n" +
            '}';
    }
}
