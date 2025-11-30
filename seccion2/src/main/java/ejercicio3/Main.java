package ejercicio3;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenidos a tu cuenta bancaria");
        System.out.println("Digite el nombre que usara en la cuenta");
        String titular = sc.nextLine();
        System.out.println("Ahora digite el monto inicial");
        double monto = sc.nextDouble(); // monto inicial
        sc.nextLine();


        boolean elegir = false;
        while (!elegir) {
            System.out.println("Que tipo de cuenta desea usar?");
            System.out.println("1. Cuenta de ahorros");
            System.out.println("2. Cuenta corriente");
            String tipo = sc.nextLine();

            switch (tipo) {
                case "1":
                    CuentaDeAhorros cuentaA = new CuentaDeAhorros(monto, titular); // Crear cuenta de ahorros
                    System.out.println("¡Cuenta de Ahorros creada para " + titular + "!");
                    System.out.println("Cuenta de ahorros creada...");

                    boolean depositar = false;
                    int dias = 0;

                    while (!depositar) {
                        dias++;
                        System.out.println("Día " + dias + " - Saldo actual: $" + cuentaA.getSaldo()); // Mostrar saldo actual
                        System.out.println("1. Depositar (se aplica interés diario automáticamente)");
                        System.out.println("2. Retirar");
                        System.out.println("0. Salir");
                        System.out.print("Opción: ");
                        int opcion = sc.nextInt();
                        switch (opcion) {
                            case 1:
                                System.out.print("Monto a depositar: ");
                                double montoDep = sc.nextDouble();
                                cuentaA.depositar(montoDep); // Depositar monto
                                System.out.println("Nuevo saldo: $" + cuentaA.getSaldo()); // Mostrar nuevo saldo
                                break;
                            case 2:
                                System.out.print("Monto a retirar: ");
                                double montoRet = sc.nextDouble();
                                if (cuentaA.retirar(montoRet)) { // Intentar retirar monto
                                    System.out.println("Retiro exitoso. Saldo: $" + cuentaA.getSaldo());
                                } else {
                                    System.out.println("No tiene suficiente saldo");
                                }
                                break;
                            case 0:
                                depositar = true;
                                System.out.println("¡Gracias por usar el banco! Saldo final: $" + cuentaA.getSaldo());
                                break;
                            default:
                                System.out.println("Opcion no reconocida, porfavor intentelo de nuevo");
                                dias--; // No contar día si la opción es inválida
                        }
                    }
                    elegir = true;
                    break;
                case "2":
                    CuentaCorriente cuentaC = new CuentaCorriente(monto, titular); // Crear cuenta corriente
                    System.out.println("¡Cuenta Corriente creada para " + titular + "!");
                    System.out.println("Cuenta corriente creada...");

                    depositar = false;
                    dias = 0;

                    while (!depositar) {
                        dias++;
                        System.out.println("Día " + dias + " - Saldo actual: $" + cuentaC.getSaldo()); // Mostrar saldo actual
                        System.out.println("1. Depositar");
                        System.out.println("2. Retirar");
                        System.out.println("0. Salir");
                        System.out.print("Opción: ");
                        int opcion = sc.nextInt();
                        switch (opcion) {
                            case 1:
                                System.out.print("Monto a depositar: ");
                                double montoDep = sc.nextDouble();
                                cuentaC.depositar(montoDep); // Depositar monto
                                System.out.println("Nuevo saldo: $" + cuentaC.getSaldo()); // Mostrar nuevo saldo
                                break;
                            case 2:
                                System.out.print("Monto a retirar: ");
                                double montoRet = sc.nextDouble();
                                if (cuentaC.retirar(montoRet)) { // Intentar retirar monto
                                    System.out.println("Retiro exitoso. Saldo: $" + cuentaC.getSaldo());
                                } else {
                                    System.out.println("Límite de sobregiro alcanzado."); // Limite hasta 50000
                                }
                                break;
                            case 0:
                                depositar = true;
                                System.out.println("¡Gracias por usar el banco! Saldo final: $" + cuentaC.getSaldo());
                                break;
                            default:
                                System.out.println("Opcion no reconocida, porfavor intentelo de nuevo");
                                dias--;
                        }
                    }
                    elegir = true;
                    break;
                default:
                    System.out.println("Opcion no reconocida, porfavor intentelo de nuevo");
            }
        }sc.close();
    }
}
