package com.monjenahuel.sweetmedical.servicio;

import com.monjenahuel.sweetmedical.entity.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UsuarioServicio {

    List<Usuario> getAllUsuarios();

    Usuario crearUsuario(Usuario usuario);

    Usuario validarCredenciales(Usuario usuarioAValidar);
}
