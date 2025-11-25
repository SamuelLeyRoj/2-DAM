package com.safa.testspringboot.Models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ropa")
public class Ropa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="id_usuario", nullable = false)
    private UsuarioPerfil usuario;

    @Column(name="nombre_prenda", nullable = false)
    private String nombrePrenda;

    @Enumerated(EnumType.STRING)
    @Column(name="estilo", nullable = false)
    private Estilo estilo;

    @Column(name="foto")
    private String foto;

    @Enumerated(EnumType.STRING)
    @Column(name="talla", nullable = false)
    private Talla talla;

    @Column(name="estado")
    private String estado = "disponible";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UsuarioPerfil getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioPerfil usuario) {
        this.usuario = usuario;
    }

    public String getNombrePrenda() {
        return nombrePrenda;
    }

    public void setNombrePrenda(String nombrePrenda) {
        this.nombrePrenda = nombrePrenda;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
