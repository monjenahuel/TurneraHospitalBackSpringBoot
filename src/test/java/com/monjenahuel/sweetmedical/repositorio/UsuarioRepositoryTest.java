package com.monjenahuel.sweetmedical.repositorio;

import com.monjenahuel.sweetmedical.datos.DatosDummy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UsuarioRepositoryTest {

    @Autowired
    UsuarioRepository repositorio;

    @BeforeEach
    void setUp() {
        repositorio.save(DatosDummy.getUser1());
        repositorio.save(DatosDummy.getUser2());
        repositorio.save(DatosDummy.getUser3());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void usuarioValido() {
        boolean valido = repositorio.usuarioValido("chau@gmail.com","4321");

        assertTrue(valido);
    }

    @Test
    void existsByUsername() {
        boolean valido = repositorio.existsByUsername("Hola@gmail.com");

        assertTrue(valido);
    }
}