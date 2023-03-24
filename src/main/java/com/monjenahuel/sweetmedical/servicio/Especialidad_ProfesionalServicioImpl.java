package com.monjenahuel.sweetmedical.servicio;

import com.monjenahuel.sweetmedical.entity.Especialidad_Profesional;
import com.monjenahuel.sweetmedical.repositorio.Especialidad_ProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Especialidad_ProfesionalServicioImpl implements Especialidad_ProfesionalServicio{

    @Autowired
    private Especialidad_ProfesionalRepository repositorio;

    public List<Especialidad_Profesional> getAllEspProf(){
        return repositorio.findAll();
    }

    //Uso de Optional, expresiones lamda, streams
    public Optional<Especialidad_Profesional> getEspProfByCombinedID(Integer idEsp, Integer idProf){

        Optional<Especialidad_Profesional> lista = repositorio
                .findAll()
                .stream()
                .filter(e ->    e.getProfesional().getId() == idProf &&
                                e.getEspecialidad().getId() == idEsp)
                .findFirst();

        if(lista.isPresent()){
            return lista;
        }else{
            return Optional.empty();
        }

    }

    @Override
    public Optional<Especialidad_Profesional> getEspProfByID(Integer id) {
        return repositorio.findById(id);
    }

}
