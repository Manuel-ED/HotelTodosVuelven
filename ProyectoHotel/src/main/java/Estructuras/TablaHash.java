package Estructuras;

public class TablaHash<K, V> {
    private static final int TAMANO_INICIAL = 20; 
    private ListaEnlazada<Entry<K, V>>[] tabla; 
    private int tamano;

    public TablaHash() {
        this.tabla = new ListaEnlazada[TAMANO_INICIAL];
        this.tamano = 0;
        for (int i = 0; i < TAMANO_INICIAL; i++) {
            tabla[i] = new ListaEnlazada<>();
        }
    }

    private int funcionHash(K clave) {
        return Math.abs(clave.hashCode()) % tabla.length;
    }

    public void poner(K clave, V valor) {
        int indice = funcionHash(clave);
        ListaEnlazada<Entry<K, V>> listaEnBalde = tabla[indice];

        Nodo<Entry<K, V>> actual = listaEnBalde.getCabeza();
        while (actual != null) {
            if (actual.getDato().getClave().equals(clave)) {
                actual.getDato().setValor(valor);
                return;
            }
            actual = actual.getSiguiente();
        }

        listaEnBalde.insertarInicio(new Entry<>(clave, valor));
        tamano++;
    }

    public V obtener(K clave) {
        int indice = funcionHash(clave);
        ListaEnlazada<Entry<K, V>> listaEnBalde = tabla[indice];

        Nodo<Entry<K, V>> actual = listaEnBalde.getCabeza(); 
        while (actual != null) {
            if (actual.getDato().getClave().equals(clave)) {
                return actual.getDato().getValor();
            }
            actual = actual.getSiguiente();
        }
        return null; 
    }

    public boolean remover(K clave) {
        int indice = funcionHash(clave);
        ListaEnlazada<Entry<K, V>> listaEnBalde = tabla[indice];
        
        Entry<K, V> dummyEntry = new Entry<>(clave, null); 
        
        boolean eliminado = listaEnBalde.eliminar(dummyEntry);
        if (eliminado) {
            tamano--;
        }
        return eliminado;
    }
    
    public ListaEnlazada<Entry<K, V>>[] getTablaInterna() {
        return tabla;
    }
}