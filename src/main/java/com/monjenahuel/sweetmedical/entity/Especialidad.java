package com.monjenahuel.sweetmedical.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "especialidades")
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidad", nullable = false, unique = true)
    Integer id;

    @NotNull
    @Column(name = "nombre",nullable = false, unique = true)
    String nombre;

    @ManyToMany
    @JoinTable(name = "especialidades_profesionales", joinColumns = @JoinColumn(name = "id_especialidad", referencedColumnName = "id_especialidad"), inverseJoinColumns = @JoinColumn(name = "id_profesional", referencedColumnName = "id_profesional"))
    private Set<Profesional> profesionales = new HashSet<>();


    public Especialidad() {
    }

    public Especialidad(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Profesional> getProfesionales() {
        return profesionales;
    }

    public void setProfesionales(Set<Profesional> profesionales) {
        this.profesionales = profesionales;
    }
}
