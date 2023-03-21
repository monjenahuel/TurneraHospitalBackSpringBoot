package com.monjenahuel.sweetmedical.servicio;

import com.monjenahuel.sweetmedical.entity.Profesional;
import com.monjenahuel.sweetmedical.repositorio.ProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
}
