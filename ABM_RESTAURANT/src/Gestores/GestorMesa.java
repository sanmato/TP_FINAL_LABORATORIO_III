package Gestores;

import Clases.Mesa;
import java.util.ArrayList;
import java.util.List;

public class GestorMesa {
    public ArrayList<Mesa> mesas;

    public GestorMesa() {
        this.mesas = new ArrayList<>();
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
