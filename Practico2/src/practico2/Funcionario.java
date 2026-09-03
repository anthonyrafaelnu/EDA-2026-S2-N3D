package practico2;

import java.util.Objects;

public abstract class Funcionario implements Comparable<Funcionario> {
    private String nombre;
    private String ci;
    
    public Funcionario(String nombre, String ci){
        this.nombre = nombre;
        this.ci = ci;
    }
    
    public abstract double calcularSueldo();
    
    // Funcionario f1 = new Funcionario(...);
    // Funcionario f2 = new Funcionario(...);
    // f1.ganaMas(f2);
    public boolean ganaMas(Funcionario f){
        return this.calcularSueldo() > f.calcularSueldo();
    }

    @Override
    public boolean equals(Object obj) {
        Funcionario f = (Funcionario) obj;
        return this.ci.equals(f.ci);
    }

    // Funcionario f1 = new Funcionario(...);
    // Funcionario f2 = new Funcionario(...);
    // f1.compareTo(f2);
    // 0 (Si son iguales)
    // 1 (Si f1 es mayor)
    // -1 (Si f2 es mayor)
    @Override
    public int compareTo(Funcionario o) {
        return (int)(this.calcularSueldo() - o.calcularSueldo());
    }
    
    
}
