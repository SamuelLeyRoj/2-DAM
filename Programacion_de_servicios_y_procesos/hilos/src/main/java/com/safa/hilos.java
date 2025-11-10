package com.safa;

public class hilos extends Thread {

    @Override
    public void run() {

        for (int i = 0; i <= 20; i++) {
            System.out.println(i);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Hilo " + getName() + " interrumpido.");
            }

            Thread hilo = Thread.currentThread();
            System.out.println("Hilo actual desde currentThread(): " + hilo.getId());
        }
    }
}
