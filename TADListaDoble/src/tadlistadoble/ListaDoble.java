package tadlistadoble;

public class ListaDoble<T  extends Comparable> implements IListaDoble<T> {
    
    private NodoDoble<T> inicio;
    private NodoDoble<T> fin;
    private int cant;

    public ListaDoble() {
        this.inicio = null;
        this.fin = null;
        this.cant = 0;
    }

    @Override
    public boolean esVacia() {
        return this.fin == null;
    }

    @Override
    public void agregarInicio(T n) {
        NodoDoble nuevo = new NodoDoble(n);
        nuevo.setAnterior(null);
        nuevo.setSiguiente(this.inicio);
        
        this.inicio.setAnterior(nuevo);
        this.inicio = nuevo;
        
        if(esVacia()){ // Solo cuando es el primer nodo
            this.fin = nuevo; // this.fin = this.inicio;
        }
        
        this.cant++;
    }
    
    @Override
    public void agregarFinal(T n) {
        if(esVacia()){
            this.agregarInicio(n);
        }else{
            NodoDoble nuevo = new NodoDoble(n);
            nuevo.setAnterior(this.fin);
            nuevo.setSiguiente(null);
            
            this.fin.setSiguiente(nuevo);
            this.fin = nuevo; // this.fin = this.fin.getSiguiente();
        
            this.cant++;
        }
    }

    @Override
    public void borrarInicio() {
        if(!esVacia()){
            if(this.inicio.getSiguiente() == null){ //Un nodo
                this.vaciar();
            }else{
                NodoDoble aBorrar = this.inicio;
                this.inicio = this.inicio.getSiguiente();
                aBorrar.setSiguiente(null);
                
                this.inicio.setAnterior(null);

                this.cant--;
            }
        }
    }

    @Override
    public void borrarFin() {
        if(!esVacia()){
            if(this.inicio.getSiguiente() == null){ //Un nodo
                this.vaciar();
            }else{
                NodoDoble aux = this.fin.getAnterior();
                this.fin.setAnterior(null);
                aux.setSiguiente(null);
                
                this.fin = aux;
                
                this.cant--;
            }
        }
    }

    @Override
    public void vaciar() {
        this.inicio = null;
        this.fin = null;
        this.cant = 0;
    }

    @Override
    public void mostrar() {
        NodoDoble aux = this.inicio;
        
        while(aux != null){
            System.out.print(aux.getDato() + " ");
            aux = aux.getSiguiente();
        }
        System.out.println("");
    }

    @Override
    public void agregarOrd(T n) {
                            // n <= this.inicio.getDato()
        if(this.esVacia() || n.compareTo(this.inicio.getDato()) <= 0){
            this.agregarInicio(n);
                // n >= this.fin.getDato()
        }else if(n.compareTo(this.fin.getDato()) >= 0){
            this.agregarFinal(n);
        }else{
            NodoDoble aux = this.inicio;
            
                 // aux.getSiguiente().getDato() < n
            while(aux.getSiguiente().getDato().compareTo(n) < 0){
                aux = aux.getSiguiente();
            }
            
            NodoDoble nuevo = new NodoDoble(n);
            
            nuevo.setSiguiente(aux.getSiguiente());
            nuevo.setAnterior(aux);
            
            aux.getSiguiente().setAnterior(nuevo);
            aux.setSiguiente(nuevo);
            
            this.cant++;
        }
    }

    @Override
    public void borrarElemento(T n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int cantElementos() {
        return this.cant;
    }

    @Override
    public T obtenerElemento(int indice) {
        int pos = 0;
        NodoDoble<T> aux = this.inicio;
        
        while(pos != indice){
            aux = aux.getSiguiente();
            pos++;
        }
        
        return aux.getDato();
    }

    @Override
    public void mostrarREC() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public T maximo(){
        T max = this.inicio.getDato();
        
        NodoDoble<T> aux = this.inicio.getSiguiente();
        
        while(aux != null){
            if(aux.getDato().compareTo(max) > 0){
                max = aux.getDato();
            }
            
            aux = aux.getSiguiente();
        }
        
        return max;
    }

    @Override
    public int contar(T elem) {
        int contador = 0;
        
        NodoDoble<T> aux = this.inicio;
        
        while(aux != null){
            if(aux.getDato().equals(elem)){
                contador++;
            }
            aux = aux.getSiguiente();
        }
        
        return contador;
    }

    @Override
    public boolean estaOrdenada() {
        if(this.cant <= 1) return true;
        
        NodoDoble<T> aux = this.inicio;
        
        while(aux.getSiguiente() != null){
            if(aux.getDato().compareTo(aux.getSiguiente().getDato()) > 0) return false;
            aux = aux.getSiguiente();
        }
        
        return true;
    }

    public ListaDoble invertir (){
        ListaDoble ret = new ListaDoble();
        
        NodoDoble<T> aux = this.inicio;
        while(aux != null){
            ret.agregarInicio(aux.getDato());
            aux = aux.getSiguiente();
        }
        
        return ret;
    }
}
