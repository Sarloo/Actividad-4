// Clase que representa un Árbol Binario de Empleados
class ArbolBinario {
    Nodo raiz; // Nodo raíz del árbol

    // Método para insertar un empleado en el árbol
    public void insertar(Empleado empleado) {
        raiz = insertarRecursivo(raiz, empleado); // Llamamos recursivamente
        Logger.log("Se insertó el empleado -> " + empleado.toString()); // Registramos en el log
    }

    // Método recursivo para insertar un empleado en la posición correcta
    private Nodo insertarRecursivo(Nodo actual, Empleado empleado) {
        if (actual == null) { // Si el nodo está vacío
            return new Nodo(empleado); // Creamos un nuevo nodo con el empleado
        }
        if (empleado.id < actual.empleado.id) { // Si el ID es menor, va a la izquierda
            actual.izquierdo = insertarRecursivo(actual.izquierdo, empleado);
        } else if (empleado.id > actual.empleado.id) { // Si el ID es mayor, va a la derecha
            actual.derecho = insertarRecursivo(actual.derecho, empleado);
        }
        return actual; // Retornamos el nodo actual
    }

    // Método para buscar un empleado en el árbol por su ID
    public Empleado buscar(int id) {
        Empleado encontrado = buscarRecursivo(raiz, id); // Llamamos recursivamente
        if (encontrado != null) {
            Logger.log("Se encontró el empleado con ID " + id); // Guardamos en log si existe
        } else {
            Logger.log("No se encontró empleado con ID " + id); // Guardamos si no existe
        }
        return encontrado; // Retornamos el empleado encontrado o null
    }

    // Método recursivo para buscar un empleado en el árbol
    private Empleado buscarRecursivo(Nodo actual, int id) {
        if (actual == null) return null; // Si no hay nodo, no existe
        if (id == actual.empleado.id) return actual.empleado; // Si coincide el ID, lo encontramos
        return id < actual.empleado.id
                ? buscarRecursivo(actual.izquierdo, id) // Si es menor, buscamos a la izquierda
                : buscarRecursivo(actual.derecho, id);  // Si es mayor, buscamos a la derecha
    }

    // Método para eliminar un empleado por ID
    public void eliminar(int id) {
        raiz = eliminarRecursivo(raiz, id); // Eliminamos recursivamente
        Logger.log("Se eliminó el empleado con ID " + id); // Guardamos en el log
    }

    // Método recursivo para eliminar un nodo del árbol
    private Nodo eliminarRecursivo(Nodo actual, int id) {
        if (actual == null) return null; // Si no hay nodo, no hacemos nada

        if (id == actual.empleado.id) { // Si encontramos el nodo
            if (actual.izquierdo == null && actual.derecho == null) return null; // Caso sin hijos
            if (actual.izquierdo == null) return actual.derecho; // Caso con solo hijo derecho
            if (actual.derecho == null) return actual.izquierdo; // Caso con solo hijo izquierdo
            Nodo menor = encontrarMenor(actual.derecho); // Buscamos el menor del subárbol derecho
            actual.empleado = menor.empleado; // Reemplazamos el valor
            actual.derecho = eliminarRecursivo(actual.derecho, menor.empleado.id); // Eliminamos duplicado
            return actual;
        }
        if (id < actual.empleado.id) { // Si el ID es menor, eliminamos en el subárbol izquierdo
            actual.izquierdo = eliminarRecursivo(actual.izquierdo, id);
        } else { // Si es mayor, eliminamos en el subárbol derecho
            actual.derecho = eliminarRecursivo(actual.derecho, id);
        }
        return actual; // Retornamos el nodo actual
    }

    // Método para encontrar el nodo con el valor mínimo (más a la izquierda)
    private Nodo encontrarMenor(Nodo nodo) {
        return nodo.izquierdo == null ? nodo : encontrarMenor(nodo.izquierdo);
    }

    // Recorrido INORDEN (Izquierda - Nodo - Derecha)
    public void inorden() {
        System.out.println("Recorrido Inorden:");
        Logger.log("Se realizó recorrido Inorden"); // Registramos la acción
        inordenRecursivo(raiz);
    }

    private void inordenRecursivo(Nodo actual) {
        if (actual != null) {
            inordenRecursivo(actual.izquierdo); // Recorremos izquierda
            System.out.println(actual.empleado); // Mostramos el nodo
            inordenRecursivo(actual.derecho);   // Recorremos derecha
        }
    }

    // Recorrido PREORDEN (Nodo - Izquierda - Derecha)
    public void preorden() {
        System.out.println("Recorrido Preorden:");
        Logger.log("Se realizó recorrido Preorden");
        preordenRecursivo(raiz);
    }

    private void preordenRecursivo(Nodo actual) {
        if (actual != null) {
            System.out.println(actual.empleado); // Mostramos el nodo
            preordenRecursivo(actual.izquierdo); // Recorremos izquierda
            preordenRecursivo(actual.derecho);   // Recorremos derecha
        }
    }

    // Recorrido POSTORDEN (Izquierda - Derecha - Nodo)
    public void postorden() {
        System.out.println("Recorrido Postorden:");
        Logger.log("Se realizó recorrido Postorden");
        postordenRecursivo(raiz);
    }

    private void postordenRecursivo(Nodo actual) {
        if (actual != null) {
            postordenRecursivo(actual.izquierdo); // Recorremos izquierda
            postordenRecursivo(actual.derecho);   // Recorremos derecha
            System.out.println(actual.empleado); // Mostramos el nodo
        }
    }
}
