package ejerciciosJava.practica5.ejercicio2;

public class Main {
    public static void main(String[] args) {


        cargarEjercicio2();


    }
    public static void cargarEjercicio2(){
        Aldea aldea = new Aldea();
        aldea.agregarHabitante("Asterix", "Guerrero");
        aldea.agregarHabitante("Obelix", "Herrero");
        aldea.agregarHabitante("Panoramix", "Druida");
        aldea.mostrarListadoDeHabitantes();
        aldea.eliminarHabitante("Panoramix");
        aldea.mostrarListadoDeHabitantes();
        aldea.agregarHabitante("Ideafix", "Perro");
        aldea.ordenarLista(1);
        aldea.buscarHabitantePorNombre("Obelix");
        aldea.buscarHabitantePorProfesion("Herrero");
        aldea.expulsarAGenteAleatoriamenteDeLaAldea(1);
        aldea.mostrarListadoDeHabitantes();
        aldea.guardarDatosEnArchivoBinario();
        /*aldea.cargarDatosDesdeArchivoBinario();
        aldea.mostrarListadoDeHabitantes();*/

        /*AldeaDos aldea2 = new AldeaDos();
        aldea2.agregarHabitante("Asterix", "Guerrero");
        aldea2.agregarHabitante("Obelix", "Herrero");
        aldea2.agregarHabitante("Panoramix", "Druida");
        aldea2.mostrarListadoDeHabitantes();
        aldea2.eliminarHabitante("Panoramix");
        aldea2.mostrarListadoDeHabitantes();
        aldea2.agregarHabitante("Ideafix", "Perro");
        aldea2.ordenarLista(0);
        aldea2.buscarHabitantePorNombre("Obelix");
        aldea2.buscarHabitantePorProfesion("Herrero");
        aldea2.expulsarAGenteAleatoriamenteDeLaAldea(1);
        aldea2.mostrarListadoDeHabitantes();
        aldea2.guardarDatosEnArchivoBinario("aldea.bin");
        aldea2.cargarDatosDesdeArchivoBinario("aldea.bin");
        aldea2.mostrarListadoDeHabitantes();*/
    }
}
