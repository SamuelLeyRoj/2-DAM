package EjemplosCosas;

import java.net.*;
import java.io.*;
public class EjemploSimpleURLMasXamp {
    public static void main(String[] args) {
        try {
            // 1. Creamos el objeto URL [cite: 66, 70]
            URL url = new URL("http://localhost/test.html");

            // 2. Abrimos un flujo para leer el contenido [cite: 67, 77]
            BufferedReader pagina = new BufferedReader(new InputStreamReader(url.openStream()));

            // 3. Leemos línea a línea y lo mostramos [cite: 78]
            String linea;
            while ((linea = pagina.readLine()) != null) {
                System.out.println(linea);
            }
            pagina.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
