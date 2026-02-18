package trasteando;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Writer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import org.apache.commons.net.smtp.*;

public class ClienteImgSMPT {
    public static void main(String[] args) {

        AuthenticatingSMTPClient client = new AuthenticatingSMTPClient();

        String server = "smtp.gmail.com";
        String username = "sleytonrojas@safareyes.es";
        String password = "nqnjxilktqecufwu"; // Tu clave de aplicación sin espacios

        String remitente = "sleytonrojas@safareyes.es";
        String destino = "ogarciadelgado@safareyes.es";

        // Ruta de la imagen en tu ordenador (Cámbiala por una real)
        String rutaImagen = "C:\\Users\\Cash\\Pictures\\negrito.jpg";
        String nombreImagen = "foto_adjunta.jpg";

        try {
            client.connect(server, 587);
            client.ehlo(server);

            if (client.execTLS()) {
                client.ehlo(server);

                if (client.auth(AuthenticatingSMTPClient.AUTH_METHOD.LOGIN, username, password)) {

                    client.setSender(remitente);
                    client.addRecipient(destino);

                    Writer writer = client.sendMessageData();
                    if (writer != null) {
                        // --- INICIO DE CABECERAS MIME ---
                        writer.write("From: " + remitente + "\n");
                        writer.write("To: " + destino + "\n");
                        writer.write("Subject: Correo con imagen adjunta\n");
                        writer.write("MIME-Version: 1.0\n");
                        String boundary = "Separador_De_Partes"; // Un código único para separar texto de imagen
                        writer.write("Content-Type: multipart/mixed; boundary=\"" + boundary + "\"\n\n");

                        // --- PARTE 1: EL TEXTO ---
                        writer.write("--" + boundary + "\n");
                        writer.write("Content-Type: text/plain; charset=UTF-8\n\n");
                        writer.write("Hola Óscar, te adjunto la imagen que me pediste.\n\n");

                        // --- PARTE 2: LA IMAGEN ---
                        File file = new File(rutaImagen);
                        if (file.exists()) {
                            writer.write("--" + boundary + "\n");
                            writer.write("Content-Type: image/jpeg; name=\"" + nombreImagen + "\"\n");
                            writer.write("Content-Transfer-Encoding: base64\n");
                            writer.write("Content-Disposition: attachment; filename=\"" + nombreImagen + "\"\n\n");

                            // Convertir imagen a Base64
                            byte[] fileContent = leerArchivo(file);
                            String encodedString = Base64.getMimeEncoder().encodeToString(fileContent);
                            writer.write(encodedString);
                            writer.write("\n");
                        }

                        // --- CIERRE ---
                        writer.write("--" + boundary + "--\n");
                        writer.close();

                        if (client.completePendingCommand()) {
                            System.out.println("¡Correo con imagen enviado!");
                        }
                    }
                }
            }
        } catch (IOException | NoSuchAlgorithmException | InvalidKeyException | InvalidKeySpecException e) {
            e.printStackTrace();
        } finally {
            try { client.disconnect(); } catch (Exception e) {}
        }
    }

    // Método auxiliar para leer la imagen en bytes
    private static byte[] leerArchivo(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();
        return data;
    }
}