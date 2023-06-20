package Gestores;

import java.util.Scanner;

public class ManejadorMenu {

    private GestorUsuarios gestorUsuarios;

    public ManejadorMenu(GestorUsuarios gestorUsuarios) {
        this.gestorUsuarios = gestorUsuarios;
    }

    public ManejadorMenu() {

    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("========== MENU ==========");
            System.out.println("1. Log in");
            System.out.println("2. Log out");
            System.out.println("3. Register");
            System.out.println("4. Exit");
            System.out.println("==========================");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    gestorUsuarios.login();
                    break;
                case 2:
                    gestorUsuarios.logout();
                    break;
                case 3:
                    gestorUsuarios.registro();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Goodbye!");
    }
}
