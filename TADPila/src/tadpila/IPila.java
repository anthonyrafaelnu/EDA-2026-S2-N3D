package tadpila;

public interface IPila<T> {
    public boolean esVacia();
    public void push(T n);
    public void pop();
    public T top();
    public void vaciar();
    public int cantElementos();
    
    
    // Con fines didácticos. No se puede recorrer una pila
    public void mostrar();
    public void mostrarREC();
}
