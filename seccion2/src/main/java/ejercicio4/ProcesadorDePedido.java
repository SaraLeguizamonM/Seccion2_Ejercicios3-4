package ejercicio4;

public abstract class ProcesadorDePedido {

    public abstract void procesar (); // Metodo abstracto que sera implementado en las clases hijas
    public void validarPedido() { // Metodo que valida el pedido
        System.out.println("Validando el pedido...");
    }
}   
