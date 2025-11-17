package com.safa.testspringboot.models;

import com.safa.testspringboot.enumerados.Estilo;
import com.safa.testspringboot.enumerados.Talla;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Ropa")
public class Ropa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    private UsuarioPerfil usuario;

    @Column(name="nombre_prenda")
    private String nombrePrenda;

    @Column(name="estilo")
    @Enumerated(EnumType.ORDINAL)
    private Estilo estilo;

    @Column(name="foto")
    private String foto;

    @Column(name="talla")
    @Enumerated(EnumType.ORDINAL)
    private Talla talla;

    @Column(name="estado")
    private String estado = "disponible";
}
