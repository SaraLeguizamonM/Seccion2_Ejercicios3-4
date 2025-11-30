package ejercicio3;
public class CuentaDeAhorros extends Cuenta {
    private final double interesDiario = 0.10 / 365; // Interes anual del 10% dividido por 365 días

    public CuentaDeAhorros(double saldo, String cuenta) { // Constructor
        this.saldo = saldo;
        this.cuenta = cuenta;
    }

    @Override
    void depositar(double monto) { // Depositar dinero y aplicar interes diario
        if (monto > 0) { // Validar monto positivo
            saldo += monto; // Sumar monto al saldo
            double interes = saldo * interesDiario; // Calcular interes diario
            saldo += interes; // Agregar interes al saldo
        }
    }

    @Override
    Boolean retirar(double monto) { // Retirar dinero si hay suficiente saldo
        if (monto > 0 && monto <= saldo) { // Validar monto positivo y suficiente saldo
            saldo -= monto; // Restar monto del saldo
            return true; // Retiro en caso que sea exitoso
        }
        return false; // Retiro fallido
    }
}
