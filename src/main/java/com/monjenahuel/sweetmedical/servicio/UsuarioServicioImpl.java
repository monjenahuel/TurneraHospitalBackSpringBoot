package com.monjenahuel.sweetmedical.servicio;

import com.monjenahuel.sweetmedical.repositorio.UsuarioRepository;
import com.monjenahuel.sweetmedical.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class UsuarioServicioImpl implements  UsuarioServicio{
    @Autowired
    private UsuarioRepository repositorio;

    @Override
    public List<Usuario> getAllUsuarios(){
        return repositorio.findAll();
    }

    @Override
    public Usuario crearUsuario(Usuario usuarioACrear){
        return repositorio.save(usuarioACrear);
    }

    @Override
    public Usuario validarCredenciales(Usuario usuarioAValidar) {
         if(repositorio.usuarioExiste(usuarioAValidar.getUsername(),usuarioAValidar.getPassword())){
             return usuarioAValidar;
         }else{
             return null;
         }
    }
}
