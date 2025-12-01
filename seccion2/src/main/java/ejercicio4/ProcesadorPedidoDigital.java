package ejercicio4;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ProcesadorPedidoDigital extends ProcesadorDePedido {
    @Override
    public void procesar() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random(); // Generador de numeros aleatorios para las claves de licencia
        ArrayList<String> itemsDigitales = new ArrayList<>(); // Lista para almacenar los items digitales

        String opcion;

        do {
            System.out.println("------------ INVENTARIO ------------");
            System.out.println("11. Steam-Biblioteca +1000         -");
            System.out.println("25. EpicGames-Biblioteca +2000     -");
            System.out.println("30. Tlanucher +50 Mods             -");
            System.out.println("20. Piratas-Biblioteca +50 CajaBOX -");
            System.out.println("------------------------------------");
            System.out.println("--- Ingrese el codigo del pedido ---");
            String codigo; // Almacena el codigo ingresado por el usuario

            do{
                codigo = sc.nextLine();
                switch (codigo) {
                    case "11":
                        System.out.println("Se ha agregado una Steam-Biblioteca en tu carrito.");
                        itemsDigitales.add("Steam-Biblioteca");
                        break;
                    case "25":
                        System.out.println("Se ha agregado una EpicGames-Biblioteca en tu carrito.");
                        itemsDigitales.add("EpicGames-Biblioteca");
                        break;
                    case "30":
                        System.out.println("Se ha agregado una Tlanucher en tu carrito.");
                        itemsDigitales.add("Tlanucher");
                        break;
                    case "20":
                        System.out.println("Se ha agregado una Piratas-Biblioteca en tu carrito.");
                        itemsDigitales.add("Virus...");
                        break;
                    default:
                        System.out.println("Opcion invalida, porfavor coloca una de nuestras opciones");
                }
            }while(!codigo.equals("11") && !codigo.equals("25") && !codigo.equals("30") && !codigo.equals("20"));

            System.out.println("Quieres agregar otro item a la lista? ");
            do {
                System.out.println("si o no");
                opcion = sc.nextLine().toLowerCase();
                if (!opcion.equals("si") && !opcion.equals("no")) {
                    System.out.println("Opcion invalida, porfavor coloca una opcion");
                }

            } while (!opcion.equals("si") && !opcion.equals("no"));

        } while (opcion.equals("si"));

        System.out.println("Digite su correo");
        String correo = sc.nextLine();

        System.out.println("-------------------------------------------------");
        System.out.println("Para: " + correo);
        System.out.println("Asunto: Has comprado los siguientes items! ");
        System.out.println("-------------------------------------------------");
        for (String item : itemsDigitales) { // Enviar clave de licencia para cada item comprado
            System.out.println(item + " Tu clave de la licencia es: " + rand.nextInt(100000,999999));
        }
        System.out.println("Gracias por tu compra!");
        System.out.println("-------------------------------------------------");
    }
}
