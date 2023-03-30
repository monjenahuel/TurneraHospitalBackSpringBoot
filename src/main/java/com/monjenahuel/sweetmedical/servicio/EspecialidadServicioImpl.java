package com.monjenahuel.sweetmedical.servicio;

import com.monjenahuel.sweetmedical.entity.Especialidad;
import com.monjenahuel.sweetmedical.repositorio.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class EspecialidadServicioImpl implements EspecialidadServicio{

    @Autowired
    private EspecialidadRepository repositorio;

    @Transactional
    @Override
    public List<Especialidad> getAllEspecialidades(){
        return repositorio.findAll();
    }

    @Override
    public Optional<Especialidad> getEspecialidadByID(Integer id) {
        return repositorio.findById(id);
    }

    @Override
    public Optional<Especialidad> getEspecialidadByNombre(String nombre) {
        return repositorio.buscarPorNombre(nombre);
    }

    @Override
    public Especialidad getEspecialidadByIDIntermedia(Integer id) {
//        return repositorio.especialidadByJoinTableID(id);
        return null;
    }


}
