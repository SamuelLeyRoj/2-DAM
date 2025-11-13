package practica1;

import java.util.ArrayList;

public class ej3 {

    public ej3(ArrayList<String> listaFicheros) {

        ArrayList<Thread> hilos = new ArrayList<>();

        for (String ruta : listaFicheros) {
            ej3Hilo hilo = new ej3Hilo(ruta);
            hilos.add(hilo);
            hilo.start();  // ejecuta el hilo
        }

        // Esperar a que terminen todos los hilos
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nTodos los hilos han terminado.");
    }
}
