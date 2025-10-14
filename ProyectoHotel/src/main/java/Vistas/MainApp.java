// Ejemplo de uso para probar el Avance 2
package Vistas; // O donde decidas poner tu clase de prueba

import Entidades.Cliente;
import Negocio.Recepcion;

public class MainApp {
    public static void main(String[] args) {
        
        Recepcion manager = new Recepcion();

        // 1. Llegada de Clientes (Se encolan)
        Cliente c1 = new Cliente("12345678", "Ana Garcia", "987654321", "ana@mail.com");
        Cliente c2 = new Cliente("87654321", "Beto Perez", "999888777", "beto@mail.com");
        Cliente c3 = new Cliente("11223344", "Carlos Lopez", "911223344", "carlos@mail.com");

        manager.registrarLlegada(c1);
        manager.registrarLlegada(c2);
        manager.registrarLlegada(c3);

        manager.mostrarEstadoFila();

        // 2. Atención de Clientes (Se desencolan en orden FIFO)
        System.out.println("\n--- Proceso de Atencion ---");
        manager.atenderSiguienteCliente(); // Atiende a Ana (FIFO)
        manager.atenderSiguienteCliente(); // Atiende a Beto
        
        manager.mostrarEstadoFila(); // Solo debe quedar Carlos

        // 3. Atención del último cliente
        manager.atenderSiguienteCliente(); // Atiende a Carlos
        
        manager.mostrarEstadoFila(); // La cola queda vacía
    }
}