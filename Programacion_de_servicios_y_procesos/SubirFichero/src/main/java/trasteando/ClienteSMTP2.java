package trasteando;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Writer;
import java.util.Base64;
import org.apache.commons.net.smtp.*;

public class ClienteSMTP2 {
    public static void main(String[] args) {

        AuthenticatingSMTPClient client = new AuthenticatingSMTPClient();

        // Datos de configuración
        String server = "smtp.gmail.com";
        int puerto = 587;
        String username = "sleytonrojas@safareyes.es";
        String password = "nqnjxilktqecufwu"; // Tu clave de aplicación sin espacios

        String remitente = "sleytonrojas@safareyes.es";
        String destino = "angelagargon07@gmail.com";

        // RUTA DE TU IMAGEN (Asegúrate de que el archivo existe en esa carpeta)
        String rutaImagen = "C:/Users/Cash/Pictures/negrito.jpg";
        String nombreArchivo = "negrito.jpg";

        try {
            client.connect(server, puerto);
            client.ehlo(server);

            if (client.execTLS()) {
                client.ehlo(server);

                if (client.auth(AuthenticatingSMTPClient.AUTH_METHOD.LOGIN, username, password)) {

                    // Bucle de envío (He puesto 3 para probar, puedes subirlo con cuidado)
                    for (int i = 1; i <= 20; i++) {
                        System.out.println("Preparando envío #" + i);

                        client.setSender(remitente);
                        client.addRecipient(destino);

                        Writer writer = client.sendMessageData();
                        if (writer != null) {
                            // Definimos un separador único para las partes del mensaje (MIME)
                            String boundary = "separador_de_partes_12345";

                            // CABECERAS DEL CORREO
                            writer.write("From: " + remitente + "\n");
                            writer.write("To: " + destino + "\n");
                            writer.write("Subject: Prueba con imagen #" + i + "\n");
                            writer.write("MIME-Version: 1.0\n");
                            writer.write("Content-Type: multipart/mixed; boundary=\"" + boundary + "\"\n\n");

                            // PARTE 1: CUERPO DE TEXTO
                            writer.write("--" + boundary + "\n");
                            writer.write("Content-Type: text/plain; charset=UTF-8\n\n");
                            writer.write("Hola Ángela,\nEste es el mensaje número " + i + " enviando la foto de Negrito.\n\n");

                            // PARTE 2: ADJUNTAR IMAGEN
                            File f = new File(rutaImagen);
                            if (f.exists()) {
                                writer.write("--" + boundary + "\n");
                                writer.write("Content-Type: image/jpeg; name=\"" + nombreArchivo + "\"\n");
                                writer.write("Content-Transfer-Encoding: base64\n");
                                writer.write("Content-Disposition: attachment; filename=\"" + nombreArchivo + "\"\n\n");

                                // Convertir imagen a Base64
                                String imagenBase64 = convertirABase64(f);
                                writer.write(imagenBase64);
                                writer.write("\n");
                            } else {
                                System.err.println("Imagen no encontrada en: " + rutaImagen);
                            }

                            // CIERRE DEL MENSAJE
                            writer.write("--" + boundary + "--\n");
                            writer.close();

                            if (client.completePendingCommand()) {
                                System.out.println("¡Mensaje #" + i + " enviado con éxito!");
                            } else {
                                System.err.println("Error al completar el comando en el envío #" + i);
                            }
                        }

                        // IMPORTANTE: Limpiar el estado para el siguiente correo del bucle
                        client.reset();

                        // Pausa de 2 segundos para no saturar a Gmail
                        Thread.sleep(2000);
                    }
                } else {
                    System.err.println("Error de autenticación.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error general: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (client.isConnected()) {
                    client.logout();
                    client.disconnect();
                }
            } catch (IOException f) {
                f.printStackTrace();
            }
        }
    }

    // Método para leer la imagen y pasarla a texto (Base64)
    private static String convertirABase64(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        fis.read(bytes);
        fis.close();
        return Base64.getMimeEncoder().encodeToString(bytes);
    }
}