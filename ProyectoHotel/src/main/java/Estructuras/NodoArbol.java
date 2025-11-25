package Estructuras;

public class NodoArbol<T extends Comparable<T>> {
    
    private T dato;
    private NodoArbol<T> izquierda;
    private NodoArbol<T> derecha;

    public NodoArbol(T dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoArbol<T> getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoArbol<T> izquierda) {
        this.izquierda = izquierda;
    }

    public NodoArbol<T> getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoArbol<T> derecha) {
        this.derecha = derecha;
    }
}