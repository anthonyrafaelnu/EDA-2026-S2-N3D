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
        PRE: La lista ya está ordenada de forma ascendente
        POS: Agrega el elemento n a la lista manteniendo el orden
    */
    public void agregarOrd(T n);
    public void borrarElemento(T n);
    public int cantElementos();
    
    /*
        PRE: recibe un índice con valor entre 0 y cantidad de elementos - 1
             la lista no es vacía
        POS: retorna el elemento en esa posición
    */
    public T obtenerElemento(int indice);
    public void mostrarREC();
    
    /*
        Pre: La lista no es vacía.
        Pos: Retorna el máximo elemento de la lista.
    */
    T maximo ();

    /*
        PRE: -
        POS: Retorna la cantidad de veces que aparece el elemento pasado 
             como parámetro en la lista
    */
    int contar (T elem);
    
    /*
        PRE: -
        POS: Retorna una nueva lista, resultado de invertir el orden de los 
             elementos de la lista original.
    */
    Lista invertir ();
    
    /*
        PRE: -
        POS: Retorna true sii la lista está ordenada.
    */
    boolean estaOrdenada ();
    
}
