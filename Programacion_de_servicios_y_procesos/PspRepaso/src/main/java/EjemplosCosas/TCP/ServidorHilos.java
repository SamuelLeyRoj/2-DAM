package EjemplosCosas.TCP;

import java.io.*;
import java.net.*;

public class ServidorHilos {
    public static void main(String[] args) throws IOException {
        // Reservamos el puerto 6000. Si otro programa lo usa, dará error.
        ServerSocket servidor = new ServerSocket(6000);
        System.out.println("SERVIDOR MULTIHILO: Esperando clientes en el puerto 6000...");

        // Usamos un bucle infinito porque un servidor real nunca debería apagarse solo.
        while (true) {
            // BLOQUEO: El programa se queda aquí "durmiendo" hasta que alguien conecta.
            Socket cliente = servidor.accept();

            // Si llegamos aquí, es que alguien ha conectado.
            System.out.println("¡Cliente detectado! IP: " + cliente.getInetAddress());

            // PASO MAESTRO:
            // 1. Creamos el objeto Hilo (el obrero) y le damos el socket del cliente.
            HiloCliente hilo = new HiloCliente(cliente);

            // 2. .start() ordena a Java que ejecute el método run() del hilo POR SEPARADO.
            // MUY IMPORTANTE: Si pusieras hilo.run() en vez de hilo.start(),
            // no habría paralelismo y el servidor se quedaría bloqueado.
            hilo.start();

            // 3. El servidor NO ESPERA al hilo. El bucle vuelve arriba inmediatamente
            // para poder aceptar a otro cliente mientras el hilo anterior sigue trabajando.
            System.out.println("Hilo lanzado. Volviendo a la puerta a esperar...");
        }
    }
}
