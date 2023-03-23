package com.monjenahuel.sweetmedical.controller;

import com.monjenahuel.sweetmedical.entity.Especialidad_Profesional;
import com.monjenahuel.sweetmedical.entity.Turno;
import com.monjenahuel.sweetmedical.repositorio.Especialidad_ProfesionalRepository;
import com.monjenahuel.sweetmedical.repositorio.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/EspProf")
public class Especialidad_ProfesionalController {

    @Autowired
    private Especialidad_ProfesionalRepository repositorio;

    @GetMapping
    public List<Especialidad_Profesional> getAllEspProf(){
        return repositorio.findAll();
    }
}
