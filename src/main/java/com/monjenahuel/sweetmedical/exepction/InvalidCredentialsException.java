package com.monjenahuel.sweetmedical.exepction;

public class InvalidCredentialsException extends RuntimeException{
    public InvalidCredentialsException(String mensaje){
        super(mensaje);
    }
}
