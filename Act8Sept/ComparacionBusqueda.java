package Act8Sept;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class ComparacionBusqueda {
    
    // Método para generar números aleatorios únicos
    public static int[] generarNumerosUnicos(int cantidad, int min, int max) {
        if (max - min + 1 < cantidad) {
            throw new IllegalArgumentException("El rango es demasiado pequeño para generar números únicos");
        }
        
        Set<Integer> numerosSet = new HashSet<>();
        Random random = new Random();
        
        while (numerosSet.size() < cantidad) {
            int numero = random.nextInt(max - min + 1) + min;
            numerosSet.add(numero);
        }
        
        return numerosSet.stream().mapToInt(Integer::intValue).toArray();
    }
    
    // Búsqueda lineal en arreglo (iterativa)
    public static boolean buscarEnArreglo(int[] arreglo, int valor) {
        for (int num : arreglo) {
            if (num == valor) {
                return true;
            }
        }
        return false;
    }
    
    // Búsqueda binaria en arreglo ordenado (recursiva)
    public static boolean busquedaBinariaRecursiva(int[] arreglo, int valor, int inicio, int fin) {
        if (inicio > fin) {
            return false;
        }
        
        int medio = inicio + (fin - inicio) / 2;
        
        if (arreglo[medio] == valor) {
            return true;
        } else if (arreglo[medio] > valor) {
            return busquedaBinariaRecursiva(arreglo, valor, inicio, medio - 1);
        } else {
            return busquedaBinariaRecursiva(arreglo, valor, medio + 1, fin);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Generar 100 números aleatorios únicos
        int[] numeros = generarNumerosUnicos(100, 1, 1000);
        int[] numerosOrdenados = numeros.clone();
        Arrays.sort(numerosOrdenados);
        
        // Crear y poblar el árbol binario
        ArbolBinario arbol = new ArbolBinario();
        for (int num : numeros) {
            arbol.insertar(num);
        }
        
        System.out.println("=== COMPARACIÓN DE BÚSQUEDA ===");
        System.out.println("Números generados (100 números únicos):");
        
        // Mostrar los números en formato más legible (10 filas de 10 números)
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int index = i * 10 + j;
                if (index < numeros.length) {
                    System.out.printf("%4d ", numeros[index]);
                }
            }
            System.out.println();
        }
        
        System.out.println("\n=== RECORRIDOS DEL ÁRBOL ===");
        arbol.preorden();
        arbol.inorden();
        arbol.postorden();
        
        // Menú interactivo
        while (true) {
            System.out.println("\n=== MENÚ DE BÚSQUEDA ===");
            System.out.println("1. Buscar un número");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion;
            try {
                opcion = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); // Limpiar el buffer
                continue;
            }
            
            if (opcion == 2) {
                System.out.println("¡Hasta luego!");
                break;
            } else if (opcion == 1) {
                System.out.print("Ingrese el número a buscar: ");
                int numeroBuscar;
                try {
                    numeroBuscar = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Por favor, ingrese un número válido.");
                    scanner.next(); // Limpiar el buffer
                    continue;
                }
                
                // Buscar en árbol y medir tiempo
                long inicioArbol = System.nanoTime();
                boolean encontradoArbol = arbol.buscar(numeroBuscar);
                long finArbol = System.nanoTime();
                double tiempoArbol = (finArbol - inicioArbol) / 1_000_000.0;
                
                // Buscar en arreglo (búsqueda lineal) y medir tiempo
                long inicioArregloLineal = System.nanoTime();
                boolean encontradoArregloLineal = buscarEnArreglo(numeros, numeroBuscar);
                long finArregloLineal = System.nanoTime();
                double tiempoArregloLineal = (finArregloLineal - inicioArregloLineal) / 1_000_000.0;
                
                // Buscar en arreglo ordenado (búsqueda binaria recursiva) y medir tiempo
                long inicioArregloBinario = System.nanoTime();
                boolean encontradoArregloBinario = busquedaBinariaRecursiva(
                    numerosOrdenados, numeroBuscar, 0, numerosOrdenados.length - 1);
                long finArregloBinario = System.nanoTime();
                double tiempoArregloBinario = (finArregloBinario - inicioArregloBinario) / 1_000_000.0;
                
                // Mostrar resultados
                System.out.println("\n=== RESULTADOS DE BÚSQUEDA ===");
                System.out.println("Número buscado: " + numeroBuscar);
                System.out.println("¿Encontrado? Árbol: " + encontradoArbol + 
                                 ", Arreglo: " + encontradoArregloLineal + 
                                 ", Arreglo Ordenado: " + encontradoArregloBinario);
                
                System.out.println("\n=== TIEMPOS DE BÚSQUEDA ===");
                System.out.printf("Árbol binario: %.3f milisegundos\n", tiempoArbol);
                System.out.printf("Arreglo (búsqueda lineal): %.3f milisegundos\n", tiempoArregloLineal);
                System.out.printf("Arreglo ordenado (búsqueda binaria recursiva): %.3f milisegundos\n", tiempoArregloBinario);
                
            } else {
                System.out.println("Opción no válida. Por favor, seleccione 1 o 2.");
            }
        }
        
        scanner.close();
    }
}