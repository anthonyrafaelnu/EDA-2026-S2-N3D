package tadcola;

public interface ICola<T> {
    
    public void encolar(T n);
    public void desencolar();
    public T front();
    
    public int cantElementos();
    public boolean esVacia();
    public void vaciar();
    
    
    /*No permitido, pero lo dejamos con fines didácticos*/
    public void mostrar();
}
