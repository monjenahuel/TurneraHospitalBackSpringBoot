package com.monjenahuel.sweetmedical.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.sql.In;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "especialidades_profesionales",
            joinColumns = @JoinColumn(name = "id_profesional"),
            inverseJoinColumns = @JoinColumn(name = "id_especialidad"))
    private List<Especialidad> especialidades;

    public Profesional(String nombre, String apellido, String matricula){
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

}
