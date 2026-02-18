package trasteando;

import java.io.*;
import org.apache.commons.net.ftp.*;

public class SubirFichero {
    public static void main(String[] args) {
        FTPClient cliente = new FTPClient();

        String servidor = "localhost";
        String user = "usuario1";
        String pasw = "usuario1";

        try {
            System.out.println("Conectándose a " + servidor + "...");
            cliente.connect(servidor);
            boolean login = cliente.login(user, pasw);

            if (login) {
                System.out.println("✅ Login correcto");

                cliente.setFileType(FTP.BINARY_FILE_TYPE);
                cliente.enterLocalPassiveMode();

                // 1. Asegúrate de que la ruta termina en el nombre del archivo y su extensión .pdf
                String rutaLocal = "C:\\Users\\Cash\\Documents\\pdfPrueba.pdf";
                File archivoLocal = new File(rutaLocal);

                if (!archivoLocal.exists()) {
                    System.out.println("❌ ERROR: No encuentro el archivo en: " + rutaLocal);
                    return;
                }

                BufferedInputStream in = new BufferedInputStream(new FileInputStream(archivoLocal));

                System.out.println("Subiendo pdfPrueba.pdf al servidor...");

// 2. Le ponemos el nombre con el que queremos que aparezca en el servidor
                if (cliente.storeFile("pdfPrueba_subido.pdf", in)) {
                    System.out.println("🚀 ¡HECHO! Archivo subido correctamente.");
                } else {
                    System.out.println("❌ Fallo en la subida. Revisa permisos en FileZilla.");
                }

                in.close();
                cliente.logout();
                cliente.disconnect();
            } else {
                System.out.println("❌ Error de login en FileZilla.");
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}