package com.monjenahuel.sweetmedical.servicio;

import com.monjenahuel.sweetmedical.entity.Especialidad_Profesional;

import java.util.List;
import java.util.Optional;

public interface Especialidad_ProfesionalServicio {

    List<Especialidad_Profesional> getAllEspProf();

    Optional<Especialidad_Profesional> getEspProfByCombinedID(Integer idEsp, Integer idProf);

    Optional<Especialidad_Profesional> getEspProfByID(Integer id);
}
