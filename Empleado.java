// Clase que representa a un Empleado
class Empleado {
    int id;             // ID único del empleado
    String nombre;      // Nombre del empleado
    String puesto;      // Puesto de trabajo del empleado
    double salario;     // Salario del empleado
    int edad;           // Edad del empleado

    // Constructor para inicializar un empleado con todos sus atributos
    public Empleado(int id, String nombre, String puesto, double salario, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        this.edad = edad;
    }

    // Método que devuelve una representación en texto del empleado
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Puesto: " + puesto +
               " | Salario: $" + salario + " | Edad: " + edad;
    }
}