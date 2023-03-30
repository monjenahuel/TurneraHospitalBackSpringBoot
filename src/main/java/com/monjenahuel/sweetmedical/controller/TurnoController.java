package com.monjenahuel.sweetmedical.controller;

import com.monjenahuel.sweetmedical.DTO.TurnoConIdDTO;
import com.monjenahuel.sweetmedical.DTO.TurnoDTO;
import com.monjenahuel.sweetmedical.DTO.mapper.TurnoMapper;
import com.monjenahuel.sweetmedical.entity.Turno;
import com.monjenahuel.sweetmedical.exception.NotFoundException;
import com.monjenahuel.sweetmedical.servicio.TurnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public List<TurnoConIdDTO> getTurnosVigentesOrderByDateASC(){

        List<Turno> listaTurnosOrdenada = servicio.getTurnosVigentesOrderByDateASC();

        List<TurnoConIdDTO> listaResponse = mapper.mapToDTOwithIDList(listaTurnosOrdenada);

        return listaResponse;
    }

    @GetMapping("/history")
    public List<TurnoConIdDTO> historialDeTurnos(){
          List<Turno> listaTurnos = servicio.getAllTurnosOrderByDateASC();
          List<TurnoConIdDTO> listaResponse = mapper.mapToDTOwithIDList(listaTurnos);
        return  listaResponse;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoConIdDTO> getTurnoByID(@PathVariable Integer id) throws NotFoundException{

     Turno turnoEncontrado = servicio.getTurnoByID(id).orElseThrow(
             ()-> new NotFoundException("Turno no encontrado")
     );

        TurnoConIdDTO turnoResponse = mapper.TurnoATurnoDTOconId(turnoEncontrado);
        return new ResponseEntity<>(turnoResponse,HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<TurnoDTO> deleteTurnoByID(@PathVariable Integer id) throws NotFoundException{

        Turno turnoEliminado = servicio.eliminarTurnoByID(id).orElseThrow(()-> new NotFoundException("Turno no encontrado"));

        TurnoDTO turnoResponse = mapper.TurnoATurnoDTO(turnoEliminado);

        return new ResponseEntity<TurnoDTO>(turnoResponse,HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<TurnoDTO> createTurno(@Valid @RequestBody TurnoDTO turnoNuevo){

        Turno turnoCreado = servicio.crearNuevoTurno(turnoNuevo);

        TurnoDTO turnoResponse = mapper.TurnoATurnoDTO(turnoCreado);

        return new ResponseEntity<>(turnoResponse,null,HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<TurnoDTO> actualizarTurno(@PathVariable Integer id,@Valid @RequestBody TurnoConIdDTO turnoActualizado){

        Turno turnoActualizadoConID = servicio.actualizarTurno(id,turnoActualizado);

        TurnoDTO response = mapper.TurnoATurnoDTO(turnoActualizadoConID);
        
        return new ResponseEntity<>(response,null,HttpStatus.OK);

    }




}
