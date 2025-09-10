// Clase Nodo que representa cada nodo del árbol binario
class Nodo {
    Empleado empleado;   // Información de empleado guardada en el nodo
    Nodo izquierdo;      // Hijo izquierdo
    Nodo derecho;        // Hijo derecho

    // Constructor que recibe un objeto empleado
    public Nodo(Empleado empleado) {
        this.empleado = empleado;
        this.izquierdo = null;
        this.derecho = null;
    }
}