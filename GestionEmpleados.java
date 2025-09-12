// Clase principal del sistema

import java.util.Scanner;

// Clase principal que contiene el menú interactivo
public class GestionEmpleados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Objeto para leer desde teclado
        ArbolBinario arbol = new ArbolBinario();  // Creamos el árbol binario

       // Cargar 100 empleados balanceados
        insertarEmpleadosBalanceados(arbol, 1, 100);

        Logger.log("Se generaron 100 empleados por defecto en el sistema.");

        int opcion; // Variable para controlar el menú
        do {
            // Mostramos el menú de opciones
            System.out.println("\n--- Sistema de Gestión de Empleados con Árbol Binario ---");
            System.out.println("1. Insertar empleado");
            System.out.println("2. Buscar empleado");
            System.out.println("3. Eliminar empleado");
            System.out.println("4. Mostrar empleados ordenados (Inorden)");
            System.out.println("5. Mostrar empleados por jerarquia (Preorden)");
            System.out.println("6. Mostrar empleados por inverso de jerarquia (Postorden)");
            System.out.println("7. Comparar eficiencia búsqueda secuencial vs árbol");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt(); // Leemos la opción

            switch (opcion) {
                case 1: // Insertar empleado
                    System.out.print("ID: ");
                    int id = scanner.nextInt(); // Leemos ID
                    scanner.nextLine(); // Limpiamos buffer
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine(); // Leemos nombre
                    System.out.print("Puesto: ");
                    String puesto = scanner.nextLine(); // Leemos puesto
                    System.out.print("Salario: ");
                    double salario = scanner.nextDouble(); // Leemos salario
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt(); // Leemos edad
                    Empleado emp = new Empleado(id, nombre, puesto, salario, edad); // Creamos empleado
                    arbol.insertar(emp); // Insertamos en el árbol
                    break;

                case 2: // Buscar empleado
                    System.out.print("ID a buscar: ");
                    int idBuscar = scanner.nextInt(); // Leemos ID a buscar
                    Empleado encontrado = arbol.buscar(idBuscar); // Buscamos
                    if (encontrado != null) {
                        System.out.println("Empleado encontrado: " + encontrado);
                    } else {
                        System.out.println("Empleado no encontrado.");
                    }
                    break;

                case 3: // Eliminar empleado
                    System.out.print("ID a eliminar: ");
                    int idEliminar = scanner.nextInt(); // Leemos ID a eliminar
                    arbol.eliminar(idEliminar); // Eliminamos del árbol
                    break;

                case 4: // Mostrar empleados Inorden
                    arbol.inorden();
                    break;

                case 5: // Mostrar empleados Preorden
                    arbol.preorden();
                    break;

                case 6: // Mostrar empleados Postorden
                    arbol.postorden();
                    break;
                
                case 7: // Comparación de eficiencia entre búsqueda secuencial y en árbol
                    // Pedimos al usuario que ingrese un ID para hacer la comparación
                    System.out.print("ID a buscar para comparación: ");
                    int idComparar = scanner.nextInt();

                // --- Búsqueda secuencial ---
                // Guardamos el tiempo inicial en nanosegundos antes de empezar la búsqueda secuencial
                long inicioSec = System.nanoTime();
                // Variable para almacenar al empleado encontrado de forma secuencial
                Empleado encontradoSec = null;
                // Recorremos del 1 al 100 simulando una búsqueda en una lista desordenada
                for (int i = 1; i <= 100; i++) {
                    // Si encontramos el ID buscado
                    if (i == idComparar) {
                        // Creamos un empleado "falso" con ese ID (simulando que lo encontramos en la lista)
                        encontradoSec = new Empleado(i, "Empleado" + i, "PuestoX", 10000, 30);
                        break; // Terminamos el ciclo porque ya lo encontramos
                    }
                }
                // Guardamos el tiempo final después de la búsqueda secuencial
                long finSec = System.nanoTime();
                // Calculamos la diferencia de tiempos para obtener el tiempo que tardó la búsqueda secuencial
                long tiempoSec = finSec - inicioSec;

                // --- Búsqueda en árbol ---
                // Guardamos el tiempo inicial en nanosegundos antes de buscar en el árbol
                long inicioArbol = System.nanoTime();
                // Buscamos el empleado directamente en el árbol binario por su ID
                Empleado encontradoArbol = arbol.buscar(idComparar);
                // Guardamos el tiempo final después de la búsqueda en el árbol
                long finArbol = System.nanoTime();
                // Calculamos el tiempo que tardó la búsqueda en el árbol
                long tiempoArbol = finArbol - inicioArbol;

                // --- Resultados ---
                // Mostramos el resultado de la búsqueda secuencial con el tiempo que tardó
                System.out.println("Resultado Búsqueda Secuencial: " +
                        (encontradoSec != null ? "Encontrado" : "No encontrado") +
                        " en " + tiempoSec + " ns.");

                // Mostramos el resultado de la búsqueda en el árbol binario con el tiempo que tardó
                System.out.println("Resultado Búsqueda Árbol Binario: " +
                        (encontradoArbol != null ? "Encontrado" : "No encontrado") +
                        " en " + tiempoArbol + " ns.");

                // Registramos la acción en el log con el ID buscado
                Logger.log("Comparación búsqueda secuencial vs árbol para ID " + idComparar);
                break;
                case 0: // Salir
                    System.out.println("Saliendo del sistema...");
                    Logger.log("El usuario salió del sistema."); // Guardamos en log
                    break;

                default: // Si la opción no es válida
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0); // El bucle se repite hasta que el usuario salga

        scanner.close(); // Cerramos el scanner
    }
    public static void insertarEmpleadosBalanceados(ArbolBinario arbol, int inicio, int fin) {
        if (inicio > fin) {
            return;
        }
        int medio = (inicio + fin) / 2;
        Empleado emp = new Empleado(
                medio,
                "Empleado" + medio,
                "Puesto" + (medio % 10),
                10000 + (medio * 50),
                20 + (medio % 40)
        );
        arbol.insertar(emp);
        insertarEmpleadosBalanceados(arbol, inicio, medio - 1);
        insertarEmpleadosBalanceados(arbol, medio + 1, fin);
    }
}