package com.safa.testspringboot.Service;

import com.safa.testspringboot.Dto.UsuarioSesionDto;
import com.safa.testspringboot.Models.UsuarioPerfil;
import com.safa.testspringboot.Models.UsuarioSesion;
import com.safa.testspringboot.Repository.UsuarioSesionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioSesionService {

    private UsuarioSesionRepository usuarioSesionRepository;

    public List<UsuarioSesion> obtenerTodos(){return usuarioSesionRepository.findAll();}

    public UsuarioSesion getById(Integer id) {
        return usuarioSesionRepository.findById(id).orElse(null);
    }

    public void borrar(Integer id) {
        usuarioSesionRepository.deleteById(id);
    }

    public UsuarioSesion crearUsuarioConPerfil(UsuarioSesionDto dto) {
        UsuarioSesion usuario = new UsuarioSesion();
        usuario.setNombreUsuario(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        usuario.setContrasenia(dto.getContrasenia());

        UsuarioPerfil perfil = new UsuarioPerfil();
        perfil.setDescripcion(dto.getDescripcion());
        perfil.setFotoPerfil(dto.getFotoPerfil());
        perfil.setUsuarioSesion(usuario);

        usuario.setPerfil(perfil);

        return usuarioSesionRepository.save(usuario);
    }
}
