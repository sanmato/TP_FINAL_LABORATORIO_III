package Clases;

import com.google.gson.annotations.Expose;

public class Mesa {
    @Expose
    private Integer numeroMesa;
    @Expose
    private Integer capacidad;
    private Boolean reservada;

    // region CONST
    public Mesa() {
    }

    public Mesa(Integer numeroMesa, Integer capacidad) {
        this.numeroMesa = numeroMesa;
        this.capacidad = capacidad;
        this.reservada = false;
    }

    public Integer getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(Integer numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Boolean getReservada() {
        return reservada;
    }

    public void setReservada(Boolean reservada) {
        this.reservada = reservada;
    }

    @Override
    public String toString() {
        return "Numero: " + numeroMesa + ". Capacidad para " + capacidad + " personas.";
    }

    // endregion
    // region GYS

}
