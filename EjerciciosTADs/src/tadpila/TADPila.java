package tadpila;

public class TADPila {

    public static void main(String[] args) {
        Pila p = new Pila();
        
        p.push(3);
        p.push(6);
        p.push(2);
        p.push(8);
        
        //p.mostrar();
        
        //System.out.println("top: " + p.top());
        
        String exp1 = "({[()]})";
        String exp2 = "({[()]";
        String exp3 = "()({[]})";
        System.out.println("Es balanceado: " + balanceoParentesis(exp3));
    }
    
    public static boolean balanceoParentesis(String exp){
        if(exp.length() % 2 != 0) return false;
        
        Pila p = new Pila();
        
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            
            if(c == '(' || c == '[' || c == '{'){
                p.push(c);
            }else if(c == ')' || c == ']' || c == '}'){
                if(p.esVacia()) return false;
                
                char cPila = (char)p.top();
                if(esPareja(cPila, c)){
                    p.pop();
                }else{
                    return false;
                }
            }
        }
        
        return p.esVacia();
    }
    
    public static boolean esPareja(char cApertura, char cCierre){
        return cApertura == '(' && cCierre == ')' ||
               cApertura == '[' && cCierre == ']' ||
               cApertura == '{' && cCierre == '}';
    }
    
}
