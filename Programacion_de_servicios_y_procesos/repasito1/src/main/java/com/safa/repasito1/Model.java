package com.safa.repasito1;

import java.io.Writer;
import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

public class Model {

    // Esta es nuestra herramienta principal, el "cartero" cibernético.
    private AuthenticatingSMTPClient cartero;

    // Constructor: Se ejecuta cuando creamos un nuevo Modelo.
    public Model() {
        // Le damos vida a nuestro cartero
        cartero = new AuthenticatingSMTPClient();
    }

    /*
     * PASO 1: CONECTAR Y AUTENTICAR
     * Este método intenta entrar al servidor (ej. Gmail) y poner el usuario y contraseña.
     * Devuelve 'true' si todo sale bien, o 'false' si algo falla.
     */
    public boolean conectar(String servidor, int puerto, String usuario, String clave) throws Exception {

        // 1. Llamamos a la puerta del servidor (ej: smtp.gmail.com en el puerto 587)
        cartero.connect(servidor, puerto);

        // 2. Le decimos "Hola" al servidor (EHLO es el saludo oficial de los correos)
        cartero.ehlo(servidor);

        // 3. Activamos la seguridad (TLS). Esto es OBLIGATORIO hoy en día para que no nos roben la clave.
        boolean seguridadActivada = cartero.execTLS();

        if (seguridadActivada == true) {
            // Como hemos puesto la seguridad, por educación volvemos a saludar
            cartero.ehlo(servidor);

            // 4. Intentamos hacer "Login" con nuestro usuario y la clave secreta de aplicación
            boolean loginCorrecto = cartero.auth(AuthenticatingSMTPClient.AUTH_METHOD.LOGIN, usuario, clave);

            // Si el login fue bien, devolverá true. Si nos equivocamos de clave, false.
            return loginCorrecto;
        }

        // Si no pudimos poner la seguridad, fallamos.
        return false;
    }

    /*
     * PASO 2: ENVIAR EL CORREO
     * Solo llamamos a esto si el paso 1 (conectar) funcionó.
     */
    public boolean enviarMensajeDeTexto(String remitente, String destinatario, String asunto, String contenido) throws Exception {

        // 1. Preparamos el sobre: Quién lo envía y a quién va
        cartero.setSender(remitente);
        cartero.addRecipient(destinatario);

        // 2. Escribimos la cabecera (es lo que ves antes de abrir el correo: Asunto, De, Para)
        SimpleSMTPHeader cabecera = new SimpleSMTPHeader(remitente, destinatario, asunto);

        // 3. Empezamos a redactar el papel del correo
        Writer papel = cartero.sendMessageData();

        if (papel != null) { // Si nos han dejado un papel en blanco para escribir...

            papel.write(cabecera.toString()); // Escribimos la cabecera arriba del todo
            papel.write("\n" + contenido);    // Damos un salto de línea y escribimos el mensaje
            papel.close();                    // Metemos el papel en el sobre y lo cerramos

            // 4. Le decimos al cartero: "¡Mándalo ya!"
            boolean enviadoConExito = cartero.completePendingCommand();
            return enviadoConExito;
        }

        // Si no nos dejaron escribir, algo falló
        return false;
    }

    /*
     * PASO 3: DESCONECTAR
     * Siempre hay que recoger todo antes de irse para no dejar "procesos fantasma" abiertos.
     */
    public void desconectar() {
        try {
            // Si el cartero existe y sigue conectado...
            if (cartero != null && cartero.isConnected()) {
                cartero.logout();     // Cerramos sesión
                cartero.disconnect(); // Cortamos la llamada
            }
        } catch (Exception e) {
            System.out.println("No pasa nada, ya estaba desconectado.");
        }
    }
}