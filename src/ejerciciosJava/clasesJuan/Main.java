package ejerciciosJava.clasesJuan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Paso 1: Leer el fichero adjunto
        List<String> partidos = leerFichero("partidos.txt");

        // Paso 2: Procesar los datos para calcular la información requerida
        Map<String, Integer> totalGolesPorPartido = new HashMap<>();
        Map<String, Integer> totalGolesLocal = new HashMap<>();
        Map<String, Integer> totalGolesVisitante = new HashMap<>();
        Map<String, Integer> totalGolesPorEquipo = new HashMap<>();

        for (String partido : partidos) {
            String[] datos = partido.split(",");
            String equipoLocal = datos[0];
            String equipoVisitante = datos[1];
            int golesLocal = Integer.parseInt(datos[2]);
            int golesVisitante = Integer.parseInt(datos[3]);

            // Calcular total de goles por partido
            int totalGoles = golesLocal + golesVisitante;
            totalGolesPorPartido.put(partido, totalGoles);

            // Calcular total de goles por equipo (local y visitante)
            totalGolesLocal.put(equipoLocal, totalGolesLocal.getOrDefault(equipoLocal, 0) + golesLocal);
            totalGolesVisitante.put(equipoVisitante, totalGolesVisitante.getOrDefault(equipoVisitante, 0) + golesVisitante);

            // Calcular total de goles por equipo
            totalGolesPorEquipo.put(equipoLocal, totalGolesPorEquipo.getOrDefault(equipoLocal, 0) + golesLocal);
            totalGolesPorEquipo.put(equipoVisitante, totalGolesPorEquipo.getOrDefault(equipoVisitante, 0) + golesVisitante);
        }

        // Ordenar los partidos por total de goles
        List<Map.Entry<String, Integer>> partidosOrdenadosPorGoles = ordenarPorValor(totalGolesPorPartido);

        // Ordenar los equipos por total de goles
        List<Map.Entry<String, Integer>> equiposOrdenadosPorGoles = ordenarPorValor(totalGolesPorEquipo);

        // Paso 3: Mostrar por pantalla la información ordenada
        mostrarResultado("5 partidos con más goles en total", partidosOrdenadosPorGoles.subList(0, 5));
        mostrarResultado("5 partidos con menos goles en total", partidosOrdenadosPorGoles.subList(partidosOrdenadosPorGoles.size() - 5, partidosOrdenadosPorGoles.size()));
        mostrarResultado("5 partidos con más goles del equipo local", null); // Implementar
        mostrarResultado("5 partidos con más goles del equipo visitante", null); // Implementar
        mostrarResultado("5 equipos con más goles", equiposOrdenadosPorGoles.subList(0, 5));
        mostrarResultado("5 equipos con menos goles", equiposOrdenadosPorGoles.subList(equiposOrdenadosPorGoles.size() - 5, equiposOrdenadosPorGoles.size()));
    }

    // Método para leer el fichero adjunto
    public static List<String> leerFichero(String nombreFichero) {
        List<String> partidos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                partidos.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return partidos;
    }

    // Método para ordenar un mapa por valor en orden descendente
    public static List<Map.Entry<String, Integer>> ordenarPorValor(Map<String, Integer> mapa) {
        List<Map.Entry<String, Integer>> lista = new LinkedList<>(mapa.entrySet());
        lista.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
        return lista;
    }

    // Método para mostrar el resultado
    public static void mostrarResultado(String titulo, List<Map.Entry<String, Integer>> resultados) {
        System.out.println(titulo);
        if (resultados != null) {
            for (Map.Entry<String, Integer> resultado : resultados) {
                System.out.println(resultado.getKey() + ": " + resultado.getValue() + " goles");
            }
        } else {
            System.out.println("No implementado");
        }
        System.out.println();
    }
}
