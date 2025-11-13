package practica1;

public class ej2_4 implements Runnable{

    String cadenIngresada;

    public ej2_4(String cadenIngresada){
        this.cadenIngresada = cadenIngresada;
    }

    @Override
    public void run() {

        long id = Thread.currentThread().getId();

        try {
            Thread.sleep(id * 100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Hola Mundo: "+id+ " "+cadenIngresada);
    }
}
