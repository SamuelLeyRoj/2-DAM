package Examen.EjHilos;

import java.io.Serializable;

class PersonajeOnePiece implements Serializable {
    private String nombre, rol;
    private Fruta frutaDiablo;
    private Barco nombreBarco;

    public PersonajeOnePiece(String nombre, String rol, Fruta fruta, Barco barco) {
        this.nombre = nombre; this.rol = rol;
        this.frutaDiablo = fruta; this.nombreBarco = barco;
    }
    // Getters y Setters
    public String getNombre() { return nombre; }
    public String getRol() { return rol; }
    public Fruta getFrutaDiablo() { return frutaDiablo; }
    public Barco getNombreBarco() { return nombreBarco; }
}
