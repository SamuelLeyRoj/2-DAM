package practica1;

/*

Actividad 2
Crea una clase que implemente la interfaz Runnable cuya única funcionalidad sea
visualizar el mensaje “Hola mundo” seguido de una cadena que se recibirá en el
constructor (es decir, al crear un objeto de este tipo se enviará una cadena) y seguido
del identificador del hilo. Crea un programa Java que visualice el mensaje anterior 5
veces creando para ello 5 hilos diferentes usando la clase creada anteriormente. Luego
haz que antes de visualizar el mensaje el hilo espere un tiempo proporcional a su
identificador; usa para ello el método sleep(). ¿Qué diferencias observas al ejecutar el
programa usando o no el método sleep()?

 */
public class ej2 implements Runnable {

    private String cadenaIngresada;

    public ej2(String cadenaIngresada) {
        this.cadenaIngresada=cadenaIngresada;
    }


    @Override
    public void run() {

        long id=Thread.currentThread().getId();

        try {
            Thread.sleep(id *100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Hola Mundo: "+id+ " "+cadenaIngresada);
    }
}
