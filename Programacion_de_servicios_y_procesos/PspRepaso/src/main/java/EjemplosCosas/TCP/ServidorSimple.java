package EjemplosCosas.TCP;

import java.io.*;
import java.net.*;

public class ServidorSimple {
    public static void main(String[] args) throws IOException {
        // 1. ServerSocket: Crea el "enchufe" del servidor.
        // El número 6000 es el PUERTO. Es como el número de teléfono al que deben llamar.
        ServerSocket servidor = new ServerSocket(6000);
        System.out.println("Servidor iniciado. Esperando en el puerto 6000...");

        // 2. .accept(): Esta función es BLOQUEANTE.
        // El programa se queda congelado aquí hasta que un cliente se conecta.
        // Cuando un cliente se conecta, devuelve un objeto 'Socket' que representa esa conexión.
        Socket cliente = servidor.accept();
        System.out.println("¡Un cliente se ha conectado desde: " + cliente.getInetAddress() + "!");

        // 3. getInputStream: Abre el flujo para RECIBIR datos del cliente (oídos).
        // DataInputStream: Es un "traductor" que nos permite leer datos simples (como texto UTF).
        DataInputStream entrada = new DataInputStream(cliente.getInputStream());

        // 4. getOutputStream: Abre el flujo para ENVIAR datos al cliente (boca).
        // DataOutputStream: Nos permite escribir datos para que viajen por la red.
        DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());

        // 5. .readUTF(): Se queda esperando a que el cliente envíe una cadena de texto.
        // UTF es el formato estándar de Java para enviar texto por sockets.
        String mensajeRecibido = entrada.readUTF();
        System.out.println("El cliente dice: " + mensajeRecibido);

        // 6. .writeUTF(): Envía una respuesta al cliente a través de la red.
        salida.writeUTF("¡Hola cliente! He recibido tu mensaje correctamente.");

        // 7. .close(): Muy importante. Hay que cerrar las tuberías y el socket
        // para liberar el puerto 6000 y que otros puedan usarlo después.
        entrada.close();
        salida.close();
        cliente.close();
        servidor.close();
    }
}
