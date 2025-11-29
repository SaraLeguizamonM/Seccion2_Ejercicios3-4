package ejercicio3;

public abstract class  Cuenta  {
    private int saldo;
    public String cuenta;

    abstract void depositar();
    abstract void retirar();

    public int getSaldo() {
        return saldo;
    }
}
