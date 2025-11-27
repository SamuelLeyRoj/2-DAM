package com.safa.testspringboot.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class IntercambioDto {

        private Integer id;
        private Integer idUsuarioOfertante;
        private Integer idUsuarioSolicitante;
        private Integer idRopa;
        private String estado;
        private LocalDateTime fechaSolicitud;
        private LocalDateTime fechaAcuerdo;


}