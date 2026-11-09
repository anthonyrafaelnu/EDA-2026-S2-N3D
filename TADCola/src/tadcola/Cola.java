package tadcola;

public class Cola<T  extends Comparable> implements ICola<T> {
    
    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int cant;

    public Cola() {
        this.inicio = null;
        this.fin = null;
        this.cant = 0;
    }
    
    @Override
    public void encolar(T n) {
        Nodo nuevo = new Nodo(n);
        nuevo.setSiguiente(null);
            
        if(esVacia()){
            this.inicio = nuevo;
            this.fin = nuevo;
        }else{
            this.fin.setSiguiente(nuevo);
            this.fin = nuevo; // this.fin = this.fin.getSiguiente();
        }
        
        this.cant++;
    }

    @Override
    public void desencolar() {
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
    public T front() {
        return this.inicio.getDato();
    }
    
    @Override
    public boolean esVacia() {
        return this.fin == null;
    }

    @Override
    public void vaciar() {
        this.inicio = null;
        this.fin = null;
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
        
        while(aux != null){
            System.out.print(aux.getDato() + " ");
            aux = aux.getSiguiente();
        }
        System.out.println("");
    }
}
