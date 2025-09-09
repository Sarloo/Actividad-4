package Act8Sept;

class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    // Método público para insertar (iterativo)
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    // Método recursivo para insertar
    private Nodo insertarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }

        if (valor < nodo.valor) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = insertarRecursivo(nodo.derecho, valor);
        }

        return nodo;
    }

    // Método público para buscar
    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    // Método recursivo para buscar
    private boolean buscarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return false;
        }

        if (valor == nodo.valor) {
            return true;
        }

        if (valor < nodo.valor) {
            return buscarRecursivo(nodo.izquierdo, valor);
        } else {
            return buscarRecursivo(nodo.derecho, valor);
        }
    }

    // Recorridos del árbol
    public void inorden() {
        System.out.print("Inorden: ");
        inordenRecursivo(raiz);
        System.out.println();
    }

    private void inordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            inordenRecursivo(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inordenRecursivo(nodo.derecho);
        }
    }

    public void preorden() {
        System.out.print("Preorden: ");
        preordenRecursivo(raiz);
        System.out.println();
    }

    private void preordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preordenRecursivo(nodo.izquierdo);
            preordenRecursivo(nodo.derecho);
        }
    }

    public void postorden() {
        System.out.print("Postorden: ");
        postordenRecursivo(raiz);
        System.out.println();
    }

    private void postordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            postordenRecursivo(nodo.izquierdo);
            postordenRecursivo(nodo.derecho);
            System.out.print(nodo.valor + " ");
        }
    }
}