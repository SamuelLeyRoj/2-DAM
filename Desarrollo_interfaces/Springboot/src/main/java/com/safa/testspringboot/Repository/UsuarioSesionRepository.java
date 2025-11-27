package com.safa.testspringboot.Repository;

import com.safa.testspringboot.Models.UsuarioSesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioSesionRepository extends JpaRepository<UsuarioSesion,Integer> {

}
