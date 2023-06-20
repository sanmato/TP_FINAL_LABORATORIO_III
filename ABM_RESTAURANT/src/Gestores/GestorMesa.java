package Gestores;

import Clases.Mesa;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class GestorMesa {
    public ArrayList<Mesa> mesas;

    public GestorMesa() {
        this.mesas = new ArrayList<>();
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

    public Mesa seleccionarMesa(List<Mesa> mesasDisponibles) {
        mesasDisponibles = obtenerMesasDisponibles();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el número de mesa:");
        int numeroDeMesa = scanner.nextInt();

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

    public void agregarNuevaMesa(Integer numeroDeMesa, Integer capacidadMesa) {
        Mesa nuevaMesa = new Mesa(numeroDeMesa, capacidadMesa);

        mesas.add(nuevaMesa);
        System.out.println("Mesa: " + nuevaMesa.getNumeroMesa() + " agregada exitosamente");
        GestorJSON.agregarAJsonMesa(nuevaMesa);
    }

    public void verMesas(List<Mesa> listaMesas) {
        System.out.println("Mesas disponibles:");
        listaMesas.forEach(mesa -> {
            System.out.println("Número de Mesa: " + mesa.getNumeroMesa() + ", Capacidad: " + mesa.getCapacidad());
        });
    }

    public List<Mesa> obtenerMesasDisponibles() {
        List<Mesa> todasLasMesas = GestorJSON.leerJsonMesa();
        List<Mesa> mesasDisponibles = new ArrayList<>();

        todasLasMesas.forEach(mesa -> {
            if (mesa.getReservada() == false) {
                mesasDisponibles.add(mesa);
            }
        });
        return mesasDisponibles;
    }

    public void modificarCapacidadMesa(int numeroDeMesa, int nuevaCapacidad) {
        Mesa mesaAModificar = buscarMesaPorNumero(numeroDeMesa);

        if (mesaAModificar != null) {
            mesaAModificar.setCapacidad(nuevaCapacidad);
            GestorJSON.actualizarJsonMesa(mesaAModificar);
            System.out.println("Capacidad de la mesa " + numeroDeMesa + " modificada con éxito.");
        } else {
            System.out.println("No se encontró una mesa con el número especificado.");
        }
    }

    public void eliminarMesa(int numeroDeMesaABorrar) {
        GestorJSON.borrarMesaDeJSON(numeroDeMesaABorrar);

        System.out.println("Mesa " + numeroDeMesaABorrar + " borrada con exito.");
    }

    @Override
    public String toString() {
        return "GestorMesa{" +
                "mesas=" + mesas +
                '}';
    }
}
