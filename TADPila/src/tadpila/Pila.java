package tadpila;

public class Pila<T extends Comparable> implements IPila<T> {

    private Nodo<T> tope;
    private int cantElementos;

    public Pila() {
        this.tope = null;
        cantElementos = 0;
    }
    
    @Override
    public boolean esVacia() {
        return this.tope == null;
    }

    @Override
    public void push(T n) {
        Nodo nuevo = new Nodo(n);
        nuevo.setSiguiente(this.tope);
        this.tope = nuevo;

        this.cantElementos++;
    }

    @Override
    public void pop() {
        if(!this.esVacia()){
            if(this.tope.getSiguiente() == null){
                this.vaciar();
            }else{
                Nodo aBorrar = this.tope;
                this.tope = this.tope.getSiguiente();
                aBorrar.setSiguiente(null);

                this.cantElementos--;   
            }
        }
    }

    @Override
    public T top() {
        return this.tope.getDato();
    }

    @Override
    public void vaciar() {
        this.tope = null;
        this.cantElementos = 0;
    }
    
    @Override
    public int cantElementos() {
        return this.cantElementos;
    }

    
    @Override
    public void mostrar() {
        Nodo aux = this.tope;
        
        while(aux != null){
            System.out.println(aux.getDato() + " ");
            aux = aux.getSiguiente();
        }
    }
    
    @Override
    public void mostrarREC() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
