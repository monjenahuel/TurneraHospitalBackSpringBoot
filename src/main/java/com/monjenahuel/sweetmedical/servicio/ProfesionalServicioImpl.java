package com.monjenahuel.sweetmedical.servicio;

import com.monjenahuel.sweetmedical.entity.Especialidad_Profesional;
import com.monjenahuel.sweetmedical.entity.Profesional;
import com.monjenahuel.sweetmedical.repositorio.ProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProfesionalServicioImpl implements ProfesionalServicio {

    @Autowired
    private ProfesionalRepository repositorio;

    @Override
    public List<Profesional> getAllProfesionales() {
        return repositorio.findAll();
    }

    @Override
    public Optional<Profesional> getProfesionalByID(Integer id) {
        return repositorio.findById(id);
    }

    @Override
    public List<Profesional> getProfesionalesConEspID(Integer id){
        List<Especialidad_Profesional> EspProf = repositorio.profesionalesByEspecialidad(id);

        List<Profesional> profesionales = EspProf.stream().map(obj -> obj.getProfesional()).collect(Collectors.toList());

        return profesionales;
    }
}
