package Practica1.Ej3;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Servidor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        DatagramSocket socket = new DatagramSocket(12345);
        System.out.println("Servidor esperando datos mixtos...");




        //enviamos mensaje


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);



        Curso curso1 = new Curso("1", "PSP");
        Curso curso2 = new Curso("2", "Inglés");
        Curso curso3 = new Curso("3", "PMDM");

        Boolean acabar = false;


        Alumno alumno1 = new Alumno("1","Samu",curso1,10);
        Alumno alumno2 = new Alumno("2","Ángela",curso2,10);
        Alumno alumno3 = new Alumno("3","Óscar",curso3,1);
        Alumno alumno4 = new Alumno("4","Laura",curso3,5);
        Alumno alumno5 = new Alumno("5","Rafa",curso2,8);


        List<Alumno> listaAlumnos = new ArrayList<Alumno>();

        listaAlumnos.add(alumno1);listaAlumnos.add(alumno2);listaAlumnos.add(alumno3);listaAlumnos.add(alumno4);listaAlumnos.add(alumno5);

        while (acabar == false) {

            //recibimos mensaje

            byte[] buf = new byte[1024];
            DatagramPacket recibo = new DatagramPacket(buf, buf.length);
            socket.receive(recibo);
            String mensaje = new String(recibo.getData()).trim();
            System.out.println("Mensaje del cliente: " + mensaje);

            if ("*".equals(mensaje)){
                System.out.println("Servidor terminando...");
                acabar = true;

            }else {
                if (mensaje.equals("1") || mensaje.equals("2") || mensaje.equals("3")||mensaje.equals("4")||mensaje.equals("5")) {

                    Iterator<Alumno> iterator = listaAlumnos.iterator();
                    while (iterator.hasNext()){
                        Alumno al = iterator.next();
                        if (al.getIdAlumno().equals(mensaje)){
                            out.writeObject(al); // Metemos el objeto en el buffer de memoria
                            out.close();

                            byte[] bufferAlumno = baos.toByteArray();
                            DatagramPacket paqueteEnvio = new DatagramPacket(bufferAlumno, bufferAlumno.length, recibo.getAddress(),recibo.getPort());
                            socket.send(paqueteEnvio);
                            System.out.println("Petición enviada...");

                        }
                    }
                }else {

                        Alumno alumnoFallo = new Alumno();
                        alumnoFallo.setIdAlumno("No encontrado");
                        alumnoFallo.setCurso(null);
                        alumnoFallo.setIdAlumno(null);
                        byte[] bufferAlumno = baos.toByteArray();
                        DatagramPacket paqueteEnvio = new DatagramPacket(bufferAlumno, bufferAlumno.length, recibo.getAddress(),recibo.getPort());
                        socket.send(paqueteEnvio);
                        System.out.println("Petición enviada...");

                }
            }
        }
    }
}
