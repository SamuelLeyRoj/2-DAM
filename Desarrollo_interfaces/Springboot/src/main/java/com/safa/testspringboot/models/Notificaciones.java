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
@Table(name="Notificacion")
public class Notificaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="id_usuario_destino")
    private UsuarioPerfil usuarioDestino;

    @Column(name="tipo")
    private String tipo;

    @Column(name="mensaje")
    private String mensaje;

    @Column(name="leido")
    private Boolean leido = false;

    @Column(name="creado_en")
    private LocalDateTime creadoEn = LocalDateTime.now();
}
