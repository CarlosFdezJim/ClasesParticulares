package ejerciciosJava.PrimeraEval.Ejercicio3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño (n) de las matrices cuadradas: ");
        int n = scanner.nextInt();

        int[][] matrizA = generarMatrizAleatoria(n);
        int[][] matrizB = generarMatrizAleatoria(n);

        System.out.println("Matriz A:");
        mostrarMatriz(matrizA);
        System.out.println();

        System.out.println("Matriz B:");
        mostrarMatriz(matrizB);
        System.out.println();

        // Apartado A
        int[][] matrizMultiplicacion = multiplicarMatrices(matrizA, matrizB);
        System.out.println("Matriz multiplicación (A * B):");
        mostrarMatriz(matrizMultiplicacion);
        System.out.println();

        // Apartado B
        int[][] matrizPotenciacion = potenciarMatriz(matrizA, matrizB);
        System.out.println("Matriz potenciación (A ^ B):");
        mostrarMatriz(matrizPotenciacion);

        scanner.close();
    }

    // Generar una matriz aleatoria de tamaño nxn con valores entre 0 y 9
    public static int[][] generarMatrizAleatoria(int n) {
        Random random = new Random();
        int[][] matriz = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = random.nextInt(10);
            }
        }

        return matriz;
    }

    // Multiplicar dos matrices cuadradas
    public static int[][] multiplicarMatrices(int[][] matrizA, int[][] matrizB) {
        int n = matrizA.length;
        int[][] resultado = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    resultado[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }

        return resultado;
    }

    // Elevar cada elemento de la matriz A al elemento correspondiente de la matriz B
    public static int[][] potenciarMatriz(int[][] matrizA, int[][] matrizB) {
        int n = matrizA.length;
        int[][] resultado = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                resultado[i][j] = (int) Math.pow(matrizA[i][j], matrizB[i][j]);
            }
        }

        return resultado;
    }

    // Mostrar una matriz en formato matricial
    public static void mostrarMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }
}
