package Practica1.Ej2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {

        MulticastSocket socket = new MulticastSocket(12345);

        InetAddress grupo = InetAddress.getByName("225.0.0.1");
        socket.joinGroup(grupo);

        byte[] bufer = new byte[1024];
        DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);

        socket.receive(recibo);

        String mensaje = new String(recibo.getData()).trim();

        socket.leaveGroup(grupo);
        socket.close();

    }
}
