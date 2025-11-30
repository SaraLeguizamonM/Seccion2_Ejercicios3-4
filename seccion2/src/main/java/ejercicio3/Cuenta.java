package ejercicio3;

public abstract class  Cuenta  {
    protected double saldo;
    public String cuenta;


    abstract void depositar(double monto); // Metodo abstracto para depositar dinero
    abstract Boolean retirar(double monto); // Metodo abstracto para retirar dinero

    public double getSaldo() { // Metodo para obtener el saldo actual 
        return saldo;
    }
}
