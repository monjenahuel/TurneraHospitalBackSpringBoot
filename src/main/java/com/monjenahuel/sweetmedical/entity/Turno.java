package com.monjenahuel.sweetmedical.entity;

import com.monjenahuel.sweetmedical.servicio.EspecialidadServicio;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turno")
    Integer id;

    @Column(name = "id_paciente")
    Integer idPaciente;

    @Column(name = "id_especialidad_profesional")
    Integer idEspProf;


    @NotNull
    @Column(name = "fecha_hora")
    LocalDateTime fechaHora;


    @ManyToOne
    @JoinColumn(name="id_paciente",
            insertable = false,
            updatable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name="id_especialidad_profesional",
            insertable = false,
            updatable = false)
    private Especialidad_Profesional especialidad_profesional;

    public Especialidad_Profesional getEspecialidad_profesional() {
        return especialidad_profesional;
    }

    public void setEspecialidad_profesional(Especialidad_Profesional especialidad_profesional) {
        this.especialidad_profesional = especialidad_profesional;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public void setIdEspProf(Integer idEspProf) {
        this.idEspProf = idEspProf;
    }

    public Turno() {
    }

    public Turno(Integer idPaciente, Integer idEspProf, LocalDateTime fechaHora) {
        this.idPaciente = idPaciente;
        this.idEspProf = idEspProf;
        this.fechaHora = fechaHora;
    }
}
