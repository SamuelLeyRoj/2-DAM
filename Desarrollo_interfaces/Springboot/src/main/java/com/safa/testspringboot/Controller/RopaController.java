package com.safa.testspringboot.Controller;


import com.safa.testspringboot.Dto.RopaDto;
import com.safa.testspringboot.Models.Ropa;
import com.safa.testspringboot.Service.RopaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ropa")
@AllArgsConstructor

public class RopaController {

    private final RopaService ropaService;

    @GetMapping("/all")
    public List<Ropa> obtenerTodas() {
        return ropaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Ropa obtenerPorId(@PathVariable Integer id) {
        return ropaService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarRopa(@PathVariable Integer id) {
        ropaService.borrar(id);
    }

    @PostMapping("/crear/{idUsuario}")
    public Ropa crearRopa(@PathVariable Integer idUsuario, @RequestBody RopaDto dto) {
        return ropaService.crearRopa(dto, idUsuario);
    }


}
