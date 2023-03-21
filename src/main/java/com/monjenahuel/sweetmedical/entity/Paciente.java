package com.monjenahuel.sweetmedical.entity;

import com.sun.istack.NotNull;
import org.springframework.data.relational.core.sql.In;

import javax.persistence.*;

@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente",nullable = false, unique = true)
    Integer id;

    @NotNull
    @Column(name = "nombre", nullable = false)
    String nombre;

    @NotNull
    @Column(name = "apellido", nullable = false)
    String apellido;

    @NotNull
    @Column(name = "dni", nullable = false, unique = true)
    String dni;

    @Column(name = "telefono")
    String telefono;

    @Column(name = "email")
    String email;

    public Paciente() {
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
