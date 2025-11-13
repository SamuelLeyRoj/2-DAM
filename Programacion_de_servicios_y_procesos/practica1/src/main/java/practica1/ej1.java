package practica1;

/*
Actividad 1
Crea una clase que extienda Thread cuya única funcionalidad sea visualizar el mensaje
“Hola mundo”. Crea un programa Java que visualice el mensaje anterior 5 veces
creando para ello 5 hilos diferentes usando la clase creada anteriormente. Modifica el
mensaje “Hola mundo” en el hilo para incluir el identificador del hilo. Prueba de nuevo
el programa Java creado anteriormente.

*/

public class ej1 extends Thread{

    @Override
    public void run() {
        System.out.println("Hola Mundo: "+getId());
    }
}
