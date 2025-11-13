package practica1;

/*

Actividad 4
Haz un programa Java que reciba a través de sus argumentos una lista de ficheros de
texto y cuente el número de palabras que hay en cada fichero. Se debe crear un hilo
por cada fichero a contar. Muestra el número de palabras de cada fichero y lo que
tarda en contar las palabras.

* */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ej4 {

    ArrayList<Thread> hilosLista = new ArrayList<>();
    ArrayList<String> lista;

    public ej4 (ArrayList<String> lista) {

        this.lista = lista;

        for(String i : lista){
            ej4Hilo hilo = new ej4Hilo(i);
            hilo.start();
            hilosLista.add(hilo);
        }

        for(Thread i : hilosLista){
            try {
                i.join();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}