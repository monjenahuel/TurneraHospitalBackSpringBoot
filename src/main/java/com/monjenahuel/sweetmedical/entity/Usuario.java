package com.monjenahuel.sweetmedical.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario", nullable = false, unique = true)
    int idUsuario;
    //Accesos
    @NotEmpty(message = "el email no puede estar vacio")
    @Email(message = "El email no tiene el formato correcto")
    String username;

    @NotEmpty(message = "el password no puede estar vacio")
    String password;

    public  Usuario(){
    }

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
