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

public class ValoracionDto {

    private  String comentario;
    private Integer puntuacion;
    private Integer intercambio;
    private Integer usuario;

}
