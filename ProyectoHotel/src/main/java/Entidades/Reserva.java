package Entidades;

public class Reserva {
    private String codigoReserva;
    private Cliente cliente;
    private Habitacion habitacion;
    private String fechaCheckIn;
    private String fechaCheckOut; 
    private double costoTotal;

    public Reserva(String codigoReserva, Cliente cliente, Habitacion habitacion, 
                    String fechaCheckIn, String fechaCheckOut, double costoTotal) {
        this.codigoReserva = codigoReserva;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
        this.costoTotal = costoTotal;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public String getFechaCheckIn() {
        return fechaCheckIn;
    }

    public void setFechaCheckIn(String fechaCheckIn) {
        this.fechaCheckIn = fechaCheckIn;
    }

    public String getFechaCheckOut() {
        return fechaCheckOut;
    }

    public void setFechaCheckOut(String fechaCheckOut) {
        this.fechaCheckOut = fechaCheckOut;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    
    @Override
    public String toString() {
        return "Reserva [" + codigoReserva + "] Cliente: " + cliente.getNombre() + 
               " | Habitacion: " + habitacion.getNumero() + 
               " | Entrada: " + fechaCheckIn + " | Salida: " + fechaCheckOut;
    }
}