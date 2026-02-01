package Examen.EjHilos;

import Examen.EjHilos.PersonajeOnePiece;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteOnePiece {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Conectado. ID asignado: " + in.readInt());

            while (true) {
                System.out.print("\nIntroduce nombre de personaje (o '*' para salir): ");
                String nombre = sc.nextLine();
                out.writeObject(nombre);
                if (nombre.equals("*")) break;

                PersonajeOnePiece p = (PersonajeOnePiece) in.readObject();

                if (p.getNombre().equals("No existe")) {
                    System.out.println("Personaje no encontrado en el Grand Line.");
                } else {
                    System.out.println("--- Datos de: " + p.getNombre() + " ---");
                    System.out.println("Rol: " + p.getRol());

                    System.out.print("¿Ver detalles de Fruta/Barco? (s/n): ");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println(p.getFrutaDiablo() != null ? p.getFrutaDiablo() : "Sin Fruta");
                        System.out.println(p.getNombreBarco() != null ? p.getNombreBarco() : "Sin Barco");
                    }
                }
            }
        } catch (Exception e) { System.out.println("Error de conexión: " + e.getMessage()); }
    }
}