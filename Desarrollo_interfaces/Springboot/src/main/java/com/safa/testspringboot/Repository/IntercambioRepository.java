package com.safa.testspringboot.Repository;

import com.safa.testspringboot.Models.Intercambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntercambioRepository extends JpaRepository<Intercambio,Integer> {
}
