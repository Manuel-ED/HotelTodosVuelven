package Vistas; 

import Entidades.Cliente;
import Entidades.Habitacion;
import Entidades.Reserva;
import Estructuras.ListaEnlazada;

public class PruebaBusqueda {
    public static void main(String[] args) {
        
        ListaEnlazada<Reserva> listaReservas = new ListaEnlazada<>();

        Cliente c1 = new Cliente("123", "Alice", "911", "a@m.com");
        Habitacion h1 = new Habitacion(101, "Simple", 100.0, "Ocupada");
        
        Cliente c2 = new Cliente("456", "Bob", "922", "b@m.com");
        Habitacion h2 = new Habitacion(205, "Doble", 150.0, "Ocupada");
        
        Reserva r1 = new Reserva("R001", c1, h1, "2025-10-15", "2025-10-18", 300.0);
        Reserva r2 = new Reserva("R002", c2, h2, "2025-10-16", "2025-10-19", 450.0);
        
        listaReservas.insertarInicio(r1);
        listaReservas.insertarInicio(r2);

        System.out.println("Reservas actuales en el sistema:");
        listaReservas.mostrarLista();

        String codigoBuscado1 = "R001";
        Reserva encontrada1 = (Reserva) listaReservas.buscarPorCodigo(codigoBuscado1);
        
        if (encontrada1 != null) {
            System.out.println("\n Busqueda Exitosa: Reserva " + codigoBuscado1 + " encontrada.");
            System.out.println("Detalle: " + encontrada1.getCliente().getNombre());
        } else {
            System.out.println("\n Error en la Busqueda: Reserva " + codigoBuscado1 + " NO encontrada.");
        }

        String codigoBuscado2 = "R003";
        Reserva encontrada2 = (Reserva) listaReservas.buscarPorCodigo(codigoBuscado2);
        
        if (encontrada2 != null) {
            System.out.println("\n Error en la Busqueda: Reserva " + codigoBuscado2 + " encontrada cuando no debería.");
        } else {
            System.out.println("\n Busqueda Fallida Correcta: Reserva " + codigoBuscado2 + " no existe.");
        }
    }
}