package Examen.EjHilos;

import Examen.EjHilos.PersonajeOnePiece;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import static Examen.EjHilos.ServidorOnePiece.personajes;

public class ManejadorCliente extends Thread {
    private Socket socket;
    private int id;

    public ManejadorCliente(Socket s, int id) { this.socket = s; this.id = id; }

    public void run() {
        try (ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            out.writeInt(id); // Enviar ID inicial
            out.flush();

            while (true) {
                String nombreBuscar = (String) in.readObject();
                if (nombreBuscar.equals("*")) break;

                PersonajeOnePiece resultado = personajes.stream()
                        .filter(p -> p.getNombre().equalsIgnoreCase(nombreBuscar))
                        .findFirst()
                        .orElse(new PersonajeOnePiece("No existe", "N/A", null, null));

                out.writeObject(resultado);
                out.flush();
            }
        } catch (Exception e) {
            System.out.println("Cliente " + id + " desconectado.");
        }
    }
}
