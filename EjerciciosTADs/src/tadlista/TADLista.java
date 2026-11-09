package tadlista;

public class TADLista {

    public static void main(String[] args) {
        Lista l = new Lista();
        
        l.agregarInicio(3);
        l.agregarInicio(6);
        l.agregarInicio(3);
        l.agregarInicio(1);
        
        // 1, 3, 6, 3
        //l.mostrar();
        //System.out.println("Máximo: " + l.maximo());
        
        //int cantTres = l.contar(3);
        //System.out.println("Cant. de 3: " + cantTres);
        
        //System.out.println("Está ordenada: " + l.estaOrdenada());
        
        Lista lOrdenada = new Lista();
        
        lOrdenada.agregarOrd(2);
        lOrdenada.agregarOrd(1);
        lOrdenada.agregarOrd(5);
        lOrdenada.agregarOrd(3);
        
        lOrdenada.mostrar();
        
        //System.out.println("Está ordenada: " + lOrdenada.estaOrdenada());
        
        Lista invertida = lOrdenada.invertir();
        invertida.mostrar();
    }
    
}
