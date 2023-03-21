package com.monjenahuel.sweetmedical.controller;

import com.monjenahuel.sweetmedical.entity.Paciente;
import com.monjenahuel.sweetmedical.servicio.PacienteServicio;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteServicio servicio;

    public PacienteController(PacienteServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Paciente> getAllPacientes(){
        return servicio.getAllPacientes();
    }

    @GetMapping("/{id}")
    public List getPacienteByID(@PathVariable Integer id){
        return Collections.singletonList(servicio.getPacienteByID(id));
    }

    @PostMapping
    public Paciente crearPaciente(@RequestBody Paciente px){
        //Manejo de Excepciones / Enviar un ResponseEntity<?>
        return servicio.newPaciente(px);
    }

    @PutMapping("/{id}")
    public Paciente actualizarPaciente(@PathVariable Integer id,@RequestBody Paciente px){
        return servicio.actualizarPaciente(id,px);
    }

    @DeleteMapping("/{id}")
    public void eliminarPaciente(@PathVariable Integer id){
        servicio.eliminarPaciente(id);
    }


}
