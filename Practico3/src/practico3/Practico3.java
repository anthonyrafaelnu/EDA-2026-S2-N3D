package practico3;

public class Practico3 {

    public static void main(String[] args) {
        int[] array = {6,3,5,1,8,7,2,4};
        
        //System.out.println("Array: " + mostrarv(array));
        //System.out.println("Promedio: " + promedio(array));
        //System.out.println("Solo impares: " + muestroValoresImpares(array));
        //System.out.println("Valores en pos pares: " + muestroPosPares(array));
        
        int[] arrayOrd = {2, 5, 6, 7, 18, 19};
        
        System.out.println("Pertenece: " + buscarVecV2(arrayOrd, 21));
    }
    
    /*
        PRE: -
        POS: Retorna un string con los valores del vector,
             en el mismo orden que aparecen en el array y
             separados por un " - ".
             El último número no debe tener un " - "  a la derecha.
    */
    public static String mostrarv(int []v){
        
        String ret = "";
        
        for (int i = 0; i < v.length - 1; i++) {
            ret += v[i] + " - ";
        }
        
        ret += v[v.length - 1];
        return ret;
    }
    
    /*
        PRE: -
        POS: Retorno el promedio de datos de v
    */
    public static double promedio(int []v){
        
        int suma = 0;
        int cantDatos = v.length;
        
        for (int i = 0; i < cantDatos; i++) {
            suma += v[i];
        }
        
        return (double)suma/cantDatos;
    }
    
    public static String muestroValoresImpares(int v[]){
        String ret = "";
        
        for (int i = 0; i < v.length; i++) {
            if(v[i] % 2 != 0){
                ret += v[i] + " - ";
            }
        }
        
        return ret.replaceAll(" - $", "");
    }
    
    public static String muestroPosPares(int v[]){ // O(n/2) = O(n * 1/2) = O(n)
        String ret = "";
        
        for (int i = 0; i < v.length; i+=2) {
            ret += v[i] + " - ";
        }
        
        return ret.replaceAll(" - $", "");
    }

    /*
        PRE: Recibo una array de enteros, no vacío y desordenado
        POS: Retorna el máximo valor del array
    */
    public static int maxVec(int []v){
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < v.length; i++) {
            if(v[i] > max){
                max = v[i];
            }
        }
        
        return max;
    }
    
    /*
        PRE: Recibo una array de enteros, no vacío y desordenado
        POS: Retorna el máximo valor del array
    */
    public static int maxVecV2(int []v){
        int max = v[0];
        
        for (int i = 1; i < v.length; i++) {
            if(v[i] > max){
                max = v[i];
            }
        }
        
        return max;
    }
    
    /*
        PRE: Recibo una array de enteros, no vacío y ordenado asc
        POS: Retorna el máximo valor del array
    */
    public static int maxVecV3(int []v){
        return v[v.length - 1];
    }
    
    /*
        PRE: Recibo una array de enteros, no vacío y desordenado
        POS: Retorna true si existe el elemento, false en caso contrario
    */
    public static boolean buscarVec(int []v, int elemento){
        for (int i = 0; i < v.length; i++) {
            if(v[i] == elemento) return true;
        }
        return false;
    }
    
    /*
        PRE: Recibo una array de enteros, no vacío y ordenado asc
        POS: Retorna true si existe el elemento, false en caso contrario
    */
    public static boolean buscarVecV2(int []v, int elemento){
        int inicio = 0;
        int fin = v.length - 1;
        
        while(inicio <= fin){
            int medio = (inicio + fin) / 2;
            
            if(v[medio] == elemento){
                return true;
            } else if(elemento > v[medio]){
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        
        return false;
    }

}
