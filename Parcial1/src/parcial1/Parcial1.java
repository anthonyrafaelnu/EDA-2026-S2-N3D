package parcial1;

import tadlista.Lista;

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
    
    public static int sumarPosParesEntre(int[] v, int inicio, int fin){
        if(inicio >= v.length - 1 || fin <= 0) return 0;
        if(inicio < 0) inicio = -1;
        if(fin > v.length - 1) fin = v.length;
        
        int suma = 0;
        
        for (int i = inicio + 1; i < fin; i++) {
            if(i % 2 == 0){
                suma += v[i];
            }
        }
        
        return suma;
    }

    public int sumarFilaYColumna(int[][] mat, int fila, int columna){
        
        int sumaCol = 0;
        int sumaFila = 0;

        // Recorro la columna
        for (int f = 0; f < mat.length; f++) {
            sumaCol += mat[f][columna];
        }
        
        // Recorro la fila
        for (int c = 0; c < mat[fila].length; c++) {
            sumaFila += mat[fila][c];
        }
        
        return sumaFila + sumaCol - mat[fila][columna];
    }
    
    public static boolean sumaDiagonalesIguales(int[][] mat){
        
        int diagonalPrincipal = 0;
        int diagonalInversa = 0;
        
        for (int i = 0; i < mat.length; i++) {
            diagonalPrincipal += mat[i][i];
            diagonalInversa += mat[i][mat.length - 1 - i];
        }
        
        return diagonalPrincipal == diagonalInversa;
    }
    
    // Muestre por consola los elementos de la lista mayores estricto a n
    // esVacia, agregarInicio, agregarFinal, borrarInicio, borrarFin, 
    // vaciar, mostrar, cantidadElementos, existeElemento y obtenerElementoPosicion.
    public static void mayoresA (Lista l, int n){
        for (int i = 0; i < l.cantElementos(); i++) {
            int elem = (int)l.obtenerElemento(i);
            if(elem > n){
                System.out.print(elem + " ");
            }
        }
    }
    
    public static int posicionMenorPar(int[] vec){
        int pos = -1;
        int valorParMasChico = vec[0]; // En principio no sabemos ni siquiera si es par
        
        for (int i = 0; i < 10; i++) {
            if(vec[i] % 2 == 0){ // Si estoy en un valor par, me interesa
                if(pos == -1){ // Es el primer par que encuentro
                    pos = i;
                    valorParMasChico = vec[i];
                }else if(vec[i] < valorParMasChico){
                    valorParMasChico = vec[i];
                    pos = i;
                }
            }
        }
        
        return pos;
    }
    
    public static int sumaBorde(int[][] mat){
        int sumaFila0 = 0;
        int sumaUltimaFila = 0;
        int sumaCol0 = 0;
        int sumaUltimaCol = 0;
        
        // Recorro la primera y última fila
        for (int col = 0; col < mat[0].length; col++) {
            sumaFila0 += mat[0][col];
            sumaUltimaFila += mat[mat.length - 1][col];
        }
        
        // Recorro la primera y última columna
        for (int fila = 0; fila < mat.length; fila++) {
            sumaCol0 += mat[fila][0];
            sumaUltimaCol += mat[fila][mat[0].length - 1];
        }
        
        return sumaFila0 + sumaUltimaFila + sumaCol0 + sumaUltimaCol
             - mat[0][0] - mat[0][mat[0].length - 1] - mat[mat.length - 1][0]
             - mat[mat.length - 1][mat[0].length - 1];
    }
    
    public static boolean existeColumnaMultiploDe(int[][] mat, int n){
        boolean existeColMultiplo = false;
        
        for (int col = 0; col < mat[0].length; col++) {
            existeColMultiplo = true;
            for (int fila = 0; fila < mat.length && existeColMultiplo; fila++) {
                if(mat[fila][col] % n != 0){
                    existeColMultiplo = false;
                }
            }
            
            if(existeColMultiplo){
                return true;
            }
        }
        
        return false;
    }
}