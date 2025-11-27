package com.safa.testspringboot.Controller;

import com.safa.testspringboot.Dto.IntercambioDto;
import com.safa.testspringboot.Service.IntercambioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/intercambios")
@RequiredArgsConstructor

public class IntercambioController {

    private final IntercambioService service;

    @PostMapping("/crear")
    public IntercambioDto crear(@Valid @RequestBody IntercambioDto dto) {

        service.crearIntercambio(dto);
        return dto;
    }

}
