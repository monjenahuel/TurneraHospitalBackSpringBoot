package com.monjenahuel.sweetmedical.servicio;

import com.monjenahuel.sweetmedical.exception.AlreadyExistException;
import com.monjenahuel.sweetmedical.exception.InvalidCredentialsException;
import com.monjenahuel.sweetmedical.repositorio.UsuarioRepository;
import com.monjenahuel.sweetmedical.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UsuarioServicioImpl implements  UsuarioServicio{
    @Autowired
    private UsuarioRepository repositorio;

    @Override
    public List<Usuario> getAllUsuarios(){
        return repositorio.findAll();
    }

    @Transactional
    @Override
    public Usuario crearUsuario(Usuario usuarioACrear){

        if(repositorio.existsByUsername(usuarioACrear.getUsername())){
            throw new AlreadyExistException("El correo ingresado ya posee un usuario");
        }

        Usuario userCreado = repositorio.save(usuarioACrear);

        return userCreado;
    }

    @Override
    public Usuario validarCredenciales(Usuario usuarioAValidar) {
         if(repositorio.usuarioValido(usuarioAValidar.getUsername(),usuarioAValidar.getPassword())){
             return usuarioAValidar;
         }else{
             throw new InvalidCredentialsException("Las credenciales ingresadas son incorrectas o no pertenecen a ningun usuario");
         }
    }
}
