package main.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUtil {
    public static void displayMenu() {
        System.out.println("\n--- Sistema de Gestión de Emergencias Urbanas ---");
        System.out.println("1. Registrar una nueva emergencia");
        System.out.println("2. Ver el estado de los recursos disponibles");
        System.out.println("3. Atender una emergencia");
        System.out.println("4. Mostrar estadísticas");
        System.out.println("5. Finalizar jornada");
        System.out.print("Seleccione una opción: ");
    }

    public static int getUserOption(Scanner input) {
        while (true) {
            try {
                int option = input.nextInt();
                input.nextLine();
                return option;
            } catch (InputMismatchException e) {
                System.out.print("Entrada inválida. Por favor, ingrese un número: ");
                input.next();
            }
        }
    }
}
