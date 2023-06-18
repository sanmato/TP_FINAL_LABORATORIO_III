package Gestores;

import Clases.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class GestorJSON {

    // #region: Manejo de JSON para usuarios
    public static void agregarAJson(Usuario usuarioActual) {
        List<Usuario> usuariosCreados = leerJson();

        usuariosCreados.add(usuarioActual);

        try (FileWriter writer = new FileWriter("users.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(usuariosCreados, writer);
        } catch (IOException e) {
            System.out.println("Error Al escribir el archivo " + e.getMessage());
        }
    }

    public static List<Usuario> leerJson() {
        File file = new File("users.json");
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (Reader reader = new FileReader(file)) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<Usuario>>() {
            }.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            System.out.println("Error al leer los datos del archivo: " + e.getMessage());
        }

        return new ArrayList<>();
    }

    // #endregion

    // #region: Manejo de JSON para mesas
    public static void agregarAJsonMesa(Mesa mesaNueva) {
        List<Mesa> mesasTotales = leerJsonMesa();

        mesasTotales.add(mesaNueva);

        try (FileWriter writer = new FileWriter("mesas.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(mesasTotales, writer);
        } catch (IOException e) {
            System.out.println("Error Al escribir el archivo " + e.getMessage());
        }
    }

    public static List<Mesa> leerJsonMesa() {
        File file = new File("mesas.json");
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (Reader reader = new FileReader(file)) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<Mesa>>() {
            }.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            System.out.println("Error al leer los datos del archivo: " + e.getMessage());
        }

        return new ArrayList<>();

    }

    public static void actualizarJsonMesa(Mesa mesaAModificar) {
        List<Mesa> mesasExistentes = leerJsonMesa();

        mesasExistentes.forEach(mesaActual -> {
            if (mesaActual.getNumeroMesa() == mesaAModificar.getNumeroMesa()) {
                mesasExistentes.set(mesasExistentes.indexOf(mesaActual), mesaAModificar);
            }
        });

        try (FileWriter writer = new FileWriter("mesas.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(mesasExistentes, writer);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo JSON de las mesas");
        }

    }

    public static void borrarMesaDeJSON(int numeroDeMesaABorrar) {
        List<Mesa> mesasExistentes = leerJsonMesa();

        // Use stream and filter to find the mesa with the given ID
        Optional<Mesa> optionalMesaABorrar = mesasExistentes.stream()
                .filter(mesa -> mesa.getNumeroMesa() == numeroDeMesaABorrar)
                .findFirst();

        if (optionalMesaABorrar.isPresent()) {
            Mesa mesaABorrar = optionalMesaABorrar.get();
            mesasExistentes.remove(mesaABorrar);

            try (FileWriter writer = new FileWriter("mesas.json")) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(mesasExistentes, writer);
            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo JSON de mesas");
            }
        } else {
            System.out.println("No se encontró una mesa con el ID especificado.");
        }
    }

    // #endregion

    // #region: Manejo de JSON para los platos

    public static void agregarAJsonMenu(MenuItem nuevoPlato) {
        List<MenuItem> menu = leerJsonMenu();

        menu.add(nuevoPlato);

        try (FileWriter writer = new FileWriter("menu.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(menu, writer);
        } catch (IOException e) {
            System.out.println("Error Al escribir el archivo " + e.getMessage());
        }
    }

    public static List<MenuItem> leerJsonMenu() {
        File file = new File("menu.json");
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (Reader reader = new FileReader(file)) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<MenuItem>>() {
            }.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            System.out.println("Error al leer los datos del archivo: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public static void actualizarJsonMenu(MenuItem platoAModificar) {
        List<MenuItem> menuExistente = leerJsonMenu();

        menuExistente.forEach(itemActual -> {
            if (itemActual.getNumeroPlato() == platoAModificar.getNumeroPlato()) {
                menuExistente.set(menuExistente.indexOf(itemActual), platoAModificar);
            }
        });

        try (FileWriter writer = new FileWriter("menu.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(menuExistente, writer);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo JSON del menu");
        }

    }

    public static void borrarMenuDeJSON(int numeroDePlatoABorrar) {
        List<MenuItem> menuActual = leerJsonMenu();

        // Use stream and filter to find the mesa with the given ID
        Optional<MenuItem> optionalPlatoABorrar = menuActual.stream()
                .filter(item -> item.getNumeroPlato() == numeroDePlatoABorrar)
                .findFirst();

        if (optionalPlatoABorrar.isPresent()) {
            MenuItem platoABorrar = optionalPlatoABorrar.get();
            menuActual.remove(platoABorrar);

            try (FileWriter writer = new FileWriter("menu.json")) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(menuActual, writer);
            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo JSON del menu");
            }
        } else {
            System.out.println("No se encontró un plato con el ID especificado.");
        }
    }

    // #endregion

}
