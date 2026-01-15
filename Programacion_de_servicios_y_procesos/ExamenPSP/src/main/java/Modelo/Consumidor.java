package Modelo;

public class Consumidor extends Thread {

    public Consumidor(Cola c, int n) {

    }
    public void run() {
        String cadena;
        Object bucle = null;
        Cola cola = new Cola();
        for (int i = 0; i < 10; i++) {
            cadena = cola.get();
        }
    }
}