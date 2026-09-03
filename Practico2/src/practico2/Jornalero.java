package practico2;

public class Jornalero extends Funcionario {
    private int cantHorasTrabajadas;
    private double valorHora;

    public Jornalero(int cantHorasTrabajadas, double valorHora, String nombre, String ci) {
        super(nombre, ci);
        this.cantHorasTrabajadas = cantHorasTrabajadas;
        this.valorHora = valorHora;
    }

    @Override
    public double calcularSueldo() {
        return this.cantHorasTrabajadas * this.valorHora;
    }
    
}
