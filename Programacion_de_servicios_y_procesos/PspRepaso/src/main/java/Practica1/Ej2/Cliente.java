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































/*
* Realiza un servidor multicast usando sockets UDP.
El servidor debe mostrar una pantalla inicial donde tenemos un campo de texto
para escribir para escribir el mensaje que se enviará a todos los clientes y un textarea
donde se van mostrando los mensajes que se van enviando. El botón Enviar envía el
mensaje escrito a todos los clientes que forman parte del grupo multicast y el botón
Salir finaliza la ejecución del servidor.
El programa cliente pide el nombre al usuario y a continuación muestra un
textarea donde se irán visualizando los mensajes que envían el servidor. El botón Salir
finaliza la ejecución.
* */