package Clases;

public class Usuario {
    private int id;
    private String nombreUsuario;
    private String nombre_apellido;
    private String password;
    private String email;
    private boolean esAdmin;
    private static int nextId = 1;

    public Usuario(String nombreUsuario, String nombre_apellido, String password, String email) {
        this.id = nextId++;
        this.nombreUsuario = nombreUsuario;
        this.nombre_apellido = nombre_apellido;
        this.password = password;
        this.email = email;
        this.esAdmin = false;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Usuario.nextId = nextId;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombreUsuario=" + nombreUsuario + ", nombre_apellido=" + nombre_apellido
                + ", password=" + password + ", email=" + email + ", esAdmin=" + esAdmin + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((nombreUsuario == null) ? 0 : nombreUsuario.hashCode());
        result = prime * result + ((nombre_apellido == null) ? 0 : nombre_apellido.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + (esAdmin ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Usuario otrUsuario = (Usuario) obj;
        return nombreUsuario.equals(otrUsuario.nombreUsuario);
    }
}
