package Gestores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Clases.MenuItem;
import Clases.TipoPlato;

public class GestorMenuItem {
    private List<MenuItem> items;

    public GestorMenuItem() {
        items = new ArrayList<>();
    }

    public MenuItem buscarItem(int id) {
        items = GestorJSON.leerJsonMenu();

        for (MenuItem item : items) {
            if (item.getNumeroPlato() == id) {
                return item;
            }
        }
        return null;
    }

    private int solicitarNumeroPlato(Scanner scanner) {
        System.out.println("Ingrese el número de plato para identificar: ");
        return scanner.nextInt();
    }

    private TipoPlato solicitarTipoPlato(Scanner scanner) {
        TipoPlato tipoPlato;
        while (true) {
            System.out.println("Ingrese el tipo de plato (ENTRADA, PRINCIPAL, POSTRE): ");
            String tipo = scanner.nextLine().toUpperCase();

            try {
                tipoPlato = TipoPlato.valueOf(tipo);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo de plato no válido. Intente nuevamente.");
            }
        }
        return tipoPlato;
    }

    private String solicitarNombrePlato(Scanner scanner) {
        System.out.println("Ingrese el nombre del plato: ");
        return scanner.nextLine();
    }

    private String solicitarDescripcionPlato(Scanner scanner) {
        System.out.println("Ingrese la descripción del plato: ");
        return scanner.nextLine();
    }

    private double solicitarPrecioPlato(Scanner scanner) {
        System.out.println("Ingrese el precio del plato: ");
        return scanner.nextDouble();
    }

    public void agregarAlMenu() {
        Scanner scanner = new Scanner(System.in);

        int numeroPlato = solicitarNumeroPlato(scanner);
        scanner.nextLine();
        TipoPlato tipoPlato = solicitarTipoPlato(scanner);
        String nombre = solicitarNombrePlato(scanner);
        String descripcion = solicitarDescripcionPlato(scanner);
        double precio = solicitarPrecioPlato(scanner);

        MenuItem nuevoPlato = new MenuItem(numeroPlato, tipoPlato, nombre, descripcion, precio);

        items.add(nuevoPlato);
        System.out.println("Agregado correctamente " + nuevoPlato.getNombre() + " al menú");

        GestorJSON.agregarAJsonMenu(nuevoPlato);
    }

    public void verMenu() {
        items = GestorJSON.leerJsonMenu();
        System.out.println(items.toString());
    }

    public void verPlatosPorTipo() {
        items = GestorJSON.leerJsonMenu();

        Scanner scanner = new Scanner(System.in);

        TipoPlato tipoPlato = solicitarTipoPlato(scanner);

        System.out.println("========= VER LISTA =========" + "\n");
        System.out.println("Lista " + tipoPlato + "\n");
        items.forEach(itemActual -> {
            if (itemActual.getTipo() == tipoPlato) {
                System.out.println(itemActual.toString());
            }
        });
    }

    public void modificarPrecio() {
        Scanner scanner = new Scanner(System.in);
        int idABuscar = solicitarNumeroPlato(scanner);
        scanner.nextLine();
        double nuevoPrecio = solicitarPrecioPlato(scanner);

        MenuItem platoAModificar = buscarItem(idABuscar);

        if (platoAModificar != null) {
            platoAModificar.setPrecio(nuevoPrecio);
            GestorJSON.actualizarJsonMenu(platoAModificar);
            System.out.println("Precio del plato " + platoAModificar.getNombre() + " modificado con éxito.");
        } else {
            System.out.println("No se encontró un plato con el número especificado.");
        }
    }

    public void eliminarPlato() {
        Scanner scanner = new Scanner(System.in);
        int idABorrar = solicitarNumeroPlato(scanner);
        scanner.nextLine();
        GestorJSON.borrarMenuDeJSON(idABorrar);

        System.out.println("Plato borrado con exito.");
    }

}
