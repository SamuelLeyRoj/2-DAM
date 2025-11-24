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
        public List<UsuarioSesion> obtenerTodosUsuarios() {
            return usuarioSesionService.obtenerTodos();
        }

        @GetMapping("/{id}")
        public UsuarioSesion obtenerPorId(@PathVariable Integer id) {
            return usuarioSesionService.getById(id);
        }

        @DeleteMapping("/{id}")
        public void eliminarUsuario(@PathVariable Integer id) {
            usuarioSesionService.borrar(id);
        }

        @PostMapping("/crear")
        public UsuarioSesion crearUsuario(@RequestBody UsuarioSesionDto dto) {
            return usuarioSesionService.crearUsuarioConPerfil(dto);
        }

    }
