package Clases;

import java.util.ArrayList;
import java.util.Scanner;

import Gestores.GestorMenuItem;
import Gestores.GestorMesa;
import Gestores.GestorUsuarios;

public class Sistema {
    private ArrayList<Mesa> mesas;
    private ArrayList<Reserva> reservas;

    public Sistema() {
        this.mesas = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(ArrayList<Mesa> mesas) {
        this.mesas = mesas;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Sistema [mesas=" + mesas + ", reservas=" + reservas + "]";
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        GestorMenuItem menu = new GestorMenuItem();
        // menu.agregarAlMenu();
        menu.verMenu();
        menu.eliminarPlato();

        scanner.close();

    }
}
