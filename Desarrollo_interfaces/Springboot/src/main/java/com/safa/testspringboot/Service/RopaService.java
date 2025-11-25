package com.safa.testspringboot.Service;

import com.safa.testspringboot.Dto.RopaDto;
import com.safa.testspringboot.Models.Ropa;
import com.safa.testspringboot.Models.UsuarioPerfil;
import com.safa.testspringboot.Repository.RopaRepository;
import com.safa.testspringboot.Repository.UsuarioPerfilRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RopaService {

    private RopaRepository ropaRepository;
    private final UsuarioPerfilRepository usuarioPerfilRepository;

    public List<Ropa> obtenerTodos(){return ropaRepository.findAll();}

    public Ropa getById(Integer id) {
        return ropaRepository.findById(id).orElse(null);
    }

    public void borrar(Integer id) {
        ropaRepository.deleteById(id);
    }

    public Ropa crearRopa(RopaDto dto, Integer idUsuarioPerfil) {

        UsuarioPerfil usuario = usuarioPerfilRepository.findById(idUsuarioPerfil)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Ropa ropa = new Ropa();
        ropa.setNombrePrenda(dto.getNombre());
        ropa.setEstilo(dto.getEstilo());
        ropa.setFoto(dto.getFoto());
        ropa.setTalla(dto.getTalla());
        ropa.setEstado(dto.getEstado() != null ? dto.getEstado() : "disponible");
        ropa.setUsuario(usuario);

        return ropaRepository.save(ropa);
    }

}
