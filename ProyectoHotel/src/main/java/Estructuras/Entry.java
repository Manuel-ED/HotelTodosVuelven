package Estructuras;

public class Entry<K, V> {
    private K clave;
    private V valor;

    public Entry(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public K getClave() {
        return clave;
    }

    public V getValor() {
        return valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry<?, ?> entry = (Entry<?, ?>) o;
        return clave.equals(entry.clave); 
    }
    
    @Override
    public int hashCode() {
        return clave.hashCode();
    }
    
    @Override
    public String toString() {
        return "{" + clave.toString() + "=" + valor.toString() + "}";
    }
}