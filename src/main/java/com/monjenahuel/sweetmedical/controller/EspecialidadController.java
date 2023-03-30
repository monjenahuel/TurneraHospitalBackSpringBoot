package com.monjenahuel.sweetmedical.controller;

import com.monjenahuel.sweetmedical.DTO.EspecialidadDTO;
import com.monjenahuel.sweetmedical.DTO.mapper.EspecialidadMapper;
import com.monjenahuel.sweetmedical.entity.Especialidad;
import com.monjenahuel.sweetmedical.servicio.EspecialidadServicio;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {

    private final EspecialidadServicio servicio;

    private final EspecialidadMapper mapper;

    public EspecialidadController(EspecialidadServicio servicio, EspecialidadMapper mapper) {
        this.servicio = servicio;
        this.mapper = mapper;
    }
    @GetMapping
    public List<EspecialidadDTO> getAllEspecialidades(@RequestParam(name = "name",required = false) String  nombre){
        if(nombre != null){
            return mapper.mapToDTOList(Collections.singletonList(servicio.getEspecialidadByNombre(nombre).get()));
        }else{
            return mapper.mapToDTOList(servicio.getAllEspecialidades());
        }
    }

    @GetMapping("/{id}")
    public List<EspecialidadDTO> getEspecialidadByID(@PathVariable Integer id){
        return mapper.mapToDTOList(Collections.singletonList(servicio.getEspecialidadByID(id).get()));
    }

    @GetMapping("/join/{id}")
    public EspecialidadDTO getEspecialidadByIDIntermedia(@PathVariable Integer id){
        return mapper.especialidadAEspecialidadDTO(servicio.getEspecialidadByIDIntermedia(id));
    }

}
