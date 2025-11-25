package Negocio;

import Estructuras.ListaEnlazada;
import Estructuras.ArbolBinario;
import Entidades.Cliente;
import Entidades.Reserva;

public class Hotel {
    
    private Inventario inventario;
    private Recepcion recepcion;
    private ListaEnlazada<Reserva> listaReservas;
    private ArbolBinario<Cliente> arbolClientes;

    public Hotel() {
        this.inventario = new Inventario();
        this.recepcion = new Recepcion();
        this.listaReservas = new ListaEnlazada<>();
        this.arbolClientes = new ArbolBinario<>();
        System.out.println("Sistema Hotel 'Todos Vuelven' iniciado.");
    }
    
    public void registrarNuevoCliente(Cliente cliente) {
        arbolClientes.insertar(cliente);
        System.out.println("Cliente " + cliente.getNombre() + " registrado en el ABB.");
    }
    
    public Cliente buscarCliente(String dni) {
        Cliente clienteDummy = new Cliente(dni, null, null, null); 
        return arbolClientes.buscar(clienteDummy);
    }

    public void crearReserva(Reserva reserva) {
        int numHabitacion = reserva.getHabitacion().getNumero();
        
        if (inventario.verificarDisponibilidad(numHabitacion).equals("Libre")) {
            listaReservas.insertarInicio(reserva);
            inventario.actualizarEstado(numHabitacion, "Ocupada");
            System.out.println("Reserva " + reserva.getCodigoReserva() + " creada exitosamente.");
        } else {
            System.out.println("Error: Habitación N°" + numHabitacion + " no disponible. Estado: " + inventario.verificarDisponibilidad(numHabitacion));
        }
    }
    
    public Reserva buscarReserva(String codigo) {
        return (Reserva) listaReservas.buscarPorCodigo(codigo);
    }
    
    public boolean cancelarReserva(Reserva reserva) {
        if (listaReservas.eliminar(reserva)) {
            inventario.actualizarEstado(reserva.getHabitacion().getNumero(), "Libre");
            System.out.println("Reserva " + reserva.getCodigoReserva() + " cancelada exitosamente.");
            return true;
        }
        return false;
    }


    public Inventario getInventarioManager() {
        return inventario;
    }

    public Recepcion getRecepcionManager() {
        return recepcion;
    }

    public ListaEnlazada<Reserva> getListaReservas() {
        return listaReservas;
    }
    
    public ArbolBinario<Cliente> getArbolClientes() {
        return arbolClientes;
    }
}