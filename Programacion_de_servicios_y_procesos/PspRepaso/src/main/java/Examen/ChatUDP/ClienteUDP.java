package Examen.ChatUDP;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteUDP {
    public static void main(String[] args) {
        int PUERTO = 12345;
        String GRUPO_IP = "225.0.0.1";
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce tu nombre: ");
        String nombre = sc.nextLine();

        try {
            // 1. Usamos MulticastSocket en lugar de DatagramSocket
            // Esto permite que el cliente se "asocie" a un grupo multicast.
            MulticastSocket socket = new MulticastSocket(PUERTO);
            InetAddress grupo = InetAddress.getByName(GRUPO_IP);

            // 2. Unirse al grupo (Join)
            // A partir de aquí, la tarjeta de red aceptará paquetes de esa IP.
            socket.joinGroup(new InetSocketAddress(grupo, PUERTO), null);

            System.out.println(nombre + ", te has unido al chat en " + GRUPO_IP);
            System.out.println("Esperando mensajes del servidor... (Pulsa Ctrl+C para salir)");

            // 3. Bucle de Recepción
            // Creamos un buffer para guardar los datos que lleguen (1KB de espacio)
            byte[] buffer = new byte[1024];

            while (true) {
                // Preparamos el contenedor para el paquete entrante
                DatagramPacket paqueteEntrada = new DatagramPacket(buffer, buffer.length);

                // 4. Recibir el paquete (el programa se detiene aquí hasta que llega algo)
                socket.receive(paqueteEntrada);

                // 5. Convertir los bytes recibidos de vuelta a String
                String mensajeRecibido = new String(
                        paqueteEntrada.getData(),
                        0,
                        paqueteEntrada.getLength()
                );

                System.out.println("\n[SERVIDOR]: " + mensajeRecibido);

                // Si el servidor envía "salir", el cliente también puede decidir cerrar
                if (mensajeRecibido.equalsIgnoreCase("salir")) {
                    break;
                }
            }

            // 6. Abandonar el grupo y cerrar
            socket.leaveGroup(new InetSocketAddress(grupo, PUERTO), null);
            socket.close();
            System.out.println("Has abandonado el chat.");

        } catch (IOException e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}