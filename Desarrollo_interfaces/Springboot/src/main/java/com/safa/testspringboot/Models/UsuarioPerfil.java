package com.safa.testspringboot.Models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="usuario_perfil")
public class UsuarioPerfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @OneToOne
    @JoinColumn(name="id_auth", referencedColumnName="id")
    private UsuarioSesion usuarioSesion;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="foto_perfil")
    private String fotoPerfil;

    @OneToMany(mappedBy="usuario", cascade=CascadeType.ALL)
    private List<Ropa> ropas;
}
