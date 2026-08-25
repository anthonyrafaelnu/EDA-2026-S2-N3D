package practico1;

public class Practico1 {

    public static void main(String[] args) {
        //mostrarSumaImpares2();
        
//        int a = 5;
//        int b = a++;
//        
//        System.out.println("a: " + a); // 5 5
//        System.out.println("b: " + b); // 6 5

        //cantParesYProm2(2, 10); // 5,5 : 4 números
        //primerosNImpares(5);
        
        // "Hola" "Hola" "Hola" "Hola" "Hola" "Hola"
        //imprimirNumero(1523);
        
        //System.out.println(esPalindromo("oso"));
        //fibonacci(11); // 8
    }
    
    private static void mostrarSumaImpares(){
        
        int suma = 0;
        
        for (int i = 1; i <= 50; i++) {
            if(i % 2 != 0){
                suma += i;
            }
        }
        
        System.out.println("Resultado: " + suma);
    }
    
    private static void mostrarSumaImpares2(){
        
        int suma = 0;
        
        for (int i = 1; i <= 50; i+=2) {
            suma += i;
        }
        
        System.out.println("Resultado: " + suma);
    }
    
    private static void cantParesYProm(int num1, int num2){ // O(n)
        double prom = (num1 + num2) / 2.0;
        
        int cantPares = 0;
        
        int min = Math.min(num1, num2);
        int max = Math.max(num1, num2);

        if(min % 2 == 0){
            for (int i = min; i < max; i+=2) {
                cantPares++;
            }
        }else{
            for (int i = min + 1; i < max; i+=2) {
                cantPares++;
            }
        }
        
        System.out.println(prom);
        System.out.println(cantPares);
        
        //        for (int i = min; i < max; i++) {
        //            if(i%2 == 0){
        //                cantPares++;
        //            }
        //        }
        
    }
    
    private static void cantParesYProm2(int num1, int num2){ // O(5) = O(1*5) = O(1)
        int result = Math.abs(num1 - num2); // O(1)
        
        if(result % 2 == 0){ // O(1)
            result /= 2;
        }else{
            result = (result-1) / 2;
        }
        
        if(num1 % 2 == 0) result++; // O(1)
        else if(num2 % 2 == 0) result++; // O(1)
        
        System.out.println(result); // O(1)
    }

    // Si recibo n=5
    // 1, 3, 5, 7, 9
    private static void primerosNImpares(int n){
        
        int impar = 1;
        
        for (int i = 1; i <= n; i++) {
            System.out.print(impar + " ");
            impar += 2;
        }
        System.out.println("");
    }

    private static void imprimirNumero(int n){
        String num = n + "";
        //String num = String.valueOf(n);
        
        
        for (int i = 0; i < num.length(); i++) {
            System.out.print(num.charAt(i) + " ");
        }
        
        System.out.println("");
    }
    
    private static boolean esPalindromo(String palabra){ // O(n)
        
        String palabraInvertida = ""; // O(1)
        
        for (int i = palabra.length() - 1; i >= 0 ; i--) {  // O(n)
            palabraInvertida += palabra.charAt(i);  // O(1)
        }
        
        return palabra.equals(palabraInvertida);  // O(n)
    }

    private static boolean esPalindromoV2(String palabra){// O(n)
        boolean esPalindroma = true; // O(1)
        
        for (int i = 0; i < palabra.length() / 2 && esPalindroma; i++) { // O(n/2)
            if(palabra.charAt(i) != palabra.charAt(palabra.length() - 1 - i)) esPalindroma = false;  // O(1)
        }
        
        return esPalindroma; // O(1)
    }
    
    private static void fibonacci(int n){
        int a = 0;
        int b = 1;
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            sum = a+b; // 2
            a = b; // 1
            b = sum; // 2
        }
    }
}
