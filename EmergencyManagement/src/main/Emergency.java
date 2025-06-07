package main;

import java.util.Scanner;

import main.utils.ConsoleUtil;

public class Emergency {

    public void start(Scanner input) {
        int option;
        boolean exitProgram = false;

        do {
            ConsoleUtil.displayMenu();
            option = ConsoleUtil.getUserOption(input);

            while (!input.hasNextInt()) {
                System.out.print("Por favor, ingrese un número válido: ");
                input.next();
            }

            option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1:
                    registrarEmergencia();
                    break;
                case 2:
                    verEstadoRecursos();
                    break;
                case 3:
                    atenderEmergencia();
                    break;
                case 4:
                    mostrarEstadisticas();
                    break;
                case 5:
                    boolean closureConfirmed = finalizarJornada(input);
                    if (closureConfirmed) {
                        exitProgram = false;
                    } else {
                        System.out.println("Regresando al menú principal...");
                    }
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

        } while (exitProgram);
    }

    private static void registrarEmergencia() {
        System.out.println("\n[Registrar una nueva emergencia]");
    }

    private static void verEstadoRecursos() {
        System.out.println("\n[Ver el estado de los recursos disponibles]");
    }

    private static void atenderEmergencia() {
        System.out.println("\n[Atender una emergencia]");
    }

    private static void mostrarEstadisticas() {
        System.out.println("\n[Mostrar estadísticas]");
    }

    private boolean finalizarJornada(Scanner input) {
        System.out.println("\n[Finalizando jornada y guardando registros...]");
        System.out.println("Presione ENTER para cancelar el cierre.");

        final boolean[] canceled = { false };

        Thread inputThread = new Thread(() -> {
            input.nextLine();
            canceled[0] = true;
        });

        inputThread.setDaemon(true);
        inputThread.start();

        try {
            for (int i = 0; i < 3; i++) {
                if (canceled[0]) {
                    System.out.println("[Cierre cancelado por el usuario.]");
                    return false;
                }

                System.out.print("Cerrando sistema");
                for (int j = 0; j <= i; j++) {
                    System.out.print(".");
                }
                System.out.println();
                Thread.sleep(1000);
            }

            System.out.println("[Sistema cerrado correctamente.]");

        } catch (InterruptedException e) {
            System.out.println("El proceso de cierre fue interrumpido.");
            Thread.currentThread().interrupt();
        }

        return true;
    }

}