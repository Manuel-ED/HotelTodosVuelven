package Negocio;

import Estructuras.Cola; 
import Entidades.Cliente;

public class Recepcion {
    
    private Cola<Cliente> filaEsperaClientes;

    public Recepcion() {
        this.filaEsperaClientes = new Cola<>();
        System.out.println("Modulo de Recepcion inicializado.");
    }


    public void registrarLlegada(Cliente cliente) {
        filaEsperaClientes.encolar(cliente);
        System.out.println("Cliente " + cliente.getNombre() + " ingreso a la fila de espera.");
    }

    public Cliente atenderSiguienteCliente() {
        Cliente clienteAtendido = filaEsperaClientes.desencolar();
        
        if (clienteAtendido != null) {
            System.out.println("Atendiendo a: " + clienteAtendido.getNombre() + ". Se procede con su reserva.");
        } else {
            System.out.println("No hay clientes esperando en la fila de recepcion.");
        }
        return clienteAtendido;
    }


    public Cliente verSiguiente() {
        return filaEsperaClientes.frente();
    }
    
    public Cola<Cliente> getFilaEsperaClientes() {
    return filaEsperaClientes;
}
    

    public void mostrarEstadoFila() {
        System.out.println("\n--- Estado Actual de la Fila de Recepcion (" + filaEsperaClientes.getTamano() + " clientes) ---");
        System.out.println(filaEsperaClientes.toString());
        System.out.println("------------------------------------------------------------------");
    }
}