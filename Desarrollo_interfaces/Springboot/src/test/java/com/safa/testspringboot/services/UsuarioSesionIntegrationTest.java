package com.safa.testspringboot.services;


import com.safa.testspringboot.Dto.UsuarioSesionDto;
import com.safa.testspringboot.Mapper.UsuarioMapper;
import com.safa.testspringboot.Models.UsuarioSesion;
import com.safa.testspringboot.Repository.UsuarioSesionRepository;
import com.safa.testspringboot.Service.UsuarioSesionService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class UsuarioSesionIntegrationTest {


    @InjectMocks
    private
    UsuarioSesionService usuarioSesionService;

    @Mock
    UsuarioSesionRepository usuarioSesionRepository;

    @Mock
    private UsuarioMapper usuarioMapper;

    @Test
    @DisplayName("Test de integracion 1 ")
    public void buscarPorIdTest(){

        //Given

        Mockito.when(this.usuarioSesionRepository
                .findById(Mockito.anyInt())).thenReturn(Optional.of(new UsuarioSesion()));

        Mockito.when(this.usuarioMapper.convertirADTO(Mockito.any(UsuarioSesion.class))).thenReturn(new UsuarioSesionDto());
        //WHEN

        this.usuarioSesionService.getById(1);

        //THEN

        Mockito.verify(this.usuarioSesionRepository).findById(1);
        Mockito.verify(this.usuarioMapper).convertirADTO((UsuarioSesion) Mockito.any());
    }
}
