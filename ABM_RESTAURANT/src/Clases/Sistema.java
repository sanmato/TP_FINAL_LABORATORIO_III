package Clases;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import Gestores.GestorMenuItem;
import Gestores.GestorMesa;
import Gestores.GestorReserva;
import Gestores.GestorUsuarios;
import Gestores.ManejadorMenu;

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

        GestorReserva gestorReserva = new GestorReserva();
        GestorMenuItem menuManager = new GestorMenuItem();
        GestorMesa mesaManager = new GestorMesa();
        GestorUsuarios userManager = new GestorUsuarios();
        ManejadorMenu manejadorMenu = new ManejadorMenu(userManager);

        Usuario usr2 = new Cliente(6, "santm", "41307627", "Santiago Manuek", "123456", "mail@mail.com");
        // gestorReserva.agregarReserva(usr, LocalDate.now());
        // gestorReserva.agregarReserva(usr2);
        // gestorReserva.verReserva(usr2);
        // gestorReserva.modificarReserva(usr2);
        // gestorReserva.eliminarReserva(usr2);
        // mesaManager.agregarNuevaMesa();
        // mesaManager.verMesas();
        // mesaManager.mostrarMesasDisponibles();
        // mesaManager.modificarCapacidadMesa();
        // mesaManager.eliminarMesa();
        // userManager.login();

        // menuManager.verMenu();
        manejadorMenu.showMenu();

        scanner.close();

    }
}
