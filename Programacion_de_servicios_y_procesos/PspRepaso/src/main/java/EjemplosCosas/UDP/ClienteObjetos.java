package EjemplosCosas.UDP;

import Practica1.Ej3.Alumno;

import java.io.*;
import java.net.*;

public class ClienteObjetos {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress IP = InetAddress.getLocalHost();

        // --- PARTE 1: ENVIAR (Lo que ya tenías) ---
        String clave = "ADMIN_123";
        // Mandamos solo el ID o clave para preguntar

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);

        out.writeUTF(clave);
        out.close();

        byte[] bufferEnvio = baos.toByteArray();
        DatagramPacket paqueteEnvio = new DatagramPacket(bufferEnvio, bufferEnvio.length, IP, 12345);
        socket.send(paqueteEnvio);
        System.out.println("Petición enviada...");

        // --- PARTE 2: RECIBIR EL OBJETO DE VUELTA (Lo nuevo) ---

        // 1. Preparamos el buffer para la respuesta
        byte[] bufferRecibo = new byte[2048]; // Un poco más grande por si el objeto pesa
        DatagramPacket paqueteRecibido = new DatagramPacket(bufferRecibo, bufferRecibo.length);

        // 2. Esperamos a que el servidor nos conteste
        // El programa se queda aquí "congelado" hasta que llegue el paquete del servidor
        socket.receive(paqueteRecibido);

        // 3. DESERIALIZACIÓN: Convertir los bytes recibidos en Objeto
        // Abrimos el flujo de lectura sobre los datos del paquete
        ByteArrayInputStream bais = new ByteArrayInputStream(paqueteRecibido.getData());
        ObjectInputStream in = new ObjectInputStream(bais);

        // 4. Reconstruimos el objeto Alumno (Casting)
        Alumno alRecibido = (Alumno) in.readObject();

        // 5. Mostramos los resultados
        if (alRecibido != null) {
            System.out.println("Alumno recibido del servidor: " + alRecibido.getNombre());
            System.out.println("Nota: " + alRecibido.getNota());
        } else {
            System.out.println("El servidor no encontró al alumno.");
        }

        // Cerramos todo
        in.close();
        socket.close();
    }
}
