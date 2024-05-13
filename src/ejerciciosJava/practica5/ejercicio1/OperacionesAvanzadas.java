package ejerciciosJava.practica5.ejercicio1;

import java.util.List;

    public interface OperacionesAvanzadas extends OperacionesBasicas {

        int calculoNumerosPrimos();

        double calculoSumaDigitosElementos();
        double calculoMediana();


        @Override
        List<Double> calcularSuma();

        @Override
        double calcularPromedio();

        @Override
        double encontrarMaximo();

        @Override
        double encontrarMinimo();

        List<Double> calcularModa();
    }

