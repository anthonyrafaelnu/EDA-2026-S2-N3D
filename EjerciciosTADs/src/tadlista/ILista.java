package tadlista;

public interface ILista<T> {
    public boolean esVacia();
    public void agregarInicio(T n);
    public void agregarFinal(T n);
    public void borrarInicio();
    public void borrarFin();
    public void vaciar();
    public void mostrar();
    
    /*
        PRE: La lista ya está ordenada, de forma ascendente
        POS: Agrega un nuevo valor de forma ordenada a la lista
    */
    public void agregarOrd(T n);
    
    public void borrarElemento(T n);
    public int cantElementos();
    
    /*
        PRE: Recibe un índice válido, 
             0 <= indice < cant elementos
        POS: Retorna el elemento que esté en la posición 
             índice
    */
    public T obtenerElemento(int indice);
    public void mostrarREC();
    
    public T maximo();
    
    public int contar(T elem);
    
    public boolean estaOrdenada();
}
