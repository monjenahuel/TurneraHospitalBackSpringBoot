package com.monjenahuel.sweetmedical.controller;

import com.monjenahuel.sweetmedical.entity.Turno;
import com.monjenahuel.sweetmedical.repositorio.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoRepository repositorio;

    @GetMapping
    public List<Turno> getAllTurnos(){
        return repositorio.findAll();
    }
}
