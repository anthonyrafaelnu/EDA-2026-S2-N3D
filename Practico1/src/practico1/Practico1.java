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
        primerosNImpares(5);
        
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
    
    private static void cantParesYProm(int num1, int num2){
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
    
    private static void cantParesYProm2(int num1, int num2){
        int result = Math.abs(num1 - num2);
        
        if(result % 2 == 0){
            result /= 2;
        }else{
            result = (result-1) / 2;
        }
        
        if(num1 % 2 == 0) result++;
        else if(num2 % 2 == 0) result++;
        
        System.out.println(result);
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
}
