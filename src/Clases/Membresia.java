package Clases;

import ClasesAbstractas.MedioPago;

import java.time.LocalDate;

public class Membresia {
    private Plan plan;
    private LocalDate fechaInicio;
    private LocalDate fechaSiguienteCobro;
    private LocalDate fechaTermino;
    private MedioPago medioPago;

    public Membresia(Plan plan, LocalDate fechaInicio, LocalDate fechaSiguienteCobro, LocalDate fechaTermino) {
        this.plan = plan;
        this.fechaInicio = fechaInicio;
        this.fechaSiguienteCobro = fechaSiguienteCobro;
        this.fechaTermino = fechaTermino;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaSiguienteCobro() {
        return fechaSiguienteCobro;
    }

    public void setFechaSiguienteCobro(LocalDate fechaSiguienteCobro) {
        this.fechaSiguienteCobro = fechaSiguienteCobro;
    }

    public LocalDate getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(LocalDate fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPago medioPago) {
        this.medioPago = medioPago;
    }

    @Override
    public String toString() {
        return "Membresia{" +
                "plan=" + plan +
                ", fechaInicio=" + fechaInicio +
                ", fechaSiguienteCobro=" + fechaSiguienteCobro +
                ", fechaTermino=" + fechaTermino +
                ", medioPago=" + medioPago +
                '}';
    }
}
