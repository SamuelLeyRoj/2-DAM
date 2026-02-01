package Examen.EjHilos;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ServidorOnePiece {
    private static int contadorClientes = 1;
    static ArrayList<PersonajeOnePiece> personajes = new ArrayList<>();

    public static void main(String[] args) {
        // Inicialización de datos (Mockup)
        Barco sunny = new Barco("Thousand Sunny", "Piratas de Sombrero de Paja", "Bergantín", 56, 39);
        Fruta gomu = new Fruta("Gomu Gomu", "Cuerpo de goma", "Violeta esférica");
        personajes.add(new PersonajeOnePiece("Luffy", "Capitán", gomu, sunny));
        personajes.add(new PersonajeOnePiece("Zoro", "Espadachín", null, sunny));

        try (ServerSocket server = new ServerSocket(5000)) {
            System.out.println("Servidor One Piece iniciado en puerto 5000...");
            while (true) {
                Socket cliente = server.accept();
                System.out.println("Cliente " + contadorClientes + " conectado.");
                new ManejadorCliente(cliente, contadorClientes++).start();
            }
        } catch (IOException e) { e.printStackTrace(); }
    }


}
