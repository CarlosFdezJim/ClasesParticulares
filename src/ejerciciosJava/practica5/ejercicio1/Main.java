package ejerciciosJava.practica5.ejercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();

    }
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        // double num=0;
        ListadeNumeros listadeNumeros = new ListadeNumeros();


        int opcion = 0;

        do {
            System.out.println("Menú:");
            System.out.println("1. Calcular la suma de los elementos en la lista.");
            System.out.println("2. Calcular el promedio de los elementos en la lista.");
            System.out.println("3. Encontrar el máximo de los elementos en la lista.");
            System.out.println("4. Encontrar el mínimo de los elementos en la lista.");
            System.out.println("5. Calcular la cantidad de números primos de la lista.");
            System.out.println("6. Calcular la suma de dígitos de cada elemento de la lista.");
            System.out.println("7. Calcular la mediana de todos los elementos.");
            System.out.println("8. Calcular la moda de todos los elementos.");
            System.out.println("0. Salir.");
            System.out.print("Ingrese su opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Suma de los elementos en la lista: " + listadeNumeros.calcularSuma());
                    break;
                case 2:
                    System.out.println("Promedio de los elementos en la lista: " + listadeNumeros.calcularPromedio());
                    break;
                case 3:
                    System.out.println("Máximo de los elementos en la lista: " + listadeNumeros.encontrarMaximo());
                    break;
                case 4:
                    System.out.println("Mínimo de los elementos en la lista: " + listadeNumeros.encontrarMinimo());
                    break;
                case 5:
                    System.out.println("Cantidad de números primos en la lista: " + listadeNumeros.calculoNumerosPrimos());
                    break;
                case 6:
                    System.out.println("Suma de dígitos de cada elemento de la lista: " + listadeNumeros.calculoSumaDigitosElementos());
                    break;
                case 7:
                    System.out.println("Mediana de todos los elementos: " + listadeNumeros.calculoMediana());
                    break;
                case 8:
                    System.out.println("Calculo de la moda de todos los elementos: " + listadeNumeros.calcularModa());
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 0);
    }

}
