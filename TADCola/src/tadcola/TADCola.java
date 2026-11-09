package tadcola;

public class TADCola {

    public static void main(String[] args) {
        Cola c = new Cola();
        c.encolar(2);
        c.encolar(4);
        c.encolar(1);
        
        System.out.println("Primero en llgar: " + c.front());
        
        c.desencolar();
        
        System.out.println("Siguiente: " + c.front());
    }
    
}
