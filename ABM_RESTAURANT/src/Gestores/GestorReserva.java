package Gestores;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import Clases.MenuItem;
import Clases.Mesa;
import Clases.Reserva;
import Clases.Usuario;

public class GestorReserva {
    private List<Reserva> reservas;

    public GestorReserva() {
        this.reservas = new ArrayList<>();
    }

    public void agregarReserva(Usuario usuario, LocalDate fechaReserva) {
        GestorMesa gestorMesa = new GestorMesa();
        List<Mesa> mesasDisponibles = gestorMesa.obtenerMesasDisponibles();
        gestorMesa.verMesas(mesasDisponibles);

        if (mesasDisponibles.isEmpty()) {
            System.out.println("No hay mesas disponibles para hacer la reserva.");
            return;
        }

        Mesa mesa = gestorMesa.seleccionarMesa(mesasDisponibles);
        if (mesa == null) {
            System.out.println("No se seleccionó una mesa para la reserva.");
            return;
        }
        mesa.setReservada(true);

        List<MenuItem> orden = solicitarOrden();

        Integer nuevaId = generarNuevaId();
        Reserva nuevaReserva = new Reserva(nuevaId, usuario, mesa, orden, fechaReserva);
        reservas.add(nuevaReserva);

        System.out.println("Reserva creada exitosamente.");

        GestorJSON.agregarAJsonReserva(nuevaReserva);
    }

    // Otros métodos de GestorReserva

    private int generarNuevaId() {
        List<Reserva> reservasExistentes = GestorJSON.leerJsonReservas();

        int maxId = 0;
        for (Reserva reserva : reservasExistentes) {
            if (reserva.getId() > maxId) {
                maxId = reserva.getId();
            }
        }

        return maxId + 1;
    }

    private List<MenuItem> solicitarOrden() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Desea agregar una orden a su reserva? s/n: ");
        String respuesta = scanner.nextLine().toLowerCase();

        if (respuesta.equals("s")) {
            GestorMenuItem gestorMenuItem = new GestorMenuItem();
            gestorMenuItem.verMenu();

            List<MenuItem> orden = new ArrayList<>();

            while (true) {
                System.out.println("Ingrese el numero de plato que desea agregar. (0 para finalizar pedido): ");
                int numeroDePlato = scanner.nextInt();
                scanner.nextLine();

                if (numeroDePlato == 0) {
                    break;
                }

                MenuItem platoParaAgregarAOrden = gestorMenuItem.buscarItem(numeroDePlato);
                if (platoParaAgregarAOrden != null) {
                    orden.add(platoParaAgregarAOrden);
                    System.out.println("Plato agregado: " + platoParaAgregarAOrden.getNombre());
                } else {
                    System.out.println("Numero de plato no valido. Intente nuevamente");
                }
            }
            return orden;
        }
        return null;
    }
}
