package com.safa.repasito1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane; // Esta es la librería para hacer ventanitas de aviso emergentes

public class Controller {

    // La etiqueta @FXML sirve para que Java conecte estas variables
    // con los cuadritos de texto y botones que dibujaste en Scene Builder.
    @FXML private TextField nombewServidor;
    @FXML private TextField puerto;
    @FXML private TextField nombreUsuario;
    @FXML private TextField Clave;
    @FXML private TextField nombreDestinatario;
    @FXML private TextField Asunto;
    @FXML private TextField Contenido;

    @FXML private Button btnConectar;
    @FXML private Button btnDesconectar;
    @FXML private Button btnEnviarMensaje;

    // Aquí guardamos a nuestro "mecánico" (la clase que explicamos arriba)
    private Model modelo;

    /*
     * ESTADO INICIAL
     * El método initialize() es mágico: se ejecuta él solo nada más arrancar la aplicación.
     * Lo usamos para preparar la pantalla antes de que el usuario haga nada.
     */
    @FXML
    public void initialize() {
        // Al principio, no queremos que nadie mande correos si no se ha conectado
        btnEnviarMensaje.setDisable(true);

        // Al principio, no podemos desconectarnos porque no estamos conectados
        btnDesconectar.setVisible(false);

        // Contratamos a nuestro mecánico
        modelo = new Model();
    }

    /*
     * ACCIÓN DEL BOTÓN: CONECTAR
     * Qué pasa cuando el usuario hace clic en "Conectar"
     */
    @FXML
    void btnConectarAccion(ActionEvent event) {
        try {
            // 1. Leemos lo que el usuario ha escrito en las cajitas de texto
            String servidor = nombewServidor.getText();
            // Convertimos el texto del puerto ("587") a un número matemático de verdad
            int numeroPuerto = Integer.parseInt(puerto.getText());
            String usuario = nombreUsuario.getText();
            String contrasena = Clave.getText();

            // 2. Le pedimos al Modelo que intente conectarse usando esos datos
            boolean seHaConectado = modelo.conectar(servidor, numeroPuerto, usuario, contrasena);

            // 3. Comprobamos qué tal ha ido
            if (seHaConectado == true) {
                // Sacamos una ventanita de éxito
                JOptionPane.showMessageDialog(null, "¡Conexión realizada! Usuario autenticado.");

                // TRUCO DE MAGIA VISUAL (Lo que pide el ejercicio):
                // Ocultamos el botón de conectar
                btnConectar.setVisible(false);
                // Mostramos el de desconectar
                btnDesconectar.setVisible(true);
                // Movemos el de desconectar al mismo sitio donde estaba el de conectar
                btnDesconectar.setLayoutX(btnConectar.getLayoutX());
                btnDesconectar.setLayoutY(btnConectar.getLayoutY());

                // Por fin, dejamos que el usuario pulse el botón de "Enviar"
                btnEnviarMensaje.setDisable(false);

            } else {
                // Sacamos una ventanita de error si nos equivocamos de clave
                JOptionPane.showMessageDialog(null, "No se puede realizar la conexión. Revisa la clave.");
            }

        } catch (Exception e) {
            // Si el usuario deja el puerto vacío o pone letras en vez de números, el programa
            // no se rompe (crushea), sino que cae aquí y mostramos un aviso amigable.
            JOptionPane.showMessageDialog(null, "Error: Revisa que el puerto sea un número (ej. 587)");
        }
    }

    /*
     * ACCIÓN DEL BOTÓN: ENVIAR MENSAJE
     * Qué pasa cuando hacemos clic en "Enviar"
     */
    @FXML
    void btnEnviarMensajeAc(ActionEvent event) {
        try {
            // 1. Recogemos los textos de la pantalla
            // (El remitente es nuestra propia cuenta, la que usamos para conectarnos)
            String miCorreo = nombreUsuario.getText();
            String correoDelOtro = nombreDestinatario.getText();
            String titulo = Asunto.getText();
            String mensaje = Contenido.getText();

            // 2. Le pedimos al modelo que envíe el correo
            boolean seHaEnviado = modelo.enviarMensajeDeTexto(miCorreo, correoDelOtro, titulo, mensaje);

            // 3. Avisamos al usuario del resultado
            if (seHaEnviado == true) {
                JOptionPane.showMessageDialog(null, "¡Mensaje enviado con éxito!");
            } else {
                JOptionPane.showMessageDialog(null, "Ups... Fallo al enviar el mensaje.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal: " + e.getMessage());
        }
    }

    /*
     * ACCIÓN DEL BOTÓN: DESCONECTAR
     * Qué pasa cuando hacemos clic en "Desconectar"
     */
    @FXML
    void btnDesconectarAccion(ActionEvent event) {
        // 1. Le decimos al modelo que cierre la conexión con Google
        modelo.desconectar();

        // 2. Tiramos el modelo viejo y creamos uno nuevo por si queremos volver a empezar de cero
        modelo = new Model();

        JOptionPane.showMessageDialog(null, "Desconectado del servidor de correos.");

        // 3. Volvemos a dejar la pantalla como estaba al principio (reseteamos los botones)
        btnDesconectar.setVisible(false); // Ocultamos desconectar
        btnConectar.setVisible(true);     // Volvemos a mostrar el de conectar
        btnEnviarMensaje.setDisable(true); // Bloqueamos de nuevo el de enviar
    }
}