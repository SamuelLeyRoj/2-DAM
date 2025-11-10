package com.safa;

public class ej1 {

    static void main() {

        hilos hilo1 = new hilos();
        hilo1.start();
        for (int i = 1; i <= 10; i++) {
            System.out.printf("Fuera del hilo: \n"+ i);

        }
    }
}
