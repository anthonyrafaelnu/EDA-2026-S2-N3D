package tadlista;

public class Nodo<T extends Comparable> {
    private T dato;
    private Nodo siguiente;

    public Nodo(T dato) {
        this.dato = dato;
    }

    public T getDato() {
        return this.dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return this.siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
