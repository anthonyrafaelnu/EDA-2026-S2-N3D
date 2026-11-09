package tadlista;

import tadcola.Cola;
import tadpila.Pila;

public class Lista<T  extends Comparable> implements ILista<T> {
    
    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int cant;

    public Lista() {
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
        Nodo nuevo = new Nodo(n);
        nuevo.setSiguiente(this.inicio);
        this.inicio = nuevo;
        
        if(esVacia()){ // Solo cuando es el primer nodo
            this.fin = nuevo; // this.fin = this.inicio;
        }
        
        this.cant++;
    }

//    @Override
//    public void agregarFinal(int n) {
//        Nodo nuevo = new Nodo(n);
//        nuevo.setSiguiente(null);
//        
//        if(esVacia()){
//            this.inicio = nuevo;
//        }else{
//            Nodo aux = this.inicio;
//        
//            while(aux.getSiguiente() != null){ // Mientras no llegue al final
//                aux = aux.getSiguiente();
//            }
//
//            aux.setSiguiente(nuevo);
//        }
//        
//        this.cant++;
//    }
    
    @Override
    public void agregarFinal(T n) {
        if(esVacia()){
            this.agregarInicio(n);
        }else{
            Nodo nuevo = new Nodo(n);
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
                Nodo aBorrar = this.inicio;
                this.inicio = this.inicio.getSiguiente();
                aBorrar.setSiguiente(null);

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
                Nodo aux = this.inicio;
                
                while(aux.getSiguiente().getSiguiente() != null){
                    aux = aux.getSiguiente();
                }
                
                this.fin = aux;
                aux.setSiguiente(null);
                
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
        Nodo aux = this.inicio;
        
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
            Nodo aux = this.inicio;
            
                 // aux.getSiguiente().getDato() < n
            while(aux.getSiguiente().getDato().compareTo(n) < 0){
                aux = aux.getSiguiente();
            }
            
            Nodo nuevo = new Nodo(n);
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
            
            this.cant++;
        }
    }

    @Override
    public void borrarElemento(T n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public int cantElementos() {
//        Nodo aux = this.inicio;
//        int cant = 0;
//        
//        while(aux != null){
//            cant++;
//            aux = aux.getSiguiente();
//        }
//        
//        return cant;
//    }
    
    @Override
    public int cantElementos() {
        return this.cant;
    }

    @Override
    public T obtenerElemento(int indice) {
        int pos = 0;
        Nodo<T> aux = this.inicio;
        
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
    public boolean estaOrdenada() {
        if(this.cant <= 1) return true;
        
        Nodo<T> aux = this.inicio;
        
        while(aux.getSiguiente() != null){
            if(aux.getDato().compareTo(aux.getSiguiente().getDato()) > 0) return false;
            aux = aux.getSiguiente();
        }
        
        return true;
    }

    public Lista invertir (){
        Lista ret = new Lista();
        
        Nodo<T> aux = this.inicio;
        while(aux != null){
            ret.agregarInicio(aux.getDato());
            aux = aux.getSiguiente();
        }
        
        return ret;
    }
    
    /*
        Implemente la operación "pilaDeMayores" que recibe un número
        entero y retorna una pila con los elementos de la lista, cuyo valor sea mayor 
        al número indicado. El primer número de la lista que cumpla la condición debe 
        estar situado al tope de la pila. Los nodos de la lista y pila no deben compartir 
        espacios en memoria (si quito un elemento de una estructura no debe afectar a la otra). 
        Se dispone de las operaciones de pila vistas en el curso (push, pop, top)
    */
    public Pila pilaDeMayores(int numero){
        Nodo<T> aux = this.inicio;
        Pila pilaAux = new Pila();
        
        while(aux != null){
            if(aux.getDato().compareTo(numero) > 0){
                pilaAux.push(aux.getDato());
            }
            aux = aux.getSiguiente();
        }
        
        Pila ret = new Pila();
        
        while(!pilaAux.esVacia()){
            ret.push(pilaAux.top());
            pilaAux.pop();
        }
        
        return ret;
    }
    
    /*
        Implemente una nueva operación en el TAD Lista que retorne una cola con los elementos 
        de la lista que son impares. La cola debe ser cargada de forma que el primer 
        elemento de la lista sea el último de la cola en salir
    */
    public Cola obtenerColaImpares(){
        Nodo<T> aux = this.inicio;
        Pila pilaAux = new Pila();
        
        while(aux != null){
            if((int)aux.getDato() % 2 != 0){
                pilaAux.push(aux.getDato());
            }
            aux = aux.getSiguiente();
        }
        
        Cola ret = new Cola();
        
        while(!pilaAux.esVacia()){
            ret.encolar(pilaAux.top());
            pilaAux.pop();
        }
        
        return ret;
    }
    
    /*
        Implemente una nueva operación en el TAD Lista que retorne 
        una pila con los elementos de la lista que son pares. 
        La pila debe ser cargada de forma que el primer elemento de la lista 
        que cumpla con la condición quede al tope de la pila.
    */
    public Pila pilaPares(){
        Nodo<T> aux = this.inicio;
        Pila pilaAux = new Pila();
        
        while(aux != null){
            if((int)aux.getDato() % 2 == 0){
                pilaAux.push(aux.getDato());
            }
            aux = aux.getSiguiente();
        }
        
        Pila ret = new Pila();
        
        while(!pilaAux.esVacia()){
            ret.push(pilaAux.top());
            pilaAux.pop();
        }
        
        return ret;
    }
}
