package com.monjenahuel.sweetmedical.controller;

import com.monjenahuel.sweetmedical.DTO.TurnoCreableDTO;
import com.monjenahuel.sweetmedical.DTO.TurnoDTO;
import com.monjenahuel.sweetmedical.DTO.mapper.TurnoMapper;
import com.monjenahuel.sweetmedical.entity.Turno;
import com.monjenahuel.sweetmedical.exepction.NotFoundException;
import com.monjenahuel.sweetmedical.servicio.TurnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private final TurnoServicio servicio;

    @Autowired
    private TurnoMapper mapper;

    public TurnoController(TurnoServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Turno> getTurnosVigentesOrderByDateASC(){
        return  servicio.getTurnosVigentesOrderByDateASC();
    }

    @GetMapping("/history")
    public List<Turno> historialDeTurnos(){
        return  servicio.getAllTurnosOrderByDateASC();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getTurnoByID(@PathVariable Integer id) throws NotFoundException{

     TurnoDTO turnoResponse = mapper.TurnoATurnoDTO(servicio.getTurnoByID(id).orElseThrow(
             ()-> new NotFoundException("Turno no encontrado")
     ));
        return new ResponseEntity<>(turnoResponse,HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<TurnoDTO> deleteTurnoByID(@PathVariable Integer id) throws NotFoundException{

        Optional<Turno> turnoEliminado = servicio.eliminarTurnoByID(id);

        TurnoDTO turnoResponse = mapper.TurnoATurnoDTO(turnoEliminado.get());

        return new ResponseEntity<TurnoDTO>(turnoResponse,HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> createTurno(@Valid @RequestBody TurnoCreableDTO turnoCreable){

        TurnoCreableDTO turnoResponse = servicio.crearNuevoTurno(turnoCreable);

        return new ResponseEntity<>(turnoResponse,null,HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarTurno(@PathVariable Integer id,@Valid @RequestBody TurnoCreableDTO turnoCreable){

        TurnoCreableDTO turnoActualizado = servicio.actualizarTurno(id,turnoCreable);
        
        return new ResponseEntity<>(turnoActualizado,null,HttpStatus.OK);

    }




}
