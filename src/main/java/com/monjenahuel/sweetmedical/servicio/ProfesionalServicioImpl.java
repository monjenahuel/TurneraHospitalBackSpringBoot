package com.monjenahuel.sweetmedical.servicio;

//import com.monjenahuel.sweetmedical.entity.Especialidad_Profesional;
import com.monjenahuel.sweetmedical.entity.Especialidad;
import com.monjenahuel.sweetmedical.entity.Profesional;
import com.monjenahuel.sweetmedical.exception.NotFoundException;
import com.monjenahuel.sweetmedical.repositorio.EspecialidadRepository;
import com.monjenahuel.sweetmedical.repositorio.ProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProfesionalServicioImpl implements ProfesionalServicio {

    @Autowired
    private ProfesionalRepository repositorio;

    @Autowired
    private EspecialidadRepository EspRepo;

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
        Optional<Especialidad> esp = EspRepo.findById(id);

        if(esp.isPresent()){
            List<Profesional> profesionales = esp.get().getProfesionales();
            return profesionales;
        }else{
            throw new NotFoundException("No se encontró la especialidad indicada");
        }


    }
}
