package Negocio;

import Estructuras.TablaHash;
import Estructuras.Entry;
import Entidades.Habitacion;
import Estructuras.ListaEnlazada;
import Estructuras.Nodo; 

public class Inventario {
    
    private TablaHash<Integer, Habitacion> habitaciones;

    public Inventario() {
        this.habitaciones = new TablaHash<>();
        precargarHabitaciones(); 
    }

    private void precargarHabitaciones() {
    registrarHabitacion(new Habitacion(101, "Simple", 100.0, "Ocupada"));
    registrarHabitacion(new Habitacion(102, "Doble", 150.0, "Ocupada"));
    registrarHabitacion(new Habitacion(103, "Simple", 100.0, "Limpieza"));
    registrarHabitacion(new Habitacion(104, "Suite", 250.0, "Libre"));
    registrarHabitacion(new Habitacion(105, "Doble", 150.0, "Libre"));

    registrarHabitacion(new Habitacion(201, "Suite", 250.0, "Ocupada"));
    registrarHabitacion(new Habitacion(202, "Simple", 100.0, "Limpieza"));
    registrarHabitacion(new Habitacion(203, "Doble", 150.0, "Ocupada"));
    registrarHabitacion(new Habitacion(204, "Simple", 100.0, "Libre"));
    registrarHabitacion(new Habitacion(205, "Familiar", 300.0, "Libre"));

    System.out.println("Inventario precargado.");
    }

    public void registrarHabitacion(Habitacion h) {
        habitaciones.poner(h.getNumero(), h);
        System.out.println("Habitación N°" + h.getNumero() + " registrada en Inventario.");
    }
    
    public Habitacion buscarHabitacion(int numero) {
        return habitaciones.obtener(numero);
    }

    public String verificarDisponibilidad(int numero) {
        Habitacion h = buscarHabitacion(numero);
        if (h == null) {
            return "NO EXISTE";
        }
        return h.getEstado();
    }
    
    public boolean actualizarEstado(int numero, String nuevoEstado) {
        Habitacion h = buscarHabitacion(numero);
        if (h != null) {
            h.setEstado(nuevoEstado); 
            System.out.println("Estado de Habitación " + numero + " actualizado a " + nuevoEstado);
            return true;
        }
        return false;
    }

    public ListaEnlazada<Habitacion> obtenerTodasLasHabitaciones() {
        ListaEnlazada<Habitacion> lista = new ListaEnlazada<>();
        ListaEnlazada<Entry<Integer, Habitacion>>[] tablaInterna = habitaciones.getTablaInterna();
        
        for (ListaEnlazada<Entry<Integer, Habitacion>> balde : tablaInterna) {
            Nodo<Entry<Integer, Habitacion>> actual = balde.getCabeza(); 
            while (actual != null) {
                lista.insertarInicio(actual.getDato().getValor()); 
                actual = actual.getSiguiente();
            }
        }
        return lista;
    }
    
    public int contarHabitacionesPorEstado(String estado) {
    int contador = 0;
    ListaEnlazada<Habitacion> todas = obtenerTodasLasHabitaciones();
    Nodo<Habitacion> actual = todas.getCabeza();
    
    while(actual != null) {
        if (actual.getDato().getEstado().equalsIgnoreCase(estado)) {
            contador++;
        }
        actual = actual.getSiguiente();
    }
    return contador;
}
}