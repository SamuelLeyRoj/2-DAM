package com.safa.testspringboot.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="UsuarioSesion")
public class UsuarioSesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="email")
    private String email;

    @Column(name="nombre_usuario")
    private String nombreUsuario;

    @Column(name="contrasenia")
    private String contrasenia;

    @Column(name="fecha_registro")
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    @OneToOne(mappedBy="usuarioSesion", cascade=CascadeType.ALL)
    private UsuarioPerfil perfil;
}
