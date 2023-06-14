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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class GestorJSON {

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

}
