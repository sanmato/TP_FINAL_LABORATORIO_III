package Clases;

import com.google.gson.annotations.Expose;

public class Usuario {
    @Expose
    private int id;
    @Expose
    private String dni;
    @Expose
    private String nombreUsuario;
    @Expose
    private String nombre_apellido;
    private String password;
    @Expose
    private String email;

    public Usuario(int id, String dni, String nombreUsuario, String nombre_apellido, String password, String email) {
        this.id = id;
        this.dni = dni;
        this.nombreUsuario = nombreUsuario;
        this.nombre_apellido = nombre_apellido;
        this.password = password;
        this.email = email;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((nombreUsuario == null) ? 0 : nombreUsuario.hashCode());
        result = prime * result + ((nombre_apellido == null) ? 0 : nombre_apellido.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
