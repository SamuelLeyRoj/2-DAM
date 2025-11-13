package practica1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ej4Hilo extends Thread{

    String NombreArchivo;
    public ej4Hilo(String NombreArchivo){
        this.NombreArchivo = NombreArchivo;
    }

    @Override
    public void run() {


            long tiempoInicio = System.currentTimeMillis();

            try (BufferedReader br = new BufferedReader(new FileReader(NombreArchivo))) {
                String linea;
                int contadorPalabras = 0;
                while ((linea = br.readLine()) != null) {

                    String[] palabras = linea.trim().split("\\s+");

                    if (!linea.trim().isEmpty()) {
                        contadorPalabras += palabras.length;
                    }
                }

                System.out.println("El fichero " + NombreArchivo + " tiene " + contadorPalabras + " palabras.");

                long tiempoFinal = System.currentTimeMillis();

                System.out.println("Tiempo total: " + (tiempoFinal - tiempoInicio) + " ms");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
