package com.monjenahuel.sweetmedical.controller;

import com.monjenahuel.sweetmedical.DTO.TurnoCreableDTO;
import com.monjenahuel.sweetmedical.entity.Turno;
import com.monjenahuel.sweetmedical.servicio.TurnoServicio;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private final TurnoServicio servicio;

    public TurnoController(TurnoServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Turno> getAllTurnos(){
        return servicio.getAllTurnos();
    }

    @GetMapping("/{id}")
    public Optional<Turno> getTurnoByID(@PathVariable Integer id){
        return servicio.getTurnoByID(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Turno>> deleteTurnoByID(@PathVariable Integer id){
        Optional<Turno> turnoEliminado = servicio.eliminarTurnoByID(id);

        if(turnoEliminado == null){
            return new ResponseEntity<Optional<Turno>>(null,null,HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Optional<Turno>>(turnoEliminado,null, HttpStatus.OK);
        }

    }

    @PostMapping
    public ResponseEntity<?> createTurno(@RequestBody TurnoCreableDTO turnoCreable){

        TurnoCreableDTO turnoResponse = servicio.crearNuevoTurno(turnoCreable);

        if(turnoResponse != null){

            return new ResponseEntity<TurnoCreableDTO>(turnoResponse,null,HttpStatus.CREATED);

        }else{
            return new ResponseEntity<String>("Error",null,HttpStatus.BAD_REQUEST);
        }
    }




}
