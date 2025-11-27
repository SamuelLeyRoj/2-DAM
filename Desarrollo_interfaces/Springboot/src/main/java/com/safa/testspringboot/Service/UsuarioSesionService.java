package com.safa.testspringboot.Service;

import com.safa.testspringboot.Dto.UsuarioSesionDto;
import com.safa.testspringboot.Mapper.UsuarioMapper;
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

    private UsuarioMapper mapper;

    public List<UsuarioSesionDto> obtenerTodos(){
        return mapper.convertirADTO(usuarioSesionRepository.findAll());
    }

    public UsuarioSesionDto getById(Integer id) {

        return mapper.convertirADTO(usuarioSesionRepository.findById(id).orElse(null));
    }

    public void borrar(Integer id) {
        usuarioSesionRepository.deleteById(id);
    }

    public UsuarioSesionDto crearUsuarioConPerfil(UsuarioSesionDto dto) {
        UsuarioSesion usuario = new UsuarioSesion();
        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        usuario.setContrasenia(dto.getContrasenia());

        UsuarioPerfil perfil = new UsuarioPerfil();
        perfil.setDescripcion(dto.getDescripcion());
        perfil.setFotoPerfil(dto.getFotoPerfil());
        perfil.setUsuarioSesion(usuario);

        usuario.setPerfil(perfil);

        return mapper.convertirADTO(usuarioSesionRepository.save(usuario));
    }
}
