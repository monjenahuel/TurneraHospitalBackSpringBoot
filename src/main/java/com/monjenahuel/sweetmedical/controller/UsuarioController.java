package com.monjenahuel.sweetmedical.controller;

import com.monjenahuel.sweetmedical.entity.Usuario;
import com.monjenahuel.sweetmedical.servicio.UsuarioServicio;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {

    private final UsuarioServicio service;
    public UsuarioController(UsuarioServicio service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuario> usuarios(){
        return this.service.getAllUsuarios();
    }

    @PostMapping
    public Usuario add(@RequestBody Usuario usuarioAAgregar){
        return this.service.crearUsuario(usuarioAAgregar);
    }

    @GetMapping("/validar")
    public String validate(){
        return "Valida a tus usuarios acá";
    }

    @PostMapping("/validar")
    public Usuario validate(@RequestBody Usuario usuarioAValidar) throws Exception {
        try{
            Usuario response = this.service.validarCredenciales(usuarioAValidar);
            if(response.getUsername() != null){
                response.setPassword("ok");
                return response;
            }
            throw new Exception("Credenciales Invalidas");
        }catch (NullPointerException e) {
            throw new Exception("Credenciales Invalidas");
        }


    }


}
