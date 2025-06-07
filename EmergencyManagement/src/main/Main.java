package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Emergency emergencySystem = new Emergency();
        emergencySystem.start(input);
        input.close();
        System.out.println("Programa finalizado correctamente.");
    }
}