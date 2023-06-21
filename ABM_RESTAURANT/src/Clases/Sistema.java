package Clases;

import java.util.Scanner;

import Gestores.GestorMenuItem;
import Gestores.GestorMesa;
import Gestores.GestorReserva;
import Gestores.GestorUsuarios;
import Gestores.ManejadorMenu;

public class Sistema {

    public void run() {
        Scanner scanner = new Scanner(System.in);

        GestorReserva gestorReserva = new GestorReserva();
        GestorMenuItem menuManager = new GestorMenuItem();
        GestorMesa mesaManager = new GestorMesa();
        GestorUsuarios userManager = new GestorUsuarios();
        ManejadorMenu manejadorMenu = new ManejadorMenu(userManager, gestorReserva, mesaManager, menuManager);

        manejadorMenu.menuInicial();

        scanner.close();

    }
}
