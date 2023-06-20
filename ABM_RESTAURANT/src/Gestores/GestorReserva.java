package Gestores;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import Clases.MenuItem;
import Clases.Mesa;
import Clases.Reserva;
import Clases.Usuario;

public class GestorReserva {
    private List<Reserva> reservas;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public GestorReserva() {
        this.reservas = new ArrayList<>();
    }

    public void agregarReserva(Usuario usuario) {
        GestorMesa gestorMesa = new GestorMesa();
        List<Mesa> mesasDisponibles = gestorMesa.obtenerMesasDisponibles();
        gestorMesa.mostrarMesasDisponibles();

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
        LocalDate fechaReserva = solicitarFechaReserva();
        Reserva nuevaReserva = new Reserva(nuevaId, usuario, mesa, orden, fechaReserva);

        reservas.add(nuevaReserva);
        System.out.println("Reserva creada exitosamente.");

        GestorJSON.agregarAJsonReserva(nuevaReserva);
    }

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
                System.out.println("Ingrese el número de plato que desea agregar (0 para finalizar el pedido): ");
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
                    System.out.println("Número de plato no válido. Intente nuevamente.");
                }
            }
            return orden;
        }

        return null;
    }

    private LocalDate solicitarFechaReserva() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la fecha de la reserva (formato: dd/MM/yyyy): ");
        String fechaReservaStr = scanner.nextLine();
        return LocalDate.parse(fechaReservaStr, DATE_FORMATTER);
    }

    public void verReserva(Usuario usuarioAChequear) {
        List<Reserva> reservas = GestorJSON.leerJsonReservas();

        Reserva reservaReciente = buscarReservaReciente(usuarioAChequear, reservas);
        if (reservaReciente != null) {
            System.out.println("Reserva más reciente para el usuario:");
            System.out.println(reservaReciente);
        } else {
            System.out.println("No hay reservas para el usuario especificado.");
        }
    }

    public void obtenerReservas() {
        List<Reserva> reservas = GestorJSON.leerJsonReservas();
        System.out.println(reservas);
    }

    public void modificarReserva(Usuario usuarioAChequear) {
        List<Reserva> reservas = GestorJSON.leerJsonReservas();

        Reserva reservaReciente = buscarReservaReciente(usuarioAChequear, reservas);
        if (reservaReciente != null) {
            LocalDate nuevaFechaReserva = solicitarFechaReserva();
            reservaReciente.setFechaReserva(nuevaFechaReserva);
            GestorJSON.actualizarJsonReserva(reservaReciente);
            System.out.println("Fecha de reserva modificada correctamente.");
        } else {
            System.out.println("No se encontró ninguna reserva reciente para el usuario especificado.");
        }
    }

    public void modificarOrden(Usuario usuarioAChequear) {
        List<Reserva> reservas = GestorJSON.leerJsonReservas();

        Reserva reservaReciente = buscarReservaReciente(usuarioAChequear, reservas);
        if (reservaReciente != null) {
            List<MenuItem> nuevaOrden = solicitarOrden();
            reservaReciente.setOrden(nuevaOrden);
            GestorJSON.actualizarJsonReserva(reservaReciente);
            System.out.println("Orden de reserva modificada correctamente.");
        } else {
            System.out.println("No se encontró ninguna reserva reciente para el usuario especificado.");
        }
    }

    public void eliminarReserva(Usuario usuarioQueTieneReserva) {
        List<Reserva> reservas = GestorJSON.leerJsonReservas();

        Reserva reservaReciente = buscarReservaReciente(usuarioQueTieneReserva, reservas);
        if (reservaReciente != null) {
            GestorJSON.borrarReservaDeJSON(reservaReciente);

            Mesa mesaReserva = reservaReciente.getMesa();
            mesaReserva.setReservada(false);
            GestorJSON.actualizarJsonMesa(mesaReserva);

            System.out.println("Reserva eliminada exitosamente.");
        } else {
            System.out.println("No se encontró una reserva reciente para el usuario especificado.");
        }
    }

    private Reserva buscarReservaReciente(Usuario usuario, List<Reserva> reservas) {
        LocalDate currentDate = LocalDate.now();
        for (Reserva reserva : reservas) {
            if (reserva.getUsuario().getNombreUsuario().equals(usuario.getNombreUsuario())
                    && reserva.getFechaReserva().isAfter(currentDate)) {
                return reserva;
            }
        }
        return null;
    }
}
