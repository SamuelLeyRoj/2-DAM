package Examen.ChatTPC;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteChat {
    public static void main(String args[]) {
        int puerto = 44444;
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cómo te llamas?: ");
        String nombre = sc.nextLine();

        try {
            // 1. Intentamos conectar con el servidor
            Socket s = new Socket("localhost", puerto);
            DataOutputStream fsalida = new DataOutputStream(s.getOutputStream());
            DataInputStream fentrada = new DataInputStream(s.getInputStream());

            // 2. CREAMOS UN HILO PARA RECIBIR (Listener)
            // Esto es necesario porque el programa no puede estar "esperando a que escribas"
            // y "esperando a que llegue un mensaje" a la vez en la misma línea.
            Thread hiloRecibo = new Thread(() -> {
                try {
                    while (true) {
                        String msg = fentrada.readUTF(); // Espera mensaje del servidor
                        // Limpiamos un poco la consola y mostramos el chat
                        System.out.println("\n--- NUEVOS MENSAJES ---\n" + msg);
                        System.out.print("Escribe: "); // Para que el cursor no se pierda
                    }
                } catch (IOException e) {
                    System.out.println("Conexión con el servidor terminada.");
                }
            });
            hiloRecibo.start(); // Arrancamos el hilo de escucha

            // 3. LÓGICA DE ENVÍO (Main Thread)
            String mensaje = "";
            while (!mensaje.equals("*")) {
                mensaje = sc.nextLine(); // Se queda esperando a que el usuario pulse Enter
                fsalida.writeUTF(nombre + "> " + mensaje); // Envía al servidor
            }

            // Al salir del bucle cerramos todo
            s.close();
            System.exit(0);

        } catch (IOException e) {
            System.out.println("ERROR: No se pudo conectar. ¿Está el servidor encendido?");
        }
    }
}