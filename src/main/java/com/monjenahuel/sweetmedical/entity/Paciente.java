package com.monjenahuel.sweetmedical.entity;

import lombok.*;
import org.springframework.data.relational.core.sql.In;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente",nullable = false, unique = true)
    Integer id;

    @NotEmpty(message = "Apellido no puede estar vacio")
    @Column(name = "nombre", nullable = false)
    String nombre;

    @NotEmpty(message = "Apellido no puede estar vacio")
    @Column(name = "apellido", nullable = false)
    String apellido;

    @NotEmpty(message = "dni no puede estar vacio")
    @Positive
    @Column(name = "dni", nullable = false, unique = true)
    String dni;

    @Column(name = "telefono")
    String telefono;

    @Column(name = "email")
    String email;

}
