package Modelo;

import java.io.*;

public class leerFichero{


public void leerFichero(String fichero) throws IOException {
    int contador = 0;
    String linea;
    File archivo = new File(fichero);
    FileReader lector = new FileReader(archivo);
    BufferedReader lectorBuffer = new BufferedReader(lector);

    while ((linea = lectorBuffer.readLine()) != null) {
        if (!linea.equals("")) { // Si la línea no está vacía
            for (int i = 0; i < linea.length(); i++) {
                if (linea.charAt(i) == 32) {
                    contador++;
                    }
                }
                contador++;
            }
        }

    }
}