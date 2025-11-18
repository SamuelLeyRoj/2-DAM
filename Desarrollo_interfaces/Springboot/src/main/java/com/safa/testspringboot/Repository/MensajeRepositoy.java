package com.safa.testspringboot.Repository;

import com.safa.testspringboot.Models.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeRepositoy extends JpaRepository<Mensaje,Integer> {
}
