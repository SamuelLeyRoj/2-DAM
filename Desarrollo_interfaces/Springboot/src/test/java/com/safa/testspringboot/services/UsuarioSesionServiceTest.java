package com.safa.testspringboot.services;

import com.safa.testspringboot.Dto.UsuarioSesionDto;
import com.safa.testspringboot.Service.UsuarioSesionService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UsuarioSesionServiceTest {


    @Autowired
    private UsuarioSesionService usuarioSesionService;

    @Test
    @DisplayName("Test Crear Perfil Negativo")
    public void TestCrearPerfil(){


        //GIVEN

        UsuarioSesionDto dto = new UsuarioSesionDto();
        dto.setNombre("Samuel");
        dto.setEmail("samuelgmail.com");
        dto.setFotoPerfil("images/logo.png");
        dto.setDescripcion("Samuel");
        dto.setContrasenia("123456");

        //WHEN
        //THEN

        Exception exception = assertThrows(Exception.class, () ->usuarioSesionService.crearUsuarioConPerfil(dto) );
        assertEquals("El Email no es valido", exception.getMessage());

    }
}
