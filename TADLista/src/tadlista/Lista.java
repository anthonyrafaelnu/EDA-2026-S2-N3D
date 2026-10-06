package tadlista;

public class Lista<T extends Comparable> implements ILista<T> {

    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int cantElementos;

    public Lista() {
        this.inicio = null;
        this.fin = null;
        cantElementos = 0;
    }
    
    @Override
    public boolean esVacia() {
        return this.fin == null;
    }

    @Override
    public void agregarInicio(T n) {
        Nodo nuevo = new Nodo(n);
        nuevo.setSiguiente(this.inicio);
        this.inicio = nuevo;
        
        if(this.esVacia()){
            this.fin = nuevo;
        }
        
        this.cantElementos++;
    }
    
    @Override
    public void agregarFinal(T n) {
        if(this.esVacia()){
            this.agregarInicio(n);
        }else{
            Nodo ultimo = new Nodo(n);
            ultimo.setSiguiente(null);
            this.fin.setSiguiente(ultimo);
            this.fin = ultimo; // this.fin = this.fin.getSiguiente();
            
            this.cantElementos++;
        }
    }

//    @Override
//    public void agregarFinal(int n) {
//        if(this.esVacia()){
//            this.agregarInicio(n);
//        }else{
//            Nodo aux = this.inicio;
//        
//            while(aux.getSiguiente() != null){
//                aux = aux.getSiguiente();
//            }
//
//            Nodo ultimo = new Nodo(n);
//            ultimo.setSiguiente(null);
//            aux.setSiguiente(ultimo);
//            
//            this.cantElementos++;
//        }
//    }

    @Override
    public void borrarInicio() {
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
    public void borrarFin() {
        if(!this.esVacia()){
            
            //Si hay un solo nodo
            if(this.inicio.getSiguiente() == null){
                this.vaciar();
            }else{
               Nodo aux = this.inicio;
            
                while(aux.getSiguiente().getSiguiente() != null){
                    aux = aux.getSiguiente();
                }

                this.fin = aux;
                aux.setSiguiente(null);
                
                this.cantElementos--;
            }
        }
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
    public void agregarOrd(T n) {
        if(this.esVacia() || n.compareTo(this.inicio.getDato()) <= 0){
            this.agregarInicio(n);
        }else if(n.compareTo(this.fin.getDato()) >= 0){
            this.agregarFinal(n);
        }else{
            Nodo<T> aux = this.inicio;
            Nodo<T> nuevo = new Nodo(n);
            
            while(aux.getSiguiente().getDato().compareTo(n) <= 0){
                aux = aux.getSiguiente();
            }
            
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
            
            this.cantElementos++;
        }
    }

    @Override
    public void borrarElemento(T n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int cantElementos() {
        return this.cantElementos;
    }

//    @Override
//    public int cantElementos() {
//        int cant = 0;
//        
//        Nodo aux = this.inicio;
//        while(aux != null){
//            cant++;
//            aux = aux.getSiguiente();
//        }
//        
//        return cant;
//    }

    @Override
    public T obtenerElemento(int indice) {
        Nodo<T> aux = this.inicio;
        
        for (int i = 0; i < this.cantElementos; i++) {
            if(i == indice){
                return aux.getDato();
            }
            aux = aux.getSiguiente();
        }
        
        return null;
    }
    
//    @Override
//    public T obtenerElemento(int indice) {
//        Nodo<T> aux = this.inicio;
//        
//        for (int i = 0; i < this.cantElementos && i != indice; i++) {
//            aux = aux.getSiguiente();
//        }
//        
//        return aux.getDato();
//    }

    @Override
    public T maximo() {
        T max = this.inicio.getDato();
        
        Nodo<T> aux = this.inicio.getSiguiente();
        
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
        
        Nodo<T> aux = this.inicio;
        
        while(aux != null){
            if(aux.getDato().equals(elem)){
                contador++;
            }
            aux = aux.getSiguiente();
        }
        
        return contador;
    }

    @Override
    public Lista invertir() {
        Lista ret = new Lista();
        
        Nodo<T> aux = this.inicio;
        while(aux != null){
            ret.agregarInicio(aux.getDato());
            aux = aux.getSiguiente();
        }
        
        return ret;
    }

    @Override
    public boolean estaOrdenada() {
        if(this.cantElementos <= 1) return true;
        
        Nodo<T> aux = this.inicio;
        
        while(aux.getSiguiente() != null){
            if(aux.getDato().compareTo(aux.getSiguiente().getDato()) > 0){
                return false;
            }
            aux = aux.getSiguiente();
        }
        
        return true;
    }

    @Override
    public void mostrarREC() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
