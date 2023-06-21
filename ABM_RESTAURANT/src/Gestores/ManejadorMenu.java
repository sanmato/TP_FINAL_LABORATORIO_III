package Gestores;

import java.util.InputMismatchException;
import java.util.Scanner;
import Clases.Usuario;

public class ManejadorMenu {

    private GestorUsuarios gestorUsuarios;
    private GestorReserva gestorReserva;
    private GestorMesa gestorMesa;
    private GestorMenuItem gestorMenuItem;

    private Usuario usuarioLogueado;

    public ManejadorMenu(GestorUsuarios gestorUsuarios, GestorReserva gestorReserva, GestorMesa gestorMesa,
            GestorMenuItem gestorMenuItem) {
        this.gestorUsuarios = gestorUsuarios;
        this.gestorReserva = gestorReserva;
        this.gestorMesa = gestorMesa;
        this.gestorMenuItem = gestorMenuItem;
    }

    public void showLoginMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("========== MENÚ DE INICIO DE SESIÓN ==========");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            System.out.println("===============================");
            System.out.print("Ingrese su opción: ");

            try {
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        if (gestorUsuarios.login()) {
                            usuarioLogueado = gestorUsuarios.getUsuarioLogueado();
                            if (usuarioLogueado.getIsAdmin() == false) {
                                showUserMenu();
                            } else {
                                verMenuAdministrador();
                            }
                        }
                        break;
                    case 2:
                        gestorUsuarios.registro();
                        break;
                    case 3:
                        exit = true;
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
                scanner.nextLine();
            }
        }

        System.out.println("¡Hasta luego!");
    }

    public void showUserMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("========== MENÚ DEL CLIENTE ==========");
            System.out.println("1. Cambiar Contraseña");
            System.out.println("2. Cambiar Correo Electrónico");
            System.out.println("3. Agregar Reserva");
            System.out.println("4. Ver Reserva");
            System.out.println("5. Modificar Reserva");
            System.out.println("6. Modificar Orden");
            System.out.println("7. Eliminar Reserva");
            System.out.println("8. Cerrar Sesión");
            System.out.println("===============================");
            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    gestorUsuarios.cambiarClave(usuarioLogueado);
                    break;
                case 2:
                    gestorUsuarios.cambiarCorreo(usuarioLogueado);
                    break;
                case 3:
                    gestorReserva.agregarReserva(usuarioLogueado);
                    break;
                case 4:
                    gestorReserva.verReserva(usuarioLogueado);
                    break;
                case 5:
                    gestorReserva.modificarReserva(usuarioLogueado);
                    break;
                case 6:
                    gestorReserva.modificarOrden(usuarioLogueado);
                    break;
                case 7:
                    gestorReserva.eliminarReserva(usuarioLogueado);
                    break;
                case 8:
                    gestorUsuarios.logout();
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }
        }

        System.out.println("¡Hasta luego!");
    }

    public void verMenuAdministrador() {
        Scanner scanner = new Scanner(System.in);

        boolean salir = false;

        while (!salir) {
            System.out.println("==== Menu Admin ====");
            System.out.println("1. Gestion de Usuarios");
            System.out.println("2. Gestion de Mesas");
            System.out.println("3. Gestion de Platos");
            System.out.println("4. Ver Reservas");
            System.out.println("5. Cerrar Sesion");
            System.out.println("0. Salir");
            System.out.println("===============================");
            System.out.print("Ingrese su opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    mostrarMenuUsuarios();
                    break;
                case 2:
                    mostrarMenuMesas();
                    break;
                case 3:
                    mostrarMenuPlatos();
                    break;
                case 4:
                    gestorReserva.obtenerReservas();
                    break;
                case 5:
                    gestorUsuarios.logout();
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion invalida. Por favor, ingrese una opcion valida.");
                    break;
            }
        }
    }

    public void mostrarMenuUsuarios() {
        Scanner scanner = new Scanner(System.in);

        boolean salir = false;

        while (!salir) {
            System.out.println("==== Menu de Gestion de Usuarios ====");
            System.out.println("1. Ver Usuarios Registrados");
            System.out.println("2. Eliminar Usuario");
            System.out.println("0. Volver al Menu Principal");
            System.out.println("===============================");
            System.out.print("Ingrese su opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    gestorUsuarios.verUsuarios();
                    break;
                case 2:
                    gestorUsuarios.eliminarUsuario();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion invalida. Por favor, ingrese una opcion valida.");
                    break;
            }
        }
    }

    public void mostrarMenuMesas() {
        Scanner scanner = new Scanner(System.in);

        boolean salir = false;

        while (!salir) {
            System.out.println("==== Menu de Gestion de Mesas ====");
            System.out.println("1. Agregar nueva Mesa");
            System.out.println("2. Ver todas las Mesas");
            System.out.println("3. Ver las Mesas disponibles");
            System.out.println("4. Modificar la capacidad de una Mesa");
            System.out.println("5. Eliminar una mesa");
            System.out.println("0. Volver al Menu Principal");
            System.out.println("===============================");
            System.out.print("Ingrese su opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    gestorMesa.agregarNuevaMesa();
                    break;
                case 2:
                    gestorMesa.verMesas();
                    break;
                case 3:
                    gestorMesa.mostrarMesasDisponibles();
                    break;
                case 4:
                    gestorMesa.modificarCapacidadMesa();
                    break;
                case 5:
                    gestorMesa.eliminarMesa();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion invalida. Por favor, ingrese una opcion valida.");
                    break;
            }
        }
    }

    public void mostrarMenuPlatos() {
        Scanner scanner = new Scanner(System.in);

        boolean salir = false;

        while (!salir) {
            System.out.println("==== Menu de Gestion de Platos ====");
            System.out.println("1. Agregar un Plato al menu");
            System.out.println("2. Ver la Carta(menu)");
            System.out.println("3. Ver Platos por tipo (Entrada, Principal, Postre)");
            System.out.println("4. Modificar el precio de un Plato");
            System.out.println("5. Retirar un Plato del Menu");
            System.out.println("0. Volver al Menu Principal");
            System.out.println("===============================");
            System.out.print("Ingrese su opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    gestorMenuItem.agregarAlMenu();
                    break;
                case 2:
                    gestorMenuItem.verMenu();
                    break;
                case 3:
                    gestorMenuItem.verPlatosPorTipo();
                    break;
                case 4:
                    gestorMenuItem.modificarPrecio();
                    break;
                case 5:
                    gestorMenuItem.eliminarPlato();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion invalida. Por favor, ingrese una opcion valida.");
                    break;
            }
        }
    }

}