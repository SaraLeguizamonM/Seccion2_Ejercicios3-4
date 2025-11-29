package ejercicio3;

public class CuentaCorriente extends Cuenta{

    public CuentaCorriente(double saldo, String cuenta) {
        this.saldo = saldo;
        this.cuenta = cuenta;

    }

    @Override
    void depositar(double monto) {
        saldo = monto + saldo;
    }

    @Override
    void retirar(double monto) {

    }
}