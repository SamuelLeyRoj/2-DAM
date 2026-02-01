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

        if (frase.contains("*")) {
            System.out.println("Se acabó");
        }
        else {
            String leerServidor = entrada.readUTF();
            System.out.println("Servidor conectado: "+leerServidor);

        }

    }
}

































/*

Usando sockets TCP realiza un programa cliente que introduzca cadenas por
teclado hasta introducir un asterisco. Las cadenas se enviarán a un programa servidor.
El programa servidor aceptará la conexión de un único cliente y por cada cadena
recibida le devolverá al cliente el número de caracteres de la misma. El programa
servidor finalizará cuando reciba un asterisco como cadena.

* */