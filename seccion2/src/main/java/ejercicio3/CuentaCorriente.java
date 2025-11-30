package ejercicio3;

public class CuentaCorriente extends Cuenta{
    private final double liimiteDeSobreGiro = -50000; // Limite de sobregiro de -50000

    public CuentaCorriente(double saldo, String cuenta) { // Constructor
        this.saldo = saldo;
        this.cuenta = cuenta;

    }

    @Override
    void depositar(double monto) { // Depositar dinero
        if (monto > 0) { // Validar monto positivo
            saldo += monto;
        }
    }

    @Override
    Boolean retirar(double monto) { // Retirar dinero si no excede el limite de sobregiro
        if (monto > 0 && saldo - monto >= liimiteDeSobreGiro) { // Validar monto positivo y limite de sobregiro
            saldo -= monto; // Restar monto del saldo
            return true; // Retiro en caso de que sea exitoso
        }
        return false; // Retiro fallido
    }
}