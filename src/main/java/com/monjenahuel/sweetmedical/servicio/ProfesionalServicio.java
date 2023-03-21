package com.monjenahuel.sweetmedical.servicio;

import com.monjenahuel.sweetmedical.entity.Especialidad;
import com.monjenahuel.sweetmedical.entity.Profesional;

import java.util.List;
import java.util.Optional;

public interface ProfesionalServicio {

    public List<Profesional> getAllProfesionales();

    public Optional<Profesional> getProfesionalByID(Integer id);

}
