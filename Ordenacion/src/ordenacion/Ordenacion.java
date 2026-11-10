package ordenacion;

import java.util.Arrays;

public class Ordenacion {

    public static void main(String[] args) {
        int[] a = {34, 11, 5, 1, 3, 90};
        int[] b = {1, 3, 5, 11, 34, 90};
        insertionSort(a);
        System.out.println(Arrays.toString(a));
    }
    
    public static void bubbleSort(int[] v){
        
        int pasadas = 0;
        int intercambios = 0;
        
        for (int i = 0; i < v.length - 1; i++) {
            pasadas++;
            for (int j = 0; j < v.length - 1 - i; j++) {
                if(v[j] > v[j + 1]){
                    int aux = v[j];
                    v[j] = v[j+1];
                    v[j+1] = aux;
                    
                    intercambios++;
                }
            }
        }
        
        System.out.println("Pasadas: " + pasadas +", Intercambios: " + intercambios);
    }
    
    public static void bubbleSortV2(int[] v){
        
        int pasadas = 0;
        int intercambios = 0;
        
        boolean estaOrdenado = false;
        
        for (int i = 0; i < v.length - 1 && !estaOrdenado; i++) {
            pasadas++;
            estaOrdenado = true;
            for (int j = 0; j < v.length - 1 - i; j++) {
                if(v[j] > v[j + 1]){
                    int aux = v[j];
                    v[j] = v[j+1];
                    v[j+1] = aux;
                    
                    intercambios++;
                    estaOrdenado = false;
                }
            }
        }
        
        System.out.println("Pasadas: " + pasadas +", Intercambios: " + intercambios);
    }
    
    public static void selectionSort(int[] v){
        
        
        int pasadas = 0;
        int intercambios = 0;
        
        for (int i = 0; i < v.length - 1; i++) {
            pasadas++;
            int posMin = i;
            
            for (int j = i + 1; j < v.length; j++) {
                if(v[j] < v[posMin]){
                    posMin = j;
                }
            }
            
            if(posMin != i){
                int aux = v[i];
                v[i] = v[posMin];
                v[posMin] = aux;
                intercambios++;
            }
        }
        
        System.out.println("Pasadas: " + pasadas +", Intercambios: " + intercambios);
    }
    
    public static void selectionSortV2(int[] v){
        int pasadas = 0;
        int intercambios = 0;
        boolean estaOrdenado = false;
        
        for (int i = 0; i < v.length - 1 && !estaOrdenado; i++) {
            pasadas++;
            int posMin = i;
            estaOrdenado = true;
            
            for (int j = i + 1; j < v.length; j++) {
                if(v[j] < v[posMin]){
                    posMin = j;
                }
                if(v[j] < v[j - 1]){
                    estaOrdenado = false;
                }
            }
            
            if(posMin != i){
                int aux = v[i];
                v[i] = v[posMin];
                v[posMin] = aux;
                intercambios++;
            }
        }
        
        System.out.println("Pasadas: " + pasadas +", Intercambios: " + intercambios);
    }

    public static void insertionSort(int[] v){
        for (int i = 1; i < v.length; i++) {
            
            int insert = v[i];
            int j = i - 1;
            
            while(j >= 0 && insert < v[j]){
                v[j + 1] = v[j];
                j--;
            }
            
            v[j + 1] = insert;
        }
    }
}
