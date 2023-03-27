package com.monjenahuel.sweetmedical.datos;

import com.monjenahuel.sweetmedical.entity.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatosDummy {

    public static Usuario getUser1(){
        return new Usuario("Hola@gmail.com","1234");
    }

    public static Usuario getUser2(){
        return new Usuario("chau@gmail.com","4321");
    }

    public static Usuario getUser3(){
        return new Usuario("mandarina@gmail.com","5894");
    }

    public List<Usuario> getAllUsers(){
        return new ArrayList<>(Arrays.asList(getUser1(),getUser2(),getUser2()));
    }

}
