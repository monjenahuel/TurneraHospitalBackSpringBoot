package com.monjenahuel.sweetmedical.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class UsuarioDTO {

    @NotEmpty(message = "el email no puede estar vacio")
    @Email(message = "El email no tiene el formato correcto")
    String username;

    public UsuarioDTO(String username, String password) {
        this.username = username;
    }

}
