package com.monjenahuel.sweetmedical.repositorio;

import com.monjenahuel.sweetmedical.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {


    @Query("SELECT count(u) > 0 from Usuario u where u.username = ?1 and u.password = ?2")
    boolean usuarioValido(String username, String password);

    boolean existsByUsername(String email);


}
