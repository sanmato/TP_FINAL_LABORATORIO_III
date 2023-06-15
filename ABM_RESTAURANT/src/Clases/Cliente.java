package Clases;

import java.util.Random;
import java.util.Scanner;

public class Cliente extends Usuario {
    // ---------------
    // region Atributos
    private Reserva reserva;

    // endregion
    // ---------------
    /// region Constructores
    public Cliente() {
        super();
    }

    public Cliente(String nombreUsuario, String nombre_apellido, String password, String email) {
        super(nombreUsuario, nombre_apellido, password, email);
        this.reserva = reserva;
    }

    // endregion
    // ---------------
    // region Getters
    public Reserva getReserva() {
        return reserva;
    }

    // endregion
    // ---------------
    // region Setters
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    // endregion
    // ---------------
    // region ToString
    @Override
    public String toString() {
        return "Cliente{" +
                "reserva=" + reserva +
                "} " + super.toString();
    }

    public void verCliente(Usuario usuario) {
        System.out.println("Id: " + usuario.getId());
        System.out.println("Nombre de Usuario: " + usuario.getNombreUsuario());
        System.out.println("Nombre y Apellido: " + usuario.getNombre_apellido());
        System.out.println("Email: " + usuario.getEmail());
    }

    // endregion
    // ---------------
    // region Metodos
    public String generarIdRandomString(int cant) {
        Random rand = new Random();
        int numeroRandom = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cant; i++) {
            numeroRandom = rand.nextInt(10);
            sb.append(String.valueOf(numeroRandom));
        }
        return sb.toString();
    }

    public Cliente datosManual() {
        Scanner scan = new Scanner(System.in);
        Cliente c = new Cliente();

        System.out.printf("Ingrese Nombre de Usuario: ");
        c.setNombreUsuario(scan.nextLine());

        System.out.printf("Ingrese Nombre Completo: ");
        c.setNombre_apellido(scan.nextLine());

        System.out.printf("Ingrese Password: ");
        c.setPassword(scan.nextLine());

        System.out.printf("Ingrese Email: ");
        c.setEmail(scan.nextLine());

        return c;
    }
    // endregion
    // ---------------
}
