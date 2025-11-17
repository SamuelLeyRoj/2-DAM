package com.safa.testspringboot;

import com.safa.testspringboot.models.UsuarioSesion;
import com.safa.testspringboot.repository.UsuarioSesionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class TestSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestSpringBootApplication.class, args);
    }
}
