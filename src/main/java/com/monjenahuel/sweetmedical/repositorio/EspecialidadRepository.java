package com.monjenahuel.sweetmedical.repositorio;

import com.monjenahuel.sweetmedical.entity.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad,Integer> {
    @Query("from Especialidad e where e.nombre = ?1")
    Optional<Especialidad> buscarPorNombre(String nombre);

    @Query(value = "select especialidades.id_especialidad, especialidades.nombre from especialidades inner join especialidades_profesionales as joinTable " +
            "ON especialidades.id_especialidad = joinTable.id_especialidad " +
            "where joinTable.id_especialidades_profesional = :id",nativeQuery = true)
    Especialidad especialidadByJoinTableID(@Param("id") Integer id);
}
