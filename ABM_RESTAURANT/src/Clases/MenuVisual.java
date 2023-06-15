package Clases;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuVisual {
    public MenuVisual() {
    }
    //----------------------------
    public void menuPrincipal(){
        Scanner scan = new Scanner(System.in);
        String opcion = null;
        boolean flag = false;
        do {
            System.out.println("<<< MENU PRINCIPAL >>>");
            System.out.println("1 - Login");
            System.out.println("2 - Registrar");
            System.out.println("0 - CERRAR");
            System.out.printf("Seleccione una opcion... ");
            opcion = scan.nextLine();

            if(opcion.equals("1") || opcion.equals("2") || opcion.equals("0")){
                switch (opcion) {
                    case "1":
                        menuLogin();
                        break;
                    case "2":
                        menuRegistrar();
                        break;
                    case "0":
                        System.out.println("\n .... PROGRAMA TERMINADO.");
                        flag = true;
                }
            }else{
                System.out.println("Opcion invalida, vualva a intentarlo...");
            }
        }while(flag==false && (!opcion.equals("1") || !opcion.equals("2") || !opcion.equals("0")));
    }
    //----------------------------
    public void menuRegistrar(){
        System.out.println("***** REGISTRAR (FALTA IMPLEMENTAR) ****\n\n\n");
    }
    //----------------------------
    public void menuLogin(){
        Scanner scan = new Scanner(System.in);
        String opcion = null;
        boolean flag = false;
        do {
            System.out.println("    <<< LOGIN >>>");
            System.out.println("    1 - Login Administrador");
            System.out.println("    2 - Login Cliente");
            System.out.println("    0 - ATRAS");
            System.out.printf("    Seleccione una opcion... ");
            opcion = scan.nextLine();

            if(opcion.equals("1") || opcion.equals("2") || opcion.equals("0")){
                switch (opcion) {
                    case "1":
                        menuAdministrador();
                        break;
                    case "2":
                        menuCliente();
                        break;
                    case "0":
                        System.out.println(".....................");
                        flag = true;
                }
            }else{
                System.out.println("Opcion invalida, vualva a intentarlo...");
            }
        }while(flag==false && (!opcion.equals("1") || !opcion.equals("2") || !opcion.equals("0")));
    }
    //----------------------------
    public void menuAdministrador(){
        Scanner scan = new Scanner(System.in);
        String opcion = null;
        boolean flag = false;
        do {
            System.out.println("        <<< ADMINISTRADOR >>>");
            System.out.println("        1 - Gestionar Reservas");
            System.out.println("        2 - Gestionar Menu");
            System.out.println("        3 - Gestionar Mesas");
            System.out.println("        4 - Gestionar Usuarios");
            System.out.println("        0 - ATRAS");
            System.out.printf("        Seleccione una opcion... ");
            opcion = scan.nextLine();

            if(opcion.equals("1") || opcion.equals("2") || opcion.equals("3") || opcion.equals("4") || opcion.equals("0")){
                switch (opcion) {
                    case "1":
                        menuGestionarReservas();
                        break;
                    case "2":
                        menuGestionarMenu();
                        break;
                    case "3":
                        menuGestionarMesas();
                        break;
                    case "4":
                        menuGestionarUsuario();
                        break;
                    case "0":
                        System.out.println(".....................");
                        flag = true;
                }
            }else{
                System.out.println("Opcion invalida, vualva a intentarlo...");
            }
        }while(flag==false && (!opcion.equals("1") || !opcion.equals("2") || !opcion.equals("3") || !opcion.equals("4") || !opcion.equals("0")));
    }
    //----------------------------
    public void menuGestionarUsuario(){
        Scanner scan = new Scanner(System.in);
        String opcion = null;
        boolean flag = false;
        do {
            System.out.println("            <<< GESTIONAR USUARIOS >>>");
            System.out.println("            1 - Ver Usuarios");
            System.out.println("            2 - Buscar Usuario");
            System.out.println("            3 - Agregar Administrador");
            System.out.println("            0 - ATRAS");
            System.out.printf("            Seleccione una opcion... ");
            opcion = scan.nextLine();

            if(opcion.equals("1") || opcion.equals("2") || opcion.equals("3") || opcion.equals("0")){
                switch (opcion) {
                    case "1":
                        menuVerUsuarios();
                        break;
                    case "2":
                        menuBuscarUsuario();
                        break;
                    case "3":
                        menuAgregarAdministrador();
                        break;
                    case "0":
                        System.out.println(".....................");
                        flag = true;
                }
            }else{
                System.out.println("Opcion invalida, vualva a intentarlo...");
            }
        }while(flag==false && (!opcion.equals("1") || !opcion.equals("2") || !opcion.equals("3") || !opcion.equals("0")));

    }
    //----------------------------
    public void menuVerUsuarios(){  //Filtrar usuario por admin o cliente
        Scanner scan = new Scanner(System.in);
        String opcion = null;
        boolean flag = false;
        do {
            System.out.println("                <<< VER USUARIOS >>>");
            System.out.println("                1 - Ver Administradores");
            System.out.println("                2 - Ver Clientes");
            System.out.println("                0 - ATRAS");
            System.out.printf("                Seleccione una opcion... ");
            opcion = scan.nextLine();

            if(opcion.equals("1") || opcion.equals("2") || opcion.equals("0")){
                switch (opcion) {
                    case "1":
                        System.out.println("***** FILTRAR ADMINISTRADORES (FALTA IMPLEMENTAR) *****\n\n\n");
                        break;
                    case "2":
                        System.out.println("***** FLITRAR CLIENTES (FALTA IMPLEMENTAR) ****\n\n\n");
                        break;
                    case "0":
                        System.out.println(".....................");
                        flag = true;
                }
            }else{
                System.out.println("Opcion invalida, vualva a intentarlo...");
            }
        }while(flag==false && (!opcion.equals("1") || !opcion.equals("2") || !opcion.equals("0")));
    }
    //----------------------------
    public void menuBuscarUsuario(){
        System.out.println("BUSCAR USUARIO (FALTA IMPLEMENTAR)\n\n\n");
    }
    //----------------------------
    public void menuAgregarAdministrador(){
        System.out.println("AGREGAR ADMINISTRADOR (FALTA IMPLEMENTAR)\n\n\n");
    }
    //----------------------------
    public void menuCliente(){
        Scanner scan = new Scanner(System.in);
        String opcion = null;
        boolean flag = false;
        do {
            System.out.println("        <<< CLIENTE >>>");
            System.out.println("        1 - Hacer Reserva");
            System.out.println("        2 - Ver Reserva");
            System.out.println("        3 - Cancelar Reserva");
            System.out.println("        4 - Ver Datos Cliente");
            System.out.println("        0 - ATRAS");
            System.out.printf("        Seleccione una opcion... ");
            opcion = scan.nextLine();

            if(opcion.equals("1") || opcion.equals("2") || opcion.equals("3") || opcion.equals("4") || opcion.equals("0")){
                switch (opcion) {
                    case "1":
                        menuHacerReserva();
                        break;
                    case "2":
                        menuVerReserva();
                        break;
                    case "3":
                        menuCancelarReserva();
                        break;
                    case "4":
                        menuVerDatosCliente();
                        break;
                    case "0":
                        System.out.println(".....................");
                        flag = true;
                }
            }else{
                System.out.println("Opcion invalida, vualva a intentarlo...");
            }
        }while(flag==false && (!opcion.equals("1") || !opcion.equals("2") || !opcion.equals("3") || !opcion.equals("4") || !opcion.equals("0")));
    }
    //----------------------------
    public void menuHacerReserva(){
        System.out.println("HACER RESERVA (FALTA IMPLEMENTAR)\n\n\n");
    }
    //----------------------------
    public void menuVerReserva(){
        System.out.println("VER RESERVA (FALTA IMPLEMENTAR)\n\n\n");
    }
    //----------------------------
    public void menuCancelarReserva(){
        System.out.println("CANCELAR RESERVA (FALTA IMPLEMEMTAR)\n\n\n");
    }
    //----------------------------
    public void menuVerDatosCliente(){
        System.out.println("<<< DATOS CLIENTE >>>");
        //verCliente() sin password
        System.out.println("DATOS AQUI...\nN\nA\nDNI\n\n");
        Scanner scan = new Scanner(System.in);
        String opcion = null;
        boolean flag = false;
        do {
            System.out.println(".........................");
            System.out.println("1 - Modificar Datos");
            System.out.println("0 - ATRAS");
            System.out.printf("Seleccione una opcion... ");
            opcion = scan.nextLine();

            if(opcion.equals("1") || opcion.equals("0")){
                switch (opcion) {
                    case "1":
                        menuModificarDatosCliente();
                        break;
                    case "0":
                        System.out.println(".....................");
                        flag = true;
                }
            }else{
                System.out.println("Opcion invalida, vualva a intentarlo...");
            }
        }while(flag==false && (!opcion.equals("1") || !opcion.equals("0")));
    }
    //----------------------------
    public void menuModificarDatosCliente(){
        Scanner scan = new Scanner(System.in);
        String opcion = null;
        boolean flag = false;
        do {
            System.out.println("<<< MODIFICAR DATOS CLIENTE >>>");
            System.out.println("1 - Modificar Nombre de Usuario"); // VALIDAR NUEVO
            System.out.println("2 - Modificar Nombre y Apellido");
            System.out.println("3 - Modificar E-Mail");
            System.out.println("4 - Cambiar Password");
            System.out.println("0 - ATRAS");
            System.out.printf("Seleccione una opcion... ");
            opcion = scan.nextLine();

            if(opcion.equals("1") || opcion.equals("2") || opcion.equals("3") || opcion.equals("4") || opcion.equals("0")){
                switch (opcion) {
                    case "1":
                        menuModificarNombreUsuario();
                        break;
                    case "2":
                        menuModificarNombreYApellido();
                        break;
                    case "3":
                        menuModificarEMail();
                        break;
                    case "4":
                        menuCambiarPassword();
                        break;
                    case "0":
                        System.out.println(".....................");
                        flag = true;
                }
            }else{
                System.out.println("Opcion invalida, vualva a intentarlo...");
            }
        }while(flag==false && (!opcion.equals("1") || !opcion.equals("2") || !opcion.equals("3") || !opcion.equals("4") || !opcion.equals("0")));
    }
    //----------------------------
    public void menuModificarNombreUsuario(){
        System.out.println("MODIFICAR NOMBRE DE USUARIO (FALTA IMPLEMENTAR\n\n\n)");
    }
    //----------------------------
    public void menuModificarNombreYApellido(){
        System.out.println("MODIFICAR NOMBRE Y APELLIDO (FALTA IMPLEMENTAR\n\n\n)");
    }
    //----------------------------
    public void menuModificarEMail(){
        System.out.println("MODIFICAR E-MAIL (FALTA IMPLEMENTAR\n\n\n)");
    }
    //----------------------------
    public void menuCambiarPassword(){
        System.out.println("CAMBIAR PASSWORD (FALTA IMPLEMENTAR\n\n\n)");
    }
    //----------------------------
    public void menuGestionarReservas(){
        Scanner scan = new Scanner(System.in);
        String opcion = null;
        boolean flag = false;
        do {
            System.out.println("            <<< GESTIONAR RESERVAS >>>");
            System.out.println("            1 - Ver Lista de Reservas");
            System.out.println("            2 - Buscar Reserva");
            System.out.println("            0 - ATRAS");
            System.out.printf("            Seleccione una opcion... ");
            opcion = scan.nextLine();

            if(opcion.equals("1") || opcion.equals("2") || opcion.equals("0")){
                switch (opcion) {
                    case "1":
                        menuVerListaDeReservas();
                        break;
                    case "2":
                        menuBuscarReserva();
                        break;
                    case "0":
                        System.out.println(".....................");
                        flag = true;
                }
            }else{
                System.out.println("Opcion invalida, vualva a intentarlo...");
            }
        }while(flag==false && (!opcion.equals("1") || !opcion.equals("2") || !opcion.equals("0")));
    }
    //----------------------------
    public void menuVerListaDeReservas(){
        Scanner scan = new Scanner(System.in);
        String opcion = null;
        boolean flag = false;
        do {
            System.out.println("<<< VER LISTA DE RESERVAS >>>");
            //FUNCION: Muestra lista de reservas
            System.out.println("LISTA DE RESERVAS\n...a\n...b\n...c...\n\n");
            System.out.printf("0 - ESCAPE ");
            opcion = scan.nextLine();

            if(opcion.equals("0")){
                System.out.println(".....................");
                flag = true;
            }else{
                System.out.println("Opcion invalida, vualva a intentarlo...");
            }
        }while(flag==false && (!opcion.equals("0")));
    }
    //----------------------------
    public void menuBuscarReserva(){
        System.out.println("BUSCAR RESERVA (FALTA IMPLEMENTAR\n\n\n)");
    }
    //----------------------------
    public void modificarReserva(){
        Scanner scan = new Scanner(System.in);
        String opcion = null;
        boolean flag = false;
        do {
            System.out.println("<<< MODIFICAR RESERVA >>>");
            System.out.println("1 - Cambiar Mesa");
            System.out.println("2 - Modificar Orden");
            System.out.println("3 - Eliminar Reserva");
            System.out.println("0 - ATRAS");
            System.out.printf("Seleccione una opcion... ");
            opcion = scan.nextLine();

            if(opcion.equals("1") || opcion.equals("2") || opcion.equals("3") || opcion.equals("0")){
                switch (opcion) {
                    case "1":
                        menuCambiarMesa();
                        break;
                    case "2":
                        menuModificarOrden();
                        break;
                    case "3":
                        menuEliminarReserva();
                        break;
                    case "0":
                        System.out.println(".....................");
                        flag = true;
                }
            }else{
                System.out.println("Opcion invalida, vualva a intentarlo...");
            }
        }while(flag==false && (!opcion.equals("1") || !opcion.equals("2") || !opcion.equals("3") || !opcion.equals("0")));
    }
    //----------------------------
    public void menuCambiarMesa(){
        System.out.println("CAMBIAR MESA (FALTA IMPLEMENTAR)\n\n\n");
    }
    //----------------------------
    public void menuModificarOrden(){
        System.out.println("MODIFICAR ORDEN (FALTA IMPLEMENTAR)\n\n\n");
    }
    //----------------------------
    public void menuEliminarReserva(){
        System.out.println("ELIMINAR RESERVA (FALTA IMPLEMENTAR)\n\n\n");
    }
    //----------------------------
    public void menuGestionarMenu(){
        Scanner scan = new Scanner(System.in);
        String opcion = null;
        boolean flag = false;
        do {
            System.out.println("<<< GESTIONAR MENU >>>");
            System.out.println("1 - Ver Lista de Productos");
            System.out.println("2 - Agregar Producto");
            System.out.println("3 - Buscar Producto");
            System.out.println("0 - ATRAS");
            System.out.printf("Seleccione una opcion... ");
            opcion = scan.nextLine();

            if(opcion.equals("1") || opcion.equals("2") || opcion.equals("3") || opcion.equals("0")){
                switch (opcion) {
                    case "1":
                        menuVerListaProductos();
                        break;
                    case "2":
                        menuAgregarProducto();
                        break;
                    case "3":
                        menuBuscarProducto();
                        break;
                    case "0":
                        System.out.println(".....................");
                        flag = true;
                }
            }else{
                System.out.println("Opcion invalida, vualva a intentarlo...");
            }
        }while(flag==false && (!opcion.equals("1") || !opcion.equals("2") || opcion.equals("3") || !opcion.equals("0")));
    }
    //----------------------------
    public void menuVerListaProductos(){
        System.out.println("VER LISTA DE PRODUCTOS (FALTA IMPLEMENTAR)\n\n\n");
    }
    //----------------------------
    public void menuAgregarProducto(){
        System.out.println("AGREGAR PRODUCTO (FALTA IMPLEMENTAR)\n\n\n");
    }
    //----------------------------
    public void menuBuscarProducto(){
        System.out.println("BUSCAR PRODCUTO (FALTA IMPLEMENTAR)\n\n\n");
    }
    //----------------------------
    public void menuModificarProducto(){
        Scanner scan = new Scanner(System.in);
        String opcion = null;
        boolean flag = false;
        do {
            System.out.println("<<< MODIFICAR PRODUCTO >>>");
            System.out.println("1 - Modificar Precio");
            System.out.println("2 - Modificar Disponibilidad");
            System.out.println("0 - ATRAS");
            System.out.printf("Seleccione una opcion... ");
            opcion = scan.nextLine();

            if(opcion.equals("1") || opcion.equals("2") || opcion.equals("0")){
                switch (opcion) {
                    case "1":
                        menuModificarPrecio();
                        break;
                    case "2":
                        menuModificarDisponibilidad();
                        break;
                    case "0":
                        System.out.println(".....................");
                        flag = true;
                }
            }else{
                System.out.println("Opcion invalida, vualva a intentarlo...");
            }
        }while(flag==false && (!opcion.equals("1") || !opcion.equals("2") || !opcion.equals("0")));
    }
    //----------------------------
    public void menuModificarPrecio(){
        System.out.println("MODIFICAR PRECIO (FALTA IMPLEMENTAR\n\n\n)");
    }
    //----------------------------
    public void menuModificarDisponibilidad(){
        System.out.println("MODIFICAR DISPONIBILIDAD (FALTA IMPLEMENTAR\n\n\n)");
    }
    //----------------------------
    public void menuGestionarMesas(){
        Scanner scan = new Scanner(System.in);
        String opcion = null;
        boolean flag = false;
        do {
            System.out.println("<<< GESTIONAR MESAS >>>");
            System.out.println("1 - Ver Lista de Mesas");
            System.out.println("2 - Mesas Disponibles");
            System.out.println("4 - Agregar Mesa");
            System.out.println("4 - Buscar Mesa");
            System.out.println("0 - ATRAS");
            System.out.printf("Seleccione una opcion... ");
            opcion = scan.nextLine();

            if(opcion.equals("1") || opcion.equals("2") || opcion.equals("3") || opcion.equals("4") || opcion.equals("0")){
                switch (opcion) {
                    case "1":
                        menuVerListaMesas();
                        break;
                    case "2":
                        menuMesasDisponibles();
                        break;
                    case "3":
                        menuAgregarMesa();
                        break;
                    case "4":
                        menuBuscarMesa();
                        break;
                    case "0":
                        System.out.println(".....................");
                        flag = true;
                }
            }else{
                System.out.println("Opcion invalida, vualva a intentarlo...");
            }
        }while(flag==false && (!opcion.equals("1") || !opcion.equals("2") || opcion.equals("3") || opcion.equals("4")|| !opcion.equals("0")));
    }
    //----------------------------
    public void menuVerListaMesas(){
        System.out.println("VER LISTA DE MESAS (FALTA IMPLEMENTAR)\n\n\n");
    }
    //----------------------------
    public void menuMesasDisponibles(){
        System.out.println("VER MESAS DISPONIBLES (FALTA IMPLEMENTAR)\n\n\n");
    }
    //----------------------------
    public void menuAgregarMesa(){
        System.out.println("AGREGAR MESDA (FALTA IMPLEMENTAR)\n\n\n");
    }
    //----------------------------
    public void menuBuscarMesa(){
        System.out.println("BUSCAR MESA (FALTA IMPLEMENTAR)\n\n\n");
    }
    //----------------------------

}
