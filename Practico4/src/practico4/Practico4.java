package practico4;

public class Practico4 {

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, 
                       {4, 15, 6}, 
                       {7, 8, 9}};
        
        //mostrarMatriz(mat);
        //mostrarDiagonalPrincipalV2(mat);
        //System.out.println(maximoMatriz(mat));
        //mostrarColumnas(mat);
    }
    
    public static void mostrarMatriz(int[][] mat){ //O(n^2), siendo n cant de filas (o largo de matriz)
        for (int i = 0; i < mat.length; i++) { //O(n)
            for (int j = 0; j < mat[i].length; j++) { //O(n)
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    public static void mostrarDiagonalPrincipal(int[][] mat){
        for (int i = 0; i < mat.length; i++) {
            System.out.println(mat[i][i]);
        }
    }
    
    public static void mostrarDiagonalPrincipalV2(int[][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(i == j){
                    System.out.println(mat[i][i]);
                }
            }
        }
    }
    
    public static int maximoMatriz(int[][] mat){
        int maximo = Integer.MIN_VALUE;
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] > maximo){
                    maximo = mat[i][j];
                }
            }
        }
        
        return maximo;
    }
    
    public static void mostrarColumna(int[][] mat, int col){
        for (int i = 0; i < mat.length; i++) {
            System.out.println(mat[i][col]);
        }
    }
    
    public static void mostrarColumnas(int[][] mat){ //O(n^2), siendo n cant de filas (o largo de matriz)
        for (int col = 0; col < mat[0].length; col++) { //O(n)
            for (int fila = 0; fila < mat.length; fila++) { //O(n)
                System.out.println(mat[fila][col] + " ");
            }
            System.out.println("");
        }
    }
    
    public void mostrarFila(int[][] mat, int fila){
        for (int col = 0; col < mat[fila].length; col++) {
            System.out.println(mat[fila][col]);
        }
    }
    
    public void mostrarFilasImpares(int[][] mat){ //O(n*m)
        for (int i = 1; i < mat.length; i+=2) { 
            for (int j = 0; j < mat[i].length; j++){
                System.out.println(mat[i][j]);
            }
        }
    }
    
    public boolean buscarElementoEnMatriz(int[][] mat, int elemento){ //O(n*m)
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] == elemento) return true;
            }
        }
        return false;
    }
    
    public boolean buscarEnColumna(int[][] mat, int col, int elemento){
        for (int i = 0; i < mat.length; i++) {
            if(mat[i][col] == elemento) return true;
        }
        return false;
    }
    
    public int sumaFila(int[] vec){
        int suma = 0;
        
        for (int i = 0; i < vec.length; i++) {
            suma += vec[i];
        }
        
        return suma;
    }
    
    public int filaMayorSuma(int[][] mat){
        int mayorSuma = sumaFila(mat[0]);
        int fila = 0;
        
        for (int i = 1; i < mat.length; i++) {
            int sumaActual = sumaFila(mat[i]);
            if(sumaActual > mayorSuma){
                mayorSuma = sumaActual;
                fila = i;
            }
        }
        
        return fila;
    }
    
    private boolean vecEsPalindromo(int[] vec){ // O(n)
        boolean esPalindromo = true; // O(1)
        
        for (int i = 0; i < vec.length / 2 && esPalindromo; i++) { // O(n/2)
            if(vec[i] != vec[vec.length - 1 - i]) esPalindromo = false;  // O(1)
        }
        
        return esPalindromo; // O(1)
    }
    
    public int esPalindroma (int[][] mat){
        for (int fila = 0; fila < mat.length; fila++) {
            if(vecEsPalindromo(mat[fila])){
                return fila;
            }
        }
        
        return -1;
    }
}
