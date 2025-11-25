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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Entry<?, ?> other = (Entry<?, ?>) obj;
        if (clave == null) return other.clave == null;
        return clave.equals(other.clave);
    }

    @Override
    public int hashCode() {
        return (clave == null) ? 0 : clave.hashCode();
    }

    @Override
    public String toString() {
        return "{" + clave + " => " + valor + "}";
    }
}
