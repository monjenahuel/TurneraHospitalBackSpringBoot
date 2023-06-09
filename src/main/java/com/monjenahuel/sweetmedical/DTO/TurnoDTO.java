package com.monjenahuel.sweetmedical.DTO;

//import com.monjenahuel.sweetmedical.entity.Especialidad_Profesional;
import com.monjenahuel.sweetmedical.entity.Especialidad;
import com.monjenahuel.sweetmedical.entity.Paciente;
import com.monjenahuel.sweetmedical.entity.Profesional;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class TurnoDTO {

    @NotNull(message = "La fecha no puede estar vacia")
    LocalDateTime fechaHora;

    @NotNull(message = "El ID del paciente no puede estar vacio")
    private Paciente paciente;

    @NotNull(message = "La especialidad no puede estar vacia")

    private EspecialidadDTO especialidad;

    @NotNull(message = "El profesional no puede estar vacio")
    private Profesional profesional;

}
