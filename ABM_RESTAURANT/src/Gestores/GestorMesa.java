package Gestores;

import Clases.Mesa;
import java.util.ArrayList;
import java.util.List;

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

    public void agregarNuevaMesa(Integer numeroDeMesa, Integer capacidadMesa) {
        Mesa nuevaMesa = new Mesa(numeroDeMesa, capacidadMesa);

        mesas.add(nuevaMesa);
        System.out.println("Mesa: " + nuevaMesa.getNumeroMesa() + " agregada exitosamente");
        GestorJSON.agregarAJsonMesa(nuevaMesa);
    }

    public void verMesas() {
        List<Mesa> todasLasMesas = GestorJSON.leerJsonMesa();

        System.out.println(todasLasMesas);
    }

    public void verMesasDisponibles() {
        List<Mesa> todasLasMesas = GestorJSON.leerJsonMesa();

        System.out.println("Mesas disponibles:");
        todasLasMesas.forEach(mesa -> {
            if (mesa.getReservada() == false) {
                System.out.println(mesa.toString());
            }
        });
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
