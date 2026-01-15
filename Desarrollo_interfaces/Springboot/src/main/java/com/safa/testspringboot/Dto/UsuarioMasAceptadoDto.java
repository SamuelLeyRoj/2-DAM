package com.safa.testspringboot.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioMasAceptadoDto {

    private Integer idUsuario;


    private String nombreUsuario;

    private Long totalIntercambios;
}
