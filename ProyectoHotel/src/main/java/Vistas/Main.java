package Vistas; // o tu paquete principal

import Entidades.Cliente;
import Entidades.Habitacion;
import Entidades.Reserva;
import Negocio.Hotel;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("--- PRUEBA DE INTEGRACIÓN DEL HOTEL TODOS VUELVEN ---");
        Hotel hotel = new Hotel(); // Inicializa todas las estructuras (ABB, Hash, Lista, Cola)

        // --- 1. CLIENTES (ÁRBOL BINARIO DE BÚSQUEDA) ---
        System.out.println("\n--- 1. ABB: BÚSQUEDA RÁPIDA DE CLIENTES ---");
        
        Cliente c1 = new Cliente("11111111", "Ana Gomez", "901", "a@mail.com");
        Cliente c2 = new Cliente("88888888", "Carlos Díaz", "908", "c@mail.com");
        Cliente c3 = new Cliente("55555555", "Beto Funes", "905", "b@mail.com");

        hotel.registrarNuevoCliente(c1);
        hotel.registrarNuevoCliente(c2);
        hotel.registrarNuevoCliente(c3);
        
        // Búsqueda en ABB (por DNI)
        Cliente encontradoABB = hotel.buscarCliente("55555555");
        System.out.println("Cliente 55555555 encontrado (ABB): " + (encontradoABB != null ? encontradoABB.getNombre() : "No encontrado"));
        
        // Recorrido InOrden (debe salir ordenado por DNI: 111, 555, 888)
        System.out.println("Clientes ordenados por DNI (InOrden):");
        hotel.getArbolClientes().recorrerInOrden(); 
        

        // --- 2. INVENTARIO (TABLA HASH) ---
        
        System.out.println("\n--- 2. TABLA HASH: VERIFICACIÓN DE HABITACIONES ---");
        // El Inventario ya precargó 4 habitaciones (101, 102, 201, 202)
        
        // Búsqueda en Tabla Hash (acceso O(1))
        System.out.println("Estado Hab. 101: " + hotel.getInventarioManager().verificarDisponibilidad(101)); 
        System.out.println("Estado Hab. 201: " + hotel.getInventarioManager().verificarDisponibilidad(201)); // Ocupada

        // Listar todas las habitaciones (Iteración de la Tabla Hash)
        System.out.println("Total de Habitaciones registradas: " + hotel.getInventarioManager().obtenerTodasLasHabitaciones().getTamano());

        
        // --- 3. RECEPCIÓN (COLA) ---
        
        System.out.println("\n--- 3. COLA: GESTIÓN DE RECEPCIÓN ---");

        hotel.getRecepcionManager().registrarLlegada(hotel.buscarCliente("11111111")); // Ana
        hotel.getRecepcionManager().registrarLlegada(hotel.buscarCliente("88888888")); // Carlos
        hotel.getRecepcionManager().mostrarEstadoFila();

        hotel.getRecepcionManager().atenderSiguienteCliente(); // Atender a Ana (FIFO)
        hotel.getRecepcionManager().mostrarEstadoFila();


        // --- 4. RESERVAS (LISTA ENLAZADA y BÚSQUEDA SECUENCIAL) ---
        
        System.out.println("\n--- 4. LISTA ENLAZADA: RESERVAS Y BÚSQUEDA SECUENCIAL ---");
        
        Habitacion h101 = hotel.getInventarioManager().buscarHabitacion(101); // Ahora Libre (si la precarga lo deja así)

        // Creación de Reserva (Usa ListaEnlazada y actualiza Tabla Hash)
        Reserva r1 = new Reserva("RES001", c1, h101, "25/11", "28/11", 300.0);
        hotel.crearReserva(r1); 
        
        // Búsqueda Secuencial en Lista Enlazada
        Reserva reservaEncontrada = hotel.buscarReserva("RES001");
        System.out.println("Búsqueda Secuencial RES001: " + (reservaEncontrada != null ? "Encontrada" : "No encontrada"));
        
        // Cancelación de Reserva (Eliminar de Lista Enlazada y actualizar Tabla Hash)
        hotel.cancelarReserva(r1);
        System.out.println("Estado Hab. 101 después de cancelación: " + hotel.getInventarioManager().verificarDisponibilidad(101)); 

        System.out.println("\n--- FIN DE PRUEBAS. LÓGICA DE NEGOCIO VERIFICADA. ---");
    }
}