package com.monjenahuel.sweetmedical.DTO;

import com.monjenahuel.sweetmedical.DTO.TurnoDTO;
import com.monjenahuel.sweetmedical.entity.Paciente;
import com.monjenahuel.sweetmedical.entity.Profesional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class TurnoConIdDTO{

    @NotNull(message = "el id no puede estar vacio")
    private Integer id;

    @NotNull(message = "La fecha no puede estar vacia")
    LocalDateTime fechaHora;

    @NotNull(message = "El ID del paciente no puede estar vacio")
    private Paciente paciente;

    @NotNull(message = "La especialidad no puede estar vacia")

    private EspecialidadDTO especialidad;

    @NotNull(message = "El profesional no puede estar vacio")
    private Profesional profesional;



}
