package Estructuras;

public class ArbolBinario<T extends Comparable<T>> {
    
    private NodoArbol<T> raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void insertar(T dato) {
        this.raiz = insertarRecursivo(this.raiz, dato);
    }

    private NodoArbol<T> insertarRecursivo(NodoArbol<T> nodoActual, T dato) {
        if (nodoActual == null) {
            return new NodoArbol<>(dato);
        }

        if (dato.compareTo(nodoActual.getDato()) < 0) {
            nodoActual.setIzquierda(insertarRecursivo(nodoActual.getIzquierda(), dato));
        } else if (dato.compareTo(nodoActual.getDato()) > 0) {
            nodoActual.setDerecha(insertarRecursivo(nodoActual.getDerecha(), dato));
        } else {
            return nodoActual;
        }

        return nodoActual;
    }

    public T buscar(T dato) {
        return buscarRecursivo(this.raiz, dato);
    }

    private T buscarRecursivo(NodoArbol<T> nodoActual, T dato) {
        if (nodoActual == null) {
            return null; 
        }

        if (dato.compareTo(nodoActual.getDato()) == 0) {
            return nodoActual.getDato();
        }

        if (dato.compareTo(nodoActual.getDato()) < 0) {
            return buscarRecursivo(nodoActual.getIzquierda(), dato);
        } else {
            return buscarRecursivo(nodoActual.getDerecha(), dato);
        }
    }
    
    public void recorrerInOrden() {
        recorrerInOrdenRecursivo(raiz);
    }
    
    private void recorrerInOrdenRecursivo(NodoArbol<T> nodoActual) {
        if (nodoActual != null) {
            recorrerInOrdenRecursivo(nodoActual.getIzquierda());
            System.out.println(nodoActual.getDato().toString());
            recorrerInOrdenRecursivo(nodoActual.getDerecha());
        }
    }
}