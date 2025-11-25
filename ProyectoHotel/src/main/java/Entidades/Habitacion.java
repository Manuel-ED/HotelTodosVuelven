package Entidades;


public class Habitacion {
    private int numero;
    private String tipo;
    private double precio;
    private String estado;

    public Habitacion(int numero, String tipo, double precio, String estado) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void setTipo(String tipo) { 
        this.tipo = tipo;
    }

    public void setPrecio(double precio) { 
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Habitacion N° " + numero +  " ("  + tipo + ") - Estado:  " + estado;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habitacion that = (Habitacion) o;
        return numero == that.numero; 
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(numero);
    }
}