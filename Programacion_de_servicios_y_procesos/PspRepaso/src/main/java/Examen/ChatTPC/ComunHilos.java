package Examen.ChatTPC;

import java.net.Socket;
import java.net.Socket;

public class ComunHilos {
    int CONEXIONES; // Contador de cuánta gente ha entrado (para el índice del array)
    int ACTUALES;   // Cuánta gente hay conectada ahora mismo
    int MAXIMO;     // El tope de personas permitidas
    Socket tabla[]; // El "listado telefónico": aquí guardamos los sockets de todos
    String mensajes; // El muro donde se escriben todos los mensajes del chat

    public ComunHilos(int maximo, int actuales, int conexiones, Socket[] tabla) {
        MAXIMO = maximo;
        ACTUALES = actuales;
        CONEXIONES = conexiones;
        this.tabla = tabla;
        mensajes = ""; // Empezamos con el chat limpio
    }

    // --- MÉTODOS SINCRONIZADOS (FUNDAMENTAL) ---
    // Usamos 'synchronized' para que si dos hilos quieren escribir a la vez,
    // hagan "cola" y no se corrompa la información.

    public synchronized String getMensajes() { return mensajes; }

    public synchronized void setMensajes(String mensajes) {
        this.mensajes = mensajes; // Actualiza el muro del chat
    }

    public synchronized int getACTUALES() { return ACTUALES; }

    public synchronized void setACTUALES(int actuales) {
        ACTUALES = actuales;
    }

    public synchronized void addTabla(Socket s, int i) {
        tabla[i] = s; // Guarda un socket en la lista para poder enviarle cosas luego
    }

    public Socket getElementoTabla(int i) { return tabla[i]; }
    public int getCONEXIONES() { return CONEXIONES; }
    public synchronized void setCONEXIONES(int conexiones) { CONEXIONES = conexiones; }
}