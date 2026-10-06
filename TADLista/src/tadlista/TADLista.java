package tadlista;

public class TADLista {

    public static void main(String[] args) {
        Lista l = new Lista();
        
        System.out.println("Es vacía: " + l.esVacia());
        l.agregarInicio(4);
        l.agregarInicio(3);
        l.agregarInicio(2);
        l.agregarFinal(5);
        l.agregarOrd(1);
        l.borrarInicio();
        
        l.mostrar();
        System.out.println("Cantidad: " + l.cantElementos());
        
        Lista invertida = l.invertir();
        invertida.mostrar();
        
        System.out.println("Está ordenada: " + l.estaOrdenada());
        System.out.println("Está ordenada: " + invertida.estaOrdenada());
    }
    
}
