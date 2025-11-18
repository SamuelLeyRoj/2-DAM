package com.safa.testspringboot.Repository;

import com.safa.testspringboot.Models.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo,Integer> {
}
