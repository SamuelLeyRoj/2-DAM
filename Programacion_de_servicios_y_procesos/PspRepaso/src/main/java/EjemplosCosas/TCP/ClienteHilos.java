package EjemplosCosas.TCP;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteHilos {
    public static void main(String[] args) throws Exception {
        // Intentamos conectar con la IP (localhost) y el puerto (6000).
        Socket socket = new Socket("localhost", 6000);
        System.out.println("Conexión establecida con el servidor.");

        // Tuberías para enviar y recibir texto.
        DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
        DataInputStream entrada = new DataInputStream(socket.getInputStream());

        // Pedimos datos por consola al usuario.
        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe una frase: ");
        String mensaje = sc.nextLine();

        // Enviamos la frase (esto activa el .readUTF() del hilo en el servidor).
        salida.writeUTF(mensaje);

        // Esperamos la respuesta (esto nos bloquea hasta que el hilo haga su .writeUTF()).
        String respuesta = entrada.readUTF();
        System.out.println("El servidor ha respondido: " + respuesta);

        // Cerramos el socket. Siempre hay que ser limpios.
        socket.close();
    }
}
