package Practica1.Ej1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Hilo extends Thread {

    private Socket socket;

    public Hilo(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try{

            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

            String mensaje = entrada.readUTF();
      



        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
