package practica1;

import java.io.BufferedReader;
import java.io.FileReader;

public class ej3Hilo extends Thread {

    private String ruta;

    public ej3Hilo(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public void run() {
        int contador = 0;
        long t_comienzo = System.currentTimeMillis();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            int c;
            while ((c = br.read()) != -1) {
                contador++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        long t_fin = System.currentTimeMillis();
        System.out.println("\nFichero: " + ruta);
        System.out.println("Caracteres: " + contador);
        System.out.println("Tiempo: " + (t_fin - t_comienzo) + " ms");
    }
}
