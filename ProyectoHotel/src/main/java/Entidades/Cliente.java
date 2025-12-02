package Entidades;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Cliente implements Comparable<Cliente> {
    private String dni;
    private String nombre;
    private String telefono;
    private String email;
    private String horaLlegada;

    public Cliente(String dni, String nombre, String telefono, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.horaLlegada = LocalTime.now()
    .format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
    
    public Cliente(String dni) {
    this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }
    
    public String getHoraLlegada() {
    return horaLlegada;
    }
    
    public void setHoraLlegada(String horaLlegada) {
    this.horaLlegada = horaLlegada;
    }


    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override 
    public int compareTo(Cliente otroCliente) {
        return this.dni.compareTo(otroCliente.dni);
    }

    @Override
    public String toString() {
        return "Cliente: DNI= " + dni + ", Nombre= " + nombre + ", Telefono= " + telefono + " ";
    }
}