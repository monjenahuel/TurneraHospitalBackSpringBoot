package com.monjenahuel.sweetmedical.DTO;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class TurnoCreableDTO {

    Integer id_turno;
    @NotNull(message = "El id_paciente no puede estar vacio")
    Integer id_paciente;
    @NotNull(message = "El id_especialidad_profesional no puede estar vacio")
    Integer id_especialidad_profesional;
    @NotNull(message = "La fecha no puede estar vacia")
    LocalDateTime fecha_hora;

    public TurnoCreableDTO() {
    }

    public TurnoCreableDTO(Integer id_paciente, Integer id_especialidad_profesional, LocalDateTime fecha_hora) {
        this.id_paciente = id_paciente;
        this.id_especialidad_profesional = id_especialidad_profesional;
        this.fecha_hora = fecha_hora;
    }

    public TurnoCreableDTO(Integer id_turno, Integer id_paciente, Integer id_especialidad_profesional, LocalDateTime fecha_hora) {
        this.id_turno = id_turno;
        this.id_paciente = id_paciente;
        this.id_especialidad_profesional = id_especialidad_profesional;
        this.fecha_hora = fecha_hora;
    }

}
