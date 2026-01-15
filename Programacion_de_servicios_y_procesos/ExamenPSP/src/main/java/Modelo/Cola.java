package Modelo;

public class Cola {
    private String cadenaEnCola;
    private boolean disponibleParaConsumir = false;
    public synchronized String get() {
        while (!disponibleParaConsumir) {


        }
        disponibleParaConsumir = false;
        notify();
        return cadenaEnCola;
    }
    public synchronized void put(String cadena) {
        while (disponibleParaConsumir) {

        }
        cadenaEnCola = cadena;
        disponibleParaConsumir = true;
        notify();
    }
}
