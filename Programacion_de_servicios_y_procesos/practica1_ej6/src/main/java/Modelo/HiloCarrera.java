package Modelo;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class HiloCarrera implements Runnable {
    private long tiempoDormir;
    private ProgressBar barra;
    private Label labelContador;
    private String nombre;
    private CarreraListener listener;

    public HiloCarrera(String nombre, long tiempoDormir, ProgressBar barra, Label labelContador, CarreraListener listener) {
        this.nombre = nombre;
        this.tiempoDormir = tiempoDormir;
        this.barra = barra;
        this.labelContador = labelContador;
        this.listener = listener;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep(tiempoDormir);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final int progreso = i;

            // Actualizar UI de forma segura
            Platform.runLater(() -> {
                barra.setProgress(progreso / 100.0);
                labelContador.setText(String.valueOf(progreso));
            });
        }

        // Al finalizar, notificar al listener
        if (listener != null) {
            listener.hiloTerminado(nombre);
        }
    }

    public interface CarreraListener {
        void hiloTerminado(String nombre);
    }
}
