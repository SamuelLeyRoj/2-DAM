package EjemplosCosas.UDP;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ClienteMultitask {
    public static void main(String[] args) throws IOException {

        // 1. EL SOCKET MULTICAST (EL SINTONIZADOR)
        // A diferencia del servidor, el cliente DEBE poner el puerto (12345)
        // en el constructor. Es como decirle a la radio en qué canal escuchar.
        MulticastSocket socket = new MulticastSocket(12345);

        // 2. LA DIRECCIÓN DE GRUPO
        // Debe ser la misma IP que usa el servidor (la "frecuencia" 225.0.0.1).
        InetAddress grupo = InetAddress.getByName("225.0.0.1");

        // 3. UNIRSE AL GRUPO (LA CLAVE DEL EXAMEN)
        // Este metodo le dice a la tarjeta de red: "Acepta los paquetes que vengan
        // dirigidos a esta IP virtual". Sin esto, no recibirías nada.
        socket.joinGroup(grupo);

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce tu nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Bienvenido " + nombre + ". Esperando mensajes...");

        // 4. BUCLE DE RECEPCIÓN (MULTITAREA)
        // El cliente se queda en un bucle infinito para recibir muchos mensajes,
        // no solo uno. Así puede escuchar todo lo que el servidor emita.
        boolean activo = true;
        while (activo) {

            // PREPARAR LA "CAJA" (BÚFER)
            // Creamos un array de bytes vacío para cada mensaje.
            byte[] bufer = new byte[1024];

            // EL SOBRE DE RECEPCIÓN
            // DatagramPacket para recibir: solo necesita el array y su tamaño.
            DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);

            // EL BLOQUEO (RECEIVE)
            // El programa se para aquí. Si el servidor no envía nada, el cliente
            // no hace nada. En cuanto llega un paquete al grupo, se "despierta".
            socket.receive(recibo);

            // TRADUCCIÓN DE BYTES A TEXTO
            // Convertimos los bytes recibidos en un String legible.
            // .trim() es vital para quitar los bytes vacíos del final del búfer.
            String mensaje = new String(recibo.getData()).trim();
            System.out.println("[SERVIDOR]: " + mensaje);

            // CONDICIÓN DE SALIDA
            // Si el servidor envía la palabra "salir", rompemos el bucle.
            if (mensaje.equalsIgnoreCase("salir")) {
                activo = false;
            }
        }

        // 5. ABANDONAR EL GRUPO Y CERRAR
        // Es de buena educación (y obligatorio) avisar de que dejas de escuchar.
        // Libera la suscripción Multicast en la tarjeta de red.
        socket.leaveGroup(grupo);
        socket.close();

        System.out.println("Has salido del grupo y el socket está cerrado.");
    }
}