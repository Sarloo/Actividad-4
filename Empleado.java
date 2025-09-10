// Clase que representa a un Empleado
class Empleado {
    int id;                // Identificador único del empleado
    String nombre;         // Nombre del empleado
    String puesto;         // Puesto o cargo que ocupa
    double salario;        // Salario mensual
    int edad;              // Edad del empleado

    // Constructor para crear un empleado con todos sus atributos
    public Empleado(int id, String nombre, String puesto, double salario, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        this.edad = edad;
    }

    // Método para mostrar la información del empleado
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Puesto: " + puesto +
               " | Salario: $" + salario + " | Edad: " + edad;
    }
}


