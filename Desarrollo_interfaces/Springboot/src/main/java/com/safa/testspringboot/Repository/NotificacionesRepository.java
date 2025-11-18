package com.safa.testspringboot.Repository;

import com.safa.testspringboot.Models.Notificaciones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacionesRepository extends JpaRepository<Notificaciones,Integer> {
}
