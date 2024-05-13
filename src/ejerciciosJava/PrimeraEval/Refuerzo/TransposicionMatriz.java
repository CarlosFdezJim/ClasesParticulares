package ejerciciosJava.PrimeraEval.Refuerzo;

import java.util.Scanner;
import java.util.Random;

//Ejercicio: Transposición de Matriz
//Escribe un programa en Java que realice la transposición de una matriz cuadrada.
// El programa debe permitir al usuario ingresar el tamaño de la matriz y luego los elementos de la misma.
// Luego, debe calcular la matriz transpuesta y mostrarla en la salida.


/*
        1 2 3       1 4 7
        4 5 6       2 5 8
        7 8 9       3 6 9
* */

public class TransposicionMatriz {
    public static void main(String[] args) {
        // Tamaño de la matriz cuadrada
        int n = 3; // Puedes cambiar el valor según lo desees

        // Declarar la matriz y generar aleatoriamente los elementos
        int[][] matriz = generarMatrizAleatoria(n);

        // Mostrar la matriz original
        System.out.println("Matriz original:");
        mostrarMatriz(matriz);

        // Calcular la matriz transpuesta
        int[][] matrizTranspuesta = transponerMatriz(matriz);

        // Mostrar la matriz transpuesta
        System.out.println("Matriz transpuesta:");
        mostrarMatriz(matrizTranspuesta);
    }

    // Método para generar una matriz cuadrada con elementos aleatorios del 0 al 9
    public static int[][] generarMatrizAleatoria(int n) {
        int[][] matriz = new int[n][n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = random.nextInt(10); // Números aleatorios del 0 al 9
            }
        }

        return matriz;
    }

    // Método para calcular la matriz transpuesta
    public static int[][] transponerMatriz(int[][] matriz) {
        int n = matriz.length;
        int[][] matrizTranspuesta = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrizTranspuesta[j][i] = matriz[i][j];
            }
        }

        return matrizTranspuesta;
    }

    // Método para mostrar una matriz
    public static void mostrarMatriz(int[][] matriz) {
        int n = matriz.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}