package tadlistadoble;

public class NodoDoble<T extends Comparable> {
    private T dato;
    private NodoDoble siguiente;
    private NodoDoble anterior;

    public NodoDoble(T dato) {
        this.dato = dato;
    }

    public T getDato() {
        return this.dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoDoble getSiguiente() {
        return this.siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
}
