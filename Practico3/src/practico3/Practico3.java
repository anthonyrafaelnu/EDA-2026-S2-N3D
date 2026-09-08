package practico3;

public class Practico3 {

    public static void main(String[] args) {
        int[] array = {6,3,5,1,8,7,2,4};
        
        //System.out.println("Array: " + mostrarv(array));
        //System.out.println("Promedio: " + promedio(array));
        //System.out.println("Solo impares: " + muestroValoresImpares(array));
        //System.out.println("Valores en pos pares: " + muestroPosPares(array));
        
        int[] arrayOrd = {2, 5, 6, 7, 18, 19};
        int[] a = {};
        
        //System.out.println(a.length);
        
        //System.out.println("Pertenece: " + buscarVecV2(arrayOrd, 21));
        
        //int[] simetrico = {1,2,3,4,3,2,1};
        //System.out.println("Es simétrico: " + esSimetricoV2(a));
        
        int posDesde = 0;
        int posHasta = 2;
        //System.out.println("Pos mínima: " + minPosV2(array, posDesde, posHasta));
        //System.out.println(posDesde);
        
        System.out.println("Array desordenado: " + mostrarv(array));
        ordenarVec2(array);
        System.out.println("Array ordenado: " + mostrarv(array));
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
        PRE: -
        POS: Retorna true si el array es simétrico, false en caso contrario
    */
    public static boolean esSimetrico(int []v){
        
        if(v.length == 0 || v.length == 1) return true;
        
        for (int i = 0; i < v.length / 2; i++) {
            if(v[i] != v[v.length - 1 - i]) return false;
        }
        
        return true;
    }
    
    public static boolean esSimetricoV2(int []v){
        boolean resultado = true;
        int inicio = 0;
        int fin = v.length - 1;
        
        while(inicio <= fin){
            if(v[inicio] != v[fin]){
                resultado = false;
                break;
            }
            
            inicio++;
            fin--;
        }
        
        return resultado;
    }
    
    /*
        PRE: Recibo dos posiciones válidas, donde posDesde <= posHasta
        POS: Retorno la posición donde se encuentra el elemento entre esas 
             dos posiciones, inclusive.
    */
    public static int posMinVec(int []v,int posDesde, int posHasta){
        int minPos = posDesde;
        int min = v[posDesde];
        
        for (int i = posDesde + 1; i <= posHasta; i++) {
            if(v[i] < min){
                min = v[i];
                minPos = i;
            }
        }
        
        return minPos;
    }
    
    public static int minPosV2(int[] v, int a, int b) {
        int min = Integer.MAX_VALUE;
        int pos = 0;
        
        for (; a <= b; a++) {
            if (v[a] < min) {
                min = v[a];
                pos = a;
            }
        }
        
        return pos;
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

    /*
        PRE: Recibe un vector de enteros desordenado
        POS: Ordena el vector de enteros
    */
    public static void ordenarvec(int []v){ // O(n^2)
        for (int i = 0; i < v.length; i++) { // O(n)
            int posMin = posMinVec(v, i, v.length - 1); // O(n)
            
            int aux = v[i];
            v[i] = v[posMin];
            v[posMin] = aux;
        }
    }
    
    public static void ordenarVec2(int[] v) {
        int[] nuevoV = new int[v.length];

        for (int i = 0; i < v.length; i++) {
            int posMin = posMinVec(v,0,v.length - 1);
            nuevoV[i] = v[posMin];
            v[posMin] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < v.length; i++) {
            v[i] = nuevoV[i];
        }
    }
    
}
