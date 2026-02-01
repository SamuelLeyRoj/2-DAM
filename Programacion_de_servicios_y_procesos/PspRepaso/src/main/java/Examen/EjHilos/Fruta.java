package Examen.EjHilos;

import java.io.Serializable;

class Fruta implements Serializable {
    private String nombre, descripcion, apariencia;

    public Fruta(String nombre, String descripcion, String apariencia) {
        this.nombre = nombre; this.descripcion = descripcion; this.apariencia = apariencia;
    }
    // Getters y Setters
    public String getNombre() { return nombre; }
    public String toString() { return "Fruta: " + nombre + " - " + descripcion; }
}
