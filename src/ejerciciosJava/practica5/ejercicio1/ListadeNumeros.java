package ejerciciosJava.practica5.ejercicio1;

import java.util.*;

public class ListadeNumeros implements OperacionesAvanzadas {
    private List<Double> lista;

    public ListadeNumeros() {
        lista = new ArrayList<>();
        generarLista();
        mostrarLista();
    }

    public void generarLista() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el número de elementos:");
        int cantidad = sc.nextInt();

        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            double numeroAleatorio = Math.round(random.nextDouble() * 10000) / 100.0;
            //lista.add(numeroAleatorio);
            agregarElementos(numeroAleatorio);
        }
    }

    public void mostrarLista() {
        for (double elementos : lista) {
            System.out.println(elementos);
        }
    }

    public void agregarElementos(double num) {
        lista.add(num);
    }

    public void borrarElementos(double num) {
        for (double elemento : lista) {
            if (elemento == num) {
                lista.remove(elemento);
                break;
            }
        }
    }

    public void ordenarListaAscendente() {
        Collections.sort(lista);

    }

    public void ordenarListaDescendente() {
        lista.sort(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {

                return (int) (o1 - o2);
            }
        });
    }

    private boolean esPrimo(double num) {
        if (num <= 1) {
            return false;
        }

        boolean primo = true;
        int contador = 2;
        while (primo && contador * contador <= num) {
            if (num % contador == 0) {
                primo = false;
            }
            contador++;
        }
        return primo;
    }

    @Override
    public int calculoNumerosPrimos() {
        int cantidadPrimos = 0;
        for (double num : lista) {
            if (esPrimo(num)) {
                cantidadPrimos++;
            }
        }
        return cantidadPrimos;
    }

    @Override
    public double calculoSumaDigitosElementos() {
        int sumaDigitos = 0;
        for (double elemento : lista) {
            String cadena = String.valueOf(elemento);
            for (int i = 0; i < cadena.length(); i++) {
                char digito = cadena.charAt(i);
                if (Character.isDigit(digito)) {
                    sumaDigitos += Character.getNumericValue(digito);
                }
            }
        }
        return sumaDigitos;
    }


    @Override
    public double calculoMediana() {
        Collections.sort(lista);
        int tamanio = lista.size();
        if (tamanio % 2 == 0) {
            int indice1 = tamanio / 2 - 1;
            int indice2 = tamanio / 2;
            double elemento1 = lista.get(indice1);
            double elemento2 = lista.get(indice2);
            return (elemento1 + elemento2) / 2;
        } else {
            int indice = tamanio / 2;
            return lista.get(indice);
        }
    }


    @Override
    public List<Double> calcularSuma() {
        double suma = 0;
        for (double elemento : lista) {
            suma += elemento;

        }
        return Collections.singletonList(suma);
    }


    @Override
    public double calcularPromedio() {
        List<Double> listaSuma = calcularSuma();
        double suma = listaSuma.get(0);
        double promedio = suma / listaSuma.size();
        return promedio;
    }


    @Override
    public double encontrarMaximo() {
        double maximo = Double.MIN_VALUE;
        for (double elemento : lista) {
            if (elemento > maximo) {
                maximo = elemento;
            }
        }
        return maximo;
    }

    @Override
    public double encontrarMinimo() {
        double minimo = Double.MAX_VALUE;
        for (double elemento : lista) {
            if (elemento < minimo) {
                minimo = elemento;
            }
        }
        return minimo;
    }

    @Override
    public List<Double> calcularModa() {
        Map<Double, Integer> frecuenciaMapa = new HashMap<>();
        for (double elemento : lista) {
            frecuenciaMapa.put(elemento, frecuenciaMapa.getOrDefault(elemento, 0) + 1);
        }
        int frecuenciaMaxima = Collections.max(frecuenciaMapa.values());
        List<Double> moda = new ArrayList<>();
        for (Map.Entry<Double, Integer> entry : frecuenciaMapa.entrySet()) {
            if (entry.getValue() == frecuenciaMaxima) {
                moda.add(entry.getKey());
            }
        }
        return moda;
    }
}










