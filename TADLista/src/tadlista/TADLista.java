package tadlista;

public class TADLista {

    public static void main(String[] args) {
        Lista l = new Lista();
        
        System.out.println("Es vacía: " + l.esVacia());
        l.agregarInicio(2);
        
        System.out.println("Es vacía: " + l.esVacia());
    }
    
}
