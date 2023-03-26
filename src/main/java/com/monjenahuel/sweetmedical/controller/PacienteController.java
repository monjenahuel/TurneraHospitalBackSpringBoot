package com.monjenahuel.sweetmedical.controller;

import com.monjenahuel.sweetmedical.entity.Paciente;
import com.monjenahuel.sweetmedical.servicio.PacienteServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<?> crearPaciente(@Valid @RequestBody Paciente px){

        Paciente pacienteCreado = servicio.newPaciente(px);

        return new ResponseEntity<>(pacienteCreado,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPaciente(@PathVariable Integer id,@Valid @RequestBody Paciente px){
        Paciente pacienteActualizado = servicio.actualizarPaciente(id,px);

        return new ResponseEntity<>(pacienteActualizado,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void eliminarPaciente(@PathVariable Integer id){
        servicio.eliminarPaciente(id);
    }

}
