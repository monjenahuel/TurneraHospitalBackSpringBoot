package com.monjenahuel.sweetmedical.entity;

import com.monjenahuel.sweetmedical.servicio.EspecialidadServicio;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
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

    @Getter @Setter
    @NotNull(message = "La fecha no puede estar vacia")
    @Column(name = "fecha_hora")
    LocalDateTime fechaHora;

    @Getter @Setter
    @ManyToOne
    @NotNull(message = "El ID del paciente no puede estar vacio")
    @JoinColumn(name="id_paciente")
    private Paciente paciente;

    @Getter @Setter
    @ManyToOne
    @NotNull(message = "La especialidad no puede estar vacia")
    @JoinColumn(name="id_especialidad")
    private Especialidad especialidad;

    @Getter @Setter
    @ManyToOne
    @NotNull(message = "El profesional no puede estar vacio")
    @JoinColumn(name="id_profesional")
    private Profesional profesional;
}
