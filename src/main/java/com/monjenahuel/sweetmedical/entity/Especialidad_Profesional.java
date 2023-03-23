package com.monjenahuel.sweetmedical.entity;

import com.sun.istack.NotNull;
import jdk.jfr.Enabled;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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


    public Especialidad_Profesional() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }
}
