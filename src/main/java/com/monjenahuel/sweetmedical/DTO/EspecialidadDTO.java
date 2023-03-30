package com.monjenahuel.sweetmedical.DTO;

import com.monjenahuel.sweetmedical.entity.Profesional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspecialidadDTO {

    @NotNull(message = "El id no puede estar vacio")
    private Integer id;

    @NotEmpty(message = "El nombre de la especialidad es obligatorio")
    private String nombre;

}
