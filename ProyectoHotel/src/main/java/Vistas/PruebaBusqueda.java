// Clase de Prueba o MainApp (Temporal)
package Vistas; 

import Entidades.Cliente;
import Entidades.Habitacion;
import Entidades.Reserva;
import Estructuras.ListaEnlazada;

public class PruebaBusqueda {
    public static void main(String[] args) {
        
        // 1. Inicializar la lista de reservas
        ListaEnlazada<Reserva> listaReservas = new ListaEnlazada<>();

        // 2. Crear datos de prueba
        Cliente c1 = new Cliente("123", "Alice", "911", "a@m.com");
        Habitacion h1 = new Habitacion(101, "Simple", 100.0, "Ocupada");
        
        Cliente c2 = new Cliente("456", "Bob", "922", "b@m.com");
        Habitacion h2 = new Habitacion(205, "Doble", 150.0, "Ocupada");
        
        // Creación de Reservas con códigos únicos
        Reserva r1 = new Reserva("R001", c1, h1, "2025-10-15", "2025-10-18", 300.0);
        Reserva r2 = new Reserva("R002", c2, h2, "2025-10-16", "2025-10-19", 450.0);
        
        // 3. Insertar reservas en la Lista Enlazada
        listaReservas.insertarInicio(r1); // La lista ahora es [R001]
        listaReservas.insertarInicio(r2); // La lista ahora es [R002, R001] (R002 es la cabeza)

        System.out.println("Reservas actuales en el sistema:");
        listaReservas.mostrarLista();

        // 4. Verificación de la Búsqueda

        // a) Búsqueda Exitosa (Caso R001)
        String codigoBuscado1 = "R001";
        Reserva encontrada1 = (Reserva) listaReservas.buscarPorCodigo(codigoBuscado1);
        
        if (encontrada1 != null) {
            System.out.println("\n✅ Búsqueda Exitosa: Reserva " + codigoBuscado1 + " encontrada.");
            System.out.println("Detalle: " + encontrada1.getCliente().getNombre());
        } else {
            System.out.println("\n❌ Error en la Búsqueda: Reserva " + codigoBuscado1 + " NO encontrada.");
        }

        // b) Búsqueda Fallida (Caso R003)
        String codigoBuscado2 = "R003";
        Reserva encontrada2 = (Reserva) listaReservas.buscarPorCodigo(codigoBuscado2);
        
        if (encontrada2 != null) {
            System.out.println("\n❌ Error en la Búsqueda: Reserva " + codigoBuscado2 + " encontrada cuando no debería.");
        } else {
            System.out.println("\n✅ Búsqueda Fallida Correcta: Reserva " + codigoBuscado2 + " no existe.");
        }
    }
}