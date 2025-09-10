// Clase principal para probar el sistema interactivo

import java.util.Scanner;

public class GestionEmpleados {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);   // Objeto para leer datos del usuario
        ArbolBinario arbol = new ArbolBinario(); // Árbol binario de empleados
        int opcion; // Variable para el menú

        do {
            // Mostrar menú de opciones
            System.out.println("\n--- SISTEMA DE GESTION DE EMPLEADOS ---");
            System.out.println("1. Insertar empleado");
            System.out.println("2. Buscar empleado por ID");
            System.out.println("3. Eliminar empleado por ID");
            System.out.println("4. Mostrar empleados en Inorden");
            System.out.println("5. Mostrar empleados en Preorden");
            System.out.println("6. Mostrar empleados en Postorden");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt(); // Leer opción

            switch (opcion) {
                case 1:
                    // Insertar un nuevo empleado
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // Limpiar buffer
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Puesto: ");
                    String puesto = sc.nextLine();
                    System.out.print("Salario: ");
                    double salario = sc.nextDouble();
                    System.out.print("Edad: ");
                    int edad = sc.nextInt();

                    Empleado emp = new Empleado(id, nombre, puesto, salario, edad);
                    arbol.insertar(emp);
                    System.out.println("Empleado insertado correctamente.");
                    break;

                case 2:
                    // Buscar un empleado por su ID
                    System.out.print("Ingrese el ID a buscar: ");
                    int buscarId = sc.nextInt();
                    Empleado encontrado = arbol.buscar(buscarId);
                    if (encontrado != null) {
                        System.out.println("Empleado encontrado: " + encontrado);
                    } else {
                        System.out.println("Empleado no encontrado.");
                    }
                    break;

                case 3:
                    // Eliminar un empleado
                    System.out.print("Ingrese el ID a eliminar: ");
                    int eliminarId = sc.nextInt();
                    arbol.eliminar(eliminarId);
                    System.out.println("Si existía, el empleado fue eliminado.");
                    break;

                case 4:
                    // Mostrar recorrido Inorden
                    System.out.println("\nRecorrido Inorden:");
                    arbol.inorden();
                    break;

                case 5:
                    // Mostrar recorrido Preorden
                    System.out.println("\nRecorrido Preorden:");
                    arbol.preorden();
                    break;

                case 6:
                    // Mostrar recorrido Postorden
                    System.out.println("\nRecorrido Postorden:");
                    arbol.postorden();
                    break;

                case 7:
                    // Salir
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }

        } while (opcion != 7); // El ciclo se repite hasta que el usuario elija salir
        sc.close(); // Cerrar Scanner
    }
}