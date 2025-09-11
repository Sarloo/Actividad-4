// Clase principal del sistema

import java.util.Random;
import java.util.Scanner;

// Clase principal que contiene el menú interactivo
public class GestionEmpleados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Objeto para leer desde teclado
        ArbolBinario arbol = new ArbolBinario();  // Creamos el árbol binario

        // --- Generamos 100 empleados por defecto ---
        Random random = new Random();
        String[] puestos = {"Gerente", "Analista", "Desarrollador", "Tester", "Soporte"};
        for (int i = 1; i <= 30; i++) { // Creamos 100 empleados
            String nombre = "Empleado " + i; // Nombre secuencial
            String puesto = puestos[random.nextInt(puestos.length)]; // Puesto aleatorio
            double salario = 10000 + (40000 * random.nextDouble()); // Salario aleatorio entre 10k-50k
            int edad = 20 + random.nextInt(41); // Edad aleatoria entre 20-60
            Empleado emp = new Empleado(i, nombre, puesto, salario, edad); // Creamos empleado
            arbol.insertar(emp); // Insertamos en el árbol
        }
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
}