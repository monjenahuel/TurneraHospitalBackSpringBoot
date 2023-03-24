package com.monjenahuel.sweetmedical.DTO;

import java.time.LocalDateTime;

public class TurnoCreableDTO {
    Integer id_turno;
    Integer id_paciente;
    Integer id_especialidad_profesional;
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

    public Integer getId_turno() {
        return id_turno;
    }

    public void setId_turno(Integer id_turno) {
        this.id_turno = id_turno;
    }

    public Integer getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Integer id_paciente) {
        this.id_paciente = id_paciente;
    }

    public Integer getId_especialidad_profesional() {
        return id_especialidad_profesional;
    }

    public void setId_especialidad_profesional(Integer id_especialidad_profesional) {
        this.id_especialidad_profesional = id_especialidad_profesional;
    }

    public LocalDateTime getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(LocalDateTime fecha_hora) {
        this.fecha_hora = fecha_hora;
    }


}
