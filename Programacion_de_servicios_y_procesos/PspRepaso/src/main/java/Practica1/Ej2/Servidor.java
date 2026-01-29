package Practica1.Ej2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;


public class Servidor {
    public static void main(String[] args) throws IOException {

        MulticastSocket socket = new MulticastSocket(12345);
        Scanner teclado = new Scanner(System.in);
        InetAddress grupo = InetAddress.getByName("225.0.0.1");
        int puerto = 12345;
        String mensaje = "";
        Boolean encendido = false;

        while (encendido == false) {

            System.out.println("Salir / Enviar mensaje: ");
            mensaje  = teclado.nextLine();
            if (mensaje.equals("salir")) encendido = true;

        }
    }
}
