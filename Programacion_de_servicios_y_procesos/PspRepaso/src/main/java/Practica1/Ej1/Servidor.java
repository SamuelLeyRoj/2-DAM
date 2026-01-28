package Practica1.Ej1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("SERVIDOR MULTIHILO: Esperando clientes en el puerto 6000...");


        while(true){

            Socket cliente = serverSocket.accept();
            System.out.println("Esperando cliente...");

            DataInputStream entrada = new DataInputStream(cliente.getInputStream());
            DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());

            String leer = entrada.readUTF();

            if (leer.contains("*")){

                System.out.println("Cerrando Servidor...");
                serverSocket.close();

            }else {

                System.out.println("Mensaje del Cliente: "+ leer);
                salida.writeUTF(String.valueOf(serverSocket.getInetAddress()));
                entrada.close();
                salida.close();
                cliente.close();

            }
        }
    }
}
