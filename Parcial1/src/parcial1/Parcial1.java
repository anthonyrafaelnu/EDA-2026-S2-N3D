package parcial1;

public class Parcial1 {

    public static void main(String[] args) {
        int[] v = {1,4,2,6,8,9};
        int[][] mat = {{10000, 2, 3},
                       {4, 10000, 6},
                       {7, 8, 10001}};
        
        //System.out.println("Hay repetido: " + hayRepetido(v));
        //System.out.println("Hay repetido: " + hayRepetidoV2(v, 9));
        System.out.println("Mínimo: " + minimoDiagonal(mat));
    }
    
    public static boolean hayRepetido(int[] vec){
        boolean hayRep = false;
        
        for (int i = 0; i < vec.length && !hayRep; i++) {
            for (int j = i + 1; j < vec.length && !hayRep; j++) {
                if(vec[i] == vec[j]){
                    hayRep = true;
                }
            }
        }
        
        return hayRep;
    }
    
    public static boolean hayRepetidoV2(int[] vec, int max){
        
        if(vec.length > max) return true;
        
        boolean[] aux = new boolean[max + 1];
        
        for (int i = 0; i < vec.length; i++) {
            if(aux[vec[i]] == true) return true;
            aux[vec[i]] = true;
        }
        
        return false;
    }

    public static int minimoDiagonal(int[][] mat){
        int minimo = mat[0][0];
        for (int i = 0; i < mat.length; i++) {
            int aux = mat[i][i];
            if(aux < minimo){
                minimo = aux;
            }
        }
        return minimo;
    }

    public static int cantFilasAsc(int[][] mat){
        int cantFilas = 0;
        boolean esAsc = false;
        
        for (int i = 0; i < mat.length; i++) {
            
            esAsc = true; // Asumimos que la fila es ascendente
            
            for (int j = 0; j <= mat[i].length - 2 && esAsc; j++) {
                if(mat[i][j] > mat[i][j+1]){ // Caso que no quiero contar
                    esAsc = false;
                }
            }
            
            if(esAsc){
                cantFilas++;
            }
        }
        
        return cantFilas;
    }

    public static int[] juntarDosVec(int[] v1, int[] v2){
        int posV1 = 0;
        int posV2 = 0;
        
        int[] res = new int[v1.length + v2.length];
        int posRes = 0;
        
        // Tengo cosas en ambos vectores
        while(posV1 < v1.length && posV2 < v2.length){ 
            if(v1[posV1] <= v2[posV2]){
                res[posRes] = v1[posV1];
                posV1++;
            }else{
                res[posRes] = v2[posV2];
                posV2++;
            }
            posRes++;
        }
        
        // Completo los elementos restantes de v1
        while(posV1 < v1.length){
            res[posRes] = v1[posV1];
            posV1++;
            posRes++;
        }
        
        // Completo los elementos restantes de v2
        while(posV2 < v2.length){
            res[posRes] = v2[posV2];
            posV2++;
            posRes++;
        }
        
        return res;
    }
    
    public static boolean dosColumnasSumanLoMismo(int[][] mat){
        int cantColumnas = mat[0].length;
        int[] aux = new int[cantColumnas];
        
        int sumaCol = 0;
        
        for (int col = 0; col < cantColumnas; col++) {
            sumaCol = 0;
            for (int fila = 0; fila < mat.length; fila++) {
                sumaCol += mat[fila][col];
            }
            aux[col] = sumaCol;
        }
        
        for (int i = 0; i < aux.length; i++) {
            for (int j = i + 1; j < aux.length; j++) {
                if(aux[i] == aux[j]){
                    return true;
                }
            }
        }
        
        return false;
    }

}