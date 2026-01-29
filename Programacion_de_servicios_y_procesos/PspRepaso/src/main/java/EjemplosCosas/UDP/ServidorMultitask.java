package EjemplosCosas.UDP;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ServidorMultitask {
    public static void main(String[] args) throws IOException {

        // 1. EL SOCKET ESPECIAL (LA EMISORA)
        // Usamos MulticastSocket en lugar de DatagramSocket.
        // Aunque el servidor no se "una" al grupo para emitir, este socket está
        // preparado para manejar direcciones de clase D (Multicast).
        MulticastSocket socket = new MulticastSocket();

        // 2. LA DIRECCIÓN DE GRUPO (LA FRECUENCIA)
        // InetAddress.getByName con una IP entre 224.0.0.0 y 239.255.255.255.
        // Esto no es la IP de un ordenador, es una "IP virtual" a la que
        // se suscriben varios clientes.
        InetAddress grupo = InetAddress.getByName("225.0.0.1");
        int puerto = 12345; // El puerto donde los clientes estarán escuchando.

        Scanner sc = new Scanner(System.in);
        String mensaje = "";

        System.out.println("--- SERVIDOR MULTICAST ---");

        // BUCLE DE ENVÍO
        // El servidor se mantiene vivo para enviar tantos mensajes como quiera.
        while (!mensaje.equals("salir")) {
            System.out.print("Escribe el mensaje para el grupo (o 'salir'): ");
            mensaje = sc.nextLine(); // Leemos el texto de la consola.

            // 3. CONVERSIÓN A BYTES (EL CONTENIDO)
            // Como estamos sobre UDP, el mensaje debe viajar como un array de bytes.
            byte[] buffer = mensaje.getBytes();

            // 4. EL DATAGRAMA (EL SOBRE DIRECCIONADO)
            // Aquí está la clave: El sobre no va a un cliente específico,
            // va a la IP del 'grupo'. Cualquier cliente que haya hecho 'joinGroup'
            // a esa IP recibirá una copia de este sobre.
            DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, grupo, puerto);

            // 5. EL ENVÍO (DIFUSIÓN)
            // El metodo send() lanza el paquete a la red. El router se encarga
            // de duplicar el mensaje para cada cliente interesado.
            socket.send(paquete);
            System.out.println("Mensaje enviado al grupo.");
        }

        // 6. CIERRE
        // Al cerrar el socket, liberamos los recursos de red del sistema.
        socket.close();
        System.out.println("Servidor cerrado.");
    }
}