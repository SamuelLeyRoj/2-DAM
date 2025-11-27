    package com.safa.testspringboot.Controller;

    import com.safa.testspringboot.Dto.UsuarioSesionDto;
    import com.safa.testspringboot.Models.UsuarioSesion;
    import com.safa.testspringboot.Service.UsuarioSesionService;
    import lombok.AllArgsConstructor;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/usuarioSesion")
    @AllArgsConstructor
    public class UsuarioSesionController {

        private UsuarioSesionService usuarioSesionService;

        @GetMapping("/all")
        public List<UsuarioSesionDto> obtenerTodosUsuarios() {
            return usuarioSesionService.obtenerTodos();
        }

        @GetMapping("/usuarios/{id:\\d+}")
        public UsuarioSesionDto obtenerPorId(@PathVariable Integer id) {
            return usuarioSesionService.getById(id);
        }

        @DeleteMapping("/usuarios/{id}")
        public void eliminarUsuario(@PathVariable Integer id) {
            usuarioSesionService.borrar(id);
        }

        @PostMapping("/usuarios")
        public UsuarioSesionDto crearUsuario(@RequestBody UsuarioSesionDto dto) {
            return usuarioSesionService.crearUsuarioConPerfil(dto);
        }

    }
