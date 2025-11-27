package com.safa.testspringboot.Service;

import com.safa.testspringboot.Dto.IntercambioDto;
import com.safa.testspringboot.Mapper.IntercambioMapper;
import com.safa.testspringboot.Models.Intercambio;
import com.safa.testspringboot.Models.Ropa;
import com.safa.testspringboot.Models.UsuarioPerfil;
import com.safa.testspringboot.Repository.IntercambioRepository;
import com.safa.testspringboot.Repository.RopaRepository;
import com.safa.testspringboot.Repository.UsuarioPerfilRepository;
import com.safa.testspringboot.Repository.UsuarioSesionRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IntercambioService {

    private IntercambioRepository intercambioRepository;
    private UsuarioPerfilRepository usuarioPerfilRepository;
    private RopaRepository ropaRepository;
    private IntercambioMapper mapper;

    public void  crearIntercambio(IntercambioDto dto) {

        intercambioRepository.save(mapper.toEntity(dto));

    }
}

