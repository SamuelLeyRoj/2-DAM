package Practica1.Ej1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 6000);
        Scanner teclado = new Scanner(System.in);


        DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
        DataInputStream entrada = new DataInputStream(socket.getInputStream());


        System.out.println("Introduzca una frase: ");
        String frase = teclado.nextLine();


        salida.writeUTF(frase);

        String leerServidor = entrada.readUTF();
        System.out.println("Servidor conectado: "+leerServidor);


    }
}
