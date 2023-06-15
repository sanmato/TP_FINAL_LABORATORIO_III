package Clases;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<MenuItem> items;

    public Menu() {
        items = new ArrayList<>();
    }

    public MenuItem buscarItem(String nombreItem) {
        for (MenuItem item : items) {
            if (item.getNombre().equals(items)) {
                return item;
            }
        }
        return null;
    }
    public void modificarPrecio(MenuItem item){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nuevo precio: ");
        Double nuevoPrecio= scanner.nextDouble();
        item.setPrecio(nuevoPrecio);
    }
    public void modificarNombre(MenuItem item){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nuevo nombre: ");
        String nuevoNombre= scanner.next();
        item.setNombre(nuevoNombre);
    }
    public void modificarDisponivilidad(MenuItem item){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Disponibilidad: ");
        Boolean nuevoNombre= scanner.nextBoolean();
        item.setDisponible(nuevoNombre);
    }


    public void eliminarItem(String nombreItem) throws Exception {
        try {
            for (MenuItem item : items) {
                if (item.getNombre().equals(nombreItem)) {
                    items.remove(item);
                    break;
                }
            }
        } catch (Exception exception) {
            System.out.println("Error: no se encontro el item para eliminar");
        }
    }

    public void agregarItem(MenuItem item) {
        items.add(item);
    }

    public void mostrarMenuDisponibles() {
        System.out.println(" -------------- Menú -------------- ");
        for (MenuItem item : items) {
            if (item.isDisponible())
                System.out.println("| " + "- " + item.getNombre() + " - $ " + item.getPrecio() + " | ");
        }
    }

    public void mostrarMenuTodos() {
        System.out.println(" -------------- Menú -------------- ");
        for (MenuItem item : items) {
            System.out.println("| " + "- " + item.getNombre() + " - $ " + item.getPrecio() + " | " + " Disponivilidad "
                    + item.isDisponible());
        }
    }

}
