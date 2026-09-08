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
    
    public static void mostrarColumnas(int[][] mat){ //O(n^2), siendo n cant de filas (o largo de matriz)
        for (int col = 0; col < mat[0].length; col++) { //O(n)
            for (int fila = 0; fila < mat.length; fila++) { //O(n)
                System.out.println(mat[fila][col] + " ");
            }
            System.out.println("");
        }
    }
}
