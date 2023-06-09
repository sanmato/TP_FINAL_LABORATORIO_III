package Clases;
import javax.management.StringValueExp;
import java.sql.Array;
import java.util.Random;
public abstract class Usuario {
    //---------------
    //region Atributos
        private String idUsuario;
        private String nombre;
        private String apellido;
        private String contrasenia;
        private boolean esAdmin;
    //endregion
    //---------------
    //region Constructores
        public Usuario() {
        }
        public Usuario(String idUsuario, String nombre, String apellido, String contrasenia, boolean esAdmin) {
            this.idUsuario = idUsuario;
            this.nombre = nombre;
            this.apellido = apellido;
            this.contrasenia = contrasenia;
            this.esAdmin = esAdmin;
        }
    //endregion
    //---------------
    //region Getters
        public String getIdUsuario() {
            return idUsuario;
        }
        public String getNombre() {
            return nombre;
        }
        public String getApellido() {
            return apellido;
        }
        public String getContrasenia() {
            return contrasenia;
        }
        public boolean isEsAdmin() {
            return esAdmin;
        }
    //endregion
    //---------------
    //region Setters
        public void setIdUsuario(String idUsuario) {
            this.idUsuario = idUsuario;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public void setApellido(String apellido) {
            this.apellido = apellido;
        }
        public void setContrasenia(String contrasenia) {
            this.contrasenia = contrasenia;
        }
        public void setEsAdmin(boolean esAdmin) {
            this.esAdmin = esAdmin;
        }
    //endregion
    //---------------
    //region ToString
    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario='" + idUsuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", esAdmin=" + esAdmin +
                '}';
    }
    //endregion
    //---------------
    //region Metodos

    //endregion
    //---------------
}
