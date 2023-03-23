package com.monjenahuel.sweetmedical.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import org.springframework.data.relational.core.sql.In;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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


//    @ManyToMany
//    @JsonBackReference //Evita la recursion cediendo el atributo a la otra parte
//    @JoinTable(name = "especialidades_profesionales", joinColumns = @JoinColumn(name = "id_profesional", referencedColumnName = "id_profesional"), inverseJoinColumns = @JoinColumn(name = "id_especialidad", referencedColumnName = "id_especialidad"))
//    private Set<Especialidad> especialidades = new HashSet<>();

    @OneToMany(mappedBy = "profesional")
    @JsonBackReference //Evita la recursion cediendo el atributo a la otra parte
    private Set<Especialidad_Profesional> especialidades = new HashSet<>();

    public Set<Especialidad_Profesional> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(Set<Especialidad_Profesional> especialidades) {
        this.especialidades = especialidades;
    }

    public Profesional() {
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

//    public Set<Especialidad> getEspecialidades() {
//        return especialidades;
//    }
//
//    public void setEspecialidades(Set<Especialidad> especialidades) {
//        this.especialidades = especialidades;
//    }
}
