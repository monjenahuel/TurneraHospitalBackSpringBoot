package com.monjenahuel.sweetmedical.controller;

import com.monjenahuel.sweetmedical.DTO.UsuarioDTO;
import com.monjenahuel.sweetmedical.DTO.mapper.UsuarioMapper;
import com.monjenahuel.sweetmedical.entity.Usuario;
import com.monjenahuel.sweetmedical.servicio.UsuarioServicio;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServicio service;

    @Autowired
    private UsuarioMapper mapper;

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody Usuario usuarioAAgregar) {

        Usuario userCreado = this.service.crearUsuario(usuarioAAgregar);

        UsuarioDTO usuarioRespuesta = mapper.UsuarioToUsuarioDTO(userCreado);

        return new ResponseEntity<>(usuarioRespuesta, HttpStatus.CREATED);
    }

    @PostMapping("/validar")
    public ResponseEntity<?> validate(@Valid @RequestBody Usuario usuarioAValidar) throws Exception {
        Usuario response = this.service.validarCredenciales(usuarioAValidar);

        UsuarioDTO usuarioRespuesta = mapper.UsuarioToUsuarioDTO(response);

        return new ResponseEntity<>(usuarioRespuesta, HttpStatus.OK);
    }


}
