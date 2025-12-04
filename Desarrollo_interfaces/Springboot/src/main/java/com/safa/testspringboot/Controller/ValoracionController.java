package com.safa.testspringboot.Controller;


import com.safa.testspringboot.Repository.ValoracionRepository;
import com.safa.testspringboot.Service.UsuarioSesionService;
import com.safa.testspringboot.Service.ValoracionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/valoracion")
@AllArgsConstructor
public class ValoracionController {

    private ValoracionService valoracionService;
    private UsuarioSesionService usuarioSesionService;



}
