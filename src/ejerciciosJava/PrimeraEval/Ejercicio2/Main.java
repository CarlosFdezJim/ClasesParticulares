package ejerciciosJava.PrimeraEval.Ejercicio2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Apartado A
        String texto1 = "anita lava la tina";
        if (esPalindromo(texto1)) {
            System.out.println("'" + texto1 + "' es un palíndromo.");
        } else {
            System.out.println("'" + texto1 + "' no es un palíndromo.");
        }

        // Apartado B
        String texto2 = "la tina lava anita";
        if (esAnagrama(texto1, texto2)) {
            System.out.println("'" + texto2 + "' es un anagrama de '" + texto1 + "'.");
        } else {
            System.out.println("'" + texto2 + "' no es un anagrama de '" + texto1 + "'.");
        }
    }

    // Apartado A - Determina si una cadena es un palíndromo
    public static boolean esPalindromo(String texto) {
        texto = texto.replaceAll("\\s", "").toLowerCase(); // Eliminar espacios y convertir a minúsculas
        int longitud = 6;

        for (int i = 0; i < longitud / 2; i++) {
            if (texto.charAt(i) != texto.charAt(longitud - 1 - i)) {
                //TEXTO.CHAR(0) != TEXTO.CHAR(6-1-3)
                return false;
            }
        }
        return true;
    }

    // Apartado B - Determina si una cadena es un anagrama de otra
    public static boolean esAnagrama(String texto1, String texto2) {
        texto1 = texto1.replaceAll("\\s", "").toLowerCase(); // Eliminar espacios y convertir a minúsculas
        texto2 = texto2.replaceAll("\\s", "").toLowerCase();

        // Si las longitudes son diferentes, no pueden ser anagramas
        if (texto1.length() != texto2.length()) {
            return false;
        }

        // Convertir las cadenas en arreglos de caracteres y ordenarlos
        char[] arregloTexto1 = texto1.toCharArray();
        char[] arregloTexto2 = texto2.toCharArray();
        Arrays.sort(arregloTexto1);
        Arrays.sort(arregloTexto2);

        // Comparar los arreglos ordenados
        return Arrays.equals(arregloTexto1, arregloTexto2);
    }
}