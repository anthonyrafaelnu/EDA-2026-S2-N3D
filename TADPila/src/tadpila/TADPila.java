package tadpila;

public class TADPila {

    public static void main(String[] args) {
        Pila p = new Pila();
        
        p.push(2);
        p.push(4);
        p.push(1);
        p.push(9);
        
        System.out.println("Pertenece: " + pertenece(p, 4));
        
//        p.pop();
        p.mostrar();
//        System.out.println("Elemento: " + p.top());
    }
    
    public static boolean pertenece(Pila p, int n){
        boolean esta = false;
        Pila aux = new Pila();
        
        while(!p.esVacia() && !esta){
            int dato = (int)p.top();
            if(dato == n){
                esta = true;
            }else{
                aux.push(dato);
                p.pop();
            }
        }
        
        while(!aux.esVacia()){
            int dato = (int)aux.top();
            p.push(dato);
            aux.pop();
        }
        
        return esta;
    }
    
}
