package com.monjenahuel.sweetmedical.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.sql.In;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "profesionales")
public class Profesional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesional",nullable = false,unique = true)
    Integer id;
    @NotNull
    @Column(nullable = false)
    String nombre;
    @NotNull
    @Column(nullable = false)
    String apellido;

    String matricula;

    @OneToMany(mappedBy = "profesional")
    @JsonBackReference //Evita la recursion cediendo el atributo a la otra parte
    private Set<Especialidad_Profesional> especialidades = new HashSet<>();

    public Profesional(String nombre, String apellido, String matricula){
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }




}
