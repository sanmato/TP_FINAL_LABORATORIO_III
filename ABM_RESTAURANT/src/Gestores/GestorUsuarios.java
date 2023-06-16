package Gestores;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import Clases.*;

public class GestorUsuarios {

    private HashMap<Integer, Usuario> usuarios;

    public GestorUsuarios() {
        this.usuarios = new HashMap<>();
    }

    public HashMap<Integer, Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(HashMap<Integer, Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "GestorUsuarios [usuarios=" + usuarios + "]";
    }

    public void registro(String nombreUsuario, String nombre, String password, String email) {
        if (nombreUsuarioExiste(nombreUsuario)) {
            System.out.println("El nombre de usuario ya existe. Por favor elija otro.");
        } else {
            Usuario nuevoUsuario = new Cliente(nombreUsuario, nombre, password, email);
            usuarios.put(nuevoUsuario.getId(), nuevoUsuario);
            System.out.println("Registro exitoso. Bienvenido: " + nuevoUsuario.getNombreUsuario());
            GestorJSON.agregarAJson(nuevoUsuario);
        }
    }

    public boolean login(String nombreUsuario, String password) {
        List<Usuario> usuariosCreados = GestorJSON.leerJson();

        Optional<Usuario> optionalUsuario = usuariosCreados.stream()
                .filter(usuario -> usuario.getNombreUsuario().equals(nombreUsuario))
                .findFirst();

        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            if (usuario.getPassword().equals(password)) {
                System.out.println("Inicio de sesión exitoso. Bienvenido: " + usuario.getNombreUsuario());
                return true;
            }
        }
        System.out.println("Credenciales inválidas. Por favor, verifique su nombre de usuario y contraseña.");
        return false;
    }

    private boolean nombreUsuarioExiste(String username) {
        List<Usuario> usuariosCreados = GestorJSON.leerJson();

        return usuariosCreados.stream()
                .anyMatch(usuarioActual -> usuarioActual.getNombreUsuario().equals(username));
    }
}