package ejercicio4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Bienvenido al Sistema de Procesamiento de Pedidos---");
        System.out.println("--------------------------------------------------------");
        System.out.println("---         ¿Que tipo de pedido desea hacer?         ---");
        System.out.println("1. Producto en fisico                                  -");
        System.out.println("2. Producto en Digital                                 -");
        System.out.println("--------------------------------------------------------");
        String opcion;

        do{
            opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    ProcesadorPedidoFisico procesadorFisico = new ProcesadorPedidoFisico();
                    procesadorFisico.validarPedido();
                    procesadorFisico.procesar();
                    break;
                case "2":
                    ProcesadorPedidoDigital  procesadorDigital = new ProcesadorPedidoDigital();
                    procesadorDigital.validarPedido();
                    procesadorDigital.procesar();
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        }while(!opcion.equals("1")&& !opcion.equals("2"));
    }
}
