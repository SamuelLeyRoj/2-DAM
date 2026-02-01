package EjemplosCosas.UDP;

import Practica1.Ej3.Alumno;

import java.io.*;
import java.net.*;

public class ServidorObjetos {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(12345);
        System.out.println("Servidor listo...");

        // Simulamos nuestra base de datos
        Alumno alumno1 = new Alumno("1", "Samu", null, 10);

        while (true) {
            // --- 1. RECIBIR LA PETICIÓN (TEXTO) ---
            byte[] bufferRecibo = new byte[1024];
            DatagramPacket paqueteEntrante = new DatagramPacket(bufferRecibo, bufferRecibo.length);
            socket.receive(paqueteEntrante); // El servidor se para aquí

            // Deserializamos el texto (ID)
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(paqueteEntrante.getData()));
            String idBuscada = in.readUTF();
            System.out.println("Cliente busca al ID: " + idBuscada);

            // --- 2. LÓGICA DE BÚSQUEDA ---
            // (Aquí buscarías en tu lista, yo usaré el alumno1 directo)
            Alumno alEnviar = null;
            if (alumno1.getIdAlumno().equals(idBuscada)) {
                alEnviar = alumno1;
            }

            // --- 3. PREPARAR LA RESPUESTA (OBJETO) ---
            // Usamos el "embudo" para triturar el OBJETO alumno a bytes
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(baos);

            out.writeObject(alEnviar); // Metemos el objeto en el buffer de memoria
            out.close();

            byte[] bufferEnvio = baos.toByteArray();

            // --- 4. ENVIAR EL OBJETO DE VUELTA ---
            // Sacamos la dirección de quien nos preguntó (remitente)
            InetAddress ipCliente = paqueteEntrante.getAddress();
            int puertoCliente = paqueteEntrante.getPort();

            // Montamos el paquete con el objeto ya convertido a bytes
            DatagramPacket paqueteSalida = new DatagramPacket(
                    bufferEnvio,
                    bufferEnvio.length,
                    ipCliente,
                    puertoCliente
            );

            socket.send(paqueteSalida); // ¡Sale el objeto hacia el cliente!
            System.out.println("Objeto enviado al cliente.");
        }
    }
}
