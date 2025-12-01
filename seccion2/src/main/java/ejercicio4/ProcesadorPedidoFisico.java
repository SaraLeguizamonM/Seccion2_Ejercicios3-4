package ejercicio4;
import java.util.ArrayList;
import java.util.Scanner;

public class ProcesadorPedidoFisico extends ProcesadorDePedido{
    @Override
    public void procesar() {
        ArrayList<String> items = new ArrayList<>(); // Lista para almacenar los items fisicos

        Scanner sc = new Scanner(System.in);

        String opcion;

        do{
            System.out.println("------------ INVENTARIO ------------");
            System.out.println("1125. PlayStation                  -");
            System.out.println("3025. Xbox                         -");
            System.out.println("3011. Nintendo Switch              -");
            System.out.println("2025. Nintendo Wii                 -");
            System.out.println("------------------------------------");
            System.out.println("--- Ingrese el codigo del pedido ---");
            String codigo; // Almacena el codigo ingresado por el usuario
            do{
                codigo = sc.nextLine();
                switch (codigo) {
                    case "1125":
                        System.out.println("Se ha agregado una PlayStation en tu carrito.");
                        items.add("PlayStation");
                        break;
                    case "3025":
                        System.out.println("Se ha agregado una Xbox en tu carrito.");
                        items.add("Xbox");
                        break;
                    case "3011":
                        System.out.println("Se ha agregado una Nintendo Switch en tu carrito.");
                        items.add("Nintendo Switch");
                        break;
                    case "2025":
                        System.out.println("Lo sentimos, por el momento esta escaso. Cuando tengamos reservas se te hara el envio.");
                        items.add("Reserva - wii");
                        break;
                    default:
                        System.out.println("Opcion invalida, porfavor coloca una de nuestras opciones");
                }
            }while (!codigo.equals("1125") && !codigo.equals("3025") && !codigo.equals("3011") && !codigo.equals("2025"));

            System.out.println("Quieres agregar otro item a la lista? ");

            do{
                System.out.println("si o no");
                opcion = sc.nextLine().toLowerCase();
                if( !opcion.equals("si") && !opcion.equals("no")){
                    System.out.println("Opcion invalida, porfavor coloca una opcion");
                }

            }while(!opcion.equals("si") && !opcion.equals("no"));

        }while(opcion.equals("si"));


        System.out.println("Escoje una de las ciudades de la lista");
        System.out.println("1. Medellin");
        System.out.println("2. Bogota");
        String opcionCiudad;
        String ciudad = "";


        int envio = 0;
        do{
            opcionCiudad = sc.nextLine(); // Almacena la opcion de ciudad ingresada por el usuario
            switch(opcionCiudad){
                case "1":
                    System.out.println("Precio del envio");
                    envio = envio + 12000;
                    ciudad = "Medellin";
                    System.out.println("Medellin -> " + envio );
                    break;
                case "2":
                    System.out.println("Precio del envio");
                    envio = envio + 15000;
                    ciudad = "Bogota";
                    System.out.println("Bogota -> " + envio );
                    break;
                default:
                    System.out.println("Opcion invalida, porfavor coloca una de nuestras opciones");
            }
        }while(!opcionCiudad.equals("1") && !opcionCiudad.equals("2"));

        System.out.println("Cual es tu direccion? ");
        String direccion = sc.nextLine();

        System.out.println("-------------------------------");
        System.out.println("Items: " + items);
        System.out.println("Ciudad: " + ciudad);
        System.out.println("Direccion: " + direccion);
        System.out.println("Envio: " + envio);
    }
}
