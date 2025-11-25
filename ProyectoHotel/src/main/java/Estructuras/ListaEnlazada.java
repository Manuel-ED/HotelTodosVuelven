package Estructuras;

public class ListaEnlazada<T> {
    
    private Nodo<T> cabeza;
    private int tamano;

    public ListaEnlazada() {
        this.cabeza = null;
        this.tamano = 0;
    }

    public Nodo<T> getCabeza() {
        return cabeza;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void insertarInicio(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.setSiguiente(cabeza);
        cabeza = nuevo;
        tamano++;
    }

    public boolean eliminar(T dato) {
        Nodo<T> actual = cabeza;
        Nodo<T> anterior = null;
        
        while (actual != null && !actual.getDato().equals(dato)) {
            anterior = actual;
            actual = actual.getSiguiente();
        }

        if (actual == null) {
            return false;
        }

        if (anterior == null) {
            cabeza = actual.getSiguiente();
        } else {
            anterior.setSiguiente(actual.getSiguiente());
        }
        tamano--;
        return true;
    }

    public T buscarPorCodigo(String codigo) {
        Nodo<T> actual = cabeza;
        
        while (actual != null) {
            if (actual.getDato() instanceof Entidades.Reserva) {
                Entidades.Reserva reserva = (Entidades.Reserva) actual.getDato();
                if (reserva.getCodigoReserva().equals(codigo)) {
                    return actual.getDato();
                }
            }
            actual = actual.getSiguiente();
        }
        return null;
    }
    
    public void insertarFinal(T dato) {
    Nodo<T> nuevo = new Nodo<>(dato);
    if (estaVacia()) {
        cabeza = nuevo;
    } else {
        Nodo<T> actual = cabeza;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(nuevo);
    }
    tamano++;
}

    public void mostrarLista() {
        if (estaVacia()) {
            System.out.println("La lista de reservas está vacia.");
            return;
        }
        
        Nodo<T> actual = cabeza;
        System.out.println("--- Lista Enlazada (Reservas) ---");
        int i = 1;
        while (actual != null) {
            System.out.println(i++ + ". " + actual.getDato().toString());
            actual = actual.getSiguiente();
        }
        System.out.println("---------------------------------");
    }
    
    public int getTamano() {
        return tamano;
    }
}