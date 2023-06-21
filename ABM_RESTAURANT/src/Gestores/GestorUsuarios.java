package Gestores;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import Clases.*;

public class GestorUsuarios {
    private Usuario usuarioLogueado;

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

    private int generarNuevaId() {
        List<Usuario> usuariosExistentes = GestorJSON.leerJsonUsuarios();
        int maxId = 0;

        for (Usuario usuario : usuariosExistentes) {
            if (usuario.getId() > maxId) {
                maxId = usuario.getId();
            }
        }

        return maxId + 1;
    }

    private int solicitarId(Scanner scanner) {
        System.out.println("Ingrese el id de usuario: ");
        return scanner.nextInt();
    }

    private String solicitarNombreUsuario(Scanner scanner) {
        System.out.println("Ingrese nombre del usuario: ");
        return scanner.nextLine();
    }

    private String solicitarNombreYApellido(Scanner scanner) {
        System.out.println("Ingrese nombre completo: ");
        return scanner.nextLine();
    }

    private String solicitarPassword(Scanner scanner) {
        System.out.println("Ingrese la clave: ");
        return scanner.nextLine();
    }

    private String solicitarCorreo(Scanner scanner) {
        System.out.println("Ingrese correo electronico: ");
        return scanner.nextLine();
    }

    private String solicitarDni(Scanner scanner) {
        System.out.println("Ingrese su DNI: ");
        return scanner.nextLine();
    }

    public void verUsuarios() {
        List<Usuario> usuarios = GestorJSON.leerJsonUsuarios();
        usuarios.forEach(usuario -> {
            System.out.println("============================================" + "\n"
                    + "ID de usuario: " + usuario.getId() + "\n"
                    + "Nombre de usuario: " + usuario.getNombreUsuario() + "\n"
                    + "Nombre Completo: " + usuario.getNombre_apellido() + "\n"
                    + "DNI: " + usuario.getDni() + "\n"
                    + "Email: " + usuario.getEmail() + "\n"
                    + "============================================");
        });
    }

    public void registro() {
        Scanner scanner = new Scanner(System.in);

        int idUsuario = generarNuevaId();

        String nombreUsuario = solicitarNombreUsuario(scanner);
        String nombreCompleto = solicitarNombreYApellido(scanner);
        String dni = solicitarDni(scanner);
        String password = solicitarPassword(scanner);
        String email = solicitarCorreo(scanner);

        if (nombreUsuarioExiste(nombreUsuario)) {
            System.out.println("El nombre de usuario ya existe. Por favor elija otro.");
        } else {
            Cliente nuevoUsuario = new Cliente(idUsuario, dni, nombreUsuario, nombreCompleto, password, email);
            usuarios.put(nuevoUsuario.getId(), nuevoUsuario);
            System.out.println("Registro exitoso. Bienvenido: " + nuevoUsuario.getNombreUsuario());
            GestorJSON.agregarAJson(nuevoUsuario);
        }
    }

    public void registroAdmin() {
        Scanner scanner = new Scanner(System.in);

        int idUsuario = generarNuevaId();

        String nombreUsuario = solicitarNombreUsuario(scanner);
        String nombreCompleto = solicitarNombreYApellido(scanner);
        String dni = solicitarDni(scanner);
        String password = solicitarPassword(scanner);
        String email = solicitarCorreo(scanner);

        if (nombreUsuarioExiste(nombreUsuario)) {
            System.out.println("El nombre de usuario ya existe. Por favor elija otro.");
        } else {
            Administrador nuevoUsuario = new Administrador(idUsuario, dni, nombreUsuario, nombreCompleto, password,
                    email);
            usuarios.put(nuevoUsuario.getId(), nuevoUsuario);
            System.out.println("Registro exitoso. Bienvenido: " + nuevoUsuario.getNombreUsuario());
            GestorJSON.agregarAJson(nuevoUsuario);
        }
    }

    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        List<Usuario> usuariosCreados = GestorJSON.leerJsonUsuarios();

        String nombreUsuario = solicitarNombreUsuario(scanner);
        String password = solicitarPassword(scanner);

        Optional<Usuario> optionalUsuario = usuariosCreados.stream()
                .filter(usuario -> usuario.getNombreUsuario().equals(nombreUsuario))
                .findFirst();

        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            if (usuario.getPassword().equals(password)) {
                usuarioLogueado = usuario;
                System.out.println("Inicio de sesión exitoso. Bienvenido: " + usuario.getNombreUsuario());
                return true;
            }
        }
        System.out.println("Credenciales inválidas. Por favor, verifique su nombre de usuario y clave.");
        return false;
    }

    public Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void logout() {
        Scanner scanner = new Scanner(System.in);
        List<Usuario> usuariosCreados = GestorJSON.leerJsonUsuarios();

        String nombreUsuario = solicitarNombreUsuario(scanner);

        Optional<Usuario> optionalUsuario = usuariosCreados.stream()
                .filter(usuario -> usuario.getNombreUsuario().equals(nombreUsuario))
                .findFirst();

        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            System.out.println("Logout successful. Goodbye, " + usuario.getNombreUsuario());
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    public void cambiarClave(Usuario usuarioLogueado) {
        Scanner scanner = new Scanner(System.in);
        List<Usuario> usuarios = GestorJSON.leerJsonUsuarios();

        for (Usuario usuario : usuarios) {
            if (usuario.getId() == usuarioLogueado.getId()) {
                String nuevaClave = solicitarPassword(scanner);
                usuario.setPassword(nuevaClave);
                GestorJSON.actualizarJsonUsuarios(usuario);
                break;
            }
        }
    }

    public void cambiarCorreo(Usuario usuarioLogueado) {
        Scanner scanner = new Scanner(System.in);
        List<Usuario> usuarios = GestorJSON.leerJsonUsuarios();

        for (Usuario usuario : usuarios) {
            if (usuario.getId() == usuarioLogueado.getId()) {
                String nuevoEmail = solicitarCorreo(scanner);
                usuario.setPassword(nuevoEmail);
                GestorJSON.actualizarJsonUsuarios(usuario);
                break;
            }
        }
    }

    public void eliminarUsuario() {
        verUsuarios();
        Scanner scanner = new Scanner(System.in);
        int idABorrar = solicitarId(scanner);
        scanner.nextLine();
        GestorJSON.borrarUsuarioDeJSON(idABorrar);

        System.out.println("Usuario borrado con exito.");
    }

    private boolean nombreUsuarioExiste(String username) {
        List<Usuario> usuariosCreados = GestorJSON.leerJsonUsuarios();

        return usuariosCreados.stream()
                .anyMatch(usuarioActual -> usuarioActual.getNombreUsuario().equals(username));
    }

}