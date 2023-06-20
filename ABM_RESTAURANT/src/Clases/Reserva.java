package Clases;

import java.util.Scanner;

public class Reserva {
    private Integer id;
    private Usuario usuario;
    private Mesa mesa;
    private Orden orden;

    // region CONST
    public Reserva() {
    }

    public Reserva(Integer id, Usuario usuario, Mesa mesa, Orden orden) {
        this.id = id;
        this.usuario = usuario;
        this.mesa = mesa;
        this.orden = orden;
    }

    // endregion
    // region GYS
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

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }
    // endregion

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", mesa=" + mesa +
                ", orden=" + orden +
                '}';
    }

}
