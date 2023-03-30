package com.monjenahuel.sweetmedical.repositorio;

import com.monjenahuel.sweetmedical.entity.Especialidad;
import com.monjenahuel.sweetmedical.entity.Profesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ProfesionalRepository extends JpaRepository<Profesional,Integer> {

//    @Query("FROM Especialidad_Profesional p where p.especialidad.id = :id")
//    List<Especialidad_Profesional> profesionalesByEspecialidad(@Param("id") Integer idEspecialidad);

}
