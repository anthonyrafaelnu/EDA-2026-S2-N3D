package tadlista;

public class Lista implements ILista {

    private Nodo inicio;
    private Nodo fin;
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
    public void agregarInicio(int n) {
        Nodo nuevo = new Nodo(n);
        nuevo.setSiguiente(this.inicio);
        this.inicio = nuevo;
        
        if(this.esVacia()){
            this.fin = nuevo;
        }
        
        this.cantElementos++;
    }
    
    @Override
    public void agregarFinal(int n) {
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
    public void agregarOrd(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarElemento(int n) {
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
    public int obtenerElemento(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrarREC() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
