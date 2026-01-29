package EjemplosCosas.UDP; // Define la carpeta donde está guardado el código.

import java.net.*; // Importa las clases necesarias para redes (DatagramSocket, DatagramPacket, etc.)[cite: 3].

public class ClienteSimple {
    public static void main(String[] args) throws Exception {

        // 1. CREACIÓN DEL SOCKET (EL BUZÓN)
        // DatagramSocket() sin parámetros deja que el sistema elija un puerto libre[cite: 106].
        // Es el canal por donde saldrá nuestro "sobre" hacia la red.
        DatagramSocket socket = new DatagramSocket();

        // 2. OBTENCIÓN DE LA DIRECCIÓN DESTINO
        // getLocalHost() devuelve la IP de tu propia máquina (127.0.0.1)[cite: 51].
        // Se usa para probar el programa en el mismo ordenador donde corre el servidor.
        InetAddress IP = InetAddress.getLocalHost();

        // 3. PREPARACIÓN DE LOS DATOS
        String mensaje = "Hola Servidor";

        // UDP no entiende de "texto", solo entiende de bytes (números).
        // getBytes() transforma tu frase en una cadena de bytes para que pueda viajar por el cable.
        byte[] enviados = mensaje.getBytes();

        // 4. CREACIÓN DEL DATAGRAMA (EL SOBRE)
        // Se usa el constructor de envío de DatagramPacket. Necesita 4 cosas:
        // - enviados: los datos en bytes.
        // - enviados.length: el tamaño de lo que enviamos.
        // - IP: la dirección a la que va.
        // - 12345: el puerto donde el servidor está "escuchando".
        DatagramPacket paquete = new DatagramPacket(enviados, enviados.length, IP, 12345);

        // 5. ENVÍO
        // El metodo send() lanza el paquete a la red hacia el destino indicado en el sobre[cite: 183].
        // A diferencia de TCP, aquí no sabemos si el servidor lo ha recibido realmente.
        socket.send(paquete);

        // 6. CIERRE
        // Cerramos el socket para liberar el recurso del sistema operativo[cite: 112].
        socket.close();
    }
}