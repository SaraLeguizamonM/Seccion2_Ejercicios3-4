package ejercicio3;

public abstract class  Cuenta  {
    protected double saldo;
    public String cuenta;


    abstract void depositar(double monto);
    abstract void retirar(double monto);

    public double getSaldo() {
        return saldo;
    }
}
