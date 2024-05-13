package ejerciciosJava.PrimeraEval.Refuerzo;

import java.util.Scanner;

// un programa en Java que realiza varias operaciones (suma, resta y multiplicación)
// entre dos arreglos de la misma longitud y muestra los arreglos resultantes para cada operación

public class OperacionesConArreglos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario el tamaño de los arreglos
        System.out.print("Ingrese el tamaño de los arreglos: ");
        int n = scanner.nextInt();

        // Declarar los arreglos
        int[] arreglo1 = new int[n];
        int[] arreglo2 = new int[n];
        int[] suma = new int[n];
        int[] resta = new int[n];
        int[] multiplicacion = new int[n];

        // Pedir al usuario los elementos del primer arreglo
        System.out.println("Ingrese los elementos del primer arreglo:");
        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            arreglo1[i] = scanner.nextInt();
        }

        // Pedir al usuario los elementos del segundo arreglo
        System.out.println("Ingrese los elementos del segundo arreglo:");
        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            arreglo2[i] = scanner.nextInt();
        }

        // Realizar la suma de los elementos de los dos arreglos
        for (int i = 0; i < n; i++) {
            suma[i] = arreglo1[i] + arreglo2[i];
        }

        // Realizar la resta de los elementos de los dos arreglos
        for (int i = 0; i < n; i++) {
            resta[i] = arreglo1[i] - arreglo2[i];
        }

        // Realizar la multiplicación de los elementos de los dos arreglos
        for (int i = 0; i < n; i++) {
            multiplicacion[i] = arreglo1[i] * arreglo2[i];
        }

        // Mostrar los arreglos resultantes
        System.out.println("La suma de los dos arreglos es:");
        mostrarArreglo(suma);

        System.out.println("La resta de los dos arreglos es:");
        mostrarArreglo(resta);

        System.out.println("La multiplicación de los dos arreglos es:");
        mostrarArreglo(multiplicacion);

        scanner.close();
    }

    // Método para mostrar un arreglo
    public static void mostrarArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }
}