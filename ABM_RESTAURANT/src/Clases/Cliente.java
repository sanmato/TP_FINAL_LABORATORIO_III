package Clases;

public class Cliente extends Usuario {
    public Cliente() {

    }

    public Cliente(int id, String dni, String nombreUsuario, String nombre_apellido, String password, String email) {
        super(id, dni, nombreUsuario, nombre_apellido, password, email, false);
    }
}
