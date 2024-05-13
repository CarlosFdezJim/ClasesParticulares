package ejerciciosJava.practica5.ejercicio2;

import java.io.*;
import java.util.*;

class Aldeano {
    private String nombre;
    private String profesion;
    private int romanosDerrotados;

    public Aldeano(String nombre, String profesion) {
        this.nombre = nombre;
        this.profesion = profesion;
        this.romanosDerrotados = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProfesion() {
        return profesion;
    }

    public int getRomanosDerrotados() {
        return romanosDerrotados;
    }

    public void derrotarRomanos(int cantidad) {
        romanosDerrotados += cantidad;
    }

    @Override
    public String toString() {
        return nombre + " - Profesión: " + profesion + " - Romanos derrotados: " + romanosDerrotados;
    }
}