package com.monjenahuel.sweetmedical.DTO.mapper;

import com.monjenahuel.sweetmedical.DTO.UsuarioDTO;
import com.monjenahuel.sweetmedical.entity.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario UsuarioDToToUsuario(UsuarioDTO usuarioDTO);

    UsuarioDTO UsuarioToUsuarioDTO(Usuario usuario);

}
