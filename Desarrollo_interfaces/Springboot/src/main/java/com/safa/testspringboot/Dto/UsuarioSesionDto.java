package com.safa.testspringboot.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioSesionDto {

    private String nombre;
    private String email;
    private String contrasenia;
    private String descripcion;
    private String fotoPerfil;


}
