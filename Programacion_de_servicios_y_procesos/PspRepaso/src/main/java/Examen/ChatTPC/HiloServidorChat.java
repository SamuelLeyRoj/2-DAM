package Examen.ChatTPC;

import java.io.*;
import java.net.*;

public class HiloServidorChat extends Thread {
    DataInputStream fentrada; // Para leer lo que escribe EL cliente
    Socket socket = null;
    ComunHilos comun;

    public HiloServidorChat(Socket s, ComunHilos comun) {
        this.socket = s;
        this.comun = comun;
        try {
            // Creamos el canal de entrada de datos desde el socket
            fentrada = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        // Al empezar, mandamos al cliente todo lo que se ha dicho antes
        enviarMensajesATodos(comun.getMensajes());

        // Bucle infinito: Escuchar al cliente hasta que se vaya
        while (true) {
            try {
                // Leemos el mensaje que nos envía el cliente
                String cadena = fentrada.readUTF();

                // Si el cliente envía un '*', es la señal de salida
                if (cadena.trim().contains("> *")) {
                    comun.setACTUALES(comun.getACTUALES() - 1);
                    System.out.println("Un cliente ha salido. Quedan: " + comun.getACTUALES());
                    break;
                }

                // Añadimos el nuevo mensaje al historial compartido
                comun.setMensajes(comun.getMensajes() + cadena + "\n");

                // ¡IMPORTANTE! Gritamos el historial actualizado a TODO el mundo
                enviarMensajesATodos(comun.getMensajes());

            } catch (Exception e) {
                // Si el cliente desconecta bruscamente (falla el socket)
                break;
            }
        }

        // Cerramos el socket de este cliente al terminar
        try {
            socket.close();
        } catch (IOException e) { e.printStackTrace(); }
    }

    // Este método recorre todos los sockets activos y les manda el texto
    private void enviarMensajesATodos(String texto) {
        for (int i = 0; i < comun.getCONEXIONES(); i++) {
            Socket s1 = comun.getElementoTabla(i);
            if (!s1.isClosed()) { // Solo si el cliente sigue ahí
                try {
                    DataOutputStream fsalida = new DataOutputStream(s1.getOutputStream());
                    fsalida.writeUTF(texto);
                } catch (IOException e) {
                    // Si un envío falla, simplemente pasamos al siguiente
                }
            }
        }
    }
}