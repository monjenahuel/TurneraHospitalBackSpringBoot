package com.monjenahuel.sweetmedical.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
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

    public Especialidad(String nombre) {
        this.nombre = nombre;
    }


}
