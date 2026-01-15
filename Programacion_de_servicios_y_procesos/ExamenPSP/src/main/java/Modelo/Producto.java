package Modelo;
import Modelo.leerFichero;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Producto extends Thread {

    public Producto(Cola c, int n) {


    }
    public void run() {
        leerFichero obj = new leerFichero();
        try {
            obj.leerFichero("C:\\Users\\Cash\\Documents\\2-DAM\\Programacion_de_servicios_y_procesos\\practica1_ej6\\src\\main\\java\\Modelo\\ficheroAleer");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Cola cola = new Cola();
        for (int i = 0; i < 10; i++) {
            cola.put("Hola");
        }
    }
}
