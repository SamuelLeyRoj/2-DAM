package EjemplosCosas.UDP; // Carpeta del proyecto.

import java.net.*; // Importa las clases necesarias para trabajar con red (UDP).

public class ServidorSimple {
    public static void main(String[] args) throws Exception {

        // 1. CREACIÓN DEL SOCKET (EL BUZÓN FIJO)
        // Al poner "12345", estamos reservando ese puerto para nuestro servidor.
        // Es como instalar un buzón con un número de casa específico para que los clientes sepan dónde enviar.
        DatagramSocket socket = new DatagramSocket(12345);

        // 2. EL BÚFER (EL ALMACÉN)
        // UDP no lee texto directamente, lee bytes. Creamos un array de 1024 bytes.
        // Es el espacio que reservamos en la memoria para guardar lo que venga en el "sobre".
        byte[] bufer = new byte[1024];

        System.out.println("Esperando al cliente...");

        // 3. PREPARACIÓN DEL PAQUETE RECIBO (EL SOBRE VACÍO)
        // Usamos el constructor para recibir: DatagramPacket(byte[] buf, int length).
        // Aquí no ponemos IP ni Puerto, porque este sobre está vacío, esperando a ser llenado.
        DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);

        // 4. RECEPCIÓN (EL MOMENTO DE BLOQUEO)
        // El metodo receive() hace que el programa se detenga. No pasará a la siguiente línea
        // hasta que un paquete físico entre por el puerto 12345.
        socket.receive(recibo);

        // 5. EXTRACCIÓN Y CONVERSIÓN DE DATOS
        // getData() saca los bytes del sobre.
        // new String(...) convierte esos bytes en texto legible.
        // .trim() elimina los espacios vacíos del búfer (los que sobraron de los 1024 bytes).
        String mensaje = new String(recibo.getData()).trim();

        System.out.println("Mensaje recibido: " + mensaje);

        // 6. CIERRE
        // Cerramos el socket para liberar el puerto 12345 y que otros programas puedan usarlo.
        socket.close();
    }
}