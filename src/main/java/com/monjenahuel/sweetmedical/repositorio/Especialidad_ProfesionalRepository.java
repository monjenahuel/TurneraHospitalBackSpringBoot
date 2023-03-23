package com.monjenahuel.sweetmedical.repositorio;

import com.monjenahuel.sweetmedical.entity.Especialidad_Profesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

@Repository
public interface Especialidad_ProfesionalRepository extends JpaRepository<Especialidad_Profesional, Integer> {
}
