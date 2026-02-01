package Examen.ChatTPC;

import java.io.*;
import java.net.*;

public class ServidorChat {
    static final int MAXIMO = 5; // Solo dejamos entrar a 5 personas

    public static void main(String args[]) throws IOException {
        int PUERTO = 44444;

        // Creamos el "oído" del servidor en el puerto indicado
        ServerSocket servidor = new ServerSocket(PUERTO);
        System.out.println("SERVIDOR INICIADO: Esperando clientes en consola...");

        // Preparamos la estructura de datos compartida
        Socket tabla[] = new Socket[MAXIMO];
        ComunHilos comun = new ComunHilos(MAXIMO, 0, 0, tabla);

        // Bucle: Mientras queden huecos libres...
        while (comun.getCONEXIONES() < MAXIMO) {
            // El código se para aquí (bloqueo) hasta que llega un cliente
            Socket socket = servidor.accept();
            System.out.println("NUEVO CLIENTE detectado. Preparando hilo...");

            // Registramos al nuevo usuario en el objeto común
            comun.addTabla(socket, comun.getCONEXIONES());
            comun.setACTUALES(comun.getACTUALES() + 1);
            comun.setCONEXIONES(comun.getCONEXIONES() + 1);

            // Lanzamos un hilo para que se encargue de este cliente
            // y el servidor pueda volver al 'accept()' a esperar al siguiente.
            HiloServidorChat hilo = new HiloServidorChat(socket, comun);
            hilo.start();
        }

        servidor.close(); // Si llegamos al máximo, dejamos de escuchar
    }
}