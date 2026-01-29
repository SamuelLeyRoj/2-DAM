package EjemplosCosas.TCP;

import java.io.*;
import java.net.*;

// "extends Thread" es vital: le dice a Java que esta clase puede ejecutarse
// al mismo tiempo (en paralelo) que otras partes del programa.
public class HiloCliente extends Thread {
    // Cada hilo necesita su propio "cable" (socket) para hablar con SU cliente.
    private Socket socket;

    // CONSTRUCTOR: El servidor nos da el socket del cliente que acaba de entrar.
    public HiloCliente(Socket socket) {
        this.socket = socket;
    }

    // El metodo run() es el CORAZON del hilo.
    // Todo lo que escribas aqui es lo que el hilo hara en paralelo.
    @Override
    public void run() {
        try {
            // FLUJOS: Creamos las tuberías de entrada (escuchar) y salida (hablar).
            // Se sacan del socket que nos pasó el servidor en el constructor.
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

            // 1. ESCUCHAR: El hilo se para aquí hasta que SU cliente mande algo.
            String texto = entrada.readUTF();
            System.out.println("Soy el hilo " + this.getName() + " y he recibido: " + texto);

            // 2. TRABAJAR: Hacemos la lógica (en este caso, pasar a mayúsculas).
            String resultado = texto.toUpperCase();

            // 3. RESPONDER: Le enviamos el resultado de vuelta al cliente.
            salida.writeUTF(resultado);

            // 4. DESPEDIDA: Cerramos la conexión con este cliente específico.
            // Al cerrarse el socket, este hilo termina su trabajo y "muere".
            socket.close();
            System.out.println("Trabajo finalizado para un cliente.");

        } catch (IOException e) {
            // Si el cliente se desconecta a lo bruto, saltará este error.
            System.err.println("Error en la comunicación con el cliente.");
        }
    }
}