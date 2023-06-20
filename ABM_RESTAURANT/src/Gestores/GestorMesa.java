package Gestores;

import Clases.Mesa;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class GestorMesa {
    private List<Mesa> mesas;

    public GestorMesa() {
        this.mesas = new ArrayList<>();
    }

    public void agregarNuevaMesa() {
        Scanner scanner = new Scanner(System.in);

        int numeroDeMesa = generarNuevaId();
        int capacidadMesa = solicitarCapacidad(scanner);

        Mesa nuevaMesa = new Mesa(numeroDeMesa, capacidadMesa);

        mesas.add(nuevaMesa);
        System.out.println("Mesa: " + nuevaMesa.getNumeroMesa() + " agregada exitosamente");
        GestorJSON.agregarAJsonMesa(nuevaMesa);
    }

    public void verMesas() {
        System.out.println("Lista de mesas:");
        mesas = GestorJSON.leerJsonMesa();
        mesas.forEach(mesa -> {
            System.out.println("Número de Mesa: " + mesa.getNumeroMesa() + ", Capacidad: " + mesa.getCapacidad());
        });
    }

    public void mostrarMesasDisponibles() {
        List<Mesa> mesasDisponibles = obtenerMesasDisponibles();
        mesasDisponibles.forEach(mesa -> {
            System.out.println("Número de Mesa: " + mesa.getNumeroMesa() + " | Capacidad para " + mesa.getCapacidad()
                    + " personas.");
        });
    }

    public void modificarCapacidadMesa() {
        verMesas();
        Scanner scanner = new Scanner(System.in);
        int numeroDeMesa = solicitarNumeroMesa(scanner);
        scanner.nextLine();

        Mesa mesaAModificar = buscarMesaPorNumero(numeroDeMesa);

        if (mesaAModificar != null) {
            int nuevaCapacidad = solicitarCapacidad(scanner);
            mesaAModificar.setCapacidad(nuevaCapacidad);
            GestorJSON.actualizarJsonMesa(mesaAModificar);
            System.out.println("Capacidad de la mesa " + numeroDeMesa + " modificada con éxito.");
        } else {
            System.out.println("No se encontró una mesa con el número especificado.");
        }
    }

    public void eliminarMesa() {
        verMesas();
        Scanner scanner = new Scanner(System.in);
        int numeroDeMesaABorrar = solicitarNumeroMesa(scanner);
        scanner.nextLine();
        GestorJSON.borrarMesaDeJSON(numeroDeMesaABorrar);

        System.out.println("Mesa " + numeroDeMesaABorrar + " borrada con éxito.");
    }

    private int generarNuevaId() {
        List<Mesa> mesasExistentes = GestorJSON.leerJsonMesa();
        int maxId = 0;

        for (Mesa mesa : mesasExistentes) {
            if (mesa.getNumeroMesa() > maxId) {
                maxId = mesa.getNumeroMesa();
            }
        }

        return maxId + 1;
    }

    private Mesa buscarMesaPorNumero(int numeroMesa) {
        List<Mesa> todasLasMesas = GestorJSON.leerJsonMesa();

        for (Mesa mesaActual : todasLasMesas) {
            if (mesaActual.getNumeroMesa() == numeroMesa) {
                return mesaActual;
            }
        }
        return null;
    }

    private int solicitarNumeroMesa(Scanner scanner) {
        System.out.println("Ingrese el número de mesa para identificar: ");
        return scanner.nextInt();
    }

    private int solicitarCapacidad(Scanner scanner) {
        System.out.println("Ingrese la capacidad de personas para la mesa: ");
        return scanner.nextInt();
    }

    public List<Mesa> obtenerMesasDisponibles() {
        List<Mesa> todasLasMesas = GestorJSON.leerJsonMesa();
        List<Mesa> mesasDisponibles = new ArrayList<>();

        todasLasMesas.stream()
                .filter(mesa -> !mesa.getReservada())
                .forEach(mesasDisponibles::add);

        return mesasDisponibles;
    }

    public Mesa seleccionarMesa(List<Mesa> mesasDisponibles) {
        mesasDisponibles = obtenerMesasDisponibles();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el número de mesa:");
        int numeroDeMesa = solicitarNumeroMesa(scanner);

        Optional<Mesa> optionalMesa = mesasDisponibles.stream()
                .filter(mesa -> mesa.getNumeroMesa() == numeroDeMesa)
                .findFirst();

        if (optionalMesa.isPresent()) {
            Mesa mesaSeleccionada = optionalMesa.get();
            mesaSeleccionada.setReservada(true);

            GestorJSON.actualizarJsonMesa(mesaSeleccionada);

            return mesaSeleccionada;
        }

        return null;
    }

    @Override
    public String toString() {
        return "MesaManager{" +
                "mesas=" + mesas +
                '}';
    }
}
