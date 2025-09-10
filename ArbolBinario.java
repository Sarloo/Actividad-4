// Clase que implementa el Árbol Binario de Búsqueda (ABB)
class ArbolBinario {
    Nodo raiz;  // Nodo raíz del árbol

    // Constructor: al inicio el árbol está vacío
    public ArbolBinario() {
        raiz = null;
    }

    // Método para insertar un nuevo empleado en el árbol
    public void insertar(Empleado empleado) {
        raiz = insertarRec(raiz, empleado); // Se llama a la versión recursiva
    }

    // Método recursivo para insertar en el árbol según el ID del empleado
    private Nodo insertarRec(Nodo raiz, Empleado empleado) {
        if (raiz == null) { // Si el árbol está vacío o llegamos a una hoja
            raiz = new Nodo(empleado); // Creamos un nuevo nodo
            return raiz;
        }
        // Si el ID es menor, insertamos a la izquierda
        if (empleado.id < raiz.empleado.id) {
            raiz.izquierdo = insertarRec(raiz.izquierdo, empleado);
        }
        // Si el ID es mayor, insertamos a la derecha
        else if (empleado.id > raiz.empleado.id) {
            raiz.derecho = insertarRec(raiz.derecho, empleado);
        }
        return raiz; // Devolvemos el nodo raíz actualizado
    }

    // Método para buscar un empleado por su ID
    public Empleado buscar(int id) {
        return buscarRec(raiz, id);
    }

    // Versión recursiva de búsqueda
    private Empleado buscarRec(Nodo raiz, int id) {
        if (raiz == null) return null; // Si no se encontró
        if (id == raiz.empleado.id) return raiz.empleado; // Si coincide el ID
        if (id < raiz.empleado.id) return buscarRec(raiz.izquierdo, id); // Buscar en izquierda
        return buscarRec(raiz.derecho, id); // Buscar en derecha
    }

    // Método para eliminar un empleado por su ID
    public void eliminar(int id) {
        raiz = eliminarRec(raiz, id);
    }

    // Versión recursiva de eliminación en el árbol binario
    private Nodo eliminarRec(Nodo raiz, int id) {
        if (raiz == null) return raiz; // Si el árbol está vacío

        // Buscar el nodo a eliminar
        if (id < raiz.empleado.id) {
            raiz.izquierdo = eliminarRec(raiz.izquierdo, id);
        } else if (id > raiz.empleado.id) {
            raiz.derecho = eliminarRec(raiz.derecho, id);
        } else {
            // Caso 1: Nodo sin hijos
            if (raiz.izquierdo == null && raiz.derecho == null) {
                return null;
            }
            // Caso 2: Nodo con un solo hijo
            else if (raiz.izquierdo == null) {
                return raiz.derecho;
            } else if (raiz.derecho == null) {
                return raiz.izquierdo;
            }
            // Caso 3: Nodo con dos hijos (se reemplaza con el sucesor)
            raiz.empleado = minValor(raiz.derecho).empleado;
            raiz.derecho = eliminarRec(raiz.derecho, raiz.empleado.id);
        }
        return raiz;
    }

    // Método auxiliar para encontrar el nodo con el valor mínimo
    private Nodo minValor(Nodo nodo) {
        Nodo actual = nodo;
        while (actual.izquierdo != null) {
            actual = actual.izquierdo;
        }
        return actual;
    }

    // Recorrido Inorden (izquierda - raíz - derecha)
    public void inorden() {
        inordenRec(raiz);
        System.out.println();
    }

    private void inordenRec(Nodo raiz) {
        if (raiz != null) {
            inordenRec(raiz.izquierdo);
            System.out.println(raiz.empleado);
            inordenRec(raiz.derecho);
        }
    }

    // Recorrido Preorden (raíz - izquierda - derecha)
    public void preorden() {
        preordenRec(raiz);
        System.out.println();
    }

    private void preordenRec(Nodo raiz) {
        if (raiz != null) {
            System.out.println(raiz.empleado);
            preordenRec(raiz.izquierdo);
            preordenRec(raiz.derecho);
        }
    }

    // Recorrido Postorden (izquierda - derecha - raíz)
    public void postorden() {
        postordenRec(raiz);
        System.out.println();
    }

    private void postordenRec(Nodo raiz) {
        if (raiz != null) {
            postordenRec(raiz.izquierdo);
            postordenRec(raiz.derecho);
            System.out.println(raiz.empleado);
        }
    }
}
