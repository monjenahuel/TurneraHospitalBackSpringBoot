package com.monjenahuel.sweetmedical.servicio;

import com.monjenahuel.sweetmedical.entity.Especialidad;

import java.util.List;
import java.util.Optional;

public interface EspecialidadServicio {

    public List<Especialidad> getAllEspecialidades();

    public Optional<Especialidad> getEspecialidadByID(Integer id);

    public Optional<Especialidad> getEspecialidadByNombre(String nombre);
}
