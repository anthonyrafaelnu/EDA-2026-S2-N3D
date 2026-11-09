package tadpila;

public class Pila<T  extends Comparable> implements IPila<T> {
    
    private Nodo<T> inicio;
    private int cant;

    public Pila() {
        this.inicio = null;
        this.cant = 0;
    }

    @Override
    public void push(T n) {
        Nodo nuevo = new Nodo(n);
        nuevo.setSiguiente(this.inicio);
        this.inicio = nuevo;

        this.cant++;
    }

    @Override
    public void pop() {
        if(!esVacia()){
            if(this.inicio.getSiguiente() == null){ //Un nodo
                this.vaciar();
            }else{
                Nodo aBorrar = this.inicio;
                this.inicio = this.inicio.getSiguiente();
                aBorrar.setSiguiente(null);

                this.cant--;
            }
        }
    }

    @Override
    public T top() {
        return this.inicio.getDato();
    }
    
    @Override
    public boolean esVacia() {
        return this.inicio == null;
    }

    @Override
    public void vaciar() {
        this.inicio = null;
        this.cant = 0;
    }

    @Override
    public int cantElementos() {
        return this.cant;
    }
    
    
    
    /*No permitido, pero lo dejamos con fines didácticos*/
    
    @Override
    public void mostrar() {
        Nodo aux = this.inicio;
        
        System.out.println("Tope");
        while(aux != null){
            System.out.println(aux.getDato() + " ");
            aux = aux.getSiguiente();
        }
        System.out.println("Fondo");
    }
}
