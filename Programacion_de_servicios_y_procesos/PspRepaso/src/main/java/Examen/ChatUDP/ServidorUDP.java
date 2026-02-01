package Examen.ChatUDP;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ServidorUDP {
    public static void main(String[] args) {
        // 1. Configuración de Red
        int PUERTO = 12345;
        // Las direcciones Multicast van de 224.0.0.0 a 239.255.255.255
        String GRUPO_IP = "225.0.0.1";

        Scanner sc = new Scanner(System.in);

        try {
            // 2. Creamos el Socket UDP (DatagramSocket)
            // A diferencia de TCP, UDP no garantiza que el mensaje llegue, pero es más rápido.
            DatagramSocket socket = new DatagramSocket();
            InetAddress grupo = InetAddress.getByName(GRUPO_IP);

            System.out.println("SERVIDOR MULTICAST INICIADO");
            System.out.println("Escribe mensajes para los clientes (escribe 'salir' para finalizar):");

            String mensaje = "";
            while (!mensaje.equalsIgnoreCase("salir")) {
                System.out.print("Mensaje a enviar: ");
                mensaje = sc.nextLine();

                // 3. Convertir el texto a Bytes (los Datagramas solo viajan en bytes)
                byte[] buffer = mensaje.getBytes();

                // 4. Crear el Datagrama (Paquete)
                // Incluye: los datos, la longitud, la IP del grupo y el puerto.
                DatagramPacket paquete = new DatagramPacket(
                        buffer,
                        buffer.length,
                        grupo,
                        PUERTO
                );

                // 5. Enviar el paquete al grupo
                socket.send(paquete);
                System.out.println("Enviado al grupo " + GRUPO_IP + " -> " + mensaje);
            }

            socket.close(); // Cerramos el socket al terminar
            System.out.println("Servidor finalizado.");

        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}