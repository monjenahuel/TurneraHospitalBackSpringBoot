package com.monjenahuel.sweetmedical.entity;

import com.monjenahuel.sweetmedical.servicio.EspecialidadServicio;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "turnos")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turno")
    @Getter @Setter
    Integer id;

    @Setter @Getter
    @NotNull(message = "El id_paciente no puede estar vacio")
    @Column(name = "id_paciente")
    Integer idPaciente;

    @Setter @Getter
    @NotNull(message = "El id_especialidad_profesional no puede estar vacio")
    @Column(name = "id_especialidad_profesional")
    Integer idEspProf;


    @Getter @Setter
    @NotNull(message = "La fecha no puede estar vacia")
    @Column(name = "fecha_hora")
    LocalDateTime fechaHora;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name="id_paciente",
            insertable = false,
            updatable = false)
    private Paciente paciente;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name="id_especialidad_profesional",
            insertable = false,
            updatable = false)
    private Especialidad_Profesional especialidad_profesional;

    public Turno(Integer idPaciente, Integer idEspProf, LocalDateTime fechaHora) {
        this.idPaciente = idPaciente;
        this.idEspProf = idEspProf;
        this.fechaHora = fechaHora;
    }
}
