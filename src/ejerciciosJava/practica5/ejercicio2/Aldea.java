package ejerciciosJava.practica5.ejercicio2;

import java.io.*;
import java.util.*;

public class Aldea {
    private Map<Integer, Aldeano> mapaAldeanos;

    public Aldea() {
        mapaAldeanos = new HashMap<>();
//        cargarDatosDesdeArchivoBinario(aldea.bin);
    }

    public void agregarHabitante(String nombre, String profesion) {
        int id = mapaAldeanos.size() + 1;
        Aldeano aldeano1 = new Aldeano(nombre, profesion);
        mapaAldeanos.put(id, aldeano1);
    }

    public void eliminarHabitante(String nombre) {
        boolean habitanteEncontrado = false;
        for (Map.Entry<Integer, Aldeano> aldeanosABorrar : mapaAldeanos.entrySet()) {
            if (aldeanosABorrar.getValue().getNombre().equalsIgnoreCase(nombre)) {
                mapaAldeanos.remove(aldeanosABorrar.getKey());
                System.out.println("Se ha eliminado a " + nombre + " de la aldea.");
                habitanteEncontrado = true;
                break;
            }
        }
        if (!habitanteEncontrado) {
            System.out.println("No se encontró a ningún habitante con el nombre " + nombre + ".");
        }
    }


    public void ordenarLista(int metodoDeOrdenacion) {
        List<Map.Entry<Integer, Aldeano>> listaAldeanos = new ArrayList<>(mapaAldeanos.entrySet());
        switch (metodoDeOrdenacion) {
            case 0:
                Collections.sort(listaAldeanos, Comparator.comparing(e -> e.getKey()));
                break;
            case 1:
                Collections.sort(listaAldeanos, Comparator.comparing(e -> e.getValue().getNombre().toLowerCase()));
                break;
            case 2:
                Collections.sort(listaAldeanos, Comparator.comparing(e -> e.getValue().getProfesion().toLowerCase()));
                break;
            case 3:
                Collections.sort(listaAldeanos, Comparator.comparing(e -> e.getValue().getRomanosDerrotados()));
                break;
            default:
                System.out.println("Método de ordenación no válido.");
                return;
        }
        System.out.println("Lista ordenada:");
        for (Map.Entry<Integer, Aldeano> entry : listaAldeanos) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void buscarHabitantePorNombre(String nombre) {
        for (Map.Entry<Integer, Aldeano> entry : mapaAldeanos.entrySet()) {
            if (entry.getValue().getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Profesión de " + nombre + ": " + entry.getValue().getProfesion());
                return;
            }
        }
        System.out.println("No se encontró a ningún habitante con el nombre " + nombre + ".");
    }

    public void buscarHabitantePorProfesion(String profesion) {
        List<String> habitantes = new ArrayList<>();
        for (Map.Entry<Integer, Aldeano> entry : mapaAldeanos.entrySet()) {
            if (entry.getValue().getProfesion().equalsIgnoreCase(profesion)) {
                habitantes.add(entry.getValue().getNombre());
            }
        }
        if (habitantes.isEmpty()) {
            System.out.println("No se encontró a ningún habitante con la profesión " + profesion + ".");
        } else {
            System.out.println("Habitantes con la profesión " + profesion + ": " + habitantes);
        }
    }

    public void mostrarListadoDeHabitantes() {
        System.out.println("Listado de habitantes:");
        for (Map.Entry<Integer, Aldeano> entry : mapaAldeanos.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void expulsarAGenteAleatoriamenteDeLaAldea(int cantidad) {
        if (cantidad >= mapaAldeanos.size()) {
            mapaAldeanos.clear();
            System.out.println("Se han expulsado a todos los habitantes de la aldea.");
        } else {
            List<Integer> keys = new ArrayList<>(mapaAldeanos.keySet());
            Collections.shuffle(keys);
            List<Integer> expulsados = keys.subList(0, cantidad);
            for (int id : expulsados) {
                System.out.println("Se ha expulsado a " + mapaAldeanos.get(id).getNombre() + " de la aldea.");
                mapaAldeanos.remove(id);
            }
        }
    }

    public void guardarDatosEnArchivoBinario() {
        String nombreArchivo = "aldea.dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(mapaAldeanos);
            System.out.println("Datos guardados en el archivo binario: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo binario: " + e.getMessage());
        }
    }

    public void cargarDatosDesdeArchivoBinario() {
        String nombreArchivo = "aldea.dat";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            mapaAldeanos = (Map<Integer, Aldeano>) ois.readObject();
            System.out.println("Datos cargados desde el archivo binario: " + nombreArchivo);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los datos desde el archivo binario: " + e.getMessage());
        }
    }
}