package com.monjenahuel.sweetmedical.controller;

import com.monjenahuel.sweetmedical.entity.Profesional;
import com.monjenahuel.sweetmedical.servicio.ProfesionalServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/profesionales")
public class ProfesionalController {

    private final ProfesionalServicio servicio;

    public ProfesionalController(ProfesionalServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Profesional> getAllProfesionales(){
        return servicio.getAllProfesionales();
    }

    @GetMapping("/{id}")
    public List getEProfesionalByID(@PathVariable Integer id){
        return Collections.singletonList(servicio.getProfesionalByID(id));
    }

}
