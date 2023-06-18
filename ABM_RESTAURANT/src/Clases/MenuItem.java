package Clases;

public class MenuItem {
    private int numeroPlato;
    private TipoPlato tipo;
    private String nombre;
    private String descripcion;
    private double precio;

    public MenuItem(int numeroPlato, TipoPlato tipo, String nombre, String descripcion, double precio) {
        this.numeroPlato = numeroPlato;
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public MenuItem() {
    }

    public int getNumeroPlato() {
        return numeroPlato;
    }

    public void setNumeroPlato(int numeroPlato) {
        this.numeroPlato = numeroPlato;
    }

    public TipoPlato getTipo() {
        return tipo;
    }

    public void setTipo(TipoPlato tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Numero de plato: " + numeroPlato + "\n" +
                "Tipo: " + tipo + "\n" +
                "Nombre: " + nombre + "\n" +
                "Descripción: " + descripcion + "\n" +
                "Precio: " + precio + "\n" +
                "\n";
    }

}
