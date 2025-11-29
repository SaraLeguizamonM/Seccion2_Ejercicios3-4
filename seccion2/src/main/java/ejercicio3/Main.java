package ejercicio3;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenidos a tu cuenta bancaria");
        System.out.println("Digite el nombre que usara en la cuenta");
        String titular = sc.nextLine();
        System.out.println("Ahora digite el monto inicial");
        double monto = sc.nextDouble();


        boolean elegir = false;
        while (!elegir) {
            System.out.println("Que tipo de cuenta desea usar?");
            System.out.println("1. Cuenta de ahorros");
            System.out.println("2. Cuenta corriente");
            String tipo = sc.nextLine();
            switch (tipo) {
                case "1":
                    CuentaDeAhorros cuentaA = new CuentaDeAhorros(monto, titular);
                    elegir = true;
                    break;
                case "2":
                    CuentaCorriente cuentaC = new CuentaCorriente(monto, titular);
                    elegir = true;
                    break;
                default:
                    System.out.println("Opcion no reconocida, porfavor intentelo de nuevo");

            }
        }
    }
}
