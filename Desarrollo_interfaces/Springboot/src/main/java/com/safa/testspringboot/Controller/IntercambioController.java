package com.safa.testspringboot.Controller;

import com.safa.testspringboot.Dto.IntercambioDto;
import com.safa.testspringboot.Service.IntercambioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/intercambios")
@RequiredArgsConstructor

public class IntercambioController {

    private final IntercambioService service;

    @PostMapping("/crear/{idUsuarioOfertante}/{idUsuarioSolicitante}/{idRopa}")
    public IntercambioDto crear(@RequestBody IntercambioDto dto,
                                @PathVariable Integer idUsuarioOfertante,
                                @PathVariable Integer idUsuarioSolicitante,
                                @PathVariable Integer idRopa
    ) {

        return service.crearIntercambio(dto, idUsuarioOfertante, idUsuarioSolicitante, idRopa);

    }

}
