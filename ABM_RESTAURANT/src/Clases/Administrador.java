package Clases;

public class Administrador extends Usuario {
    public Administrador(int id, String dni, String nombreUsuario, String nombre_apellido, String password,
            String email) {
        super(id, dni, nombreUsuario, nombre_apellido, password, email, true);
    }

    public Administrador() {
    }

}
