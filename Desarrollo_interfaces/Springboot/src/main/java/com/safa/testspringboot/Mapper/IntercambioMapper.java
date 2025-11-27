package com.safa.testspringboot.Mapper;

import com.safa.testspringboot.Dto.IntercambioDto;
import com.safa.testspringboot.Dto.RopaDto;
import com.safa.testspringboot.Models.Intercambio;
import com.safa.testspringboot.Models.Ropa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IntercambioMapper {

    IntercambioDto toDTO(Intercambio intercambio);
    Intercambio toEntity(IntercambioDto dto);

}

