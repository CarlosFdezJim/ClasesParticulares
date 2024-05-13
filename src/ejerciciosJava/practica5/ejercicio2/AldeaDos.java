package ejerciciosJava.practica5.ejercicio2;

import java.io.*;
import java.util.*;

public class AldeaDos {
    private List<Aldeano> aldeanos;

    public AldeaDos() {
        aldeanos = new ArrayList<>();
    }

    public void agregarHabitante(String nombre, String profesion) {
        Aldeano alde1 = new Aldeano(nombre, profesion);
        aldeanos.add(new Aldeano(nombre, profesion));
    }

    public void eliminarHabitante(String nombre) {
        Iterator<Aldeano> iterator = aldeanos.iterator();
        while (iterator.hasNext()) {
            Aldeano aldeano = iterator.next();
            if (aldeano.getNombre().equalsIgnoreCase(nombre)) {
                iterator.remove();
                System.out.println("Se ha eliminado a " + nombre + " de la aldea.");
                return;
            }
        }
        System.out.println("No se encontró a ningún habitante con el nombre " + nombre + ".");
    }

    public void ordenarLista(int metodoDeOrdenacion) {
        switch (metodoDeOrdenacion) {
            case 0:
                Collections.sort(aldeanos, Comparator.comparing(Aldeano::getNombre));
                break;
            case 1:
                Collections.sort(aldeanos, Comparator.comparing(Aldeano::getProfesion));
                break;
            case 2:
                Collections.sort(aldeanos, Comparator.comparingInt(Aldeano::getRomanosDerrotados));
                break;
            default:
                System.out.println("Método de ordenación no válido.");
                return;
        }
        System.out.println("Lista ordenada:");
        for (Aldeano aldeano : aldeanos) {
            System.out.println(aldeano);
        }
    }

    public void buscarHabitantePorNombre(String nombre) {
        for (Aldeano aldeano : aldeanos) {
            if (aldeano.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Profesión de " + nombre + ": " + aldeano.getProfesion());
                return;
            }
        }
        System.out.println("No se encontró a ningún habitante con el nombre " + nombre + ".");
    }

    public void buscarHabitantePorProfesion(String profesion) {
        List<String> habitantes = new ArrayList<>();
        for (Aldeano aldeano : aldeanos) {
            if (aldeano.getProfesion().equalsIgnoreCase(profesion)) {
                habitantes.add(aldeano.getNombre());
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
        for (Aldeano aldeano : aldeanos) {
            System.out.println(aldeano);
        }
    }

    public void expulsarAGenteAleatoriamenteDeLaAldea(int cantidad) {
        if (cantidad >= aldeanos.size()) {
            aldeanos.clear();
            System.out.println("Se han expulsado a todos los habitantes de la aldea.");
        } else {
            Collections.shuffle(aldeanos);
            List<Aldeano> expulsados = aldeanos.subList(0, cantidad);
            for (Aldeano aldeano : expulsados) {
                System.out.println("Se ha expulsado a " + aldeano.getNombre() + " de la aldea.");
                aldeanos.remove(aldeano);
            }
        }
    }

    public void guardarDatosEnArchivoBinario(String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(aldeanos);
            System.out.println("Datos guardados en el archivo binario: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo binario: " + e.getMessage());
        }
    }

    public void cargarDatosDesdeArchivoBinario(String nombreArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            aldeanos = (List<Aldeano>) ois.readObject();
            System.out.println("Datos cargados desde el archivo binario: " + nombreArchivo);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los datos desde el archivo binario: " + e.getMessage());
        }
    }
}
