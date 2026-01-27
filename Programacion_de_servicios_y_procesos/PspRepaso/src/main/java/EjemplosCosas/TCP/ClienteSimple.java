package EjemplosCosas.TCP;

import java.io.*;
import java.net.*;

public class ClienteSimple {
    public static void main(String[] args) throws Exception {
        // 1. Socket(IP, PUERTO): Intenta conectar con el servidor.
        // "localhost" significa "mi propio ordenador".
        // 6000 debe coincidir con el puerto que puso el servidor.
        Socket socket = new Socket("localhost", 6000);
        System.out.println("Conectado al servidor con éxito.");

        // 2. Preparamos las tuberías de salida (hablar) y entrada (escuchar).
        // Espejo del servidor: lo que aquí es salida, en el servidor es entrada.
        DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
        DataInputStream entrada = new DataInputStream(socket.getInputStream());

        // 3. Enviamos el mensaje al servidor.
        // Importante: El servidor está parado en un 'readUTF()', así que esto lo desbloquea.
        salida.writeUTF("Hola servidor, soy el cliente enviando datos.");

        // 4. Esperamos la respuesta del servidor.
        // El cliente se queda aquí parado hasta que el servidor ejecute su 'writeUTF'.
        String respuesta = entrada.readUTF();
        System.out.println("Respuesta del servidor: " + respuesta);

        // 5. Cerramos la conexión.
        // Al cerrar el socket, se cierran automáticamente los flujos (entrada/salida).
        socket.close();
        System.out.println("Conexión cerrada.");
    }
}
