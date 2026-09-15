package tadlista;

public interface ILista {
    public boolean esVacia();
    public void agregarInicio(int n);
    public void agregarFinal(int n);
    public void borrarInicio();
    public void borrarFin();
    public void vaciar();
    public void mostrar();
    public void agregarOrd(int n);
    public void borrarElemento(int n);
    public int cantElementos();
    public int obtenerElemento(int n);
    public void mostrarREC();
}
