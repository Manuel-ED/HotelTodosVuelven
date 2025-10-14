package Vistas;
import Entidades.Cliente;
import Negocio.Recepcion;

public class EjemploCola {
    public static void main(String[] args) {
        
        Recepcion manager = new Recepcion();

        Cliente c1 = new Cliente("12345678", "Ana Garcia", "987654321", "ana@mail.com");
        Cliente c2 = new Cliente("87654321", "Beto Perez", "999888777", "beto@mail.com");
        Cliente c3 = new Cliente("11223344", "Carlos Lopez", "911223344", "carlos@mail.com");

        manager.registrarLlegada(c1);
        manager.registrarLlegada(c2);
        manager.registrarLlegada(c3);

        manager.mostrarEstadoFila();

        System.out.println("\n--- Proceso de Atencion ---");
        manager.atenderSiguienteCliente(); 
        manager.atenderSiguienteCliente();
        
        manager.mostrarEstadoFila();

        manager.atenderSiguienteCliente();
        
        manager.mostrarEstadoFila();
    }
}