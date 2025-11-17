package com.safa.testspringboot.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Intercambio")
public class Intercambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="id_usuario_ofertante")
    private UsuarioPerfil usuarioOfertante;

    @ManyToOne
    @JoinColumn(name="id_usuario_solicitante")
    private UsuarioPerfil usuarioSolicitante;

    @Column(name="estado")
    private String estado = "solicitado";

    @Column(name="fecha_solicitud")
    private LocalDateTime fechaSolicitud = LocalDateTime.now();

    @Column(name="fecha_acuerdo")
    private LocalDateTime fechaAcuerdo;

    @OneToMany(mappedBy="intercambio", cascade=CascadeType.ALL)
    private List<IntercambioPrenda> prendas;
}
