package Clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

public class Reserva {
    @Expose
    private Integer id;
    @Expose
    private Usuario usuario;
    @Expose
    private Mesa mesa;
    @Expose
    private List<MenuItem> orden;
    @Expose
    private LocalDate fechaReserva;

    public Reserva(Integer id, Usuario usuario, Mesa mesa, List<MenuItem> orden, LocalDate fechaReserva) {
        this.id = id;
        this.usuario = usuario;
        this.mesa = mesa;
        this.orden = orden;
        this.fechaReserva = fechaReserva;
    }

    public Reserva(Integer id, Usuario usuario, Mesa mesa, LocalDate fechaReserva) {
        this.id = id;
        this.usuario = usuario;
        this.mesa = mesa;
        this.orden = new ArrayList<>();
        this.fechaReserva = fechaReserva;
    }

    public Reserva() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<MenuItem> getOrden() {
        return orden;
    }

    public void setOrden(List<MenuItem> orden) {
        this.orden = orden;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    @Override
    public String toString() {
        return "Reserva [id=" + id + ", usuario=" + usuario + ", mesa=" + mesa + ", orden=" + orden + ", fechaReserva="
                + fechaReserva + "]";
    }

}
