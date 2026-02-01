    package Practica1.Ej3;

    import java.io.*;
    import java.net.*;
    import java.util.Scanner;

    public class Cliente implements Serializable {
        public static void main(String[] args) throws IOException, ClassNotFoundException {

            DatagramSocket socket = new DatagramSocket();
            InetAddress IP = InetAddress.getLocalHost();


            Scanner teclado = new Scanner(System.in);

            System.out.println("Ingrese el id de un alumno: ");
            String id = teclado.nextLine();

            byte[] bufferAlumno = id.getBytes();
            DatagramPacket paquete = new DatagramPacket(bufferAlumno, bufferAlumno.length, IP, 12345);
            socket.send(paquete);
            System.out.println("Petición eniviada");


            //Recibimos
            byte[] bufferRecibo = new byte[1024];
            DatagramPacket paqueteEntrante = new DatagramPacket(bufferRecibo, bufferRecibo.length);
            socket.receive(paqueteEntrante);

            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(paqueteEntrante.getData()));
            Alumno alumno = (Alumno) in.readObject();

            System.out.println("Alumno: " + alumno.getNombre());


        }
    }
