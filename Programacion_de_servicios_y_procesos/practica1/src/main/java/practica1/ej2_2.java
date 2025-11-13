package practica1;

public class ej2_2 implements Runnable{

    private String cadenIngresada;

    public ej2_2(String cadenIngresada){
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
