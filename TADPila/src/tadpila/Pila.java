package tadpila;

public class Pila<T extends Comparable> implements IPila<T> {

    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int cantElementos;

    public Pila() {
        this.inicio = null;
        this.fin = null;
        cantElementos = 0;
    }
    
    @Override
    public boolean esVacia() {
        return this.fin == null;
    }

    @Override
    public void push(T n) {
        Nodo nuevo = new Nodo(n);
        nuevo.setSiguiente(this.inicio);
        this.inicio = nuevo;
        
        if(this.esVacia()){
            this.fin = nuevo;
        }
        
        this.cantElementos++;
    }

    @Override
    public void pop() {
        if(!this.esVacia()){
            if(this.inicio.getSiguiente() == null){
                this.vaciar();
            }else{
                Nodo aBorrar = this.inicio;
                this.inicio = this.inicio.getSiguiente();
                aBorrar.setSiguiente(null);

                this.cantElementos--;   
            }
        }
    }

    @Override
    public T top() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vaciar() {
        this.inicio = null;
        this.fin = null;
        this.cantElementos = 0;
    }

    @Override
    public void mostrar() {
        Nodo aux = this.inicio;
        
        while(aux != null){
            System.out.print(aux.getDato() + " ");
            aux = aux.getSiguiente();
        }
        System.out.println("");
    }
    
    @Override
    public int cantElementos() {
        return this.cantElementos;
    }

    @Override
    public void mostrarREC() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
