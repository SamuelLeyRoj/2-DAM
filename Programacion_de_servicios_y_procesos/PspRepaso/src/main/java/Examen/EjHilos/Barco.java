package Examen.EjHilos;

import java.io.Serializable;

class Barco implements Serializable {
    private String nombre, tripulantes, tipo;
    private Integer altura, longitud;

    public Barco(String nombre, String tripulantes, String tipo, Integer altura, Integer longitud) {
        this.nombre = nombre; this.tripulantes = tripulantes;
        this.tipo = tipo; this.altura = altura; this.longitud = longitud;
    }
    // Getters y Setters
    public String getNombre() { return nombre; }
    public String toString() { return "Barco: " + nombre + " (" + tipo + ")"; }
}
