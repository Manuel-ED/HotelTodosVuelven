package Estructuras;

public class Cola<T> {
    
    private Nodo<T> frente; 
    private Nodo<T> finalCola; 
    private int tamano; 

    public Cola() {
        this.frente = null;
        this.finalCola = null;
        this.tamano = 0;
    }

    public boolean estaVacia() {
        return frente == null;
    }


    public void encolar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        
        if (estaVacia()) {
            frente = nuevoNodo;
        } else {
            finalCola.setSiguiente(nuevoNodo);
        }
        
        finalCola = nuevoNodo;
        tamano++;
        System.out.println("Encolado: " + dato.toString());
    }

    public T desencolar() {
        if (estaVacia()) {
            System.out.println("Error: La cola de recepcion esta vacia.");
            return null;
        }

        T datoDesencolado = frente.getDato();
        
        frente = frente.getSiguiente();
        
        if (frente == null) {
            finalCola = null;
        }
        
        tamano--;
        return datoDesencolado;
    }


    public T frente() {
        if (estaVacia()) {
            return null;
        }
        return frente.getDato();
    }
    

    public int getTamano() {
        return tamano;
    }
    
    @Override
    public String toString() {
        if (estaVacia()) {
            return "La cola de recepcion esta vacia.";
        }
        
        StringBuilder sb = new StringBuilder("Cola de Recepcion:\n");
        Nodo<T> actual = frente;
        int i = 1;
        
        while (actual != null) {
            sb.append(i++).append(". ").append(actual.getDato().toString()).append("\n");
            actual = actual.getSiguiente();
        }
        return sb.toString();
    }
}