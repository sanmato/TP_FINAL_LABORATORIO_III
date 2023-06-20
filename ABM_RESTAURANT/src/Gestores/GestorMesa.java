package Gestores;
import Clases.Mesa;

import Clases.Situacion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GestorMesa {
    public ArrayList<Mesa> mesas;

    public GestorMesa() {
        this.mesas = new ArrayList<>();
    }

    public void agregarMesas(Mesa mesa) {
        List<Mesa> mesaList = leerMesa();
        mesaList.add(mesa);
        try (FileWriter writer = new FileWriter("mesa.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(mesaList, writer);
        } catch (IOException e) {
            System.out.println("Error Al escribir el archivo " + e.getMessage());
        }
    }

    public List<Mesa> leerMesa() {
        File file = new File("mesa.json");
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

//    public void eliminarMesa(Mesa m) {
//        List<Mesa> mesaList = leerMesa();
//        mesaList.remove(m);
//        try(FileWriter writer = new FileWriter("mesa.json")){
//            Gson gson = new GsonBuilder().create();
//            String jsonString = gson.toJson(m);
//            writer.append(jsonString);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
  //  }
    public boolean verificarMesaDisponible(int numeroMesa) {
        try {
            List<Mesa> mesas = leerMesa();
            for (Mesa mesa : mesas) {
                if (mesa.getNumMesa() == numeroMesa && mesa.getSituacion() == Situacion.LIBRE) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer los datos del archivo: " + e.getMessage());
        }
        return false;
    }

    public List<Mesa> consultarMesasDisponibles() {
        List<Mesa> mesasDisponibles = null;
        try {
            List<Mesa> mesas = leerMesa();
            mesasDisponibles = new ArrayList<>();

            for (Mesa mesa : mesas) {
                if (mesa.getSituacion() == Situacion.LIBRE) {
                    mesasDisponibles.add(mesa);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer los datos del archivo: " + e.getMessage());
        }
        return mesasDisponibles;
    }

    @Override
    public String toString() {
        return "GestorMesa{" +
                "mesas=" + mesas +
                '}';
    }
}
