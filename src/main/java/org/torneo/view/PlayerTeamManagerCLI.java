package org.torneo.view;

import org.torneo.controller.PlayerTeamManagerController;

import java.time.LocalDate;
import java.util.Scanner;

public class PlayerTeamManagerCLI {
    private final Scanner sc;
    private final PlayerTeamManagerController mController;

    public PlayerTeamManagerCLI(){
        sc = new Scanner(System.in);
         mController = new PlayerTeamManagerController();
    }

    public void menu() {
        int option = 0;

        do {

            option = printMenu();

            switch (option) {
                case 1 -> teamRegistrar();
                case 2 -> addPlayerToTeam();
                case 3 -> removePlayerFromTeam();
                case 4 -> showPlayerList();
                case 5 -> showTeamList();
            }

        } while (option != 6);

        System.out.println("Fin del programa");

        sc.close();
    }

    public int printMenu() {
        int option;

        System.out.println(" 1.- Registrar equipo");
        System.out.println(" 2.- Añadir jugador a un equipo");
        System.out.println(" 3.- Eliminar jugador de un equipo");
        System.out.println(" 4.- Mostrar lista de jugadores");
        System.out.println(" 5.- Mostrar todos los equipos");
        System.out.println(" 6.- Salir");

        System.out.print("Introduce una opción, 6 para salir: ");
        option = sc.nextInt();

        while (option < 1 || option > 6) {
            System.out.println("Opción incorrecta, validos valores de 1 a 6");
            System.out.print("Introduce una opción: ");
            option = sc.nextInt();
        }

        return option;
    }

    public void teamRegistrar() {
        System.out.println("Para registrar un nuevo equipo debe introducir su nombre.");
        String name = sc.next();
        System.out.print(mController.registerTeam(name) + "\n\n");
        sc.nextLine();
    }

    public void addPlayerToTeam() {
        int option = 0;

        do {
            System.out.println(" 1.- Añadir jugador ya existente");
            System.out.println(" 2.- Añadir nuevo jugador");
            System.out.println(" 3.- Salir");

            System.out.print("Introduce una opción, 3 para salir: ");

            option = sc.nextInt();
        } while (option < 1 || option > 3);

        switch (option) {
            case 1:
                System.out.print("Introduce el dni del jugador: ");
                String dni = sc.next();
                System.out.print("Introduce el nombre del equipo: ");
                String name = sc.next();
                System.out.println(mController.addPlayerToTeam(dni, name));
                break;
            case 2:
                System.out.print("Introduce el dni del jugador: ");
                String dni2 = sc.next();
                System.out.print("Introduce el nombre del jugador: ");
                String pName = sc.next();
                System.out.println("Introduce el primer apellido del jugador: ");
                String pLastName = sc.next();
                System.out.println("Introduce el segundo apellido del jugador: ");
                String pLastName2 = sc.next();
                System.out.println("Introduce el email del jugador: ");
                String email = sc.next();
                System.out.println("Introduce el telefono del jugador: ");
                String phone = sc.next();
                System.out.println("Introduce el año de nacimiento del jugador: ");
                int year = sc.nextInt();
                System.out.println("Introduce el mes de nacimiento del jugador: ");
                int month = sc.nextInt();
                System.out.println("Introduce el día de nacimiento del jugador: ");
                int day = sc.nextInt();
                System.out.println("introduce el nombre de usuario del jugador: ");
                String userName = sc.next();
                System.out.println("Introduce el nombre del equipo al que lo quieres añadir: ");
                String teamName = sc.next();

                System.out.println("\n" +
                        mController.addPlayerToTeam(dni2,
                                                    pName,
                                                    pLastName,
                                                    pLastName2,
                                                    email,
                                                    phone,
                                                    teamName,
                                                    LocalDate.of(year, month, day),
                                                    userName) + "\n\n");
        }
        sc.nextLine();
    }

    public void removePlayerFromTeam() {
        System.out.println("introduce el dni del jugador: ");
        String dni = sc.next();
        System.out.println("introduce el nombre del equipo: ");
        String name = sc.next();
        System.out.println(mController.removePlayerFromTeam(dni, name) + "\n\n");
        sc.nextLine();
    }

    public void showPlayerList() {
        System.out.println(mController.playersList() + "\n\n");
    }

    public void showTeamList() {
        System.out.println(mController.teamsList() + "\n\n");
    }



}
