package com.safa.testspringboot.services;

import com.safa.testspringboot.Dto.IntercambioDto;
import com.safa.testspringboot.Dto.RopaDto;
import com.safa.testspringboot.Dto.UsuarioSesionDto;
import com.safa.testspringboot.Dto.ValoracionDto;
import com.safa.testspringboot.Models.Estilo;
import com.safa.testspringboot.Models.Talla;
import com.safa.testspringboot.Service.IntercambioService;
import com.safa.testspringboot.Service.RopaService;
import com.safa.testspringboot.Service.UsuarioSesionService;
import com.safa.testspringboot.Service.ValoracionService;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Null;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class RopaServiceTest {



        @Autowired
        private UsuarioSesionService usuarioService;
        @Autowired
        private RopaService ropaService;
        @Autowired
        private IntercambioService intercambioService;
        @Autowired
        private ValoracionService valoracionService;

        @BeforeEach
        void inicializarBaseDatos() throws Exception {

            // ----------------------------------------------------------------------------------
            // 1. CREAR 3 USUARIOS (IDs esperados: 1, 2, 3)
            // ----------------------------------------------------------------------------------
            // Usuario 1


            UsuarioSesionDto user1 = new UsuarioSesionDto();
            user1.setNombre("Pepe");
            user1.setEmail("pepe@email.com");
            user1.setContrasenia("1234");
            user1.setDescripcion("Me gusta la ropa vintage");
            user1.setFotoPerfil("foto_pepe.jpg");
            usuarioService.crearUsuarioConPerfil(user1);

            // Usuario 2
            UsuarioSesionDto user2 = new UsuarioSesionDto();
            user2.setNombre("Maria");
            user2.setEmail("maria@email.com");
            user2.setContrasenia("1234");
            user2.setDescripcion("Busco ropa deportiva");
            user2.setFotoPerfil("foto_maria.jpg");
            usuarioService.crearUsuarioConPerfil(user2);

            // Usuario 3
            UsuarioSesionDto user3 = new UsuarioSesionDto();
            user3.setNombre("Juan");
            user3.setEmail("juan@email.com");
            user3.setContrasenia("1234");
            user3.setDescripcion("Solo intercambio formal");
            user3.setFotoPerfil("foto_juan.jpg");
            usuarioService.crearUsuarioConPerfil(user3);

            // ----------------------------------------------------------------------------------
            // 2. CREAR 3 PRENDAS DE ROPA (IDs esperados: 1, 2, 3)
            // ----------------------------------------------------------------------------------
            // Ropa 1 (Pertenece a Pepe - ID 1)
            RopaDto ropa1 = new RopaDto();
            ropa1.setNombre("Camiseta Retro");
            ropa1.setEstilo(Estilo.CASUAL); // Asegúrate de tener este Enum importado
            ropa1.setTalla(Talla.M);        // Asegúrate de tener este Enum importado
            ropa1.setFoto("img_cami.jpg");
            ropa1.setEstado("disponible");
            ropaService.crearRopa(ropa1, 1); // ID Usuario Perfil 1

            // Ropa 2 (Pertenece a Maria - ID 2)
            RopaDto ropa2 = new RopaDto();
            ropa2.setNombre("Chándal Nike");
            ropa2.setEstilo(Estilo.DEPORTIVO);
            ropa2.setTalla(Talla.L);
            ropa2.setFoto("img_chandal.jpg");
            ropa2.setEstado("disponible");
            ropaService.crearRopa(ropa2, 2); // ID Usuario Perfil 2

            // Ropa 3 (Pertenece a Pepe - ID 1) -> Pepe tiene dos prendas
            RopaDto ropa3 = new RopaDto();
            ropa3.setNombre("Traje Boda");
            ropa3.setEstilo(Estilo.ELEGANTE);
            ropa3.setTalla(Talla.XL);
            ropa3.setFoto("img_traje.jpg");
            ropa3.setEstado("disponible");
            ropaService.crearRopa(ropa3, 1); // ID Usuario Perfil 1

            // ----------------------------------------------------------------------------------
            // 3. CREAR 3 INTERCAMBIOS (IDs esperados: 1, 2, 3)
            // ----------------------------------------------------------------------------------

            // Intercambio 1: Maria (2) pide la Camiseta Retro (1) a Pepe (1)
            IntercambioDto inter1 = new IntercambioDto();
            inter1.setEstado("solicitado");
            // Parametros: DTO, idOfertante, idSolicitante, idRopa
            intercambioService.crearIntercambio(inter1, 1, 2, 1);

            // Intercambio 2: Juan (3) pide el Chándal (2) a Maria (2)
            IntercambioDto inter2 = new IntercambioDto();
            inter2.setEstado("aceptado");
            intercambioService.crearIntercambio(inter2, 2, 3, 2);

            // Intercambio 3: Juan (3) pide el Traje (3) a Pepe (1)
            IntercambioDto inter3 = new IntercambioDto();
            inter3.setEstado("finalizado");
            intercambioService.crearIntercambio(inter3, 1, 3, 3);

            // ----------------------------------------------------------------------------------
            // 4. CREAR 3 VALORACIONES
            // ----------------------------------------------------------------------------------

            // Valoración 1: Maria valora el Intercambio 1
            ValoracionDto val1 = new ValoracionDto();
            val1.setComentario("Todo perfecto, muy rápido");
            val1.setPuntuacion(5);
            // Parametros: DTO, idUsuario(que valora), idIntercambio
            valoracionService.guardarValoracion(val1, 2, 1);

            // Valoración 2: Juan valora el Intercambio 2
            ValoracionDto val2 = new ValoracionDto();
            val2.setComentario("La ropa estaba un poco usada");
            val2.setPuntuacion(3);
            valoracionService.guardarValoracion(val2, 3, 2);

            // Valoración 3: Juan valora el Intercambio 3
            ValoracionDto val3 = new ValoracionDto();
            val3.setComentario("El traje es increíble");
            val3.setPuntuacion(5);
            valoracionService.guardarValoracion(val3, 3, 3);
        }



/*
        @Test
        @DisplayName("Test Negativo 3")
        public void testNegativo3() throws Exception {

            RopaDto ropa = new RopaDto();
            ropa.setNombre("Traje Boda");
            ropa.setEstilo(Estilo.ELEGANTE);
            ropa.setTalla(null);
            ropa.setFoto("img_traje.jpg");
            ropa.setEstado("disponible");


            Exception exception = assertThrows(
                    Exception.class,
                    () -> ropaService.crearRopa(ropa, 1)
            );
            assertEquals("La talla es obligatoria para crear una prenda", exception.getMessage()
            );

        }


 */


    @Test
    @DisplayName("Test Positivo 3")
    public void testPositivo3() throws Exception {

        RopaDto ropa = new RopaDto();
        ropa.setNombre("Traje Boda");
        ropa.setEstilo(Estilo.ELEGANTE);
        ropa.setTalla(Talla.XL);
        ropa.setFoto("img_traje.jpg");
        ropa.setEstado("disponible");

        ropaService.crearRopa(ropa, 1);

        List<UsuarioSesionDto> lista = new ArrayList<UsuarioSesionDto>(usuarioService.obtenerTodos());

        assertEquals("Traje Boda",lista.get(0).getNombre());

    }

    }
