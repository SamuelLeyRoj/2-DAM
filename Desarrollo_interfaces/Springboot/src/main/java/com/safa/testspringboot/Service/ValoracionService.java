package com.safa.testspringboot.Service;

import com.safa.testspringboot.Dto.IntercambioDto;
import com.safa.testspringboot.Dto.ValoracionDto;
import com.safa.testspringboot.Mapper.ValoracionMapper;
import com.safa.testspringboot.Models.Valoracion;
import com.safa.testspringboot.Repository.IntercambioRepository;
import com.safa.testspringboot.Repository.UsuarioSesionRepository;
import com.safa.testspringboot.Repository.ValoracionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ValoracionService {

    private ValoracionRepository valoracionRepository;
    private IntercambioRepository intercambioRepository;
    private UsuarioSesionRepository usuarioSesionRepository;
    private ValoracionMapper mapper;

    public List<ValoracionDto> getValoracion(){

        return mapper.toDto(valoracionRepository.findAll());
    }


}
