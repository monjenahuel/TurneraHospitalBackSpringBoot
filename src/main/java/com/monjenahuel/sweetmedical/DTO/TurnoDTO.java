package com.monjenahuel.sweetmedical.DTO;

import com.monjenahuel.sweetmedical.entity.Especialidad_Profesional;
import com.monjenahuel.sweetmedical.entity.Paciente;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class TurnoDTO {
    Integer id;

    LocalDateTime fechaHora;

    private Paciente paciente;

    private Especialidad_Profesional especialidad_profesional;

}
