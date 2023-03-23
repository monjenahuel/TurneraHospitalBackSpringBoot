package com.monjenahuel.sweetmedical.controller;

import com.monjenahuel.sweetmedical.entity.Especialidad;
import com.monjenahuel.sweetmedical.repositorio.EspecialidadRepository;
import com.monjenahuel.sweetmedical.servicio.EspecialidadServicio;
import com.monjenahuel.sweetmedical.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {

    private final EspecialidadServicio servicio;

    public EspecialidadController(EspecialidadServicio servicio) {
        this.servicio = servicio;
    }


    @GetMapping
    public List getAllEspecialidades(@RequestParam(name = "name",required = false) String  nombre){
        if(nombre != null){
            return Collections.singletonList(servicio.getEspecialidadByNombre(nombre));
        }else{
            return servicio.getAllEspecialidades();
        }
    }

    @GetMapping("/{id}")
    public List getEspecialidadByID(@PathVariable Integer id){
        return Collections.singletonList(servicio.getEspecialidadByID(id));
    }

    @GetMapping("/join/{id}")
    public Especialidad getEspecialidadByIDIntermedia(@PathVariable Integer id){
        return servicio.getEspecialidadByIDIntermedia(id);
    }

}
