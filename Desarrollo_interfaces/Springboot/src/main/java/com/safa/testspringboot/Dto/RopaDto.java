package com.safa.testspringboot.Dto;

import com.safa.testspringboot.Models.Estilo;
import com.safa.testspringboot.Models.Talla;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RopaDto {

    private String nombre;
    private Estilo estilo;
    private String foto;
    private Talla talla;
    private String estado;
}
