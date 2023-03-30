package com.monjenahuel.sweetmedical.entity;

import com.fasterxml.jackson.annotation.*;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
@NoArgsConstructor
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "especialidades_profesionales",
            joinColumns = @JoinColumn(name = "id_especialidad"),
            inverseJoinColumns = @JoinColumn(name = "id_profesional"))
    private List<Profesional> profesionales;

    public Especialidad(String nombre) {
        this.nombre = nombre;
    }
}
