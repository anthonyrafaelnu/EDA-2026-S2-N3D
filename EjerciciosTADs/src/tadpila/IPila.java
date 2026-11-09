package tadpila;

public interface IPila<T> {
    public void push(T n);
    public void pop();
    
    /*
        PRE: La pila no es vacía
        POS: Retorna el último elemento insertado
    */
    public T top();
    
    public boolean esVacia();
    public void vaciar();
    public int cantElementos();
    
    
    /*No permitido, pero lo dejamos con fines didácticos*/
    public void mostrar();
}
