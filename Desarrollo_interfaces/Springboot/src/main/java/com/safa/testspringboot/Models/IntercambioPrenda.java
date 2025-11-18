package com.safa.testspringboot.Models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="IntercambioPrenda")
public class IntercambioPrenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="id_intercambio")
    private Intercambio intercambio;

    @ManyToOne
    @JoinColumn(name="id_ropa")
    private Ropa ropa;

    @Column(name="devolucion_esperada")
    private LocalDate devolucionEsperada;
}
