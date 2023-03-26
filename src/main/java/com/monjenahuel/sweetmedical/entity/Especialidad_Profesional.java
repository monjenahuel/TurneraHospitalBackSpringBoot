package com.monjenahuel.sweetmedical.entity;

import com.sun.istack.NotNull;
import jdk.jfr.Enabled;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "especialidades_profesionales")
public class Especialidad_Profesional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidades_profesional")
    Integer id;

    @ManyToOne
    @JoinColumn(name = "id_especialidad",
                insertable = false,
                updatable = false)
   private Especialidad especialidad;

    @ManyToOne
    @JoinColumn(name = "id_profesional",
            insertable = false,
            updatable = false)
    private Profesional profesional;

    public Especialidad_Profesional(Especialidad especialidad, Profesional profesional) {
        this.especialidad = especialidad;
        this.profesional = profesional;
    }
}
