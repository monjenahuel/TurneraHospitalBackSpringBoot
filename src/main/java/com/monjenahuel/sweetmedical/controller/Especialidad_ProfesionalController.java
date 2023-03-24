package com.monjenahuel.sweetmedical.controller;

import com.monjenahuel.sweetmedical.entity.Especialidad_Profesional;
import com.monjenahuel.sweetmedical.servicio.Especialidad_ProfesionalServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/EspProf")
public class Especialidad_ProfesionalController {

    private final Especialidad_ProfesionalServicio servicio;

    public Especialidad_ProfesionalController(Especialidad_ProfesionalServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public ResponseEntity<?> getAllEspProf(@RequestParam(required = false) Integer esp,
                                @RequestParam(required = false) Integer prof){
        if(esp == null || prof == null)
            return new ResponseEntity<>(servicio.getAllEspProf(),null,HttpStatus.OK);
        else
            try {
                return new ResponseEntity<>(servicio.getEspProfByCombinedID(esp,prof).get(),null,HttpStatus.OK);
            }catch (Exception e){
                System.out.println(e);
                return new ResponseEntity<>(new RuntimeException("No existe una entidad con esos parametros").getMessage(),null, HttpStatus.BAD_REQUEST);
            }
    }

    @GetMapping("/{id}")
    public Optional<Especialidad_Profesional> getByID(@PathVariable Integer id){
       return servicio.getEspProfByID(id);
    }
}
