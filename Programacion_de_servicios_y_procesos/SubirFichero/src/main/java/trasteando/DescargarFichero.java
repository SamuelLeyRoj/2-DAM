package trasteando;

import org.apache.commons.net.ftp.FTPClient;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;
import org.apache.commons.net.ftp.*;


public class DescargarFichero {
    public static void main(String[] args) {
        FTPClient cliente = new FTPClient();

        String servidor = "127.0.0.1";
        String user = "usuario2";
        String pasw = "usuario2";

        try {
            System.out.println("1. Conectando al servidor...");
            cliente.connect(servidor);

            boolean login = cliente.login(user, pasw);
            if (login) {
                System.out.println("2. ✅ Login correcto con " + user);

                cliente.enterLocalPassiveMode();
                cliente.setFileType(FTP.BINARY_FILE_TYPE);

                // El nombre del archivo que el usuario1 subió al servidor
                String archivoEnServidor = "pdfPrueba_subido.pdf";

                // RUTA DE TU ESCRITORIO (donde se guardará al bajar)
                String rutaDestinoLocal = "C:\\Users\\Cash\\Desktop\\filezilaEj\\pdfPrueba_descargado.pdf";

                File ficheroDestino = new File(rutaDestinoLocal);
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(ficheroDestino));

                System.out.println("3. Descargando archivo...");

                if (cliente.retrieveFile(archivoEnServidor, out)) {
                    System.out.println("4. 🚀 ¡ÉXITO! Mira en tu escritorio, carpeta filezilaEj.");
                } else {
                    System.out.println("4. ❌ ERROR: El archivo no existe en la carpeta del usuario2.");
                    System.out.println("   (Asegúrate de haber copiado el PDF a la carpeta de este usuario)");
                }

                out.close();
                cliente.logout();
            } else {
                System.out.println("2. ❌ Error de Login. Revisa usuario/pass en FileZilla.");
            }
            cliente.disconnect();
        } catch (IOException e) {
            System.out.println("❌ Error crítico: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
