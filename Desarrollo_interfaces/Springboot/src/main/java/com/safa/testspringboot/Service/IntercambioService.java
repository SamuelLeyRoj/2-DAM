package com.safa.testspringboot.Service;

import com.safa.testspringboot.Dto.IntercambioDto;
import com.safa.testspringboot.Mapper.IntercambioMapper;
import com.safa.testspringboot.Models.Intercambio;
import com.safa.testspringboot.Models.Ropa;
import com.safa.testspringboot.Models.UsuarioPerfil;
import com.safa.testspringboot.Repository.IntercambioRepository;
import com.safa.testspringboot.Repository.RopaRepository;
import com.safa.testspringboot.Repository.UsuarioPerfilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class IntercambioService {

    private final IntercambioRepository intercambioRepository;
    private final  UsuarioPerfilRepository usuarioPerfilRepository;
    private final RopaRepository ropaRepository;
    private final  IntercambioMapper mapper;

    public IntercambioDto crearIntercambio(IntercambioDto dto,Integer idUsuarioOfertante,Integer idUsuarioSolicitante,Integer idRopa) {

        UsuarioPerfil usuarioOfertante = usuarioPerfilRepository.findById(idUsuarioOfertante).orElse(null);
        UsuarioPerfil usuarioSolicitante = usuarioPerfilRepository.findById(idUsuarioSolicitante).orElse(null);
        Ropa ropa = ropaRepository.findById(idRopa).orElse(null);

        Intercambio intercambio = mapper.toEntity(dto);
        intercambio.setIdRopa(ropa);
        intercambio.setIdUsuarioSolicitante(usuarioSolicitante);
        intercambio.setIdUsuarioOfertante(usuarioOfertante);
        Intercambio guardado = intercambioRepository.save(intercambio);

        return mapper.toDTO(guardado);



    }
}

