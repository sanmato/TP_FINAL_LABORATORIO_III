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
                System.out.println("Opcion invalida, vualva a intentarlo...\n");
            }
        }while(flag==false && (!opcion.equals("1") || !opcion.equals("2") || !opcion.equals("0")));
    }
    //----------------------------
    public void menuRegistrar(){

    }
    //----------------------------
    public void menuLogin(){
/*
        Scanner scan = new Scanner(System.in);
        boolean flag = false;
        Usuario u = new Usuario();
        String nombreUsuario;
        String password;
        String salida;

        do{
            System.out.printf("    Ingrese S para continuar o N para salir: ");
            salida=scan.nextLine();
            if(salida.equals("n") || salida.equals("N")){
                flag=true;
            }else{
                System.out.printf("    Ingrese Nombre de Usuario: ");
                nombreUsuario=scan.nextLine();
                System.out.printf("    Ingrese Password: ");
                password=scan.nextLine();

                //u = login(nombreUsuario, password);
                if(u == null){
                    System.out.println("    Usuario o Password invalidos...");
                }else{
                    if(u instanceof Cliente){
                        menuCliente();
                    }else{
                        menuAdministrador();
                    }
                }
            }
        }while(flag==false && (salida.equals("s") || !salida.equals("S") || !salida.equals("n") || !salida.equals("N")));
*/
        //------------------------------------------------------------------------
        Scanner scan2 = new Scanner(System.in);
        String opcion = null;
        boolean flag2 = false;
        do {
            System.out.println("<<< LOGIN >>>");
            System.out.println("1 - Login Administrador");
            System.out.println("2 - Login Cliente");
            System.out.println("0 - ATRAS");
            System.out.printf("Seleccione una opcion... ");
            opcion = scan2.nextLine();

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
                        flag2 = true;
                }
            }else{
                System.out.println("Opcion invalida, vualva a intentarlo...\n");
            }
        }while(flag2==false && (!opcion.equals("1") || !opcion.equals("2") || !opcion.equals("0")));
    }
    //----------------------------
    public void menuAdministrador(){
        Scanner scan = new Scanner(System.in);
        String opcion = null;
        boolean flag = false;
        do {
            System.out.println("    <<< ADMINISTRADOR >>>");
            System.out.println("    1 - Gestionar Reservas");
            System.out.println("    2 - Gestionar Menu");
            System.out.println("    3 - Gestionar Mesas");
            System.out.println("    4 - Gestionar Usuarios");
            System.out.println("    0 - ATRAS");
            System.out.printf("    Seleccione una opcion... ");
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
                        System.out.println("    .....................");
                        flag = true;
                }
            }else{
                System.out.println("    Opcion invalida, vualva a intentarlo...\n");
            }
        }while(flag==false && (!opcion.equals("1") || !opcion.equals("2") || !opcion.equals("3") || !opcion.equals("4") || !opcion.equals("0")));
    }
    //----------------------------
    public void menuGestionarUsuario(){
        Scanner scan = new Scanner(System.in);
        String opcion = null;
        boolean flag = false;
        do {
            System.out.println("        <<< GESTIONAR USUARIOS >>>");
            System.out.println("        1 - Ver Lista de Usuarios");
            System.out.println("        2 - Buscar Usuario");
            System.out.println("        3 - Agregar Administrador");
            System.out.println("        0 - ATRAS");
            System.out.printf("        Seleccione una opcion... ");
            opcion = scan.nextLine();

            if(opcion.equals("1") || opcion.equals("2") || opcion.equals("3") || opcion.equals("0")){
                switch (opcion) {
                    case "1":
                        System.out.println("VER LISTA DE USUARIOS (FLATA IMPLEMENTAR\n\n)");
                        break;
                    case "2":
                        menuBuscarUsuario();
                        break;
                    case "3":
                        menuAgregarAdministrador();
                        break;
                    case "0":
                        System.out.println("        .....................");
                        flag = true;
                }
            }else{
                System.out.println("        Opcion invalida, vualva a intentarlo...\n");
            }
        }while(flag==false && (!opcion.equals("1") || !opcion.equals("2") || !opcion.equals("3") || !opcion.equals("0")));
    }
    //----------------------------
    public void menuBuscarUsuario(){
        Scanner scan = new Scanner(System.in);
        String opcion = null;
        boolean flag = false;
        do {
            System.out.println("            <<< BUSCAR USUARIO >>>");
            System.out.println("            1 - Por Id");
            System.out.println("            2 - Por DNI");
            System.out.println("            0 - ATRAS");
            System.out.printf("            Seleccione una opcion... ");
            opcion = scan.nextLine();

            if(opcion.equals("1") || opcion.equals("2") || opcion.equals("0")){
                switch (opcion) {
                    case "1":
                        menuBuscarPorId();
                        break;
                    case "2":
                        menuBuscarPorDNI();
                        break;
                    case "0":
                        System.out.println("            .....................");
                        flag = true;
                }
            }else{
                System.out.println("            Opcion invalida, vualva a intentarlo...\n");
            }
        }while(flag==false && (!opcion.equals("1") || !opcion.equals("2") || !opcion.equals("0")));
    }
    //----------------------------
    public void menuBuscarPorId(){
        System.out.println("BUSCAR USUARIO POR ID (FALTA IMPLEMENTAR)\n\n");
    }
    //----------------------------
    public void menuBuscarPorDNI(){
        System.out.println("BUSCAR USUARIO POR ID (FALTA IMPLEMENTAR)\n\n");
    }
    //----------------------------
    public void menuUsuarioEncontrado(){
        Scanner scan = new Scanner(System.in);
        String opcion = null;
        boolean flag = false;
        do {
            System.out.println("<<< ESTE USUARIO >>>");
            //MUESTRA DATOS USUARIO
            System.out.println("DATOS DE ESTE USUARIO\ndato1\ndato2\ndato3\n\n");
            System.out.println("1 - Eliminar Usuario");
            System.out.println("0 - ATRAS");
            System.out.printf("Seleccione una opcion... ");
            opcion = scan.nextLine();

            if(opcion.equals("1") || opcion.equals("0")){
                switch (opcion) {
                    case "1":
                        menuEliminarUsuario();
                        break;
                    case "0":
                        System.out.println(".....................");
                        flag = true;
                }
            }else{
                System.out.println("Opcion invalida, vualva a intentarlo...\n");
            }
        }while(flag==false && (!opcion.equals("1") || !opcion.equals("0")));
    }
    //----------------------------
    public void menuEliminarUsuario(){
        System.out.println("ELIMINAR ESTE USUARIO (FALTA IMPLEMENTAR)\n\n");
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
            System.out.println("    <<< CLIENTE >>>");
            System.out.println("    1 - Hacer Reserva");
            System.out.println("    2 - Ver Reserva");
            System.out.println("    3 - Ver Datos Cliente");
            System.out.println("    0 - ATRAS");
            System.out.printf("    Seleccione una opcion... ");
            opcion = scan.nextLine();

            if(opcion.equals("1") || opcion.equals("2") || opcion.equals("3") || opcion.equals("0")){
                switch (opcion) {
                    case "1":
                        menuHacerReserva();
                        break;
                    case "2":
                        menuVerReserva();
                        break;
                    case "3":
                        menuVerDatosCliente();
                        break;
                    case "0":
                        System.out.println("    .....................");
                        flag = true;
                }
            }else{
                System.out.println("    Opcion invalida, vualva a intentarlo...\n");
            }
        }while(flag==false && (!opcion.equals("1") || !opcion.equals("2") || !opcion.equals("3") || !opcion.equals("0")));
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
    public void menuVerDatosCliente(){
        System.out.println("        <<< DATOS CLIENTE >>>");
        //verCliente() sin password
        System.out.println("        DATOS AQUI...\n        N\n        A\n        DNI\n\n");
        Scanner scan = new Scanner(System.in);
        String opcion = null;
        boolean flag = false;
        do {
            System.out.println("        .........................");
            System.out.println("        1 - Modificar Datos");
            System.out.println("        0 - ATRAS");
            System.out.printf("        Seleccione una opcion... ");
            opcion = scan.nextLine();

            if(opcion.equals("1") || opcion.equals("0")){
                switch (opcion) {
                    case "1":
                        menuModificarDatosCliente();
                        break;
                    case "0":
                        System.out.println("        .....................");
                        flag = true;
                }
            }else{
                System.out.println("        Opcion invalida, vualva a intentarlo...\n");
            }
        }while(flag==false && (!opcion.equals("1") || !opcion.equals("0")));
    }
    //----------------------------
    public void menuModificarDatosCliente(){
        Scanner scan = new Scanner(System.in);
        String opcion = null;
        boolean flag = false;
        do {
            System.out.println("            <<< MODIFICAR DATOS CLIENTE >>>");
            System.out.println("            1 - Modificar Nombre de Usuario"); // VALIDAR NUEVO
            System.out.println("            2 - Modificar Nombre y Apellido");
            System.out.println("            3 - Modificar E-Mail");
            System.out.println("            4 - Cambiar Password");
            System.out.println("            0 - ATRAS");
            System.out.printf("            Seleccione una opcion... ");
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
                        System.out.println("            .....................");
                        flag = true;
                }
            }else{
                System.out.println("            Opcion invalida, vualva a intentarlo...\n");
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
            System.out.println("        <<< GESTIONAR RESERVAS >>>");
            System.out.println("        1 - Ver Lista de Reservas");
            System.out.println("        2 - Buscar Reserva");
            System.out.println("        0 - ATRAS");
            System.out.printf("        Seleccione una opcion... ");
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
                        System.out.println("        .....................");
                        flag = true;
                }
            }else{
                System.out.println("        Opcion invalida, vualva a intentarlo...\n");
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
            System.out.println("LISTA DE RESERVAS\n...a\n...b\n...c\n\n");
            System.out.printf("0 - ESCAPE ");
            opcion = scan.nextLine();

            if(opcion.equals("0")){
                System.out.println(".....................");
                flag = true;
            }else{
                System.out.println("Opcion invalida, vualva a intentarlo...\n");
            }
        }while(flag==false && (!opcion.equals("0")));
    }
    //----------------------------
    public void menuBuscarReserva(){
        //cambiar Objetc por Reserva
        Object buscada = new Object();

        if(buscada!=null){
            Scanner scan = new Scanner(System.in);
            String opcion = null;
            boolean flag = false;
            do {
                //Muestra Reserva
                System.out.println("MUESTRA RESERVAS:\ndato1\ndato2\ndato3\n\n");
                System.out.println("1 - Cerrar Reserva");
                System.out.println("0 - ATRAS");
                System.out.printf("Seleccione una opcion... ");
                opcion = scan.nextLine();

                if(opcion.equals("1") || opcion.equals("2") || opcion.equals("3") || opcion.equals("0")){
                    switch (opcion) {
                        case "1":
                            //  Cerrar Reserva
                            break;
                        case "0":
                            System.out.println(".....................");
                            flag = true;
                    }
                }else{
                    System.out.println("Opcion invalida, vualva a intentarlo...\n");
                }
            }while(flag==false && (!opcion.equals("1") || !opcion.equals("2") || !opcion.equals("3") || !opcion.equals("0")));
        }else{
            System.out.println("Reserva Inexistente.\n");
        }
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
                System.out.println("                Opcion invalida, vualva a intentarlo...\n");
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
            System.out.println("        <<< GESTIONAR MENU >>>");
            System.out.println("        1 - Ver Lista de Items");
            System.out.println("        2 - Agregar Item");
            System.out.println("        3 - Buscar Itrem");
            System.out.println("        0 - ATRAS");
            System.out.printf("        Seleccione una opcion... ");
            opcion = scan.nextLine();

            if(opcion.equals("1") || opcion.equals("2") || opcion.equals("3") || opcion.equals("0")){
                switch (opcion) {
                    case "1":
                        menuVerListaItems();
                        break;
                    case "2":
                        menuAgregarItem();
                        break;
                    case "3":
                        menuBuscarItem();
                        break;
                    case "0":
                        System.out.println("        .....................");
                        flag = true;
                }
            }else{
                System.out.println("        Opcion invalida, vualva a intentarlo...");
            }
        }while(flag==false && (!opcion.equals("1") || !opcion.equals("2") || opcion.equals("3") || !opcion.equals("0")));
    }
    //----------------------------
    public void menuVerListaItems(){
        System.out.println("VER LISTA DE PRODUCTOS (FALTA IMPLEMENTAR)\n\n\n");
    }
    //----------------------------
    public void menuAgregarItem(){
        System.out.println("AGREGAR PRODUCTO (FALTA IMPLEMENTAR)\n\n\n");
    }
    //----------------------------
    public void menuBuscarItem(){
        System.out.println("BUSCAR PRODCUTO (FALTA IMPLEMENTAR)\n\n\n");

        menuModificarItem();
    }
    //----------------------------
    public void menuModificarItem(){
        Scanner scan = new Scanner(System.in);
        String opcion = null;
        boolean flag = false;
        do {
            System.out.println("                <<< MODIFICAR ITEM >>>");
            System.out.println("                1 - Precio");
            System.out.println("                2 - Disponibilidad");
            System.out.println("                0 - ATRAS");
            System.out.printf("                Seleccione una opcion... ");
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
                        System.out.println("        .....................");
                        flag = true;
                }
            }else{
                System.out.println("        Opcion invalida, vualva a intentarlo...\n");
            }
        }while(flag==false && (!opcion.equals("1") || !opcion.equals("2") || !opcion.equals("0")));
    }
    //----------------------------
    public void menuModificarPrecio(){
        System.out.println("MODIFICAR PRECIO (FALTA IMPLEMENTAR)\n\n\n");
    }
    //----------------------------
    public void menuModificarDisponibilidad(){
        System.out.println("MODIFICAR DISPONIBILIDAD (FALTA IMPLEMENTAR)\n\n\n");
    }
    //----------------------------
    public void menuGestionarMesas(){
        Scanner scan = new Scanner(System.in);
        String opcion = null;
        boolean flag = false;
        do {
            System.out.println("        <<< GESTIONAR MESAS >>>");
            System.out.println("        1 - Ver Lista de Mesas");
            System.out.println("        2 - Agregar Mesa");
            System.out.println("        3 - Quitar Mesa");
            System.out.println("        0 - ATRAS");
            System.out.printf("        Seleccione una opcion... ");
            opcion = scan.nextLine();

            if(opcion.equals("1") || opcion.equals("2") || opcion.equals("3") || opcion.equals("4") || opcion.equals("0")){
                switch (opcion) {
                    case "1":
                        menuVerListaMesas();
                        break;
                    case "2":
                        menuVerListaMesas();
                        break;
                    case "3":
                        menuAgregarMesa();
                        break;
                    case "4":
                        menuQuitarMesa();
                        break;
                    case "0":
                        System.out.println("        .....................");
                        flag = true;
                }
            }else{
                System.out.println("        Opcion invalida, vualva a intentarlo...\n");
            }
        }while(flag==false && (!opcion.equals("1") || !opcion.equals("2") || opcion.equals("3") || opcion.equals("4")|| !opcion.equals("0")));
    }
    //----------------------------
    public void menuVerListaMesas(){
        System.out.println("VER LISTA DE MESAS (FALTA IMPLEMENTAR)\n\n\n");
    }
    //----------------------------
    public void menuAgregarMesa(){
        System.out.println("AGREGAR MESDA (FALTA IMPLEMENTAR)\n\n\n");
    }
    //----------------------------
    public void menuQuitarMesa(){
        System.out.println("BUSCAR MESA (FALTA IMPLEMENTAR)\n\n\n");
    }

//----------------------------

}